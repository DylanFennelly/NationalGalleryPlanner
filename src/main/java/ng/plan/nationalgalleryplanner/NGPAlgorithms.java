package ng.plan.nationalgalleryplanner;

import ng.plan.nationalgalleryplanner.ADTs.GraphLinkAdjList;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import java.util.ArrayList;
import java.util.List;

public class NGPAlgorithms {
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
