package ng.plan.nationalgalleryplanner;

import ng.plan.nationalgalleryplanner.ADTs.GraphLinkAdjList;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NGPAlgorithmsTest {
    private GraphNodeAdjList<Room> room51, room51a, room52, room53, room54, room55, room56, room57, room58, room59, room60, room61, room62, room63, room64, room65, room66;
    private ArrayList<GraphNodeAdjList<Room>> avoidedRooms;

    @BeforeEach
    void setUp() {
        //sample of rooms from Sainsbury Wing
        room51 = new GraphNodeAdjList<>(new Room("Room 51", "51", "Art", ""));
        room51a = new GraphNodeAdjList<>(new Room("Room 51a", "51a", "Art", ""));
        room52 = new GraphNodeAdjList<>(new Room("Room 52", "52", "Art", ""));
        room53 = new GraphNodeAdjList<>(new Room("Room 53", "53", "Art", ""));
        room54 = new GraphNodeAdjList<>(new Room("Room 54", "54", "Art", ""));
        room55 = new GraphNodeAdjList<>(new Room("Room 55", "55", "Art", ""));
        room56 = new GraphNodeAdjList<>(new Room("Room 56", "56", "Art", ""));
        room57 = new GraphNodeAdjList<>(new Room("Room 57", "57", "Art", ""));
        room58 = new GraphNodeAdjList<>(new Room("Room 58", "58", "Art", ""));
        room59 = new GraphNodeAdjList<>(new Room("Room 59", "59", "Art", ""));
        room60 = new GraphNodeAdjList<>(new Room("Room 60", "60", "Art", ""));
        room61 = new GraphNodeAdjList<>(new Room("Room 61", "61", "Art", ""));
        room62 = new GraphNodeAdjList<>(new Room("Room 62", "62", "Art", ""));
        room63 = new GraphNodeAdjList<>(new Room("Room 63", "63", "Art", ""));
        room64 = new GraphNodeAdjList<>(new Room("Room 64", "64", "Art", ""));
        room65 = new GraphNodeAdjList<>(new Room("Room 65", "65", "Art", ""));
        room66 = new GraphNodeAdjList<>(new Room("Room 66", "66", "Art", ""));

        room51.connectNodeUndir(room51a, 10);
        room51.connectNodeUndir(room52, 10);
        room51.connectNodeUndir(room60, 10);

        room52.connectNodeUndir(room53, 10);

        room53.connectNodeUndir(room54, 10);
        room53.connectNodeUndir(room59, 10);

        room54.connectNodeUndir(room55, 10);

        room55.connectNodeUndir(room56, 10);
        room55.connectNodeUndir(room57, 10);

        room57.connectNodeUndir(room58, 10);
        room57.connectNodeUndir(room65, 10);

        room58.connectNodeUndir(room59, 10);

        room59.connectNodeUndir(room60, 10);
        room59.connectNodeUndir(room63, 10);

        room60.connectNodeUndir(room61, 10);

        room61.connectNodeUndir(room62, 10);

        room62.connectNodeUndir(room63, 10);

        room63.connectNodeUndir(room64, 10);

        room64.connectNodeUndir(room65, 10);

        room65.connectNodeUndir(room66, 10);

        avoidedRooms = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        room51 = room51a = room52 = room53 = room54 = room55 = room56 = room57 = room58 = room59 = room60 = room61 = room62 = room63 = room64 = room65 = null;
        avoidedRooms = null;
    }

    @Test
    void testDepthFirstSearchSinglePath() {
        //search from room 51 for 66
        List<GraphNodeAdjList<Room>> path = NGPAlgorithms.findPathDepthFirst(room51, null, room66.data, avoidedRooms);
        assertNotNull(path);
        assertEquals(room51, path.get(0));
        assertEquals(room66, path.get((path.size()) - 1));   //end node is as expected
        assertTrue(path.contains(room52));  //exhaustive search
        assertTrue(path.contains(room58));
        assertTrue(path.contains(room63));
        assertFalse(path.contains(room51a));    //does not contain deadends
        assertFalse(path.contains(room56));

        //search from room 51 for 66 avoiding room 58
        avoidedRooms.add(room58);
        path = NGPAlgorithms.findPathDepthFirst(room51, null, room66.data, avoidedRooms);
        assertEquals(room51, path.get(0));
        assertEquals(room66, path.get((path.size()) - 1));   //end node is as expected
        assertFalse(path.contains(room58));

        //search from room 66 for 51 avoiding room 60 and 55
        avoidedRooms.clear();
        avoidedRooms.add(room60);
        avoidedRooms.add(room55);
        path = NGPAlgorithms.findPathDepthFirst(room66, null, room51.data, avoidedRooms);
        assertEquals(room66, path.get(0));
        assertEquals(room51, path.get((path.size()) - 1));   //end node is as expected
        assertFalse(path.contains(room60));
        assertFalse(path.contains(room55));

        //invalid search - search from room 66 for 51 avoiding room 60 and 52
        avoidedRooms.clear();
        avoidedRooms.add(room60);
        avoidedRooms.add(room52);
        path = NGPAlgorithms.findPathDepthFirst(room66, null, room51.data, avoidedRooms);
        assertNull(path);

    }

    @Test
    void testDepthFirstSearchMultiPath() {
        //search from room 51 for 66
        List<List<GraphNodeAdjList<Room>>> allPath = NGPAlgorithms.findAllPathsDepthFirst(room51, null, room66.data, avoidedRooms);
        assertNotNull(allPath);
        assertTrue(allPath.size() > 1); //multiple paths recorded

        for (List<GraphNodeAdjList<Room>> p : allPath) {    //each path should have start and end as expected
            assertEquals(room51, p.get(0));
            assertEquals(room66, p.get((p.size()) - 1));
        }
        //search from room 51 for 66 avoiding room 58
        avoidedRooms.add(room58);
        List<List<GraphNodeAdjList<Room>>> allPath2 = NGPAlgorithms.findAllPathsDepthFirst(room51, null, room66.data, avoidedRooms);
        assertTrue(allPath2.size() < allPath.size());   //removal of a room = less possible paths

        //invalid search - search from room 66 for 51 avoiding room 60 and 52
        avoidedRooms.clear();
        avoidedRooms.add(room60);
        avoidedRooms.add(room52);
        allPath = NGPAlgorithms.findAllPathsDepthFirst(room51, null, room66.data, avoidedRooms);
        assertNull(allPath);

    }

    @Test
    void testBreadthFirstSearch() {
        //search from room 51 for 66
        List<GraphNodeAdjList<Room>> path = NGPAlgorithms.findPathBreadthFirst(room51, room66.data, avoidedRooms);
        assertNotNull(path);
        assertEquals(room51, path.get(0));
        assertEquals(room66, path.get((path.size()) - 1));   //end node is as expected
        assertFalse(path.contains(room52));  //not exhaustive search
        assertTrue(path.contains(room60));
        assertFalse(path.contains(room63));
        assertFalse(path.contains(room51a));    //does not contain deadends
        assertFalse(path.contains(room56));

        //search from room 51 for 66 avoiding room 58
        avoidedRooms.add(room58);
        path = NGPAlgorithms.findPathBreadthFirst(room51, room66.data, avoidedRooms);
        assertEquals(room51, path.get(0));
        assertEquals(room66, path.get((path.size()) - 1));   //end node is as expected
        assertFalse(path.contains(room58));

        //search from room 66 for 51 avoiding room 60 and 55
        avoidedRooms.clear();
        avoidedRooms.add(room60);
        avoidedRooms.add(room55);
        path = NGPAlgorithms.findPathBreadthFirst(room66, room51.data, avoidedRooms);
        assertEquals(room66, path.get(0));
        assertEquals(room51, path.get((path.size()) - 1));   //end node is as expected
        assertFalse(path.contains(room60));
        assertFalse(path.contains(room55));

        //invalid search - search from room 66 for 51 avoiding room 60 and 52
        avoidedRooms.clear();
        avoidedRooms.add(room60);
        avoidedRooms.add(room52);
        path = NGPAlgorithms.findPathDepthFirst(room66, null, room51.data, avoidedRooms);
        assertNull(path);

    }

    @Test
    void testfindCheapestPathDijkstra() {
        //search from room 51 for 66    (all paths same cost)
        NGPAlgorithms.CostedPath costedPath = NGPAlgorithms.findCheapestPathDijkstra(room51, room66.data, avoidedRooms);
        assertNotNull(costedPath);
        assertEquals(room51, costedPath.pathList.get(0));
        assertEquals(room66, costedPath.pathList.get((costedPath.pathList.size()) - 1));   //end node is as expected


        //search from room51 to 66, reduce cost going to room52 and increase cost of going to 60
        for (GraphLinkAdjList link : room52.adjList) {
            link.setCost(1);
        }
        for (GraphLinkAdjList link : room60.adjList) {
            link.setCost(20);
        }
        costedPath = NGPAlgorithms.findCheapestPathDijkstra(room51, room66.data, avoidedRooms);
        assertTrue(costedPath.pathList.contains(room52));
        assertFalse(costedPath.pathList.contains(room60));

        //making rooms 53-59 expensive
        for (GraphLinkAdjList link : room53.adjList) {
            link.setCost(20);
        }
        for (GraphLinkAdjList link : room54.adjList) {
            link.setCost(20);
        }
        for (GraphLinkAdjList link : room55.adjList) {
            link.setCost(20);
        }
        for (GraphLinkAdjList link : room56.adjList) {
            link.setCost(20);
        }
        for (GraphLinkAdjList link : room57.adjList) {
            link.setCost(20);
        }
        for (GraphLinkAdjList link : room58.adjList) {
            link.setCost(20);
        }
        for (GraphLinkAdjList link : room59.adjList) {
            link.setCost(20);
        }
        costedPath = NGPAlgorithms.findCheapestPathDijkstra(room51, room66.data, avoidedRooms);
        assertFalse(costedPath.pathList.contains(room52));
        assertTrue(costedPath.pathList.contains(room60));

        //as above, but avoding room 62
        avoidedRooms.add(room62);
        costedPath = NGPAlgorithms.findCheapestPathDijkstra(room51, room66.data, avoidedRooms);
        assertFalse(costedPath.pathList.contains(room52));
        assertTrue(costedPath.pathList.contains(room60));
        assertFalse(costedPath.pathList.contains(room62));
        assertTrue(costedPath.pathList.contains(room59));

        //invalid path
        avoidedRooms.add(room65);
        costedPath = NGPAlgorithms.findCheapestPathDijkstra(room51, room66.data, avoidedRooms);
        assertNull(costedPath);
    }
}