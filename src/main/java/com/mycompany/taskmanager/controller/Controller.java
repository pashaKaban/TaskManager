package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
/**
 *
 * @author St1gven
 */
public interface Controller {
	/**
	 * Устанавливает журнал с которым будет работать контроллер
	 */
	void setJournal(Journal journal);
	
	/**
	 * Создание задачи, добавление ее в журнал
	 * @param name название задачи
	 * @param description описание задачи
	 * @param datetime время и дата задачи
	 * @param notificationTime время, в которое должно сработать оповещение
	 * @param type тип уведомления
	 */
	void createTask(String name, String description, LocalDateTime datetime, LocalDateTime notificationTime, NotificationType type);
	
	/**
	 * Изменить статус задачи на "завершенная"
	 * @param taskId идентификатор задачи
	 */
	void finishTask(int taskId);
	
	/**
	 * Отложить задачу на определенное время
	 * Новое время задачи определяется путем прибавления к текущему времени количсетво времени определяемое параметром shift
	 * @param taskId идентификатор задачи
	 * @param shift количество времени, на которое перемещается задачу
	 */
	void postponeTask(int taskId, TemporalAmount shift);

	/**
	 * Перенести задачу на определенное время
	 * @param taskId идентификатор задачи
	 * @param datetime время, на которое перемещается задача
	 */
	void postponeTask(int taskId, LocalDateTime datetime);
	
	/**
	 * Изменить параметры задачи
	 * @param taskId идентификатор задачи
	 * @param name Название задачи
	 * @param description Описание задачи
	 * @param datetime Время и дата задачи
	 * @param notificationTime время, в которое должно сработать оповещение
	 * @param type Тип уведомления
	 */
	void changeTask(int taskId, String name, String description, LocalDateTime datetime, LocalDateTime notificationTime,  NotificationType type);
	
	/**
	 * Изменить статус задачи на "отмененная"
	 * @param taskId идентификатор задачи
	 */
	void cancelTask(int taskId);
}
