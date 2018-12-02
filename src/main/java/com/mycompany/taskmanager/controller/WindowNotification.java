package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

/**
 *
 * @author St1gven
 */
public class WindowNotification implements Notification{
	private String taskId;
	private LocalDateTime time;
	WindowNotification(String taskId, LocalDateTime time, TemporalAmount shift)
	{
		this.taskId = taskId;
		this.time = time.minus(shift);
	}
	
	@Override
	public String getTaskId() 
	{
		return taskId;
	}

	@Override
	public void setTaskId(String taskId) 
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
