package com.mycompany.taskmanager.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author St1gven
 */
public class Task implements Cloneable, Serializable{
	private int id;
	private String name;
	private String description;
	private LocalDateTime time;
	private NotificationType type;
	private Status status;
	
	public Task(String name, String description, LocalDateTime time, NotificationType type)
	{
		id = IdGenerator.getNextId();
		this.name = name;
		this.description = description;
		this.time = time;
		this.type = type;
		status = Status.ACTIVE;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public LocalDateTime getTime()
	{
		return time;
	}
	public void setTime(LocalDateTime time)
	{
		this.time = time;
	}
	
	public NotificationType getType()
	{
		return type;
	}
	public void setType(NotificationType type)
	{
		this.type = type;
	}
	
	public Status getStatus()
	{
		return status;
	}
	public void setStatus(Status status)
	{
		this.status = status;
	}
	
	@Override
	public Task clone() throws CloneNotSupportedException
	{
		return (Task)super.clone();
	}
}
