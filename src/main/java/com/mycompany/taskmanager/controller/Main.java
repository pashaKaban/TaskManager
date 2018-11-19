package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.NotificationType;
import com.mycompany.taskmanager.model.Task;
import java.time.LocalDateTime;

/**
 *
 * @author St1gven
 */
public class Main 
{
	
	/**
     * @param args the command line arguments
     */
	public static void main(String[] args) throws InterruptedException
	{
		Notifier n = new Notifier();
		Task t1 = new Task("fd", "fsdf", LocalDateTime.now().minusHours(1), NotificationType.WINDOW);
		n.addNotification(t1);
		Task t2 = new Task("fd", "fsdf", LocalDateTime.now(), NotificationType.NONE);
		n.addNotification(t2);
		Thread.sleep(20000);
		n.cancel();
		//while(true);
	}
}
