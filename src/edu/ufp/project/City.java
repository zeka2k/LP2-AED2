package edu.ufp.project;




import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Main class.
 * Has all information about the city.
 * All the information is held here.
 */
public class City implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(City.class.getName());

    private HashMap<Integer ,PoI>pois;
    private HashMap<Integer,User>users;
    private String nome;


    public HashMap<Integer, PoI> getPois() {
        return pois;
    }
    public HashMap<Integer, User> getUsers() {
        return users;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Contrutor City
     * @param nome -> nome da city
     */
    public City(String nome ) {
        this.pois = new HashMap<Integer ,PoI>();
        this.users = new HashMap<Integer,User>();
        this.nome=nome;
    }
    /**
     * Metodo para adicionar um poi ao hashmap de pois
     * @param poi -> poi a adicionar
     */
    public void addPoiHash(PoI poi){
        this.pois.put(poi.getId(),poi);
    }
    /**
     * Metodo para adicionar um user ao hasmap de users
     * @param user -> user a ser adicionado
     */
    public void addUserHash(User user ){
        this.users.put(user.getId(),user);
    }
    /**
     * Metodo para imprimir o hasmap de pois
     */
    public void printPoiHash() {
        System.out.println(this.pois.toString());
    }
    /**
     * Metodo para imprimir o hasmap de users
     */
    public void printUserHash() {
        System.out.println(this.users.toString());
    }
    /**
     * Metodo now gera um snapshot global do sistema
     */
    public void now() {
        Date d1 = new Date(1, 1, 1);
        Date d2 = new Date(3000, 12, 31);
        LOGGER.info("Printing current city status ...");
        LOGGER.info("Printing PoIs...");
        this.printPoiHash();

        for (Map.Entry<Integer, PoI> poi : this.pois.entrySet()) {
            System.out.println(poi.getValue().user_visitado_poi_tempo(d1, d2).toString());
        }
    }
    /**
     * Metodo para remover um user da hashmap users
     * @param user -> user a remover
     */
    public void removerUser(User user) {
        if (this.users.containsValue(user)) {
            this.users.remove(user.getId(), user);
            user.removeUser();
        }
    }
    /**
     * Metodo para remover um poi da hashmap pois
     * @param poi -> poi a remover
     */
    public void removePoI(PoI poi) {
        if (this.pois.containsValue(poi)) {
            this.pois.remove(poi.getId(), poi);
            poi.removePoi();
        }
    }
}