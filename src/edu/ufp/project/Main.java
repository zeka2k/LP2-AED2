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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    private void testCity() {
        City city = new City("Batatinha");
        Etiqueta e1 = new Etiqueta("1", "1", "elevado", 1);//node
        ArrayList<PoI> pois = new ArrayList<>();
        Etiqueta e2 = new Etiqueta("1", "1", "VCI", "Highway", pois);//way
        Way w1 = new Way(e2.getKey(), e2.getVal(), "Controlado", 2, 1000, "sol");

        //-->Poi's
        Localization l1 = new Localization(12123.1, -8.1233);
        PoI p1 = new PoI(TypeOfPoI.electricChargingStation, l1, "Cars");
        Localization l2 = new Localization(42242.23, -8.12343);
        PoI p2 = new PoI(TypeOfPoI.fireHydrants, l2, "");
        Localization l3 = new Localization(13443.1, -9.1233);
        PoI p3 = new PoI(TypeOfPoI.trafficLigth, l3, "");
        Localization l4 = new Localization(12123.1, -1.1233);
        PoI p4 = new PoI(TypeOfPoI.electricChargingStation, l4, "Cars");
        Localization l5 = new Localization(12223.1, -2.1233);
        PoI p5 = new PoI(TypeOfPoI.electricChargingStation, l5, "Cars");
        Localization l6 = new Localization(12323.1, -3.1233);
        PoI p6 = new PoI(TypeOfPoI.electricChargingStation, l6, "Cars");
        Localization l7 = new Localization(12423.1, -4.1233);
        PoI p7 = new PoI(TypeOfPoI.electricChargingStation, l7, "Cars");
        Localization l8 = new Localization(12523.1, -5.1233);
        PoI p8 = new PoI(TypeOfPoI.electricChargingStation, l8, "Cars");
        Localization l9 = new Localization(12623.1, -6.1233);
        PoI p9 = new PoI(TypeOfPoI.electricChargingStation, l9, "Cars");
        Localization l10 = new Localization(17123.1, -7.1233);
        PoI p10 = new PoI(TypeOfPoI.electricChargingStation, l10, "Cars");

        //-->User's
        User u1 = new User(TypeOfUser.Admin, "Jose Carlos", 1);
        User u2 = new User(TypeOfUser.Admin, "Rodrigo Branco", 2);
        User u3 = new User(TypeOfUser.Basic, "Pina Galinhas", 3);
        User u4 = new User(TypeOfUser.Basic, "Batatinha Alfredo", 4);
        User u5 = new User(TypeOfUser.Premium, "Papi Xulo", 5);
        User u6 = new User(TypeOfUser.Basic, "Jose Carlos", 6);
        User u7 = new User(TypeOfUser.Basic, "Rodrigo Branco", 7);
        User u8 = new User(TypeOfUser.Basic, "Pina Galinhas", 8);
        User u9 = new User(TypeOfUser.Basic, "Batatinha Alfredo", 9);
        User u10 = new User(TypeOfUser.Premium, "Papi Xulo", 10);
    }
}
