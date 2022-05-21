package edu.ufp.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Node  implements Serializable {
    private long id;
    private Localization localization;
    private ArrayList<Etiqueta> etiquetas;

    public Node(long id, Localization localization) {
        this.id = id;
        this.localization = localization;
        this.etiquetas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
    public void insert_etiqueta(Etiqueta etiqueta){
        this.etiquetas.add(etiqueta);
    }
    public void remove_etiqueta(Etiqueta etiqueta){
        if(this.etiquetas.contains(etiqueta))
            this.etiquetas.remove(etiqueta);
        System.out.println("Nao existe");
    }
}



