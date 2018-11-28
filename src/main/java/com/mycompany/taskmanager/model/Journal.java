import java.time.LocalDateTime;
//поменять на стринг
public interface Journal {
    void addTask(TaskIpml task);
    TaskIpml getTask(String id);
    void deleteTask(String id);
    String getNameTaskInJournal(String id);
    void setNameTaskInJournal(String id,String nameTask);
    String getDiscriptionTaskInJournal(String id);
    void setDiscriptionTaskInJournal(String id,String discriptionTask);
    LocalDateTime getIntervalTimeTaskInJournal(String id);
    void setIntervaTimeTaskInJournal(String id,LocalDateTime intervalTimeTask);
    LocalDateTime getPlanTimeTaskInJournalInJournal(String id);
    void setPlanTimeTaskInJournal(String id,LocalDateTime planTimeTask);
    Status getStatusTaskInJournal(String id);
    void setStatusTaskInJournal(String id,Status status);
    NotificationType getNotificationTypeTaskInJournal(String id);
    void setNotificationTaskInJournal(String id,NotificationType notificationType);
}
