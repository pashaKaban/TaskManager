package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.Journal;
import com.mycompany.taskmanager.model.Status;
import com.mycompany.taskmanager.model.Task;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author St1gven
 */
public final class NotificationManager 
{
	private final LinkedList<Notification> notifications = new LinkedList<>();
	private Timer timer;
	private final static int REPEAT_PERIOD = 5000;
	
	private NotificationManager(){}
	
	private static class NotificationManagerHolder
	{
		private final static NotificationManager instance = new NotificationManager();
	}
	
	/**
	 * @return экземпляр класса NotificationManager
	 */
	public static NotificationManager getNotifier()
	{
		return NotificationManagerHolder.instance;
	}
	
	/**
	 * Добавить задачу в отслеживание времени оповещений
	 * @param taskId идентификатор задачи
	 * @param journal журнал из которого загружается задача
	 */
	void addNotification(int taskId)
	{
		Task task = Controller.getController().getTask(taskId);
		List list = Collections.synchronizedList(notifications);
		synchronized (list) 
		{
			for (ListIterator<Notification> it = list.listIterator(); it.hasNext();) 
			{
				Notification notification = it.next();

				if(notification.getTaskId() == task.getId())
					throw new IllegalArgumentException("This task also added");

				if(notification.getTime().compareTo(task.getTime().minus(task.getNotificationShift())) > 0)
				{
					it.previous();
					it.add(buildNotification(task));
					return;
				}
			}
			list.add(buildNotification(task));
		}
	}
	
	/**
	 * Обновить состояние задачи
	 * @param taskId 
	 */
	void updateNotification(int taskId)
	{
		Task task = Controller.getController().getTask(taskId);
		List list = Collections.synchronizedList(notifications);
		synchronized (list)
		{
			for(ListIterator<Notification> it = list.listIterator(); it.hasNext();)
			{
				Notification notification = it.next();
				if(notification.getTaskId() == task.getId())
				{
					if(notification.getTime().compareTo(task.getTime().minus(task.getNotificationShift())) != 0)
					{
						it.remove();
					}
					else
					{
						it.set(buildNotification(task));
					}
					break;
				}
			}
		}
		addNotification(taskId);
	}
	
	private Notification buildNotification(Task task)
	{
		switch(task.getType())
		{
			case WINDOW:
				return new WindowNotification(task.getId(), task.getTime(), task.getNotificationShift());
			case NONE:
			default:
				return new NoneNotification(task.getId(), task.getTime(), task.getNotificationShift());
		}
	}
	
	/**
	 * Удалить задачу из отслеживания времени оповещения
	 * @param taskId 
	 */
	void removeNotification(int taskId)
	{
		List list = Collections.synchronizedList(notifications);
		synchronized (list)
		{
			for(ListIterator<Notification> it = notifications.listIterator(); it.hasNext();)
			{		
				Notification notification = it.next();
				if(notification.getTaskId() == taskId)
				{
					it.remove();
					return;
				}
			}
		}
	}
	
	/**
	 * Начать отслеживание времени оповещений
	 */
	void start()
	{
		timer = new Timer(true);
		TimerTask action;
		action = new TimerTask()
		{
			@Override
			public void run()
			{
				if(!notifications.isEmpty())
				{
					Notification first = notifications.getFirst();
					if(first.getTime().compareTo(LocalDateTime.now()) <= 0)
					{
						first.action();
						notifications.removeFirst();
					}
				}
			}
		};
		timer.scheduleAtFixedRate(action, 0, REPEAT_PERIOD);
	}
	
	/**
	 * Завершить отслеживание времени оповещений
	 */
	void cancel()
	{
		timer.cancel();
	}
}
