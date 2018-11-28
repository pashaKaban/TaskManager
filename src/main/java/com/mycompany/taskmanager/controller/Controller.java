package com.mycompany.taskmanager.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import com.mycompany.taskmanager.model.*;
import com.mycompany.taskmanager.view.*;
/**
 *
 * @author St1gven
 */
public class Controller 
{	
	private String journalPath;
	
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
	
	private JournalWindow window;
	void setMainWindow(JournalWindow window)
	{
		this.window = window;
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
		window.reloadTable();
	}
	
	/**
	 * Изменить статус задачи на "завершенная"
	 * @param taskId идентификатор задачи
	 */
	void finishTask(int taskId)
	{
		journal.getTask(taskId).setStatus(Status.FINISHED);
		NotificationManager.getNotifier().removeNotification(taskId);
		window.reloadTable(journal);
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
		window.reloadTable(journal);
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
		window.reloadTable(journal);
	}
	
	/**
	 * Изменить статус задачи на "отмененная"
	 * @param taskId идентификатор задачи
	 */
	void cancelTask(int taskId)
	{
		journal.getTask(taskId).setStatus(Status.CANCELED);
		NotificationManager.getNotifier().removeNotification(taskId);
		window.reloadTable(journal);
	}
	
	/**
	 * Изменить параметры задачи
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
		task.setNotificationTime(notificationShift);
		task.setType(type);
		NotificationManager.getNotifier().updateNotification(task.getId());
		window.reloadTable(journal);
	}
	
	/**
	 * Отрисовывает главное окно
	 */
	void showWindow()
	{
		window.showJournal(journal);
	}
	
	/**
	 * Завершает работу приложения
	*/
	void exit()
	{
		JournalLoader.store(journal, Main.journalPath);
	}
}
