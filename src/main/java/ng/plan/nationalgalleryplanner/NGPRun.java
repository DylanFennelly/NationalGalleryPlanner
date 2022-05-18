package ng.plan.nationalgalleryplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NGPRun extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent p = FXMLLoader.load(Objects.requireNonNull(NGPRun.class.getResource("main-view.fxml")));
        Scene scene = new Scene(p);
        stage.setTitle("National Gallery Route Planner");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}