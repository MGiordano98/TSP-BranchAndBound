package app;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class App {

    public static Graph exampleGraph= exampleGraph();
    public static Graph exampleGraph2= exampleGraph2();
    public static int costoMin= 10000;
    public static String finalPath= "";

    public static void main(String[] args) throws Exception {
        RecursiveTSP(exampleGraph, "1", 0);
        System.out.println("costo ottimo grafo 1: " + costoMin);
        System.out.println("ciclo ottimo grafo 1: " + finalPath);

        costoMin= 1000;
        finalPath= "";

        RecursiveTSP(exampleGraph2, "1", 0);
        System.out.println("costo ottimo grafo 2: " + costoMin);
        System.out.println("ciclo ottimo grafo 2: " + finalPath);
        
    }

    public static void RecursiveTSP(Graph graph, String path, int costo){
        if(path.length()==graph.getNumNodes()+1){ //se abbiamo chiuso il ciclo
                costoMin= costo;
                finalPath= path;
        }

        int selectedNode= Integer.parseInt(path.substring(path.length()-1,path.length())); //prendiamo l'ultimo nodo visitato

        HashMap<Integer, Node> nodes= graph.getNodes();
        Node n= nodes.get(selectedNode);    
        List<int[]> neighbors= n.getNeighbors();    //prendiamo i vicini del nodo
        Iterator<int[]> it= neighbors.iterator();
        while(it.hasNext()){    //scorriamo i vicini
            int[] el= it.next();
            //System.out.println(el[0]);
            if(path.length()!=graph.getNumNodes()){ //se non siamo all'ultima iterazione prima delle foglie
                if(!path.contains(""+el[0]) && costo+el[1]<costoMin){ //se non abbiamo visitato già il nodo e se il costo corrente più il costo dell'arco è del costo minimo
                    RecursiveTSP(graph, path+el[0], costo+el[1]);   //richiamo ricorsivamente sul nodo
                }
            } else {    //se siamo all'ultima iterazione prima delle foglie
                int c= Integer.parseInt(path.substring(0,1));
                if(c==el[0] && costo+el[1]<costoMin){ //se il nodo da visitare è il primo nodo e il costo corrente più il costo dell'arco è minore del costo minimo
                    RecursiveTSP(graph, path+el[0], costo+el[1]); //richiamo ricorsivamente sul nodo finale
                }
            }
        }

    }

    private static Graph exampleGraph(){

        List<int[]> nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{2,1});
        nodeNeighbors.add(new int[]{3,2});
        Node node1= new Node(1, nodeNeighbors);

        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{1,1});
        nodeNeighbors.add(new int[]{4,3});
        nodeNeighbors.add(new int[]{5,2});
        Node node2= new Node(2,nodeNeighbors);

        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{1,2});
        nodeNeighbors.add(new int[]{3,4});
        nodeNeighbors.add(new int[]{5,7});
        Node node3= new Node(3,nodeNeighbors);
        
        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{2,3});
        nodeNeighbors.add(new int[]{3,3});
        nodeNeighbors.add(new int[]{5,5});
        Node node4= new Node(4,nodeNeighbors);
        
        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{2,2});
        nodeNeighbors.add(new int[]{4,5});
        nodeNeighbors.add(new int[]{3,7});
        Node node5= new Node(5,nodeNeighbors);
        
        HashMap<Integer, Node> nodes= new HashMap<Integer, Node> ();
        nodes.put(node1.getId(), node1);
        nodes.put(node2.getId(), node2);
        nodes.put(node3.getId(), node3);
        nodes.put(node4.getId(), node4);
        nodes.put(node5.getId(), node5);
        
        Edge[] edges= new Edge[7];
        edges[0]= new Edge(1,2,1);
        edges[1]= new Edge(1,3,2);
        edges[2]= new Edge(2,4,3);
        edges[3]= new Edge(2,5,2);
        edges[4]= new Edge(3,4,3);
        edges[5]= new Edge(3,5,7);
        edges[6]= new Edge(4,5,5);

        Graph graph= new Graph(nodes, edges);

        return graph;
    }

    private static Graph exampleGraph2(){

        List<int[]> nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{2,1});
        nodeNeighbors.add(new int[]{3,6});
        nodeNeighbors.add(new int[]{4,5});
        nodeNeighbors.add(new int[]{5,1});
        Node node1= new Node(1, nodeNeighbors);

        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{1,1});
        nodeNeighbors.add(new int[]{3,1});
        nodeNeighbors.add(new int[]{4,3});
        Node node2= new Node(2,nodeNeighbors);

        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{1,6});
        nodeNeighbors.add(new int[]{2,1});
        nodeNeighbors.add(new int[]{4,1});
        nodeNeighbors.add(new int[]{5,3});
        Node node3= new Node(3,nodeNeighbors);
        
        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{1,5});
        nodeNeighbors.add(new int[]{2,3});
        nodeNeighbors.add(new int[]{3,1});
        nodeNeighbors.add(new int[]{5,1});
        Node node4= new Node(4,nodeNeighbors);
        
        nodeNeighbors= new ArrayList<int[]>();
        nodeNeighbors.add(new int[]{1,1});
        nodeNeighbors.add(new int[]{3,3});
        nodeNeighbors.add(new int[]{4,1});
        Node node5= new Node(5,nodeNeighbors);
        
        HashMap<Integer, Node> nodes= new HashMap<Integer, Node> ();
        nodes.put(node1.getId(), node1);
        nodes.put(node2.getId(), node2);
        nodes.put(node3.getId(), node3);
        nodes.put(node4.getId(), node4);
        nodes.put(node5.getId(), node5);
        
        Edge[] edges= new Edge[9];
        edges[0]= new Edge(1,2,1);
        edges[1]= new Edge(1,3,6);
        edges[2]= new Edge(1,4,5);
        edges[3]= new Edge(1,5,1);
        edges[4]= new Edge(2,3,1);
        edges[5]= new Edge(2,4,3);
        edges[6]= new Edge(3,4,1);
        edges[7]= new Edge(3,5,3);
        edges[8]= new Edge(4,5,1);

        Graph graph= new Graph(nodes, edges);

        return graph;
    }
}