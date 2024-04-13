package com.todo.todo.taskmanager;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TaskController {

    private final TaskManager taskManager;

    private boolean isFirstMethod = true;

    @FXML
    private TextField title;
    @FXML
    private TextField description;

    @FXML
    private ListView<Task> taskListView;

    public TaskController() {
        taskManager = TaskManager.getInstance();
    }

    @FXML
    protected void initialize() {
        taskManager.loadTasksFromDatabase();
        taskListView.setItems(taskManager.getObservableTaskList());
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
    public void changeStatus() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        taskManager.changeStatus(selectedTask);
        taskListView.refresh();
    }

    @FXML
    public void sort() {
        if (isFirstMethod) {
            taskManager.sortStatus();
            isFirstMethod = false;
        } else {
            taskManager.sortId();
            isFirstMethod = true;
        }
        taskListView.refresh();
    }
}