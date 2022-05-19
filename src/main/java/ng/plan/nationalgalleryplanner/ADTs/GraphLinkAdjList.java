package ng.plan.nationalgalleryplanner.ADTs;

public class GraphLinkAdjList {
    public GraphNodeAdjList<?> destNode;    //node link is connecting to

    public int cost;                        //link value for Dijkstra's

    public GraphLinkAdjList(GraphNodeAdjList<?> destNode, int cost){
        this.destNode = destNode;
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


}
