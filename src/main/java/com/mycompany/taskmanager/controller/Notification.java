package com.mycompany.taskmanager.controller;

/**
 *
 * @author St1gven
 */
public interface Notification {
	Task getTask();
	void setTask(Task task);
	void action();
}
