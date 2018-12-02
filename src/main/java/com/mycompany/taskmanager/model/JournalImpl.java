package com.mycompany.taskmanager.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JournalImpl implements Journal {
    Map<String,Task> listTask;
    JournalImpl()
    {
        Map<String,Task>listTask =new HashMap<String,Task>();
    }
     public void addTask(Task task)
    {
       listTask.putIfAbsent(task.getId(),task);
    }
    public Task getTask(String id)
    {
        if(!listTask.isEmpty() && listTask.containsKey(id))
        return listTask.get(id);
        else
            return null;
    }
    public void deleteTask(String id)
    { if(!listTask.isEmpty() && listTask.containsKey(id))
        listTask.remove(id);
    else
        System.out.print("No such id");
    }
    public Set<Map.Entry<String,Task>> getAllTasks()
    {
        if(!listTask.isEmpty())
            return listTask.entrySet();
        else
            return null;
    }
}
