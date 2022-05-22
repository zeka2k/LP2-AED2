package edu.ufp.project;

import edu.princeton.cs.algs4.*;
import edu.ufp.project.exceptions.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

public class NodeManager implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(Localization.class.getName());
    private EdgeWeightedGraph globalGraph;       // global graph with all the sub-graphs
    private ArrayList<Node> nodes;
    private ArrayList<Way> ways;
    protected static Cost cost = Cost.DISTANCE;

    public NodeManager() {
        this.nodes = new ArrayList<>();
        this.ways = new ArrayList<>();
    }

    /**
     * Add a location to the ArrayList of locations and sets the VertexId
     *
     * @param node being added to nodes
     */
    public void addNode(Node node) {
        if (this.nodes.contains(node)) {
            LOGGER.warning("Node already exists!");
            return;
        }

        this.nodes.add(node);
        LOGGER.info("Node successfully added to locations!");
    }
public void createGlobalGraph() throws LocationsNotInitException{
        if(this.nodes.isEmpty()) throw new LocationsNotInitException();
        this.globalGraph=new EdgeWeightedGraph(this.nodes.size());
    LOGGER.info("Global graph was created successfully with " + this.nodes.size() + " nodes!");
}
    public Localization getLocationWherenodeIs(int nodeId) throws VertexNotFoundException {
        for (Node node : this.nodes) if (node.getId() == nodeId) return node.getLocalization();
        return null;
    }
   public void createEdge(Way way) throws GlobalGraphNotCreated{
        if(this.globalGraph !=null){
            Edge e=new Edge(way.getNode1(), way.getNode2(), way.getPeso());
            this.globalGraph.addEdge(e);
            this.ways.add(way);

       LOGGER.info("An edge from " + way.getNode1() + " to " + way.getNode2()  + " weight  "+way.getPeso() +  "was added to graph");
   } else throw new GlobalGraphNotCreated();
   }
    public boolean isConexo(EdgeWeightedGraph g) {
        int s = 0;
        int flag = 0;
        DijkstraUndirectedSP diskastra= new DijkstraUndirectedSP(g,s);
        for (int t = 0; t < g.V(); t++) {
            if (!diskastra.hasPathTo(t)) {
                LOGGER.info("Not connected in -> " + t);
                flag = 1;
            }
        }
        if (flag == 0) {
            LOGGER.info("The graph is connected!");
            return true;
        }
        LOGGER.info("The graph is not connected!");
        return false;
    }
    public void shortestPathBetween(int source, int destination ,EdgeWeightedGraph g,Cost type) {
        cost = type;
        DijkstraUndirectedSP dijkas = new DijkstraUndirectedSP(g,source);
        LOGGER.info("printing dijkstra ...");
        if (dijkas.hasPathTo(destination )) {
            StdOut.printf("%d to %d (%.2f)  ", source, destination, dijkas.distTo(destination ));
            for (Edge e : dijkas.pathTo(destination )) {
                StdOut.print((e.toString()));
            }
            StdOut.println();
        } else {
            StdOut.printf("%d to %d         no path\n", source , destination );
        }
    }
    public ArrayList<Node> listar_vertices_etiqeta_poi(TypeOfPoI tipo_poi){
        ArrayList<Node> end =new ArrayList<>();
        for (Node node:this.nodes){
            if(node.getPoi().getTypeOfPoI()==tipo_poi)
                end.add(node);
        }
        return end;
    }
    public Node getNearestLocation(Localization localization,TypeOfPoI tipo_poi) throws LocationsNotInitException {
        ArrayList<Node> end=listar_vertices_etiqeta_poi(tipo_poi);
        double min=end.get(0).getLocalization().getDistanceFromOtherLocation(localization);
        Node chosen=end.get(0);
        for(Node  node : end){

            double distance = node.getLocalization().getDistanceFromOtherLocation(localization);
            if(distance <= min) {
                min = distance;
                  chosen = node;
            }
        }
        return chosen;
    }

}
