package Ch3Swing;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class JavaFx extends Application {
    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        webView.getEngine().loadContent("""
            <html>
              <head>
                <style>
                  body { font-family: Arial; background: #f0f0f0; color: #333; padding: 20px; }
                  h1 { color: green; }
                </style>
              </head>
              <body>
                <h1>JavaFX WebView</h1>
                <p>This is styled with CSS!</p>
              </body>
            </html>
        """);

        Scene scene = new Scene(webView, 600, 400);
        stage.setScene(scene);
        stage.setTitle("HTML & CSS in Java");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
