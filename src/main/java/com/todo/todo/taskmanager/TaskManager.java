package com.todo.todo.taskmanager;

import com.todo.todo.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.sql.*;
import java.time.LocalDateTime;
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

    public void loadTasksFromDatabase() {
        tasks.clear();
        try {
            Connection connection = DataBaseConnection.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                boolean status = resultSet.getBoolean("status");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                Task task = new Task(id, title, description, status, createdAt);
                tasks.add(task);
            }
            System.out.println("Задачи загружены из базы данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при загрузке задач из базы данных: " + e.getMessage());
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        try {
            Connection connection = DataBaseConnection.connection();
            String sql = "INSERT INTO tasks (title, description, status, created_at) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isStatus());
            statement.setTimestamp(4, Timestamp.valueOf(task.getCreationTime()));
            statement.executeUpdate();
            System.out.println("Задача добавлена в базу данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении задачи в базу данных: " + e.getMessage());
        }
        System.out.println("Задача добавлена");
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
        try {
            Connection connection = DataBaseConnection.connection();
            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getId());
            statement.executeUpdate();
            System.out.println("Задача удалена из базы данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении задачи из базы данных: " + e.getMessage());
        }
    }

    public void changeStatus(Task task) {
        if (task != null) {
            boolean currentStatus = task.isStatus();
            task.setStatus(!currentStatus);
        }
    }

    public void sortStatus() {
        List<Task> tasks = getTasks();
        tasks.sort(new TaskStatusComparator());
    }

    public void sortId() {
        List<Task> tasks = getTasks();
        tasks.sort(new TaskIdComparator());
    }

    public ObservableList<Task> getObservableTaskList() {
        return tasks;
    }
}
