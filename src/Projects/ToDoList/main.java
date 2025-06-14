package Projects.ToDoList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.geometry.Insets;


public class main extends Application {

    @Override
    public void start(Stage stage) {
        Label head = new Label("To-Do List");
        TextField todo= new TextField("Insert new task");
        Button add = new Button("Add");
        Button del = new Button("Abort");
        ListView<String> taskList = new ListView<>();

        add.setOnAction(e -> {
            String task = todo.getText().trim();
            if (task.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Please enter a task.");
                alert.showAndWait();
            } else {
                taskList.getItems().add(task);
                todo.clear();
            }
        });

        del.setOnAction(e -> {
            int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String current = taskList.getItems().get(selectedIndex);
                if (!current.endsWith("❌")) {
                    taskList.getItems().set(selectedIndex, current + " ❌");
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Info");
                alert.setContentText("No task selected to delete.");
                alert.showAndWait();
            }
        });

        HBox inputBox = new HBox(10, todo, add, del);
        inputBox.setPadding(new Insets(10));


        VBox root = new VBox(30, head, inputBox, taskList);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-alignment: center;");

        Scene scene = new Scene(root, 800, 400);
        stage.setTitle("To-Do App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}