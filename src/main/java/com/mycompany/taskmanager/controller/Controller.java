package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
/**
 *
 * @author St1gven
 */
public interface Controller {
	void setJournal(Journal journal);
	
	/**
	 * Создание задачи, добавление ее в журнал
	 * @param name Название задачи
	 * @param description Описание задачи
	 * @param datetime Время и дата задачи
	 * @param type Тип уведомления
	 */
	void createTask(String name, String description, LocalDateTime datetime, NotificationType type);
	
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
	 * @param name Название задачи
	 * @param description Описание задачи
	 * @param datetime Время и дата задачи
	 * @param type Тип уведомления
	 */
	void changeTask(String name, String description, LocalDateTime datetime,  NotificationType type);
	
	/**
	 * Изменить статус задачи на "отмененная"
	 * @param taskId 
	 */
	void cancelTask(int taskId);
}
