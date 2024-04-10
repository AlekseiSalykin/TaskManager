package com.todo.todo.taskmanager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private static AtomicInteger idGenerator = new AtomicInteger(1);

    private int id;
    private String title;
    private String description;
    private boolean status;

    public Task(String title, String description, boolean status) {
        this.id = idGenerator.getAndIncrement();
        this.title = title;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString(){
        return "Задача № " + id
                + "\nНаименование: " + title
                + "\nОписание: " + description
                + "\nСтатус: " + status;
    }
}
