package com.mycompany.taskmanager.model;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public interface Task {
    String getId();
    String getNameTask();
    void setNameTask(String nameTask);
    String getDiscription();
    void setDiscription(String discription);
    TemporalAmount getIntervalTime();
    void setIntervalTime(TemporalAmount intervalTime);
    LocalDateTime getPlanTime();
    void setPlanTime(LocalDateTime planTime);
    Status getStatus();
    void setStatus(Status status);
    NotificationType getNotificationType();
    void setNotificationType(NotificationType notificationType);
}
