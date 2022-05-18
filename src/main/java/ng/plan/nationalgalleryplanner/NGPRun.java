package ng.plan.nationalgalleryplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    public static void save() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("auctionApp.xml"));
        out.writeObject(AuctionApp.DRIVER);
        out.close();
        System.out.println("Saved to auctionApp.xml");
    }
}