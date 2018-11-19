package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.Task;

/**
 *
 * @author St1gven
 */
public class NoneNotification implements Notification{
	
	private Task task;
	
	NoneNotification(Task task)
	{
		this.task = task;
	}
	
	@Override
	public Task getTask() 
	{
		return task;
	}

	@Override
	public void setTask(Task task) 
	{
		this.task = task;
	}

	@Override
	public void action() 
	{
		System.out.println("NoneNotification");
		throw new UnsupportedOperationException("Not supported yet."); 
	}
	
}
