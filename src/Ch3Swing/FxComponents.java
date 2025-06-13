package Ch3Swing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxComponents extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label and a button
        Label label = new Label("Hello, JavaFX!");
        Button button = new Button("Click Me");

        // Set button action
        button.setOnAction(e -> label.setText("Button Clicked!"));

        // Layout
        VBox layout = new VBox(10); // 10 px spacing
        layout.getChildren().addAll(label, button);

        // Create a scene
        Scene scene = new Scene(layout, 300, 200);

        // Set up the stage
        primaryStage.setTitle("JavaFX Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
