package com.mycompany.taskmanager.controller;

/**
 *
 * @author St1gven
 */
public interface Notifier {
	Notification addNotification(Task);
	void removeNotification(int taskId);
}
