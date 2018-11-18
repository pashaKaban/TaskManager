package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.Task;

/**
 *
 * @author St1gven
 */
public interface Notification {
	Task getTask();
	void setTask(Task task);
	void action();
}
