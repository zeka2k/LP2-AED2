package edu.ufp.project;

import edu.princeton.cs.algs4.*;
import edu.ufp.project.exceptions.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

public class LocalizationManager implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(Localization.class.getName());
    private EdgeWeightedDigraph globalGraph;       // global graph with all the sub-graphs
    private ArrayList<Localization> locations;
    protected static Cost cost = Cost.DISTANCE;

    public LocalizationManager() {
        this.locations = new ArrayList<>();
    }

    /**
     * Add a location to the ArrayList of locations and sets the VertexId
     *
     * @param location being added to locations
     */
    public void addLocation(Localization location) {
        if (this.locations.contains(location)) {
            LOGGER.warning("Location already exists!");
            return;
        }
        location.setVertexId(this.locations.size());
        this.locations.add(location);
        LOGGER.info("Location successfully added to locations!");
    }



}
