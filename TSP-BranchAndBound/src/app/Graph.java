package app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;

public class Graph{

    private HashMap<Integer, Node> nodes;
    private Edge[] edges;

    public Graph(HashMap<Integer,Node> nodes, Edge[] edges){
        this.nodes= nodes;
        this.edges= edges;
    }

    public HashMap<Integer, Node> getNodes(){
        return nodes;
    }

    public Edge[] getEdges(){
        return edges;
    }

    public int getNumNodes(){
        return nodes.size();
    }

    public String toString(){
        String s=  "Graph informations: \n" + 
                "num nodi: " + getNumNodes() + "\n";

        Collection<Node> nodes= this.nodes.values();
        Iterator<Node> it= nodes.iterator();
        while(it.hasNext()){
            s+= it.next().toString();
        }
        
        s+="\n";
        for (Edge edge : edges){
            s+= edge.toString();
        }

        return s; 
    }
}