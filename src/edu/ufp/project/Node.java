package edu.ufp.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Node extends Etiqueta implements Serializable {
    private int aresta;
    private Localization localization;


    public Node(String key, String val, String nome_rua, String tipo_rua, ArrayList<PoI> poi_na_etiqueta,int aresta) {
        super(key, val, nome_rua, tipo_rua, poi_na_etiqueta);
        this.aresta=aresta;
    }


    public int getAresta() {
        return aresta;
    }
    public void setAresta(int aresta) {
        this.aresta = aresta;
    }
    public Localization getLocalization() {
        return localization;
    }
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }
}
