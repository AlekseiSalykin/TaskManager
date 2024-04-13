module com.todo.todo {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires java.sql;

    opens com.todo.todo to javafx.fxml;
    exports com.todo.todo;
    exports com.todo.todo.taskmanager;
    opens com.todo.todo.taskmanager to javafx.fxml;
}