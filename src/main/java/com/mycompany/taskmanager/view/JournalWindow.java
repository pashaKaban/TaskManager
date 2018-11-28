package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.time.LocalDateTime;

public class JournalWindow extends Application {

    private ObservableList<Task> taskData;
    private Stage stage;
    private static ObservableList<String> stateTask = FXCollections.observableArrayList("active", "finised", "cancel");
    private static Journal journal = new Journal();

    @FXML
    private TableView<Task> table;

    @FXML
    private TableColumn<Task, String> timeColumn;
    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private ChoiceBox<String> states;

    // инициализируем форму данными
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        timeColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("time"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));

        // заполняем таблицу данными
        table.setItems(taskData);
        states.setItems(stateTask);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        taskData = FXCollections.observableArrayList(journal.getTasks());
    }

    public void reloadTable(Journal journal) {
        taskData.clear(); //очищаем список точек
        //taskData.add(new Task("d","d", "d"));
        initData();
        table.refresh(); //перерисовываем таблицу
    }

    @FXML
    private void addTask() throws Exception {
        TaskWindow taskWindow = new TaskWindow();
       // taskWindow.setOwnerStage(stage);
        taskWindow.start(new Stage());
        stage.showAndWait();
    }

    @FXML
    private void showTask() throws Exception{

       // taskWindow.setOwnerStage(stage);
        Task task = table.getFocusModel().getFocusedItem();
        TaskWindow taskWindow = new TaskWindow();
        TaskWindow.task = task;
        //taskWindow.setTask(task);
        taskWindow.start(new Stage());

       // stage.showAndWait();
    }

    @FXML
    private void deleteTask(){
        int index=table.getFocusModel().getFocusedCell().getRow();
        taskData.remove(index);
        table.refresh();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("journal.fxml"));
        primaryStage.setTitle("journal");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
	
	public void showJournal(Journal journal)
	{
		this.journal = journal;
		start(new Stage());
	}

    public static void main(String[] args) {
        launch(args);
    }
}