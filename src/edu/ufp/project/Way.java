package edu.ufp.project;


import java.io.Serializable;
import java.util.logging.Logger;


public class Way implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(Way.class.getName());

    private String id;
    private String name;

    public Way(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person:" +
                "\n\tid: " + id +
                "\n\tname: " + name;
    }
}
