package edu.ufp.project;


import edu.princeton.cs.algs4.RedBlackBST;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Logger;


public class PoI implements Serializable {
    //private static final Logger LOGGER = Logger.getLogger(PoI.class.getName());

    private int id;
    private TypeOfPoI typeOfPoI;
    private Localization localization;
    private String info;
    private RedBlackBST<Date, User> users;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TypeOfPoI getTypeOfPoI() {
        return typeOfPoI;
    }
    public void setTypeOfPoI(TypeOfPoI typeOfPoI) {
        this.typeOfPoI = typeOfPoI;
    }
    public Localization getLocalization() {
        return localization;
    }
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public RedBlackBST<Date, User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "PoI{" +
                "Id = " + id +
                "typeOfPoI = " + typeOfPoI +
                ", localization = " + localization +
                '}' + "\n";
    }


    /**
     * Contrutor PoI
     * @param Id -> id do PoI
     * @param typeOfPoI -> de que tipo é o respetivo poi
     * @param localization -> localização do poi
     * @param info -> info sobre o poi
     */
    public PoI(int Id, TypeOfPoI typeOfPoI, Localization localization, String info) {
        this.id = Id;
        this.typeOfPoI = typeOfPoI;
        this.localization = localization;
        this.info = info;
        users = new RedBlackBST<>();
    }
    /**
     * Metodo para adicionar um user na Redblack users num dado PoI (users que visitaram um dado PoI)
     * @param user -> user a ser adicionado
     * @param data -> data em que o user visitou o PoI
     */
    public void addUserPoi(User user, Date data) {
        this.users.put(data, user);
    }
    /**
     * Metodo para remover uma visita numa dada data
     * @param data -> data da visita a remover
     */
    public void removeUserPoi(Date data) {
        if (this.users.contains(data)) {
            this.users.delete(data);
        }
    }
    /**
     * metodo para remover um poi
     */
    public void removePoi(){
        for (Date key :this.users.keys()){
            this.users.get(key).getPois().delete(key);
        }
    }
    /**
     * Metodo que verifica quais os user que visitaram um dado poi num dado intervalo de tempo
     * @param d1 -> inicio do intervalo de tempo
     * @param d2 -> fim do intervalo de tempo
     * @return -> retorna um ArrayList com todos os users visitaram o poi
     */
    public ArrayList<User> user_visitado_poi_tempo(Date d1, Date d2){
        ArrayList<User> aUsers = new ArrayList<>();
        for (Date key : this.users.keys(d1, d2)) {
            aUsers.add(this.users.get(key));
        }
        return aUsers;
    }
    /**
     * Metodo para editar um determinado PoI
     * @param typeOfPoI -> novo tipo do poi
     * @param localization -> nova localização do poi
     * @param info -> nova info do poi
     */
    public void editPoi(TypeOfPoI typeOfPoI,Localization localization,String info){
        if(typeOfPoI!=null)
            this.setTypeOfPoI(typeOfPoI);
        if (info!=null)
            this.setInfo(info);
        if(localization!=null)
            this.setLocalization(localization);
    }
    /**
     * Requesito 5 f
     * @param pois -> hashmap de pois
     * @param d1 -> data1
     * @param d2 -> data2
     * @return -> arraylist dos top 5
     */
    public  ArrayList<PoI> top_5_poi(HashMap<Integer,PoI> pois,Date d1,Date d2){
        HashMap<PoI,Integer> top5=new HashMap<>();
        ArrayList<PoI> end=new ArrayList<>();
        ArrayList<PoI> top5poi=new ArrayList<>();
        int tamanho;
        for (Map.Entry<Integer,PoI> set:pois.entrySet()){
            tamanho=set.getValue().user_visitado_poi_tempo(d1,d2).size();
            top5.put(set.getValue(),tamanho);

        }
        // Create a list from elements of HashMap
        List<Map.Entry<PoI,Integer>> list = new LinkedList<Map.Entry<PoI,Integer>>(top5.entrySet());
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<PoI, Integer>>() {
            @Override
            public int compare(Map.Entry<PoI, Integer> o1, Map.Entry<PoI, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // put data from sorted list to hashmap

        for (Map.Entry<PoI,Integer> aa:list){
            end.add(aa.getKey());

        }
        for (int i= end.size()-1;i>= end.size()-5;i--){
            top5poi.add(end.get(i));
        }
        return top5poi; }
}
