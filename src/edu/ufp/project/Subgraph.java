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
  public Subgraph(){
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
        this.graph=new EdgeWeightedDigraph(this.nodes.size());
        LOGGER.info("Global graph was created successfully with " + this.nodes.size() + " nodes!");
    }
    public void createEdge(Way way) throws GlobalGraphNotCreated {
        if(this.graph !=null){

            this.graph.addEdge(way);
            this.ways.add(way);

            LOGGER.info("An edge from " + way.getNode1() + " to " + way.getNode2()  + " weight  "+way.weight() +  "was added to graph");
        } else throw new GlobalGraphNotCreated();
    }
}
