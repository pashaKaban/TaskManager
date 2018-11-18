package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
/**
 *
 * @author St1gven
 */
public interface Controller {
	setJournal(Journal journal);
	
	Task createTask(String name, String description, LocalDateTime datetime, NotificationType type);
	void deleteTask(int taskId);
	Task postponeTask(int taskId, TemporalAmount shift);
	Task postponeTask(int taskId, LocalDateTime datetime);
	Task changeTask(String name, String description, LocalDateTime datetime);
	void cancelTask(int taskId);
}
