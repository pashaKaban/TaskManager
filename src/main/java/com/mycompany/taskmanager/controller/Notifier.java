package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.Task;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author St1gven
 */
public final class Notifier 
{
	//TODO Singleton
	private final LinkedList<Notification> notifications = new LinkedList<>();
	private Timer timer;
	private final static int REPEAT_PERIOD = 5000;
	
	public Notifier(){}
	
	public Notifier(Collection<Task> tasks)
	{
		for(Task task:tasks)
		{
			notifications.add(buildNotification(task));
		}
		Collections.sort(notifications, (Notification t1, Notification t2) -> t1.getTask().getTime().compareTo(t2.getTask().getTime()));
	}
	
	public void addNotification(Task task)
	{
		for (ListIterator<Notification> it = notifications.listIterator(); it.hasNext();) 
		{
			int index = it.nextIndex();
			Notification notification = it.next();
			
			if(notification.getTask().getId() == task.getId())
				throw new IllegalArgumentException("This task also added");
			
			if(notification.getTask().getTime().compareTo(task.getTime()) > 0)
			{
				notifications.add(index, buildNotification(task));
				return;
			}
		}
		notifications.add(buildNotification(task));
	}
	
	public void updateNotification(Task task)
	{
		for(ListIterator<Notification> it = notifications.listIterator(); it.hasNext();)
		{
			Notification notification = it.next();
			if(notification.getTask().getId() == task.getId())
			{
				if(notification.getTask().getTime().compareTo(task.getTime()) != 0)
				{
					it.remove();
				}
				break;
			}
		}
		addNotification(task);
	}
	
	Notification buildNotification(Task task)
	{
		try
		{
			task = task.clone();
		}
		catch(CloneNotSupportedException e){}
		switch(task.getType())
		{
			case WINDOW:
				return new WindowNotification(task);
			case NONE:
			default:
				return new NoneNotification(task);
		}
	}
	public void removeNotification(int taskId)
	{
		for(ListIterator<Notification> it = notifications.listIterator(); it.hasNext();)
		{		
			int index = it.nextIndex();
			Notification notification = it.next();
			if(notification.getTask().getId() == taskId)
			{
				notifications.remove(index);
				return;
			}
		}
	}
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
					if(first.getTask().getTime().compareTo(LocalDateTime.now()) <= 0)
					{
						first.action();
						notifications.removeFirst();
					}
				}
			}
		};
		timer.scheduleAtFixedRate(action, 0, REPEAT_PERIOD);
	}
	void cancel()
	{
		timer.cancel();
	}
}
