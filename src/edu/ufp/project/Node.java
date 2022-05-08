package edu.ufp.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Node extends Etiqueta implements Serializable {
    private Localization localization;

    /**
     * Construtor Node
     * @param key -> key do node
     * @param val -> val do node
     * @param poi_na_etiqueta -> tipo de poi presente no node
     */
    public Node(String key, String val, ArrayList<PoI> poi_na_etiqueta) {
        super(key, val, poi_na_etiqueta);
    }


    public Localization getLocalization() {
        return localization;
    }
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }
}
