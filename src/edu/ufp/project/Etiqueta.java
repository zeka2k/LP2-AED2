package edu.ufp.project;

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


    public Etiqueta(String key, String val) {
        this.key = key;
        this.val = val;
    }
}
