package app;

/**
 * this class represent a bidirectional edge between two nodes in the graph
 * with a cost assigned on that represent the distance between two nodes
 */
public class Edge{
    private int u,v;
    private int cost;

    public Edge(int u, int v, int cost){
        this.u=u;
        this.v=v;
        this.cost=cost;
    }

    public int getU(){
        return u;
    }

    public int getV(){
        return v;
    }

    public int getCost(){
        return cost;
    }

    public String toString(){
        return "arco e=(" + u + "," + v + ")" + "\tcost: " + cost + "\n";
       }
}