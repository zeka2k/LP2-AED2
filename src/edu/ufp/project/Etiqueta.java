package edu.ufp.project;

import java.util.ArrayList;

public class Etiqueta {
    private String key;
    private String val;


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
    @Override
    public String toString() {
        return "Etiqueta{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }


    /**
     * construtor para um node
     */
    public Etiqueta(String key, String val) {
        this.key = key;
        this.val = val;

    }
}
