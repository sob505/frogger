import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FroggerGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Frogger");

        Pane background = new Pane();
        background.setMinWidth(800);
        background.setMinHeight(700);

        Game frogger = new Game(background);

        Scene scene = new Scene(background, 800, 700);
        stage.setScene(scene);
        stage.show();

        frogger.play();
    }
}
