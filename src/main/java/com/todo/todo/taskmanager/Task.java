package com.todo.todo.taskmanager;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
public class Task {
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private int id;
    private String title;
    private String description;
    private boolean status;
    private LocalDateTime creationTime;

    public Task(int id, String title, String description, boolean status, LocalDateTime creationTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationTime = creationTime;
    }

    public Task(String title, String description, boolean status) {
        this.id = idGenerator.getAndIncrement();
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationTime = LocalDateTime.now();
    }

    public static void setIdGenerator(AtomicInteger idGenerator) {
        Task.idGenerator = idGenerator;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        String statusStr = status ? "Выполнено" : "В работе";
        String formattedDate = creationTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String formattedTime = creationTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        return "Наименование: " + title
                + "\nОписание: " + description
                + "\nСтатус: " + statusStr
                + "\nВремя: " + formattedTime + " Дата: " + formattedDate;
    }
}
