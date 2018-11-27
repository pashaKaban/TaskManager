package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;

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
	 * Получить время оповещения данного уведомления
	 * @return время оповещения
	 */
	LocalDateTime getTime();
	
	/**
	 * Устанавливает время оповещения данного уведомления
	 * @param time время оповещения
	 */
	void setTime(LocalDateTime time);
	
	/**
	 * Уведомление пользователя о наступлении события
	 */
	void action();
}
