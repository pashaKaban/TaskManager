package com.mycompany.taskmanager.controller;

/**
 *
 * @author St1gven
 */
public interface NotificationManager {
	/**
	 * Добавить задачу в отслеживание времени оповещений
	 * @param taskId идентификатор задачи
	 */
	void addNotification(int taskId);
	
	/**
	 * Удалить задачу из отслеживания времени оповещения
	 * @param taskId 
	 */
	void removeNotification(int taskId);
	
	/**
	 * Обновить состояние задачи
	 * @param taskId 
	 */
	void updateNotification(int taskId);
	
	/**
	 * Начать отслеживание времени оповещений
	 */
	void start();
	
	/**
	 * Завершить отслеживание времени оповещений
	 */
	void cancel();
}
