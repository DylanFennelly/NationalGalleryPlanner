package ng.plan.nationalgalleryplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import java.util.ArrayList;
import java.util.List;

import static ng.plan.nationalgalleryplanner.NGPRun.ROOMS;

public class NGPController {
    private boolean namesDisplay = false;   //boolean to ensure method to update comboBox names only runs once
    private ArrayList<GraphNodeAdjList<Room>> avoidedRooms;
    @FXML
    private ToggleGroup algoToggleGroup;

    @FXML
    private RadioButton dfsSingleRadio, dfsMultiRadio, dijkRadio, bfsRadio;

    @FXML
    private ComboBox<GraphNodeAdjList<Room>> curRoomComboBox, destRoomComboBox, avoidRoomComboBox;

    @FXML
    private TreeView<String> routesTreeView;

    @FXML
    private Spinner<Integer> routeLimitSpinner;

    @FXML
    private ListView<String> avoidRoomsListView;

    @FXML
    private void initialize(){
        avoidedRooms = new ArrayList<>();

        ObservableList<GraphNodeAdjList<Room>> roomsList = FXCollections.observableArrayList();
        roomsList.addAll(ROOMS.room1,ROOMS.room2,ROOMS.room4,ROOMS.room5,ROOMS.room6,ROOMS.room7,ROOMS.room8,ROOMS.room9,ROOMS.room10,ROOMS.room11,ROOMS.room12,ROOMS.room14,ROOMS.room15, ROOMS.room15s,
                ROOMS.room16,ROOMS.room17,ROOMS.room17a,ROOMS.room18,ROOMS.room19,ROOMS.room20,ROOMS.room21,ROOMS.room22,ROOMS.room23,ROOMS.room24,ROOMS.room25,ROOMS.room26,ROOMS.room27,
                ROOMS.room28,ROOMS.room29,ROOMS.room30,ROOMS.room31,ROOMS.room32,ROOMS.room33,ROOMS.room34,ROOMS.room35,ROOMS.room36,ROOMS.room37,ROOMS.room38,ROOMS.room39,ROOMS.room40,ROOMS.room41,
                ROOMS.room42,ROOMS.room43,ROOMS.room44,ROOMS.room45,ROOMS.room46,ROOMS.room51,ROOMS.room51a,ROOMS.room52,ROOMS.room53,ROOMS.room54,ROOMS.room55,ROOMS.room56,ROOMS.room57,ROOMS.room58,
                ROOMS.room59,ROOMS.room60,ROOMS.room61,ROOMS.room62,ROOMS.room63,ROOMS.room64,ROOMS.room65,ROOMS.room66, ROOMS.roomSunley, ROOMS.roomCentral, ROOMS.roomVestibule, ROOMS.roomBridge);

        curRoomComboBox.setItems(roomsList);
        destRoomComboBox.setItems(roomsList);
        avoidRoomComboBox.setItems(roomsList);


    }

    @FXML
    protected void onFindRoutesButtonClick() {
        if (algoToggleGroup.getSelectedToggle().equals(dfsSingleRadio)){
            runDFSSingleRoute();

        }else if(algoToggleGroup.getSelectedToggle().equals(dfsMultiRadio)){
            runDFSMultiRoute();
        }else if(algoToggleGroup.getSelectedToggle().equals(dijkRadio)){
            runDijkstras();
        }else{  //if none of the above, then it is BFS
            runBFS();
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
            destRoomComboBox.setConverter(new StringConverter<>() {
                @Override
                public String toString(GraphNodeAdjList<Room> roomGraphNodeAdjList) {
                    return roomGraphNodeAdjList.data.name;
                }

                @Override
                public GraphNodeAdjList<Room> fromString(String s) {
                    return curRoomComboBox.getValue();
                }
            });
            avoidRoomComboBox.setConverter(new StringConverter<>() {
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

    @FXML
    private void onRadioButtonChanged(){
        routeLimitSpinner.setDisable(!algoToggleGroup.getSelectedToggle().equals(dfsMultiRadio));
    }

    private void runDFSSingleRoute(){
        List<GraphNodeAdjList<Room>> path = NGPAlgorithms.findPathDepthFirst(curRoomComboBox.getValue(), null,destRoomComboBox.getValue().data, avoidedRooms);

        //todo: objects (display room names in treeview) so room details can be displayed on click
        //todo: arrayList with room objects (indices corresponding to room in list) [Array of Arrays]
        TreeItem<String> routeNo = new TreeItem<>("Route");
        routeNo.setExpanded(true);
        //todo: set null condition
        for (GraphNodeAdjList<Room> n : path) {
            TreeItem<String> roomName = new TreeItem<>(n.data.name);
            routeNo.getChildren().add(roomName);
        }
        routesTreeView.setRoot(routeNo);
    }

    @FXML
    private void onAddAvoidedRoomButtonPress(){
        //todo: cant add duplicates (low priority)
        avoidRoomsListView.getItems().add(avoidRoomComboBox.getValue().data.name);
        avoidedRooms.add(avoidRoomComboBox.getValue());
    }

    @FXML
    private void onClearAvoidedRoomsButtonPress(){
        avoidRoomsListView.getItems().clear();
        avoidedRooms.clear();
    }

    private void runDFSMultiRoute(){
        List<List<GraphNodeAdjList<Room>>> allPath = NGPAlgorithms.findAllPathsDepthFirst(curRoomComboBox.getValue(), null,destRoomComboBox.getValue().data, avoidedRooms);
        int pCount=1;

        ArrayList<TreeItem<String>> treeRoutes = new ArrayList<>();

        for (List<GraphNodeAdjList<Room>> p : allPath) {
            if (pCount <= routeLimitSpinner.getValue()) {
                TreeItem<String> routeNo = new TreeItem<>("Route " +pCount);

                for (GraphNodeAdjList<Room> n : p){
                    TreeItem<String> roomName = new TreeItem<>(n.data.name);
                    routeNo.getChildren().add(roomName);
                }

                treeRoutes.add(pCount-1,routeNo);
                pCount++;
            }else{
                TreeItem dummy = new TreeItem();
                routesTreeView.setRoot(dummy);   //tree can only have one root, so create dummy root at top
                routesTreeView.setShowRoot(false);

                for (TreeItem<String> route : treeRoutes){
                    dummy.getChildren().add(route);
                }
                break;
            }
        }
    }

    private void runDijkstras() {
        //todo: set null condition
        NGPAlgorithms.CostedPath cpa=NGPAlgorithms.findCheapestPathDijkstra(curRoomComboBox.getValue(),destRoomComboBox.getValue().data, avoidedRooms);

        TreeItem<String> routeNo = new TreeItem<>("Route");
        routeNo.setExpanded(true);

        for(GraphNodeAdjList<Room> n : cpa.pathList) {
            TreeItem<String> roomName = new TreeItem<>(n.data.name);
            routeNo.getChildren().add(roomName);
        }
        routesTreeView.setRoot(routeNo);
    }

    private void runBFS() {
        List<GraphNodeAdjList<Room>> bfsPath = NGPAlgorithms.findPathBreadthFirst(curRoomComboBox.getValue(),destRoomComboBox.getValue().data, avoidedRooms);

        TreeItem<String> routeNo = new TreeItem<>("Route");
        routeNo.setExpanded(true);

        for(GraphNodeAdjList<Room> n : bfsPath) {
            TreeItem<String> roomName = new TreeItem<>(n.data.name);
            routeNo.getChildren().add(roomName);
        }
        routesTreeView.setRoot(routeNo);
    }
}