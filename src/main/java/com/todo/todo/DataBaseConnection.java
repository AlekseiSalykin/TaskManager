package com.todo.todo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite::resource:tasks.db");
            System.out.println("Соединение с базой данных установлено.");
        } catch (Exception e) {
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
        return connection;
    }
}
