package edu.ufp.project;


import edu.princeton.cs.algs4.DirectedEdge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Way extends DirectedEdge implements Serializable {
    private int id;
    private Node node1;
    private Node node2;
    private ArrayList<Etiqueta> etiquetas;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Node getNode1() {
        return node1;
    }
    public void setNode1(Node node1) {
        this.node1 = node1;
    }
    public Node getNode2() {
        return node2;
    }
    public void setNode2(Node node2) {
        this.node2 = node2;
    }
    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
    @Override
    public String toString() {
        return "Way{" +
                "id=" + id +
                ", node1=" + node1 +
                ", node2=" + node2 +
                ", etiquetas=" + etiquetas +
                '}';
    }


    /**
     * Contrutor de uma way
     * @param id -> id da way
     * @param node1 -> node1 da way
     * @param node2 -> node2 da way
     * @param peso -> peso da way
     * @param etiquetas -> etiqueta da way
     */
    public Way(int id, Node node1, Node node2, double peso, ArrayList<Etiqueta> etiquetas) {
        super(node1.getId(), node2.getId(), peso);
        this.id = id;
        this.node1 = node1;
        this.node2 = node2;
        this.etiquetas = etiquetas;
    }

    /**
     * Metodo para inserir uma etiqueta na way
     * @param etiqueta -> etiqueta a inserir na way
     */
    public void insert_etiqueta(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
    }

    /**
     * Metodo para remover uma etiqueta da way
     * @param etiqueta -> etiqueta a remover da way
     */
    public void remove_etiqueta(Etiqueta etiqueta) {
        if (this.etiquetas.contains(etiqueta))
            this.etiquetas.remove(etiqueta);
        System.out.println("Nao existe");
    }
}
