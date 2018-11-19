package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import com.mycompany.taskmanager.model.*;
/**
 *
 * @author St1gven
 */
public class Controller {
	//TODO Singleton
	private Journal journal;
	public void setJournal(Journal journal)
	{
		this.journal = journal;
	}
	
	public Task createTask(String name, String description, LocalDateTime datetime, NotificationType type)
	{
		return new Task(name, description, datetime, type);
	}
	
	public void finishTask(int taskId)
	{
		Task task = journal.removeTask(taskId, Status.ACTIVE);
		task.setStatus(Status.FINISHED);
		journal.addTask(task);
	}
	
	public Task postponeTask(int taskId, TemporalAmount shift)
	{
		Task task = journal.getTask(taskId, Status.ACTIVE);
		task.setTime(task.getTime().plus(shift));
		return task;
	}
	
	public Task postponeTask(int taskId, LocalDateTime datetime)
	{
		Task task = journal.getTask(taskId, Status.ACTIVE);
		task.setTime(datetime);
		return task;
	}
	
	public void cancelTask(int taskId)
	{
		Task task = journal.removeTask(taskId, Status.ACTIVE);
		task.setStatus(Status.CANCELED);
		journal.addTask(task);
	}
	
	public Task changeTask(int taskId, String name, String description, LocalDateTime time, NotificationType type)
	{
		Task task = journal.getTask(taskId, Status.ACTIVE);
		task.setName(name);
		task.setDescription(description);
		task.setTime(time);
		task.setType(type);
		return task;
	}
}
