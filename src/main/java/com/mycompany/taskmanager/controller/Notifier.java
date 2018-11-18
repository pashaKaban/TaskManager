package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.Task;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author St1gven
 */
public class Notifier {
	LinkedList<Notification> notifications;
	public void addNotification(Task task)
	{
		for (ListIterator<Notification> it = notifications.listIterator(); it.hasNext();) 
		{
			int index = it.nextIndex();
			Notification notification = it.next();
			
			int cmp = notification.getTask().getTime().compareTo(task.getTime());
			
			if(cmp == 0)
			{
				throw new IllegalArgumentException();
			}
			
			if(cmp > 0)
			{
				Notification newNotification = null;
				switch(task.getType())
				{
					case WINDOW:
						newNotification = new WindowNotification(task);
						break;
					case NONE:
						newNotification = new NoneNotification(task);
						break;
				}
				notifications.add(index + 1, newNotification);
				return;
			}
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
	
	void action()
	{
		Notification first = notifications.getFirst();
		if(notifications.getFirst().getTask().getTime().compareTo(LocalDateTime.now()) > 0)
		{
			first.action();
		}
	}
	void start()
	{
		Timer timer = new Timer(true);
		TimerTask action;
		action = new TimerTask()
		{
			@Override
			public void run()
			{
				Notification first = notifications.getFirst();
				if(notifications.getFirst().getTask().getTime().compareTo(LocalDateTime.now()) > 0)
				{
					first.action();
				}
			}
		};
		timer.scheduleAtFixedRate(action, 0, 5);
	}
}
