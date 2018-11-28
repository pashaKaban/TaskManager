
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class JournalIpml implements Journal {
    ArrayList<TaskIpml> listTask;

    public JournalIpml() {
        ArrayList<TaskIpml> listTask = new ArrayList<TaskIpml>();
    }

    public void addTask(TaskIpml task) {
        listTask.add(task);
    }

    public TaskIpml getTask(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                return this.listTask.get(i);
            }
        }
        return null;
    }

    public void deleteTask(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.remove(i);
                break;
            }
        }
    }

    public String getNameTaskInJournal(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id))
                return this.listTask.get(i).getNameTask();
        }
        return null;
    }

    public void setNameTaskInJournal(String id,String nameTask) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.get(i).setNameTask(nameTask);
                break;
            }
        }
    }

    public String getDiscriptionTaskInJournal(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id))
                return this.listTask.get(i).getDiscription();
        }
        return null;
    }
    public void setDiscriptionTaskInJournal(String id,String discriptionTask) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.get(i).setDiscription(discriptionTask);
                break;
            }
        }
    }

    public TemporalAmount getIntervalTimeTaskInJournal(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id))
                return this.listTask.get(i).getIntervalTime();
        }
        return null;
    }
    public void setIntervaTimeTaskInJournal(String id,TemporalAmount intervalTimeTask) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.get(i).setIntervalTime(intervalTimeTask);
                break;
            }
        }
    }
    public LocalDateTime getPlanTimeTaskInJournalInJournal(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id))
                return this.listTask.get(i).getPlanTime();
        }
        return null;
    }
    public void setPlanTimeTaskInJournal(String id,LocalDateTime planTimeTask) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.get(i).setPlanTime(planTimeTask);
                break;
            }
        }
    }
    public Status getStatusTaskInJournal(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id))
                return this.listTask.get(i).getStatus();
        }
        return null;
    }
    public void setStatusTaskInJournal(String id,Status status) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.get(i).setStatus(status);
                break;
            }
        }
    }
    public NotificationType getNotificationTypeTaskInJournal(String id) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id))
                return this.listTask.get(i).getNotificationType();
        }
        return null;
    }
    public void setNotificationTaskInJournal(String id,NotificationType notificationType) {
        for (int i = 0; i < this.listTask.size(); i++) {
            if (this.listTask != null && this.listTask.get(i).getId().equals(id)) {
                this.listTask.get(i).setNotificationType(notificationType );
                break;
            }
        }
    }
}
