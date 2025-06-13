package Ch3Swing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFx extends Application {
    @Override
    public void start(Stage stage) {
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        txt3.setEditable(false);

        // Set size and font for all text fields
        TextField[] fields = {txt1, txt2, txt3};
        for (TextField field : fields) {
            field.setPrefSize(100, 100);
            field.setFont(new Font(20));
        }

        Label plus = new Label("+");
        Label equal = new Label("=");
        plus.setFont(new Font(30));
        equal.setFont(new Font(30));

        Button button = new Button("CALCULATE");
        button.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(txt1.getText());
                int num2 = Integer.parseInt(txt2.getText());
                int sum = num1 + num2;
                txt3.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WARNING");
                alert.setHeaderText("PLEASE NO STRING");
                alert.setContentText("RE-TRY");
                alert.showAndWait();
            }
        });

        // Layout setup
        HBox inputBox = new HBox(10, txt1, plus, txt2, equal, txt3);
        inputBox.setPadding(new Insets(20));
        inputBox.setSpacing(20);

        VBox root = new VBox(30, inputBox, button);
        root.setPadding(new Insets(50));
        root.setStyle("-fx-alignment: center;");

        Scene scene = new Scene(root, 800, 400);
        stage.setTitle("Basic JavaFX Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}