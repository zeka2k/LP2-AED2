package edu.ufp.project;

import edu.princeton.cs.algs4.*;
import edu.ufp.project.exceptions.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class NodeManager implements Serializable {
    private EdgeWeightedDigraph globalGraph;       // global graph with all the sub-graphs
    private ArrayList<Node> nodes;
    private ArrayList<Way> ways;
    private ArrayList<Subgraph> subgraphs;
    private ArrayList<Node> indisponiveis;
    protected static Cost cost = Cost.DISTANCE;

    public NodeManager() {
        this.nodes = new ArrayList<>();
        this.ways = new ArrayList<>();
        this.subgraphs=new ArrayList<>();
        this.indisponiveis=new ArrayList<>();
    }
public void addSubGraph(Subgraph subgraph){
        if(this.subgraphs.contains(subgraph)){
            System.out.println("subgraph already exists!");
    return;
}
        this.subgraphs.add(subgraph);
    System.out.println("subgraph successfully added ");

}
    /**
     * Add a location to the ArrayList of locations and sets the VertexId
     *
     * @param node being added to nodes
     */
    public void addNode(Node node) {
        if (this.nodes.contains(node)) {
            System.out.println("Node already exists!");
            return;
        }

        this.nodes.add(node);
        System.out.println("Node successfully added ");
    }
public void createGlobalGraph() throws LocationsNotInitException{
        if(this.nodes.isEmpty()) throw new LocationsNotInitException();
        this.globalGraph=new EdgeWeightedDigraph(this.nodes.size());
    System.out.println("Global graph was created successfully with " + this.nodes.size() + " nodes!");
}
    public Localization getLocationWherenodeIs(int nodeId) throws VertexNotFoundException {
        for (Node node : this.nodes) if (node.getId() == nodeId) return node.getLocalization();
        return null;
    }
   public void createEdge(Way way) throws GlobalGraphNotCreated{
        if(this.globalGraph !=null){
            this.globalGraph.addEdge(way);
            this.ways.add(way);

            System.out.println("An edge from " + way.getNode1() + " to " + way.getNode2()  + " weight  "+way.weight() +  "was added to graph");
   } else throw new GlobalGraphNotCreated();
   }
    public boolean isConexo(EdgeWeightedDigraph g) {
        int s = 0;
        int flag = 0;
        DijkstraSP sp = new DijkstraSP(g, s);
        for (int t = 0; t < g.V(); t++) {
            if (!sp.hasPathTo(t)) {
                System.out.println("Not connected in -> " + t);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("The graph is connected!");
            return true;
        }
        System.out.println("The graph is not connected!");
        return false;
    }
    public void shortestPathBetween(int source, int destination ,EdgeWeightedDigraph g,Cost type) {
        cost = type;
        DijkstraSP dijkstraSP = new DijkstraSP(g, source );
        System.out.println("printing dijkstra ...");
        if (dijkstraSP.hasPathTo(destination )) {
            StdOut.printf("%d to %d (%.2f)  ", source, destination, dijkstraSP.distTo(destination ));
            for (DirectedEdge e : dijkstraSP.pathTo(destination )) {
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
    public void update_graph(Etiqueta e,Node n,Way w){
        if(w==null){
            n.getEtiquetas().add(e);
        }
        else if(n==null){
            w.getEtiquetas().add(e);
        }
        else if(n==null && w==null){
            System.out.println("nao adicionou nodes nem ways para modificar");
        }
        else {
            w.getEtiquetas().add(e);
            w.getNode1().getEtiquetas().add(e);
            w.getNode2().getEtiquetas().add(e);
        }
    }
    public void interrupcao(Node n){
        Etiqueta e =new Etiqueta("obra","parado");
        n.getEtiquetas().add(e);
        this.indisponiveis.add(n);
    }

    public EdgeWeightedDigraph getGlobalGraph() {
        return globalGraph;
    }

    public void setGlobalGraph(EdgeWeightedDigraph globalGraph) {
        this.globalGraph = globalGraph;
    }
}
