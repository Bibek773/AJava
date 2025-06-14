


// Everything done by myself except style
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
        head.setFont(new Font("Arial", 32));
        head.setStyle("-fx-font-weight: bold;");
        head.setMaxWidth(Double.MAX_VALUE);
        head.setStyle("-fx-alignment: center; -fx-font-size: 32px; -fx-font-weight: bold;");


        TextField todo = new TextField();
        todo.setPromptText("Insert new task");
        todo.setFont(new Font("Arial", 16));
        todo.setStyle("-fx-background-radius: 8;");


        Button add = new Button("Add");
        Button del = new Button("Mark Done");
        Button dell = new Button("Not Completed");


        add.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        del.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        dell.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");


        ListView<String> taskList = new ListView<>();
        taskList.setPrefHeight(250);
        taskList.setStyle("-fx-background-radius: 10; -fx-border-color: #cccccc;");

        taskList.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    if (item.endsWith("✔️")) {
                        setStyle("-fx-background-color: #30e813;");
                    } else if (item.endsWith("❌")) {
                        setStyle("-fx-background-color: #ea1208;");
                    } else {
                        setStyle("");
                    }
                }
            }
        });


        add.setOnAction(e -> {
            String task = todo.getText().trim();
            if (task.isEmpty()) {
                showAlert("Warning", "Please enter a task.");
            } else {
                taskList.getItems().add(task);
                todo.clear();
            }
        });


        del.setOnAction(e -> {
            int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String current = taskList.getItems().get(selectedIndex);
                if (!current.endsWith("✔️")) {
                    current = current.replace("❌", "").trim();
                    taskList.getItems().set(selectedIndex, current + " ✔️");
                }
            } else {
                showAlert("Info", "No task selected to mark as done.");
            }
        });


        dell.setOnAction(e -> {
            int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String current = taskList.getItems().get(selectedIndex);
                if (!current.endsWith("❌")) {
                    current = current.replace("✔️", "").trim();
                    taskList.getItems().set(selectedIndex, current + " ❌");
                }
            } else {
                showAlert("Info", "No task selected to mark as not completed.");
            }
        });


        HBox inputBox = new HBox(10, todo, add);
        inputBox.setPadding(new Insets(10));
        inputBox.setStyle("-fx-alignment: center;");

        HBox actionButtons = new HBox(10, del, dell);
        actionButtons.setPadding(new Insets(10));
        actionButtons.setStyle("-fx-alignment: center-right;");

        VBox root = new VBox(20, head, inputBox, taskList, actionButtons);
        root.setPadding(new Insets(30));
        root.setStyle("""
            -fx-alignment: top-center;
            -fx-background-color: #f5f5f5;
        """);


        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("To-Do App");
        stage.setScene(scene);
        stage.show();
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
