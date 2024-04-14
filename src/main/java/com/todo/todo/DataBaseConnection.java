package com.todo.todo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static Connection connection() {
        Connection connection = null;
        try {
            // Получаем абсолютный путь к файлу базы данных
            String dbFilePath = new File("tasks.db").getAbsolutePath();
            // Устанавливаем соединение с базой данных, используя абсолютный путь
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
            System.out.println("Соединение с базой данных установлено.");
        } catch (Exception e) {
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
        return connection;
    }
}
