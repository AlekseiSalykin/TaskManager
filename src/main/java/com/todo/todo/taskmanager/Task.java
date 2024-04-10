package com.todo.todo.taskmanager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private LocalDateTime creationTime;

    public Task(String title, String description, boolean status) {
        this.id = idGenerator.getAndIncrement();
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationTime = LocalDateTime.now();
    }

    @Override
    public String toString(){
        String statusStr = status ? "Выполнено" : "В работе";
        String formattedDate = creationTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String formattedTime = creationTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        return "Задача № " + id
                + "\nНаименование: " + title
                + "\nОписание: " + description
                + "\nСтатус: " + statusStr
                + "\nВремя: " + formattedTime + " Дата: " + formattedDate;
    }
}
