import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

//поменять на стринг
public interface Journal {
    void addTask(TaskIpml task);
    TaskIpml getTask(String id);
    void deleteTask(String id);
    String getNameTaskInJournal(String id);
    void setNameTaskInJournal(String id,String nameTask);
    String getDiscriptionTaskInJournal(String id);
    void setDiscriptionTaskInJournal(String id,String discriptionTask);
    TemporalAmount getIntervalTimeTaskInJournal(String id);
    void setIntervaTimeTaskInJournal(String id,TemporalAmount intervalTimeTask);
    LocalDateTime getPlanTimeTaskInJournalInJournal(String id);
    void setPlanTimeTaskInJournal(String id,LocalDateTime planTimeTask);
    Status getStatusTaskInJournal(String id);
    void setStatusTaskInJournal(String id,Status status);
    NotificationType getNotificationTypeTaskInJournal(String id);
    void setNotificationTaskInJournal(String id,NotificationType notificationType);
}
