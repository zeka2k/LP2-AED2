package edu.ufp.project;


import java.io.Serializable;
import java.util.logging.Logger;


public class Way extends Etiqueta implements Serializable {
    private double distancia;
    private String tempo;


    /**
     * Construtor Way
     * @param key ->key da way
     * @param val -> val da way
     * @param volume_de_trafego -> volume de trafego da way
     * @param sensores -> sensores presentes na way
     * @param nome_rua -> nome da way
     * @param tipo_rua -> tipo de way
     * @param distancia -> distancia da way
     * @param tempo ->
     */
    public Way(String key, String val, String volume_de_trafego, int sensores, String nome_rua, String tipo_rua, double distancia, String tempo) {
        super(key, val, volume_de_trafego, sensores, nome_rua, tipo_rua);
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
