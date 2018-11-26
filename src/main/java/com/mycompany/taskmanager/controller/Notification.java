package com.mycompany.taskmanager.controller;

/**
 *
 * @author St1gven
 */
public interface Notification {
	/**
	 * Получить идентификатор задачи связанной с данным уведомлением
	 * @return идентификатор задачи
	 */
	int getTaskId();
	
	/**
	 * Установить задачу для данного уведомления
	 * @param taskId идентификатор задачи
	 */
	void setTaskId(int taskId);
	
	/**
	 * Уведомление пользователя о наступлении события
	 */
	void action();
}
