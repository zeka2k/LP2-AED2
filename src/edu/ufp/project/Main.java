package edu.ufp.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        //launch(args);
        testCity();


    }


    public static void testCity() {
        City city = new City("Batatinha");
        Etiqueta e1 = new Etiqueta("1", "1", "elevado", 1);//node
        ArrayList<PoI> pois = new ArrayList<>();
        Etiqueta e2 = new Etiqueta("1", "1", "VCI", "Highway", pois);//way
        Way w1 = new Way(e2.getKey(), e2.getVal(), "Controlado", 2, 1000, "sol");

        //-->Poi's
        Localization l1 = new Localization(12123.1, -8.1233);
        PoI p1 = new PoI(1, TypeOfPoI.electricChargingStation, l1, "Cars");
        city.addPoiHash(p1);
        Localization l2 = new Localization(42242.23, -8.12343);
        PoI p2 = new PoI(2, TypeOfPoI.fireHydrants, l2, "");
        city.addPoiHash(p2);
        Localization l3 = new Localization(13443.1, -9.1233);
        PoI p3 = new PoI(3, TypeOfPoI.trafficLigth, l3, "");
        city.addPoiHash(p3);
        Localization l4 = new Localization(12123.1, -1.1233);
        PoI p4 = new PoI(4, TypeOfPoI.electricChargingStation, l4, "Cars");
        city.addPoiHash(p4);
        Localization l5 = new Localization(12223.1, -2.1233);
        PoI p5 = new PoI(5, TypeOfPoI.electricChargingStation, l5, "Cars");
        city.addPoiHash(p5);
        Localization l6 = new Localization(12323.1, -3.1233);
        PoI p6 = new PoI(6, TypeOfPoI.electricChargingStation, l6, "Cars");
        city.addPoiHash(p6);
        Localization l7 = new Localization(12423.1, -4.1233);
        PoI p7 = new PoI(7, TypeOfPoI.electricChargingStation, l7, "Cars");
        city.addPoiHash(p7);
        Localization l8 = new Localization(12523.1, -5.1233);
        PoI p8 = new PoI(8, TypeOfPoI.electricChargingStation, l8, "Cars");
        city.addPoiHash(p8);
        Localization l9 = new Localization(12623.1, -6.1233);
        PoI p9 = new PoI(9, TypeOfPoI.electricChargingStation, l9, "Cars");
        city.addPoiHash(p9);
        Localization l10 = new Localization(17123.1, -7.1233);
        PoI p10 = new PoI(10, TypeOfPoI.electricChargingStation, l10, "Cars");
        city.addPoiHash(p10);

        //-->User's
        User u1 = new User(TypeOfUser.Admin, "Jose Carlos", 1);
        city.addUserHash(u1);
        User u2 = new User(TypeOfUser.Admin, "Rodrigo Branco", 2);
        city.addUserHash(u2);
        User u3 = new User(TypeOfUser.Basic, "Pina Galinhas", 3);
        city.addUserHash(u3);
        User u4 = new User(TypeOfUser.Basic, "Batatinha Alfredo", 4);
        city.addUserHash(u4);
        User u5 = new User(TypeOfUser.Premium, "Papi Xulo", 5);
        city.addUserHash(u5);
        User u6 = new User(TypeOfUser.Basic, "Jose Carlos", 6);
        city.addUserHash(u6);
        User u7 = new User(TypeOfUser.Basic, "Rodrigo Branco", 7);
        city.addUserHash(u7);
        User u8 = new User(TypeOfUser.Basic, "Pina Galinhas", 8);
        city.addUserHash(u8);
        User u9 = new User(TypeOfUser.Basic, "Batatinha Alfredo", 9);
        city.addUserHash(u9);
        User u10 = new User(TypeOfUser.Premium, "Papi Xulo", 10);
        city.addUserHash(u10);


        ArrayList<PoI> pp1 = new ArrayList<>();
        ArrayList<User> uu1 = new ArrayList<>();
        Date d1 = new Date(2000, 1, 1);
        Date d2 = new Date(2000, 2, 1);
        Date d3 = new Date(2000, 3, 1);
        u1.addPoIUser(p1, d1);
        u1.addPoIUser(p2, d2);
        u1.addPoIUser(p3, d3);
        pp1 = u1.poi_visitado_user_tempo(d1, d3);
        for (PoI poi : pp1) {
            System.out.println(poi.toString());
        }

        p1.addUserPoi(u1, d1);
        p1.addUserPoi(u2, d2);
        p1.addUserPoi(u3, d3);
        uu1 = p1.user_visitado_poi_tempo(d1, d2);
        for (User user : uu1) {
            System.out.println(user.toString());
        }

        city.printPoiHash();
        city.printUserHash();
    }
}
