package edu.ufp.project;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.ufp.project.exceptions.GlobalGraphNotCreated;
import edu.ufp.project.exceptions.LocationsNotInitException;

import java.util.ArrayList;
import java.util.logging.Logger;

public class subgraph {
    private static final Logger LOGGER = Logger.getLogger(Localization.class.getName());
    private EdgeWeightedGraph graph;
    private ArrayList<Node> nodes;
    private ArrayList<Way> ways;
    protected static Cost cost = Cost.DISTANCE;
  public subgraph(){
      this.nodes=new ArrayList<>();
      this.ways=new ArrayList<>();
  }
    public void addNode(Node node) {
        if (this.nodes.contains(node)) {
            LOGGER.warning("Node already exists!");
            return;
        }

        this.nodes.add(node);
        LOGGER.info("Node successfully added to locations!");
    }
    public void createsubGraph() throws LocationsNotInitException {
        if(this.nodes.isEmpty()) throw new LocationsNotInitException();
        this.graph=new EdgeWeightedGraph(this.nodes.size());
        LOGGER.info("Global graph was created successfully with " + this.nodes.size() + " nodes!");
    }
    public void createEdge(Way way) throws GlobalGraphNotCreated {
        if(this.graph !=null){
            Edge e=new Edge(way.getNode1(), way.getNode2(), way.getPeso());
            this.graph.addEdge(e);
            this.ways.add(way);

            LOGGER.info("An edge from " + way.getNode1() + " to " + way.getNode2()  + " weight  "+way.getPeso() +  "was added to graph");
        } else throw new GlobalGraphNotCreated();
    }
}
