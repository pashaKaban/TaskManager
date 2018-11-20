package com.mycompany.taskmanager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author St1gven
 */
public class Journal implements Serializable{
	public ArrayList<Task> activeTasks = new ArrayList<>();
	public ArrayList<Task> finshedTasks = new ArrayList<>();
	public ArrayList<Task> canceledTasks = new ArrayList<>();
	
	public ArrayList<Task> getActiveTasks()
	{
		return activeTasks;
	}
	public ArrayList<Task> getFinishedTasks()
	{
		return finshedTasks;
	}
	public ArrayList<Task> getCanceledTasks()
	{
		return canceledTasks;
	}
	private ArrayList<Task> getCollection(Status status)
	{
		switch(status)
		{
			case ACTIVE:
				return activeTasks;
			case FINISHED:
				return finshedTasks;
			case CANCELED:
			default:
				return canceledTasks;
		}
	}
	public Task getTask(int taskId, Status status)
	{
		ArrayList<Task> tasks = getCollection(status);
		for(Task task:tasks)
			if(task.getId() == taskId)
				return task;
		throw new IllegalArgumentException("There is no task with same id");
	}
	public Task removeTask(int taskId, Status status)
	{
		ArrayList<Task> tasks = getCollection(status);
		for(int i = 0; i < tasks.size(); i++)
		{
			Task task = tasks.get(i);
			if(task.getId() == taskId)
			{
				tasks.remove(i);
				return task;
			}
		}
		throw new IllegalArgumentException("There is no task with same id");
	}
	public void addTask(Task task)
	{
		ArrayList<Task> tasks = getCollection(task.getStatus());
		tasks.add(task);
	}
}
