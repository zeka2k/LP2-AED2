package edu.ufp.project;


import java.io.Serializable;
import java.util.logging.Logger;


public class Way extends Etiqueta implements Serializable {
    private double distancia;
    private String tempo;


    public Way(String key, String val, String volume_de_trafego, int sensores, double distancia, String tempo) {
        super(key, val, volume_de_trafego, sensores);
        this.distancia = distancia;
        this.tempo = tempo;
    }


    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public String getTempo() {
        return tempo;
    }
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
}
