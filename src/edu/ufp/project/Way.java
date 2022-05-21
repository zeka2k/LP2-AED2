package edu.ufp.project;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Way  implements Serializable {
   private long id;
   private long node1;
   private long node2;
   private float peso;
   private ArrayList<Etiqueta> etiquetas;


    public Way(long id, long node1, long node2, float peso) {
        this.id = id;
        this.node1 = node1;
        this.node2 = node2;
        this.peso = peso;
        this.etiquetas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNode1() {
        return node1;
    }

    public void setNode1(long node1) {
        this.node1 = node1;
    }

    public long getNode2() {
        return node2;
    }

    public void setNode2(long node2) {
        this.node2 = node2;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
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
}
