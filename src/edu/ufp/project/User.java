package edu.ufp.project;


import edu.princeton.cs.algs4.RedBlackBST;
import java.util.ArrayList;


public class User {
    private TypeOfUser typeOfUser;
    private String nome;
    private int id;
    private RedBlackBST<Date, PoI> pois;


    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }
    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "User{" +
                "typeOfUser=" + typeOfUser +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}' + "\n";
    }


    public User(TypeOfUser typeOfUser, String nome, int id) {
        this.typeOfUser = typeOfUser;
        this.nome = nome;
        this.id = id;
        pois = new RedBlackBST<>();
    }
    public void addPoIUser(PoI poi, Date data) {
        this.pois.put(data, poi);
    }
    public void removePoIUser(Date data) {
        if (this.pois.contains(data)) {
            this.pois.delete(data);
        }
    }
    public ArrayList<PoI> poi_visitado_user_tempo(Date d1, Date d2){
        ArrayList<PoI> aPois = new ArrayList<>();
        for (Date key : this.pois.keys(d1, d2)) {
            aPois.add(this.pois.get(key));
        }
        return aPois;
    }
}
