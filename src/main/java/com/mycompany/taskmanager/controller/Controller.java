package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
/**
 *
 * @author St1gven
 */
public interface Controller {
	setJournal(Journal journal);
	
	void createTask(String name, String description, LocalDateTime datetime, NotificationType type);
	void finishTask(int taskId);
	void postponeTask(int taskId, TemporalAmount shift);
	void postponeTask(int taskId, LocalDateTime datetime);
	void changeTask(String name, String description, LocalDateTime datetime,  NotificationType type);
	void cancelTask(int taskId);
}
