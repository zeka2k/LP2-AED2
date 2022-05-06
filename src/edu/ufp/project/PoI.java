package edu.ufp.project;


import edu.princeton.cs.algs4.RedBlackBST;
import java.io.Serializable;
import java.util.logging.Logger;


public class PoI implements Serializable {
    //private static final Logger LOGGER = Logger.getLogger(PoI.class.getName());

    private int visitas;
    private TypeOfPoI typeOfPoI;
    private Localization localization;
    private String info;
    private RedBlackBST<Date, User> users;


    public int getVisitas() {
        return visitas;
    }
    public void setVisitas(int visitas) {
        this.visitas = visitas;
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



    public PoI(TypeOfPoI typeOfPoI, Localization localization, String info) {
        this.visitas = 0;
        this.typeOfPoI = typeOfPoI;
        this.localization = localization;
        this.info = info;
        users = new RedBlackBST<>();
    }
    public void addUserPoi(User user, Date data) {
        this.users.put(data, user);
        this.visitas++;
    }
    public void removeUserPoi(Date data) {
        if (this.users.contains(data)) {
            this.users.delete(data);
            this.visitas--;
        }
    }
}
