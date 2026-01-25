import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class bottoni extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click me!");
        button.setOnAction(e -> System.out.println("Button clicked!"));

        Scene scene = new Scene(button, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Button Example");
        primaryStage.show();
    }
}
