package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.net.URL;

import static javafx.application.Application.launch;


public class TaskWindow extends Application{

   // private Stage ownerStage;
    private Stage stage;
    public static Task task;
    private ObservableList<Integer> hoursTask = FXCollections.observableArrayList();
    private ObservableList<Integer> minTask = FXCollections.observableArrayList();
    //private boolean b;

    public TaskWindow(){
    }

    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private ChoiceBox<Integer> hours;
    @FXML
    private ChoiceBox<Integer> min;
    @FXML
    private Button btnSave;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        //this.b = b;
        URL s = getClass().getResource("task.fxml");
        Parent root = FXMLLoader.load(s);

        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.setTitle("Task");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
       // primaryStage.initOwner(ownerStage);
    }

    @FXML
    private void initialize() {
        initTask();
       hours.setItems(hoursTask);
       min.setItems(minTask);
       title.setText(task.getName());
       description.setText(task.getDescription());
       hours.getSelectionModel().select(0);
       min.getSelectionModel().select(0);
    }

    private void initTask(){
        for(int i = 0; i < 24; i++) {
            hoursTask.add(i);
        }
        for (int i = 0; i < 60; i++){
            minTask.add(i);
        }
    }

    @FXML
    private void saveTask(){
        Controller.getInstance().createTask(title.getText(), hours.getItems(), min.getItems(), description.getText());
        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancel(){

    }

    public void setTask(Task task) {
        this.task = task;
    }

   /* void setOwnerStage(Stage ownerStage) {
        this.ownerStage = ownerStage;
    }*/

  //  public Stage getStage() {
    //    return stage;
    //}



}
