package com.todo.todo.taskmanager;

import com.todo.todo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskController extends TaskManager {

    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private Text id;
    @FXML
    private Text titleTask;
    @FXML
    private Text descriptionTask;
    @FXML
    private Text status;
    @FXML
    private ListView<Task> taskListView;



    @FXML
    protected void addMenu() throws IOException {
        openNewStage("task-add.fxml");
    }


    @FXML
    protected void addTask() {
        String name = title.getText();
        String descr = description.getText();
        Task task = new Task(name, descr, false);
        addTask(task);
        viewTask();
        closeCurrentStage();
    }

    @FXML
    protected void viewTasks() throws IOException {
        List<Task> tasks = new ArrayList<>();
        // Добавляем задачи в список (ваша логика создания и добавления задач)
        tasks.add(new Task("Task 1", "Description 1", false));
        tasks.add(new Task("Task 2", "Description 2", true));
        // Создаем ObservableList из списка задач
        ObservableList<Task> observableTasks = FXCollections.observableArrayList(tasks);
        // Устанавливаем ObservableList в ListView
        taskListView.setItems(observableTasks);
        openNewStage("my-tasks.fxml");
//        if (checkEmpty()){
//        }
    }


    void closeCurrentStage() {
        Stage currentStage = (Stage) title.getScene().getWindow(); // Получение текущего Stage
        currentStage.close();
    }

    void openNewStage(String name) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(name));
        Scene scene = new Scene(fxmlLoader.load(), 300, 200);
        stage.setTitle("Планировщик задач");
        stage.setScene(scene);
        stage.show();
    }
}