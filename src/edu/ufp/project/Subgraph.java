package edu.ufp.project;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.ufp.project.exceptions.GlobalGraphNotCreated;
import edu.ufp.project.exceptions.LocationsNotInitException;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Subgraph {
    private static final Logger LOGGER = Logger.getLogger(Localization.class.getName());
    private EdgeWeightedDigraph graph;
    private ArrayList<Node> nodes;
    private ArrayList<Way> ways;
    protected static Cost cost = Cost.DISTANCE;


    public EdgeWeightedDigraph getGraph() {
        return graph;
    }
    public void setGraph(EdgeWeightedDigraph graph) {
        this.graph = graph;
    }
    public ArrayList<Node> getNodes() {
        return nodes;
    }
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    public ArrayList<Way> getWays() {
        return ways;
    }
    public void setWays(ArrayList<Way> ways) {
        this.ways = ways;
    }


    /**
     * Contrutor subgraph
     */
    public Subgraph() {
        this.nodes = new ArrayList<>();
        this.ways = new ArrayList<>();
    }

    /**
     * Metodo para adicionar um node ao subgraph
     * @param node -> node a adicionar
     */
    public void addNode(Node node) {
        if (this.nodes.contains(node)) {
            System.out.println("Node already exists!");
            return;
        }

        this.nodes.add(node);
        System.out.println("Node successfully added to subgraph!");
    }

    /**
     * Metodo para criar um subgraph
     * @throws LocationsNotInitException -> excecao lancada em caso de nao existirem nodes
     */
    public void createsubGraph() throws LocationsNotInitException {
        if (this.nodes.isEmpty()) throw new LocationsNotInitException();
        this.graph = new EdgeWeightedDigraph(this.nodes.size());
        System.out.println("SubGraph was created successfully with " + this.nodes.size() + " nodes!");
    }

    /**
     * Metodo para criar uma edge
     * @param way -> edge a ser criada
     * @throws GlobalGraphNotCreated -> excecao lancada em caso de nao existir um graph principal, neste caso um subgraph
     */
    public void createEdge(Way way) throws GlobalGraphNotCreated {
        if (this.graph != null) {

            this.graph.addEdge(way);
            this.ways.add(way);

            System.out.println("An edge from " + way.getNode1() + " to " + way.getNode2() + " weight  " + way.weight() + "was added to graph");
        } else throw new GlobalGraphNotCreated();
    }
}
