package com.todo.todo.taskmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskManager {
    private static TaskManager instance;
    private final ObservableList<Task> tasks;

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

    public void sortStatus(){
        List<Task> tasks = getTasks();
        tasks.sort(new TaskStatusComparator());
    }

    public void sortId(){
        List<Task> tasks = getTasks();
        tasks.sort(new TaskIdComparator());
    }

    public ObservableList<Task> getObservableTaskList() {
        return tasks;
    }
}
