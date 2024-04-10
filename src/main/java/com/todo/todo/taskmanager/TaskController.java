package com.todo.todo.taskmanager;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TaskController {

    private TaskManager taskManager;

    @FXML
    private TextField title;
    @FXML
    private TextField description;

    @FXML
    private ListView<Task> taskListView;

    public TaskController(){
        taskManager = TaskManager.getInstance();
    }

    @FXML
    protected void initialize() {
        if (taskManager.getObservableTaskList() != null && !taskManager.getObservableTaskList().isEmpty()) {
            taskListView.setItems(taskManager.getObservableTaskList());
        } else {
            taskListView.setAccessibleText("Список задач пуст");
            System.out.println("Список задач пуст");
        }
    }

    @FXML
    protected void addTask() {
        String name = title.getText();
        String descr = description.getText();
        Task task = new Task(name, descr, false);
        taskManager.addTask(task);
        initialize();
        title.clear();
        description.clear();
    }

    @FXML
    public void deleteTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskManager.deleteTask(selectedTask);
        }
    }

    @FXML
    public void changeStatus(){
       Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
       taskManager.changeStatus(selectedTask);
       taskListView.refresh();
    }
}