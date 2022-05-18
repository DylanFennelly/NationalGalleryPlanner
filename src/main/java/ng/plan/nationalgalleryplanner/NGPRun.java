package ng.plan.nationalgalleryplanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class NGPRun extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent p = FXMLLoader.load(Objects.requireNonNull(NGPRun.class.getResource("main-view.fxml")));
        Scene scene = new Scene(p);
        stage.setTitle("National Gallery Route Planner");
        stage.setScene(scene);
        stage.show();

        boolean xmlExists = new File("ngpRooms.xml").isFile();
        if (!xmlExists)
            save(); //creates an xml file if it doesnt exit yet
        load();

    }

    public static void main(String[] args) {
        launch();
    }

    public static void save() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("ngpRooms.xml"));

        out.close();
        System.out.println("Saved to ngpRooms.xml");
    }

    public static void load() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        xStream.addPermission(AnyTypePermission.ANY);       //granting permissions to set read object to the driver  | from: https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        ObjectInputStream in = xStream.createObjectInputStream(new FileReader("ngpRooms.xml"));

        in.close();
        System.out.println("Loaded from ngpRooms.xml");
    }
}