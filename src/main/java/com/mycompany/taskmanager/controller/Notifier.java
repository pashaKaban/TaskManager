package com.mycompany.taskmanager.controller;

/**
 *
 * @author St1gven
 */
public interface Notifier {
	void addNotification(Task);
	void removeNotification(int taskId);
}
