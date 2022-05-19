package ng.plan.nationalgalleryplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import ng.plan.nationalgalleryplanner.ADTs.GraphLinkAdjList;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static ng.plan.nationalgalleryplanner.NGPRun.ROOMS;
import static ng.plan.nationalgalleryplanner.NGPRun.load;

public class NGPController {
    private JFrame frame; //used for popup windows
    private boolean namesDisplay = false;   //boolean to ensure method to update comboBox names only runs once
    private ArrayList<GraphNodeAdjList<Room>> avoidedRooms;
    private ArrayList<String> interestRooms;
    private ArrayList<GraphNodeAdjList<Room>> waypoints;
    @FXML
    private ToggleGroup algoToggleGroup;

    @FXML
    private RadioButton dfsSingleRadio, dfsMultiRadio, dijkRadio, bfsRadio;

    @FXML
    private ComboBox<GraphNodeAdjList<Room>> curRoomComboBox, destRoomComboBox, avoidRoomComboBox, waypointComboBox;

    @FXML
    private ChoiceBox<String> interestComboBox;

    @FXML
    private TreeView<String> routesTreeView;

    @FXML
    private Spinner<Integer> routeLimitSpinner;

    @FXML
    private ListView<String> avoidRoomsListView, interestListView, waypointListView;

    @FXML
    private Label roomSelectionLabel, roomTitleLabel, roomNoLabel;

    @FXML
    private TextArea roomDescTextArea;

    @FXML
    private Button waypointAddButton, waypointClearButton;

    @FXML
    private void initialize(){
        avoidedRooms = new ArrayList<>();
        interestRooms = new ArrayList<>();
        waypoints = new ArrayList<>();

        ObservableList<GraphNodeAdjList<Room>> roomsList = FXCollections.observableArrayList();
        roomsList.addAll(ROOMS.room1,ROOMS.room2,ROOMS.room4,ROOMS.room5,ROOMS.room6,ROOMS.room7,ROOMS.room8,ROOMS.room9,ROOMS.room10,ROOMS.room11,ROOMS.room12,ROOMS.room14,ROOMS.room15, ROOMS.room15s,
                ROOMS.room16,ROOMS.room17,ROOMS.room17a,ROOMS.room18,ROOMS.room19,ROOMS.room20,ROOMS.room21,ROOMS.room22,ROOMS.room23,ROOMS.room24,ROOMS.room25,ROOMS.room26,ROOMS.room27,
                ROOMS.room28,ROOMS.room29,ROOMS.room30,ROOMS.room31,ROOMS.room32,ROOMS.room33,ROOMS.room34,ROOMS.room35,ROOMS.room36,ROOMS.room37,ROOMS.room38,ROOMS.room39,ROOMS.room40,ROOMS.room41,
                ROOMS.room42,ROOMS.room43,ROOMS.room44,ROOMS.room45,ROOMS.room46,ROOMS.room51,ROOMS.room51a,ROOMS.room52,ROOMS.room53,ROOMS.room54,ROOMS.room55,ROOMS.room56,ROOMS.room57,ROOMS.room58,
                ROOMS.room59,ROOMS.room60,ROOMS.room61,ROOMS.room62,ROOMS.room63,ROOMS.room64,ROOMS.room65,ROOMS.room66, ROOMS.roomSunley, ROOMS.roomCentral, ROOMS.roomVestibule, ROOMS.roomBridge);

        curRoomComboBox.setItems(roomsList);
        destRoomComboBox.setItems(roomsList);
        avoidRoomComboBox.setItems(roomsList);
        waypointComboBox.setItems(roomsList);


    }

    @FXML
    protected void onFindRoutesButtonClick() {
        routesTreeView.setShowRoot(true);   //resetting showRoot value
        if (curRoomComboBox.getValue() != null && destRoomComboBox.getValue() != null) {
            if (waypoints.isEmpty()) { //if any waypoints have been specified, run alternate versions of algorithms
                if (!interestRooms.isEmpty()) {
                    checkInterestList();    //checking if any points of interest have been selected and updating values accordingly
                }
                if (algoToggleGroup.getSelectedToggle().equals(dfsSingleRadio)) {
                    runDFSSingleRoute();

                } else if (algoToggleGroup.getSelectedToggle().equals(dfsMultiRadio)) {
                    runDFSMultiRoute();
                } else if (algoToggleGroup.getSelectedToggle().equals(dijkRadio)) {
                    runDijkstras();
                } else {  //if none of the above, then it is BFS
                    runBFS();
                }
            }else{
                if (!interestRooms.isEmpty()) {
                    checkInterestList();    //checking if any points of interest have been selected and updating values accordingly
                }
                if (algoToggleGroup.getSelectedToggle().equals(dfsSingleRadio)) {
                    runDFSSingleRouteWaypoints();
                } else if (algoToggleGroup.getSelectedToggle().equals(dfsMultiRadio)) {
                    runDFSMultiRoute();
                } else if (algoToggleGroup.getSelectedToggle().equals(dijkRadio)) {
                    runDijkstrasWaypoint();
                } else {  //if none of the above, then it is BFS
                    runBFS();
                }
            }
        }else{
            JOptionPane.showMessageDialog(frame, "Please select start and destination room.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
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
            waypointComboBox.setConverter(new StringConverter<GraphNodeAdjList<Room>>() {
                @Override
                public String toString(GraphNodeAdjList<Room> roomGraphNodeAdjList) {
                    return roomGraphNodeAdjList.data.name;
                }

                @Override
                public GraphNodeAdjList<Room> fromString(String s) {
                    return waypointComboBox.getValue();
                }
            });
        }
    }

    @FXML
    private void onRadioButtonChanged(){
        routeLimitSpinner.setDisable(!algoToggleGroup.getSelectedToggle().equals(dfsMultiRadio));

        //waypoints only supported for DFS Single and Dijkstra's
        if (algoToggleGroup.getSelectedToggle().equals(dfsSingleRadio) || algoToggleGroup.getSelectedToggle().equals(dijkRadio)){
            waypointComboBox.setDisable(false);
            waypointAddButton.setDisable(false);
            waypointClearButton.setDisable(false);
            waypointListView.setDisable(false);
        }else{
            waypointComboBox.setDisable(true);
            waypointAddButton.setDisable(true);
            waypointClearButton.setDisable(true);
            waypointListView.setDisable(true);
        }
    }



    @FXML
    private void onAddAvoidedRoomButtonPress(){
        //todo: cant add duplicates (low priority)
        if (avoidRoomComboBox.getValue() != null) {
            avoidRoomsListView.getItems().add(avoidRoomComboBox.getValue().data.name);
            avoidedRooms.add(avoidRoomComboBox.getValue());
        }else {
            JOptionPane.showMessageDialog(frame, "Please select a room to avoid.", "Add Avoided Room Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void onClearAvoidedRoomsButtonPress(){
        avoidRoomsListView.getItems().clear();
        avoidedRooms.clear();
    }

    @FXML
    private void onAddInterestButtonPress(){
        if(interestComboBox.getValue() != null) {
            interestListView.getItems().add(interestComboBox.getValue());
            interestRooms.add(interestComboBox.getValue());
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a topic of interest.", "Add Point of Interest Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void onClearInterestButtonPress() throws Exception {
        interestListView.getItems().clear();
        interestRooms.clear();
        resetRoomCosts();
    }

    @FXML
    private void onAddWaypointButtonPress(){
        if(waypointComboBox.getValue() != null) {
            waypointListView.getItems().add(waypointComboBox.getValue().data.name);
            waypoints.add(waypointComboBox.getValue());
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a waypoint room to add.", "Add Waypoint Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void onClearWaypointButtonPress(){
        waypointListView.getItems().clear();
        waypoints.clear();
    }

    @FXML
    private void onStartNodeSelected(){
        updateRoomInfo(curRoomComboBox.getValue().data);
    }

    @FXML
    private void onDestNodeSelected(){
        updateRoomInfo(destRoomComboBox.getValue().data);
    }

    @FXML
    private void onAvoidNodeSelected(){
        updateRoomInfo(avoidRoomComboBox.getValue().data);
    }


    private void updateRoomInfo(Room room){
        roomSelectionLabel.setVisible(false);
        roomTitleLabel.setVisible(true);
        roomNoLabel.setVisible(true);
        roomDescTextArea.setVisible(true);

        roomTitleLabel.setText(room.title);
        roomNoLabel.setText(room.name);
        roomDescTextArea.setText(room.description);
    }

    private void runDFSSingleRoute(){
        List<GraphNodeAdjList<Room>> path = NGPAlgorithms.findPathDepthFirst(curRoomComboBox.getValue(), null,destRoomComboBox.getValue().data, avoidedRooms);

        //todo: objects (display room names in treeview) so room details can be displayed on click
        //todo: arrayList with room objects (indices corresponding to room in list) [Array of Arrays]
        TreeItem<String> routeNo = new TreeItem<>("Route");
        routeNo.setExpanded(true);

        if (path != null) {
            for (GraphNodeAdjList<Room> n : path) {
                TreeItem<String> roomName = new TreeItem<>(n.data.name);
                routeNo.getChildren().add(roomName);
            }
            routesTreeView.setRoot(routeNo);
        }else {
            JOptionPane.showMessageDialog(frame, "No valid routes between source and destination could be found.\nPlease refine your search parameters and try again.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void runDFSSingleRouteWaypoints(){
        boolean noValidPaths = false;   //if any path cannot be formed between a node and a waypoint, path is invalid regardless if other nodes can connect to each other
        TreeItem<String> dummy = new TreeItem<>();
        routesTreeView.setRoot(dummy);
        routesTreeView.setShowRoot(false);

        ArrayList<TreeItem<String>> treeRoutes = new ArrayList<>();
        int pCount=1;

        for (int waypointNo = 0; waypointNo < waypoints.size();waypointNo++) {
            if (waypointNo == 0) {    //else if current waypointNo is the first waypoint, connect from start to waypoint
                List<GraphNodeAdjList<Room>> tempPath = NGPAlgorithms.findPathDepthFirst(curRoomComboBox.getValue(), null, waypoints.get(waypointNo).data, avoidedRooms);

                if (tempPath != null) {
                    TreeItem<String> routeNo = new TreeItem<>("Route from Current Room to Waypoint " + (waypointNo+1));
                    for (GraphNodeAdjList<Room> n : tempPath) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }
                    treeRoutes.add(pCount - 1,routeNo);
                    pCount++;
                } else {
                    noValidPaths = true;
                }

            }
            if (waypointNo == (waypoints.size() - 1)) {      //if current waypointNo is the final waypoint, connect to destNode
                //destNode
                List<GraphNodeAdjList<Room>> tempPath = NGPAlgorithms.findPathDepthFirst(waypoints.get(waypointNo), null, destRoomComboBox.getValue().data, avoidedRooms);

                if (tempPath != null) {
                    TreeItem<String> routeNo = new TreeItem<>("Route from Waypoint " + (waypointNo+1) + " to Destination Room");
                    for (GraphNodeAdjList<Room> n : tempPath) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }
                    treeRoutes.add(pCount - 1,routeNo);
                    pCount++;
                } else {
                    noValidPaths = true;
                }
                break;

            }else {     //if current waypoint is not first waypoint or last waypoint, then it is an intermediary waypoint and connects to the waypoint ahead of it
                List<GraphNodeAdjList<Room>> tempPath = NGPAlgorithms.findPathDepthFirst(waypoints.get(waypointNo), null, waypoints.get(waypointNo+1).data, avoidedRooms);

                if (tempPath != null) {
                    TreeItem<String> routeNo = new TreeItem<>("Route from Waypoint " + (waypointNo + 1) + " to Waypoint " + (waypointNo + 2));
                    for (GraphNodeAdjList<Room> n : tempPath) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }
                    treeRoutes.add(pCount - 1, routeNo);
                    pCount++;
                } else {
                    noValidPaths = true;
                }
            }
        }
        if (!noValidPaths){
            for (TreeItem<String> route : treeRoutes) {
                dummy.getChildren().add(route);
            }
        }else {
            JOptionPane.showMessageDialog(frame, "No valid routes between source and destination could be found.\nPlease refine your search parameters and try again.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void runDFSMultiRoute(){
        List<List<GraphNodeAdjList<Room>>> allPath = NGPAlgorithms.findAllPathsDepthFirst(curRoomComboBox.getValue(), null,destRoomComboBox.getValue().data, avoidedRooms);
        int pCount=1;

        ArrayList<TreeItem<String>> treeRoutes = new ArrayList<>();

        if (allPath != null) {
            for (List<GraphNodeAdjList<Room>> p : allPath) {
                if (pCount <= routeLimitSpinner.getValue()) {
                    TreeItem<String> routeNo = new TreeItem<>("Route " + pCount);

                    for (GraphNodeAdjList<Room> n : p) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }

                    treeRoutes.add(pCount - 1, routeNo);
                    pCount++;
                } else {
                    TreeItem dummy = new TreeItem();
                    routesTreeView.setRoot(dummy);   //tree can only have one root, so create dummy root at top
                    routesTreeView.setShowRoot(false);

                    for (TreeItem<String> route : treeRoutes) {
                        dummy.getChildren().add(route);
                    }
                    break;
                }

            }
        }else {
            JOptionPane.showMessageDialog(frame, "No valid routes between source and destination could be found.\nPlease refine your search parameters and try again.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void runDijkstras() {
        NGPAlgorithms.CostedPath cpa=NGPAlgorithms.findCheapestPathDijkstra(curRoomComboBox.getValue(),destRoomComboBox.getValue().data, avoidedRooms);

        TreeItem<String> routeNo = new TreeItem<>("Route");
        routeNo.setExpanded(true);

        if (cpa != null) {
            for (GraphNodeAdjList<Room> n : cpa.pathList) {
                TreeItem<String> roomName = new TreeItem<>(n.data.name);
                routeNo.getChildren().add(roomName);
            }
            routesTreeView.setRoot(routeNo);

//        System.out.println("Total Cost: " + cpa.pathCost);
        }else {
            JOptionPane.showMessageDialog(frame, "No valid routes between source and destination could be found.\nPlease refine your search parameters and try again.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void runDijkstrasWaypoint() {
        boolean noValidPaths = false;   //if any path cannot be formed between a node and a waypoint, path is invalid regardless if other nodes can connect to each other
        TreeItem<String> dummy = new TreeItem<>();
        routesTreeView.setRoot(dummy);
        routesTreeView.setShowRoot(false);

        ArrayList<TreeItem<String>> treeRoutes = new ArrayList<>();
        int pCount = 1;

        for (int waypointNo = 0; waypointNo < waypoints.size(); waypointNo++) {
            if (waypointNo == 0) {    //else if current waypointNo is the first waypoint, connect from start to waypoint
                NGPAlgorithms.CostedPath tempcpa = NGPAlgorithms.findCheapestPathDijkstra(curRoomComboBox.getValue(), waypoints.get(waypointNo).data, avoidedRooms);

                if (tempcpa != null) {
                    TreeItem<String> routeNo = new TreeItem<>("Route from Current Room to Waypoint " + (waypointNo + 1));
                    for (GraphNodeAdjList<Room> n : tempcpa.pathList) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }
                    treeRoutes.add(pCount - 1, routeNo);
                    pCount++;
                } else {
                    noValidPaths = true;
                }

            }
            if (waypointNo == (waypoints.size() - 1)) {      //if current waypointNo is the final waypoint, connect to destNode
                NGPAlgorithms.CostedPath tempcpa = NGPAlgorithms.findCheapestPathDijkstra(waypoints.get(waypointNo), destRoomComboBox.getValue().data, avoidedRooms);

                if (tempcpa != null) {
                    TreeItem<String> routeNo = new TreeItem<>("Route from Waypoint " + (waypointNo + 1) + " to Destination Room");
                    for (GraphNodeAdjList<Room> n : tempcpa.pathList) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }
                    treeRoutes.add(pCount - 1, routeNo);
                    pCount++;
                } else {
                    noValidPaths = true;
                }
                break;


            } else {     //if current waypoint is not first waypoint or last waypoint, then it is an intermediary waypoint and connects to the waypoint ahead of it
                NGPAlgorithms.CostedPath tempcpa = NGPAlgorithms.findCheapestPathDijkstra(waypoints.get(waypointNo), waypoints.get(waypointNo + 1).data, avoidedRooms);

                if (tempcpa != null) {
                    TreeItem<String> routeNo = new TreeItem<>("Route from Waypoint " + (waypointNo + 1) + " to Waypoint " + (waypointNo + 2));
                    for (GraphNodeAdjList<Room> n : tempcpa.pathList) {
                        TreeItem<String> roomName = new TreeItem<>(n.data.name);
                        routeNo.getChildren().add(roomName);
                    }
                    treeRoutes.add(pCount - 1, routeNo);
                    pCount++;
                } else {
                    noValidPaths = true;
                }
            }
        }
        if (!noValidPaths) {
            for (TreeItem<String> route : treeRoutes) {
                dummy.getChildren().add(route);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No valid routes between source and destination could be found.\nPlease refine your search parameters and try again.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void runBFS() {
        List<GraphNodeAdjList<Room>> bfsPath = NGPAlgorithms.findPathBreadthFirst(curRoomComboBox.getValue(),destRoomComboBox.getValue().data, avoidedRooms);

        TreeItem<String> routeNo = new TreeItem<>("Route");
        routeNo.setExpanded(true);

        if (bfsPath != null) {
            for (GraphNodeAdjList<Room> n : bfsPath) {
                TreeItem<String> roomName = new TreeItem<>(n.data.name);
                routeNo.getChildren().add(roomName);
            }
            routesTreeView.setRoot(routeNo);
        }else {
            JOptionPane.showMessageDialog(frame, "No valid routes between source and destination could be found.\nPlease refine your search parameters and try again.", "Find Route Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkInterestList() {
        for (String pointOfInterest : interestRooms){
            switch (pointOfInterest){
                case "Dates 1200-1500" -> update12001500Rooms();
                case "Dates 1500-1600" -> update15001600Rooms();
                case "Dates 1600-1700" -> update16001700Rooms();
                case "Dates 1700-1930" -> update17001930Rooms();
                case "Raphael" -> updateRaphaelRooms();
            }
        }
    }

    private void update12001500Rooms() {
        for (GraphLinkAdjList link : ROOMS.room51.adjList){
            link.setCost(1);        //set links connecting to points of interest to 1
        }
        for (GraphLinkAdjList link : ROOMS.room52.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room53.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room54.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room55.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room56.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room57.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room58.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room59.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room60.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room61.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room62.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room63.adjList){
            link.setCost(1);
        }for (GraphLinkAdjList link : ROOMS.room64.adjList){
            link.setCost(1);        
        }
        for (GraphLinkAdjList link : ROOMS.room65.adjList){
            link.setCost(1);        
        }
    }

    private void update15001600Rooms() {
        for (GraphLinkAdjList link : ROOMS.room1.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room2.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room4.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room5.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room6.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room7.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room8.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room9.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room10.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room11.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room12.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room14.adjList){
            link.setCost(1);
        }

    }

    private void update16001700Rooms() {
        for (GraphLinkAdjList link : ROOMS.room15.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room16.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room17.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room18.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room19.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room20.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room21.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room22.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room23.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room24.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room25.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room26.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room27.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room28.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room29.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room30.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room30.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room32.adjList){
            link.setCost(1);
        }
    }

    private void update17001930Rooms() {
        for (GraphLinkAdjList link : ROOMS.room33.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room34.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room35.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room36.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room37.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room38.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room39.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room40.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room41.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room42.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room43.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room44.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room45.adjList){
            link.setCost(1);
        }
    }

    private void updateRaphaelRooms(){
        for (GraphLinkAdjList link : ROOMS.room1.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room2.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room4.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room5.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room6.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room7.adjList){
            link.setCost(1);
        }
        for (GraphLinkAdjList link : ROOMS.room8.adjList){
            link.setCost(1);
        }
    }

    private void resetRoomCosts() { //resetting links back to 10
        for (GraphLinkAdjList link : ROOMS.room1.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room2.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room4.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room5.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room6.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room7.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room8.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room9.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room10.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room11.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room12.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room14.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room15.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room16.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room17.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room18.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room19.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room20.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room21.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room22.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room23.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room24.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room25.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room26.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room27.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room28.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room29.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room30.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room30.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room32.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room33.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room34.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room35.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room36.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room37.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room38.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room39.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room40.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room41.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room42.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room43.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room44.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room45.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room51.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room52.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room53.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room54.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room55.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room56.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room57.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room58.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room59.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room60.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room61.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room62.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room63.adjList){
            link.setCost(10);
        }for (GraphLinkAdjList link : ROOMS.room64.adjList){
            link.setCost(10);
        }
        for (GraphLinkAdjList link : ROOMS.room65.adjList){
            link.setCost(10);
        }
    }



}