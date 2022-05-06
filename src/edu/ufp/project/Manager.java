package edu.ufp.project;

import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.io.*;
import java.util.logging.Logger;

/**
 * Singleton that manages all the Nodes
 */

public class Manager implements Serializable{
    private static final Logger LOGGER = Logger.getLogger(Manager.class.getName());

    private static Manager manager;
    private SeparateChainingHashST<String, Way> ways;
    private SeparateChainingHashST<String, Node> nodes;
    private SeparateChainingHashST<String,LocalizationManager> locations;

    private Manager() {
        this.ways = new SeparateChainingHashST<>();
        this.nodes = new SeparateChainingHashST<>();
        this.locations = new SeparateChainingHashST<>();
    }

    public static Manager getInstance() {
        if (manager == null) manager = new Manager();
        return manager;
    }
    /**
     * Returns a node stored in nodes
     *
     * @param name wanted.
     * @return The university called by the name.
     */
    public Node getNode(String name) {
        Node node = nodes.get(name);
        if (node == null) {
            // doesn't have this node yet, let's add it
            node = new Node(name);
            nodes.put(name, node);
        }
        return node;
    }


    /**
     * Returns the LocationManager from given node
     * @param node we want the LocationManager
     * @return LocationManager from the university
     */
    public LocalizationManager getLocationManager(String node) {
        if(this.locations.contains(node)) return this.locations.get(node);
        this.locations.put(node,new LocalizationManager());
        return this.locations.get(node);
    }

}
