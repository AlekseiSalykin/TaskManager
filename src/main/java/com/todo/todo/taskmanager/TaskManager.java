package com.todo.todo.taskmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class TaskManager {
    private static TaskManager instance;
    private ObservableList<Task> tasks;

    public TaskManager() {
        tasks = FXCollections.observableArrayList();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Задача добавлена");
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void changeStatus(Task task){
        if (task != null) {
            boolean currentStatus = task.isStatus();
            task.setStatus(!currentStatus);
        }
    }

    public ObservableList<Task> getObservableTaskList() {
        return tasks;
    }
}
