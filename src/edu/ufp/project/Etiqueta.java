package edu.ufp.project;

import java.util.ArrayList;

public class Etiqueta {
    private String key;
    private String val;
    private String nome_rua;
    private String tipo_rua;
    private ArrayList<PoI> poi_na_etiqueta = new ArrayList<>();
    private String volume_de_trafego;
    private int sensores;


    //construtor para os way
    public Etiqueta(String key, String val, String nome_rua, String tipo_rua, ArrayList<PoI> poi_na_etiqueta) {
        this.key = key;
        this.val = val;
        this.nome_rua = nome_rua;
        this.tipo_rua = tipo_rua;
        this.poi_na_etiqueta = poi_na_etiqueta;
    }
    //construtor para as node
    public Etiqueta(String key, String val, String volume_de_trafego, int sensores) {
        this.key = key;
        this.val = val;
        this.volume_de_trafego = volume_de_trafego;
        this.sensores = sensores;
    }


    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }
    public String getNome_rua() {
        return nome_rua;
    }
    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }
    public String getTipo_rua() {
        return tipo_rua;
    }
    public void setTipo_rua(String tipo_rua) {
        this.tipo_rua = tipo_rua;
    }
    public String getVolume_de_trafego() {
        return volume_de_trafego;
    }
    public void setVolume_de_trafego(String volume_de_trafego) {
        this.volume_de_trafego = volume_de_trafego;
    }
    public int getSensores() {
        return sensores;
    }
    public void setSensores(int sensores) {
        this.sensores = sensores;
    }
}
