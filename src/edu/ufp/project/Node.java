package edu.ufp.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Node implements Serializable {
    private int id;
    private Localization localization;
    private ArrayList<Etiqueta> etiquetas;
    private PoI poi;


    public PoI getPoi() {
        return poi;
    }
    public void setPoi(PoI poi) {
        this.poi = poi;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", localization=" + localization +
                ", etiquetas=" + etiquetas +
                ", poi=" + poi +
                '}';
    }


    /**
     * Contrutor Node apenas com id e localizacao
     * @param id -> id do Node
     * @param etiquetas -> etiquetas presentes no node
     * @param poi -> poi presente no node
     */
    public Node(int  id, ArrayList<Etiqueta> etiquetas, PoI poi) {
        this.id = id;
        this.localization = poi.getLocalization();
        this.etiquetas = etiquetas;
        this.poi = poi;
    }

    /**
     * Metodo para inserir uma etiqueta no Node
     * @param etiqueta -> etiqueta a inserir
     */
    public void insert_etiqueta(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
    }

    /**
     * Metodo para remover uma etiqueta do Node
     * @param etiqueta -> etiqueta a remover do Node
     */
    public void remove_etiqueta(Etiqueta etiqueta) {
        if (this.etiquetas.contains(etiqueta))
            this.etiquetas.remove(etiqueta);
        System.out.println("Nao existe");
    }
}



