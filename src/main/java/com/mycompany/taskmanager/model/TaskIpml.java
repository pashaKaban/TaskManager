package com.mycompany.taskmanager.model;
import java.time.LocalDateTime;
public class TaskIpml implements Task {
    String id;
    String nameTask;
    String discription;
    LocalDateTime planTime;
    LocalDateTime intervalTime;
    Status status;
    NotificationType notificationType;

    public TaskIpml(String nameTask,String discription,LocalDateTime planTime,LocalDateTime intervalTime,Status status,NotificationType notificationType){
        this.id= IdGenerator.generateId();
        this.discription=discription;
        this.intervalTime=intervalTime;
        this.nameTask=nameTask;
        this.notificationType=notificationType;
        this.planTime=planTime;
        this.status=status;
    }

    public String getId() {
        return this.id;
    }
    public String getNameTask(){
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LocalDateTime getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(LocalDateTime intervalTime) {
        this.intervalTime = intervalTime;
    }

    public LocalDateTime getPlanTime() {
        return planTime;
    }

    public void setPlanTime(LocalDateTime planTime) {
        this.planTime = planTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
