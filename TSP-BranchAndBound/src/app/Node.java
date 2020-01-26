package app;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Node{
    private int id;
    private List<int[]> neighbors;

    public Node(int id, List<int[]> neighbors){
        this.id= id;
        this.neighbors= neighbors;
    }

    public int getId(){
        return id;
    }

    public List<int[]> getNeighbors(){
        return neighbors;
    }

    public String toString(){
        String s="";
        s+= "node: " + id + "\t";
        s+= "vicini: ";
        Iterator<int[]> it= neighbors.iterator();
        
        while(it.hasNext()){
            int[] el= it.next();
            s+= "node: " + el[0] + " cost: " + el[1] + "\n\t\t";
        }
        s+="\n";
        return s;
    }
}