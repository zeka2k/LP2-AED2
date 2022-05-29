package edu.ufp.project;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;


/**
 * Main class.
 * Has all information about the city.
 * All the information is held here.
 */
public class City implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(City.class.getName());

    private HashMap<Integer, PoI> pois;
    private HashMap<Integer, User> users;
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
     *
     * @param nome -> nome da city
     */
    public City(String nome) {
        this.pois = new HashMap<Integer, PoI>();
        this.users = new HashMap<Integer, User>();
        this.nome = nome;
    }

    /**
     * Metodo para adicionar um poi ao hashmap de pois
     *
     * @param poi -> poi a adicionar
     */
    public void addPoiHash(PoI poi) {
        this.pois.put(poi.getId(), poi);
    }

    /**
     * Metodo para adicionar um user ao hasmap de users
     *
     * @param user -> user a ser adicionado
     */
    public void addUserHash(User user) {
        this.users.put(user.getId(), user);
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
     *
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
     *
     * @param poi -> poi a remover
     */
    public void removePoI(PoI poi) {
        if (this.pois.containsValue(poi)) {
            this.pois.remove(poi.getId(), poi);
            poi.removePoi();
        }
    }

    /**
     * Metodo para escrever info dos users em ficheiro txt
     */
    public  void writetxtusers_poi(){
        Out out=new Out(".idea/data/output_user_poi");
        out.println(this.nome);
        out.println(this.pois.size());
        for (Map.Entry<Integer, PoI> poi : this.pois.entrySet()){
            out.println(poi.getValue().getId()+","+poi.getValue().getTypeOfPoI()+","+poi.getValue().getLocalization().getX()+","+poi.getValue().getLocalization().getY()+","+poi.getValue().getInfo());
        }
        out.println(this.users.size());
        for (Map.Entry<Integer,User> user:this.users.entrySet()){
            out.println(user.getValue().getTypeOfUser()+","+user.getValue().getNome()+","+user.getValue().getId());
        }
        for (Map.Entry<Integer, PoI> poi : this.pois.entrySet()){
            out.println(poi.getValue().getUsers().size());
            for (Date  key: poi.getValue().getUsers().keys()){
                out.println(poi.getValue().getId() +","+poi.getValue().getUsers().get(key).getId()+","+key.getYear()+","+key.getMonth()+","+key.getDay()+","+key.getHour()+","+key.getMinute()+","+key.getSecond());
            }
        }
        for (Map.Entry<Integer, User> user : this.users.entrySet()){
            out.println(user.getValue().getPois().size());
            for (Date  key: user.getValue().getPois().keys()){
                out.println(user.getValue().getId()+","+user.getValue().getPois().get(key).getId()+","+key.getYear()+","+key.getMonth()+","+key.getDay()+","+key.getHour()+","+key.getMinute()+","+key.getSecond());
            }
        }
    }

    /**
     * Metodo para ler info de users em ficheiro txt
     * @param filetxt -> ficheiro a ler
     */
    public void readtxtuser_poi(String filetxt){
        String linha;
        In in=new In(filetxt);
        if (!in.exists()) {
            System.out.println("Failed to read file");
        } else {
            while(in.hasNextLine()){
                linha=in.readLine();
                this.setNome(linha);
                linha=in.readLine();
                int poicount=Integer.parseInt(linha);
                int idpoi;
                TypeOfPoI tipopoi;

                String info;
                for (int i=0;i<poicount;i++){
                    linha=in.readLine();
                    String[] newpoi =linha.split(",",5);
                    idpoi=Integer.parseInt(newpoi[0]);
                    if(newpoi[1].matches("electricChargingStation")){
                        tipopoi=TypeOfPoI.electricChargingStation;
                    }
                    else if(newpoi[1].matches("fireHydrants")) {
                        tipopoi=TypeOfPoI.fireHydrants;
                    }
                    else
                        tipopoi=TypeOfPoI.trafficLigth;
                    Localization localization=new Localization(Double.parseDouble(newpoi[2]),Double.parseDouble(newpoi[3]));
                    info=newpoi[4];
                    PoI po=new PoI(idpoi,tipopoi,localization,info);
                    this.addPoiHash(po);
                }
                linha=in.readLine();
                int usercount=Integer.parseInt(linha);
                TypeOfUser tipouser;
                int iduser;
                String nome;
                for (int i=0;i<usercount;i++){
                    linha=in.readLine();
                    String[] newUser =linha.split(",",3);
                    if(newUser[0].matches("Basic")){
                        tipouser=TypeOfUser.Basic;
                    }
                    else if(newUser[0].matches("Admin")){
                        tipouser=TypeOfUser.Admin;
                    }
                    else {
                        tipouser=TypeOfUser.Premium;
                    }
                    nome=newUser[1];
                    iduser=Integer.parseInt(newUser[2]);
                    User u=new User(tipouser,nome,iduser);
                    this.addUserHash(u);
                }
                for (int i=0;i<poicount;i++){
                    linha=in.readLine();
                    int rsbcount;
                    rsbcount=Integer.parseInt(linha);
                    for (int j=0;j<rsbcount;j++){
                        int idpoirsb;
                        int iduserrsb;
                        int year,mnth,day,hour,min,sec;
                        linha=in.readLine();
                        String[] rsbp =linha.split(",",8);
                        idpoirsb=Integer.parseInt(rsbp[0]);
                        iduserrsb=Integer.parseInt(rsbp[1]);
                        year=Integer.parseInt(rsbp[2]);
                        mnth=Integer.parseInt(rsbp[3]);
                        day=Integer.parseInt(rsbp[4]);
                        hour=Integer.parseInt(rsbp[5]);
                        min=Integer.parseInt(rsbp[6]);
                        sec=Integer.parseInt(rsbp[7]);
                        Date data=new Date(year,mnth,day,hour,min,sec);
                        this.pois.get(idpoirsb).addUserPoi(this.users.get(iduserrsb),data);
                    }
                }
                for (int i=0;i<usercount;i++){
                    linha=in.readLine();
                    int rsbcount;
                    rsbcount=Integer.parseInt(linha);
                    for (int j=0;j<rsbcount;j++){
                        int idpoirsb;
                        int iduserrsb;
                        int year,mnth,day,hour,min,sec;
                        linha=in.readLine();
                        String[] rsbp =linha.split(",",8);
                        iduserrsb=Integer.parseInt(rsbp[0]);
                        idpoirsb=Integer.parseInt(rsbp[1]);
                        year=Integer.parseInt(rsbp[2]);
                        mnth=Integer.parseInt(rsbp[3]);
                        day=Integer.parseInt(rsbp[4]);
                        hour=Integer.parseInt(rsbp[5]);
                        min=Integer.parseInt(rsbp[6]);
                        sec=Integer.parseInt(rsbp[7]);
                        Date data=new Date(year,mnth,day,hour,min,sec);
                        this.users.get(iduserrsb).addPoIUser(this.pois.get(idpoirsb),data);
                    }
                }
            }
        }
    }
}