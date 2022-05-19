package ng.plan.nationalgalleryplanner.ADTs;

import java.util.ArrayList;
import java.util.List;

public class GraphNodeAdjList<T> {
    public T data;
    public int nodeValue = Integer.MAX_VALUE;     //dijkstra's default value

    public List<GraphLinkAdjList> adjList = new ArrayList<>();  //adjacency list of links to other rooms

    public GraphNodeAdjList(T data) {
        this.data = data;
    }

    public void connectNodeUndir(GraphNodeAdjList<T> destNode, int cost) {
        adjList.add(new GraphLinkAdjList(destNode, cost));      //add new link to adjList
        destNode.adjList.add(new GraphLinkAdjList(this, cost));     //add link to destination's adjList
    }

}
