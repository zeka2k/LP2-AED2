package edu.ufp.project;

import java.util.logging.Logger;

public class Node {
    private static final Logger LOGGER = Logger.getLogger(Node.class.getName());
    private final String name;

    public Node(String name) {
        this.name = name;
    }
}
