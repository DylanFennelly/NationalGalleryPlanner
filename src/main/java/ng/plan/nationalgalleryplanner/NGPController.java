package ng.plan.nationalgalleryplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.StringConverter;
import ng.plan.nationalgalleryplanner.ADTs.GraphLinkAdjList;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import java.util.ArrayList;
import java.util.List;

import static ng.plan.nationalgalleryplanner.NGPRun.ROOMS;

public class NGPController {
    boolean namesDisplay = false;   //boolean to ensure method to update comboBox names only runs once
    @FXML
    private ToggleGroup algoToggleGroup;

    @FXML
    private RadioButton dfsRadio;

    @FXML
    private ComboBox<GraphNodeAdjList<Room>> curRoomComboBox, destRoomComboBox;

    @FXML
    private void initialize(){
        ObservableList<GraphNodeAdjList<Room>> roomsList = FXCollections.observableArrayList();
        roomsList.addAll(ROOMS.room1,ROOMS.room2,ROOMS.room4,ROOMS.room5,ROOMS.room6,ROOMS.room7,ROOMS.room8,ROOMS.room9,ROOMS.room10,ROOMS.room11,ROOMS.room12,ROOMS.room14,ROOMS.room15, ROOMS.room15s,
                ROOMS.room16,ROOMS.room17,ROOMS.room17a,ROOMS.room18,ROOMS.room19,ROOMS.room20,ROOMS.room21,ROOMS.room22,ROOMS.room23,ROOMS.room24,ROOMS.room25,ROOMS.room26,ROOMS.room27,
                ROOMS.room28,ROOMS.room29,ROOMS.room30,ROOMS.room31,ROOMS.room32,ROOMS.room33,ROOMS.room34,ROOMS.room35,ROOMS.room36,ROOMS.room37,ROOMS.room38,ROOMS.room39,ROOMS.room40,ROOMS.room41,
                ROOMS.room42,ROOMS.room43,ROOMS.room44,ROOMS.room45,ROOMS.room46,ROOMS.room51,ROOMS.room51a,ROOMS.room52,ROOMS.room53,ROOMS.room54,ROOMS.room55,ROOMS.room56,ROOMS.room57,ROOMS.room58,
                ROOMS.room59,ROOMS.room60,ROOMS.room61,ROOMS.room62,ROOMS.room63,ROOMS.room64,ROOMS.room65,ROOMS.room66, ROOMS.roomSunley, ROOMS.roomCentral, ROOMS.roomVestibule, ROOMS.roomBridge);

        curRoomComboBox.setItems(roomsList);
        destRoomComboBox.setItems(roomsList);


    }

    @FXML
    protected void onFindRoutesButtonClick() {
        if (algoToggleGroup.getSelectedToggle().equals(dfsRadio)){
            System.out.println("\nFinding a valid path between room51 and room 66");
            System.out.println("------------------------------------");
            List<GraphNodeAdjList<Room>> path = findPathDepthFirst(curRoomComboBox.getValue(), null,destRoomComboBox.getValue().data);
            for (GraphNodeAdjList<Room> n : path) {
                System.out.println(n.data.name);
        }
        }
    }
    @FXML
    private void onComboBoxMouseEnter(){        //really jank solution to an issue with the converter in initialize erroring out the whole project
        if (!namesDisplay) {
            curRoomComboBox.setConverter(new StringConverter<>() {        //https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
                @Override
                public String toString(GraphNodeAdjList<Room> roomGraphNodeAdjList) {
                    return roomGraphNodeAdjList.data.name;
                }

                @Override
                public GraphNodeAdjList<Room> fromString(String s) {
                    return curRoomComboBox.getValue();
                }
            });
            destRoomComboBox.setConverter(new StringConverter<GraphNodeAdjList<Room>>() {
                @Override
                public String toString(GraphNodeAdjList<Room> roomGraphNodeAdjList) {
                    return roomGraphNodeAdjList.data.name;
                }

                @Override
                public GraphNodeAdjList<Room> fromString(String s) {
                    return curRoomComboBox.getValue();
                }
            });
        }
    }

    public static <T> List<GraphNodeAdjList<Room>> findPathDepthFirst(GraphNodeAdjList<Room> from, List<GraphNodeAdjList<Room>> encountered, Room lookingfor){
        List<GraphNodeAdjList<Room>> result;
        if(from.data.equals(lookingfor)) { //Found it
            result=new ArrayList<>(); //Create new list to store the path info (any List implementation could be used)
            result.add(from); //Add the current node as the only/last entry in the path list
            return result; //Return the path list
        }
        if(encountered==null)
            encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);

        for(GraphLinkAdjList adjLink : from.adjList)
            if(!encountered.contains(adjLink.destNode)) {
                result=findPathDepthFirst((GraphNodeAdjList<Room>) adjLink.destNode, encountered,lookingfor);
                if(result!=null) { //Result of the last recursive call contains a path to the solution node
                    result.add(0,from); //Add the current node to the front of the path list
                    return result; //Return the path list
                }
            }
        return null;
    }
}