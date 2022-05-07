package edu.ufp.project;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import edu.princeton.cs.algs4.RedBlackBST;
import java.io.Serializable;
import java.util.ArrayList;
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
    @Override
    public String toString() {
        return "PoI{" +
                "Id = " + id +
                "typeOfPoI = " + typeOfPoI +
                ", localization = " + localization +
                '}' + "\n";
    }


    public PoI(int Id, TypeOfPoI typeOfPoI, Localization localization, String info) {
        this.id = Id;
        this.typeOfPoI = typeOfPoI;
        this.localization = localization;
        this.info = info;
        users = new RedBlackBST<>();
    }
    public void addUserPoi(User user, Date data) {
        this.users.put(data, user);
    }
    public void removeUserPoi(Date data) {
        if (this.users.contains(data)) {
            this.users.delete(data);
        }
    }
    public ArrayList<User> user_visitado_poi_tempo(Date d1, Date d2){
        ArrayList<User> aUsers = new ArrayList<>();
        for (Date key : this.users.keys(d1, d2)) {
            aUsers.add(this.users.get(key));
        }
        return aUsers;
    }
}
