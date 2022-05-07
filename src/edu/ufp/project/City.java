package edu.ufp.project;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

//fazer hasmap para todos os Pois para ser mais facil entrar todos os Pois pelo id

/**
 * Main class.
 * Has all information about the city.
 * All the information is held here.
 */
public class City implements Serializable {
    private HashMap<Integer ,PoI>pois;
    private HashMap<Integer,User>users;
    private String nome;

    public City(String nome ) {
        this.pois = new HashMap<Integer ,PoI>();
        this.users = new HashMap<Integer,User>();
        this.nome=nome;
    }
    public void addPoiHash(PoI poi){
        this.pois.put(poi.getId(),poi);
    }
    public void addUserHash(User user ){
        this.users.put(user.getId(),user);
    }
    public void printPoiHash() {
        System.out.println(this.pois.toString());
    }
    public void printUserHash() {
        System.out.println(this.users.toString());
    }
}