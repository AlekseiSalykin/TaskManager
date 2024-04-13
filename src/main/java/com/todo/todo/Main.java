package com.todo.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Connection connection = DataBaseConnection.connection();
        if (connection != null) {
            String sqlRequest = """
                    CREATE TABLE IF NOT EXISTS tasks (
                        id INTEGER PRIMARY KEY,
                        title TEXT NOT NULL,
                        description TEXT,
                        status INTEGER,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    )""";

            Statement statement = connection.createStatement();
            statement.execute(sqlRequest);
            System.out.println("Таблица создана успешно (или уже существует).");
        } else {
            System.out.println("Таблица не создана");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Планировщик задач");
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}