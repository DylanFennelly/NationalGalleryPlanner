package ng.plan.nationalgalleryplanner;

import ng.plan.nationalgalleryplanner.ADTs.GraphLinkAdjList;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import java.util.ArrayList;
import java.util.Collections;
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

    public static class CostedPath{     //holds total cost of path
        public int pathCost=0;
        public List<GraphNodeAdjList<Room>> pathList=new ArrayList<>();
    }

    public static <T> CostedPath findCheapestPathDijkstra(GraphNodeAdjList<Room> startNode, T lookingfor) {
        CostedPath cp = new CostedPath();       //Create result object for cheapest path
        List<GraphNodeAdjList<Room>> encountered = new ArrayList<>(), unencountered = new ArrayList<>();      //Create encountered/unencountered lists
        startNode.nodeValue = 0;        //Set the starting node value to zero
        unencountered.add(startNode);       //Add the start node as the only value in the unencountered list to start
        GraphNodeAdjList<Room> currentNode;

        do{     //Loop until unencountered list is empty
            currentNode=unencountered.remove(0);                //Get the first unencountered node (sorted list, so will have lowest value)
            encountered.add(currentNode);                               //Record current node in encountered list

            if(currentNode.data.equals(lookingfor)){                    //Found goal - assemble path list back to start and return it
                cp.pathList.add(currentNode);                           //Add the current (goal) node to the result list (only element)
                cp.pathCost=currentNode.nodeValue;                          //The total cheapest path cost is the node value of the current/goal node

                while(currentNode!=startNode) {                              //While we're not back to the start node...
                    boolean foundPrevPathNode=false;                            //Use a flag to identify when the previous path node is identified

                    for(GraphNodeAdjList<Room> n : encountered) {                         //For each node in the encountered list...
                        for(GraphLinkAdjList e : n.adjList)                             //For each edge from that node...
                            if(e.destNode==currentNode && currentNode.nodeValue-e.cost==n.nodeValue){ //If that edge links to the current node and the difference in node values is the cost of the edge -> found path node!
                                cp.pathList.add(0, n);                       //Add the identified path node to the front of the result list
                                currentNode= n;                              //Move the currentNode reference back to the identified path node
                                foundPrevPathNode=true;                         //Set the flag to break the outer loop
                                break;                                  //We've found the correct previous path node and moved the currentNode reference back to it so break the inner loop
                            }
                        if(foundPrevPathNode) //We've identified the previous path node, so break the inner loop to continue
                            break;
                    }
                }
                //Reset the node values for all nodes to (effectively) infinity so we can search again (leave no footprint!)
                for(GraphNodeAdjList<?> n : encountered)
                    n.nodeValue=Integer.MAX_VALUE;
                for(GraphNodeAdjList<?> n : unencountered)
                    n.nodeValue=Integer.MAX_VALUE;
                return cp;          //The costed (cheapest) path has been assembled, so return it!
            }
            //We're not at the goal node yet, so...
            for(GraphLinkAdjList e: currentNode.adjList) //For each edge/link from the current node...
                if(!encountered.contains(e.destNode)) { //If the node it leads to has not yet been encountered (i.e. processed)
                    e.destNode.nodeValue=Integer.min(e.destNode.nodeValue, currentNode.nodeValue+e.cost); //Update the node value at the end of the edge to the minimum of its current value or the total of the current node's value plus the cost of the edge
                    unencountered.add((GraphNodeAdjList<Room>) e.destNode);
                }
            Collections.sort(unencountered,(n1, n2)->n1.nodeValue-n2.nodeValue); //Sort in ascending node value order
        }while(!unencountered.isEmpty());
        return null; //No path found, so return null
    }

    public static <T> List<List<GraphNodeAdjList<Room>>> findAllPathsDepthFirst(GraphNodeAdjList<Room> from, List<GraphNodeAdjList<Room>> encountered, Room lookingfor){
        List<List<GraphNodeAdjList<Room>>> result=null, temp2;
        if(from.data.equals(lookingfor)) { //Found it
            List<GraphNodeAdjList<Room>> temp=new ArrayList<>(); //Create new single solution path list
            temp.add(from); //Add current node to the new single path list
            result=new ArrayList<>(); //Create new "list of lists" to store path permutations
            result.add(temp); //Add the new single path list to the path permutations list
            return result; //Return the path permutations list
        }
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from); //Add current node to encountered list
        for(GraphLinkAdjList adjLink : from.adjList){
            if(!encountered.contains(adjLink.destNode)) {
                temp2=findAllPathsDepthFirst((GraphNodeAdjList<Room>) adjLink.destNode,new ArrayList<>(encountered),lookingfor); //Use clone of encountered list for recursive call!
                if(temp2!=null) { //Result of the recursive call contains one or more paths to the solution node
                    for(List<GraphNodeAdjList<Room>> x : temp2) //For each partial path list returned
                        x.add(0,from); //Add the current node to the front of each path list
                    if(result==null)
                        result=temp2; //If this is the first set of solution paths found use it as the result
                    else
                        result.addAll(temp2); //Otherwise append them to the previously found paths
                }
            }
        }
        return result;
    }

    //Interface method to allow just the starting node and the goal node data to match to be specified
    public static <T> List<GraphNodeAdjList<Room>> findPathBreadthFirst(GraphNodeAdjList<Room> startNode, T lookingfor){
        List<List<GraphNodeAdjList<Room>>> agenda=new ArrayList<>(); //Agenda comprised of path lists here!
        List<GraphNodeAdjList<Room>> firstAgendaPath=new ArrayList<>(),resultPath;
        firstAgendaPath.add(startNode);
        agenda.add(firstAgendaPath);
        resultPath=findPathBreadthFirst(agenda,null,lookingfor); //Get single BFS path (will be shortest)
        Collections.reverse(resultPath); //Reverse path (currently has the goal node as the first item)
        return resultPath;
    }

    public static <T> List<GraphNodeAdjList<Room>> findPathBreadthFirst(List<List<GraphNodeAdjList<Room>>> agenda, List<GraphNodeAdjList<Room>> encountered, T lookingfor){
        if(agenda.isEmpty())
            return null; //Search failed
        List<GraphNodeAdjList<Room>> nextPath=agenda.remove(0); //Get first item (next path to consider) off agenda
        GraphNodeAdjList<Room> currentNode=nextPath.get(0); //The first item in the next path is the current node
        if(currentNode.data.equals(lookingfor))
            return nextPath; //If that's the goal, we've found our path (so return it)
        if(encountered==null)
            encountered=new ArrayList<>(); //First node considered in search so create new (empty) encountered list
        encountered.add(currentNode); //Record current node as encountered so it isn't revisited again
        for(GraphLinkAdjList adjLink : currentNode.adjList) //For each adjacent node
            if(!encountered.contains(adjLink.destNode)) { //If it hasn't already been encountered
                List<GraphNodeAdjList<Room>> newPath=new ArrayList<>(nextPath); //Create a new path list as a copy of the current/next path
                newPath.add(0, (GraphNodeAdjList<Room>) adjLink.destNode); //And add the adjacent node to the front of the new copy
                agenda.add(newPath); //Add the new path to the end of agenda (end->BFS!)
            }
        return findPathBreadthFirst(agenda,encountered,lookingfor); //Tail call
    }
}
