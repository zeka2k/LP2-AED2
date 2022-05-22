package edu.ufp.project;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Way  implements Serializable {
   private int id;
   private int node1;
   private int  node2;
   private double peso;
   private ArrayList<Etiqueta> etiquetas;


    public Way(int  id, int  node1, int  node2, double peso) {
        this.id = id;
        this.node1 = node1;
        this.node2 = node2;
        this.peso = peso;
        this.etiquetas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNode1() {
        return node1;
    }

    public void setNode1(int node1) {
        this.node1 = node1;
    }

    public int getNode2() {
        return node2;
    }

    public void setNode2(int node2) {
        this.node2 = node2;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

    @Override
    public String toString() {
        return "Way{" +
                "id=" + id +
                ", node1=" + node1 +
                ", node2=" + node2 +
                ", peso=" + peso +
                ", etiquetas=" + etiquetas +
                '}';
    }
}
