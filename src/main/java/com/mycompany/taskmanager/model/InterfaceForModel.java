package com.mycompany.taskmanager.model;

import javax.management.Notification;
import java.time.LocalDateTime;
import com.mycompany.taskmanager.model.Task;//импорт необходимых классов
import com.mycompany.taskmanager.model.Status;
import com.mycompany.taskmanager.model.NotificationType;


public interface InterfaceForModel {
    //class JournalLoader
    public Journal dowloadJournal(String fileName);
    public void storeJournal(String fileName,Journal journalName);
    //class Task
    public String getId();
    public String getNameTask();
    public void setNameTask(String nameTask);
    public String getDefinishionTask();
    public void setDefinitionTask(String definitionTask);
    public Status getStatusTask();//?
    public void setStatusTask(Status statusTask);
    public NotificationType getTypeTask();
    public void setTypeTask(NotificationType typeTask);
    public LocalDateTime getTimeTask();
    //нужно ли менять время создания задания?
    //class Journal
    public void delayTask(Task task);
    public Task addTaskToJournal(String id,String taskName,String definishion, Status status,NotificationType typeTask);
    public void deleteTask();
    public ArrayList<Task> getActiveTasks();
    public ArrayList<Task> getFinishedTasks();
    public ArrayList<Task> getCanceledTasks();


}
