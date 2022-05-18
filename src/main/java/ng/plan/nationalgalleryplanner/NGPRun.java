package ng.plan.nationalgalleryplanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class NGPRun extends Application {
    public static RoomStore ROOMS;

    public static class RoomStore {
        GraphNodeAdjList<Room> room1, room2, room4, room5, room6, room7, room8, room9, room10, room11, room12, room14, roomSunley,
                room15, room16, room17, room17a, room18, room19, room20, room21, room22, room23, room24, room25, room26, room27,
                room28, room29, room30, room31, room32, room33, room34, room35, room36, room37, room38, room39, room40, room41,
                room42, room43, room44, room45, room46, roomCentral, roomVestibule, roomBridge, room51,  room51a, room52, room53,
                room54, room55, room56, room57, room58, room59, room60, room61, room62, room63, room64, room65, room66;



        public void createRooms(){  //one time method to create all Rooms
            room1=new GraphNodeAdjList<>(new Room("Room 1","1","The Credit Suisse Exhibition: Raphael",))

        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        ROOMS = new RoomStore();

        Parent p = FXMLLoader.load(Objects.requireNonNull(NGPRun.class.getResource("main-view.fxml")));
        Scene scene = new Scene(p);
        stage.setTitle("National Gallery Route Planner");
        stage.setScene(scene);
        stage.show();

        boolean xmlExists = new File("ngpRooms.xml").isFile();
        //if (!xmlExists)
            save(); //creates an xml file if it doesnt exit yet
        load();

    }

    public static void main(String[] args) {
        launch();
    }

    public static void save() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("ngpRooms.xml"));
        out.writeObject(NGPRun.ROOMS);
        out.close();
        System.out.println("Saved to ngpRooms.xml");
    }

    public static void load() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        xStream.addPermission(AnyTypePermission.ANY);       //granting permissions to set read object to the driver  | from: https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        ObjectInputStream in = xStream.createObjectInputStream(new FileReader("ngpRooms.xml"));
        NGPRun.ROOMS = (RoomStore) in.readObject();   //casting readObject to type Driver
        in.close();
        System.out.println("Loaded from ngpRooms.xml");
    }


}