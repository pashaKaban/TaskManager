package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import com.mycompany.taskmanager.model.*;
/**
 *
 * @author St1gven
 */
public class Controller 
{
	private Controller(){}
	
	private static class ControllerHolder
	{
		private final static Controller instance = new Controller();
	}
	
	/**
	 * @return экземпляр Controller
	 */
	public static Controller getController()
	{
		return ControllerHolder.instance;
	}
	
	private Journal journal;
	/**
	 * Устанавливает журнал с которым будет работать контроллер
	 * @param journal журнал
	 */
	void setJournal(Journal journal)
	{
		this.journal = journal;
	}
	
	/**
	 * @param taskId идентификатор задачи
	 * @return обьект Task с соответствующим идентификатором
	 */
	Task getTask(int taskId)
	{
		return journal.getTask(taskId);
	}
	
	/**
	 * Создание задачи, добавление ее в журнал
	 * @param name название задачи
	 * @param description описание задачи
	 * @param datetime время и дата задачи
	 * @param notificationShift время, за которое должно сработать оповещение
	 * @param type тип уведомления
	 */
	void createTask(String name, String description, LocalDateTime datetime, 
			TemporalAmount notificationShift, NotificationType type)
	{
		Task task = new Task(name, description, datetime, notificationShift, type);
		journal.addTask(task);
		NotificationManager.getNotifier().addNotification(task.getId());
		//TODO redrawJournal
	}
	
	/**
	 * �?зменить статус задачи на "завершенная"
	 * @param taskId идентификатор задачи
	 */
	void finishTask(int taskId)
	{
		journal.finishTask(taskId);
		NotificationManager.getNotifier().removeNotification(taskId);
		//TODO redrawJournal
	}
	
	/**
	 * Отложить задачу на определенное время
	 * Новое время задачи определяется путем прибавления к текущему времени количсетво времени определяемое параметром shift
	 * @param taskId идентификатор задачи
	 * @param shift количество времени, на которое перемещается задачу
	 */
	void postponeTask(int taskId, TemporalAmount shift)
	{
		Task task = journal.getTask(taskId);
		task.setTime(task.getTime().plus(shift));
		NotificationManager.getNotifier().updateNotification(taskId);
		//TODO redrawJournal
	}
	
	/**
	 * Перенести задачу на определенное время
	 * @param taskId идентификатор задачи
	 * @param datetime время, на которое перемещается задача
	 */
	void postponeTask(int taskId, LocalDateTime datetime)
	{
		Task task = journal.getTask(taskId);
		task.setTime(datetime);
		NotificationManager.getNotifier().updateNotification(taskId);
		//TODO redrawJournal
	}
	
	/**
	 * �?зменить статус задачи на "отмененная"
	 * @param taskId идентификатор задачи
	 */
	void cancelTask(int taskId)
	{
		journal.cancelTask(taskId);
		NotificationManager.getNotifier().removeNotification(taskId);
		//TODO redrawJournal
	}
	
	/**
	 * �?зменить параметры задачи
	 * @param taskId идентификатор задачи
	 * @param name Название задачи
	 * @param description Описание задачи
	 * @param datetime Время и дата задачи
	 * @param notificationShift время, в которое должно сработать оповещение
	 * @param type Тип уведомления
	 */
	void changeTask(int taskId, String name, String description, 
			LocalDateTime datetime, TemporalAmount notificationShift,  NotificationType type)
	{
		Task task = journal.getTask(taskId);
		task.setName(name);
		task.setDescription(description);
		task.setTime(datetime);
		task.setNotificationTime(notificationTime);
		task.setType(type);
		NotificationManager.getNotifier().updateNotification(task.getId());
		//TODO redrawJournal
	}
}
