package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

/**
 *
 * @author St1gven
 */
public class WindowNotification implements Notification{
	private int taskId;
	private LocalDateTime time;
	WindowNotification(int taskId, LocalDateTime time, TemporalAmount shift)
	{
		this.taskId = taskId;
		this.time = time.minus(shift);
	}
	
	@Override
	public int getTaskId() 
	{
		return taskId;
	}

	@Override
	public void setTaskId(int taskId) 
	{
		this.taskId = taskId;
	}

	@Override
	public LocalDateTime getTime()
	{
		return time;
	}
	
	@Override
	public void setTime(LocalDateTime time)
	{
		this.time = time;
	}
	
	@Override
	public void action() 
	{
		System.out.println("WindowsNotification");
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
