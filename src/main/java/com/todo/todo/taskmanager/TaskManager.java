package com.todo.todo.taskmanager;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import lombok.Getter;

import java.util.ArrayList;

public class TaskManager {
    @Getter
    private ArrayList<Task> tasks;


    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Задача добавлена");
    }

    public void deleteTask(int id) {
        Task task = findByIdTask(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Задача под номером " + id + " удалена");
        } else {
            System.out.println("Такой задачи не существует");
        }
    }

    public void changeStatus(int id) {
        Task task = findByIdTask(id);
        if (task != null) {
            if (!task.isStatus()) {
                task.setStatus(true);
            } else task.setStatus(false);
            System.out.println("Статус задачи обновлен");
        } else System.out.println("Такой задчи нет");
    }

    public void viewTask() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст");
        } else {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }

    public boolean checkEmpty(){
        if (tasks.isEmpty()){
            return false;
        }else return true;
    }

    public Task findByIdTask(int id) {
        for (Task task : tasks) {
            if (id == task.getId()) {
                return task;
            }
        }
        return null;
    }

}
