package edu.ufp.project;


import edu.princeton.cs.algs4.RedBlackBST;


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
}
