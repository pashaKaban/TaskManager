package com.mycompany.taskmanager.model;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.Map;
import java.util.Set;

//поменять на стринг
public interface Journal {
	//TODO id
    public void addTask(Task task);
    public Task getTask(String id);
    public void deleteTask(String id);
    public Set<Map.Entry<String,Task>> getAllTasks();
}
