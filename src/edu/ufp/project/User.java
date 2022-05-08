package edu.ufp.project;


import edu.princeton.cs.algs4.RedBlackBST;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;


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
    public RedBlackBST<Date, PoI> getPois() {
        return pois;
    }

    @Override
    public String toString() {
        return "User{" +
                "typeOfUser=" + typeOfUser +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}' + "\n";
    }


    /**
     * Contrutor User
     * @param typeOfUser -> tipo do user
     * @param nome -> nome do user
     * @param id -> id do user
     */
    public User(TypeOfUser typeOfUser, String nome, int id) {
        this.typeOfUser = typeOfUser;
        this.nome = nome;
        this.id = id;
        pois = new RedBlackBST<>();
    }
    /**
     * Metodo para adicionar um poi na Redblack pois num dado user (pois que foram visitados por um dado user)
     * @param poi -> poi a ser adicionado
     * @param data -> data em que o user visitou o PoI
     */
    public void addPoIUser(PoI poi, Date data) {
        this.pois.put(data, poi);
    }
    /**
     * Metodo para remover uma visita numa dada data
     * @param data -> data da visita a remover
     */
    public void removePoIUser(Date data) {
        if (this.pois.contains(data)) {
            this.pois.delete(data);
        }
    }
    /**
     * metodo para remover um user
     */
    public void removeUser(){
        for (Date key :this.pois.keys()){
            this.pois.get(key).getUsers().delete(key);
        }
    }
    /**
     * Metodo que verifica quais os pois visitados por um dado user num dado intervalo de tempo
     * @param d1 -> inicio do intervalo de tempo
     * @param d2 -> fim do intervalo de tempo
     * @return -> retorna um ArrayList de todos o pois que o user visitou
     */
    public ArrayList<PoI> poi_visitado_user_tempo(Date d1, Date d2){
        ArrayList<PoI> aPois = new ArrayList<>();
        for (Date key : this.pois.keys(d1, d2)) {
            aPois.add(this.pois.get(key));
        }
        return aPois;
    }
    /**
     * Metodo que verifica quais os pois noa foram visitado pelo um dado user num dado intervalo de tempo
     * @param pois -> hashmap de todos os pois existentes
     * @param d1 -> inicio do intervalo de tempo
     * @param d2 -> fim do intervalo de tempo
     * @return -> retorna um ArrayList com todos os pois nao visitados
     */
    public HashMap<Integer,PoI>poi_nao_visitado_usertempo(HashMap<Integer,PoI> pois,Date d1,Date d2){
        HashMap<Integer,PoI> poiHashNaoVisitdaoUser = new HashMap<>();
        poiHashNaoVisitdaoUser.putAll(pois);

        ArrayList<PoI> pp1 = this.poi_visitado_user_tempo(d1,d2);

        for (PoI poi : pp1) {
            poiHashNaoVisitdaoUser.remove(poi.getId(),poi);
        }
        return poiHashNaoVisitdaoUser;
    }
    /**
     * Metodo para editar um dado user
     * @param typeOfUser -> novo tipo do user
     * @param nome -> novo nome do user
     */
    public void editUser(TypeOfUser typeOfUser,String nome){
        if(typeOfUser!=null)
            this.setTypeOfUser(typeOfUser);
        if(nome!=null)
            this.setNome(nome);
    }
    /**
     * Requesito 5 e
     * @param users ->hasmap de users
     * @param d1 -> data1
     * @param d2 -> data2
     * @return -> arraylist dos top 5 users
     */
    public  ArrayList<User> top_5_user(HashMap<Integer,User> users,Date d1,Date d2){

        HashMap<User,Integer> top5=new HashMap<>();
        ArrayList<User> end=new ArrayList<>();
        ArrayList<User> top5users=new ArrayList<>();

        int tamanho;
        for (Map.Entry<Integer,User> set:users.entrySet()){
            tamanho=set.getValue().poi_visitado_user_tempo(d1,d2).size();
            top5.put(set.getValue(),tamanho);

        }
        // Create a list from elements of HashMap
        List<Map.Entry<User,Integer>> list = new LinkedList<Map.Entry<User,Integer>>(top5.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<User, Integer>>() {
            @Override
            public int compare(Map.Entry<User, Integer> o1, Map.Entry<User, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // put data from sorted list to hashmap

        for (Map.Entry<User,Integer> aa:list){
            end.add(aa.getKey());

        }
        for (int i= end.size()-1;i>= end.size()-5;i--){
            top5users.add(end.get(i));
        }
        return top5users;
    }
}
