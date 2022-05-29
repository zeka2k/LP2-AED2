package edu.ufp.project;

import edu.ufp.project.exceptions.GlobalGraphNotCreated;
import edu.ufp.project.exceptions.LocationsNotInitException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/

    }


    public static void main(String[] args) throws LocationsNotInitException, GlobalGraphNotCreated {
        //launch(args);
        //testCity();
         test2();
    }


    /**
     * função de teste para popular a cidade e fazer novos teste dentrp da cidade
     */
    public static void testCity() throws LocationsNotInitException, GlobalGraphNotCreated {
        //-->City
        City city = new City("Batatinha");
        Date d1 = new Date(2000, 1, 1);
        Date d2 = new Date(2000, 2, 1);
        Date d3 = new Date(2000, 3, 1);
        ArrayList<PoI> pois = new ArrayList<>();



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

        /*-->Print city hashmap<--
        city.printPoiHash();
        city.printUserHash();*/


        /*-->Requesito 3 funcao editar<--
        p4.editPoi(TypeOfPoI.trafficLigth, null, null);
        System.out.println(p4.toString());*/


        ArrayList<PoI> pp1 ;
        ArrayList<User> uu1;
        //-->Requesito 5a<--
        u1.addPoIUser(p1, d1);
        u1.addPoIUser(p2, d2);
        u1.addPoIUser(p3, d3);/*
        pp1 = u1.poi_visitado_user_tempo(d1, d3);
        for (PoI poi : pp1) {
            System.out.println(poi.toString());
        }*/


        //-->Requesito 5b<--
        //System.out.println(u1.poi_nao_visitado_usertempo(city.getPois(), d1,d2).toString());


        //-->Requesito 5c<--
        p1.addUserPoi(u1, d1);
        p1.addUserPoi(u2, d2);
        p1.addUserPoi(u3, d3);
        //city.writetxtusers_poi();
/*
        uu1 = p1.user_visitado_poi_tempo(d1, d3);
        for (User user : uu1) {
            System.out.println(user.toString());
        }*/


        /*-->Remove from hashmap<--
        city.printUserHash();
        city.removerUser(u1);
        city.printUserHash();
        city.printPoiHash();
        city.removePoI(p1);
        city.printPoiHash();*/

        /*-->Requesito 6<--
        p1.addUserPoi(u1, d1);
        u1.addPoIUser(p1, d1);
        p1.addUserPoi(u2, d2);
        u2.addPoIUser(p1, d2);
        p1.addUserPoi(u3, d3);
        u3.addPoIUser(p1, d3);
        city.now();
        city.removePoI(p2);
        city.removerUser(u1);
        city.now();*/

        /*-->Requesito 5 e/f<--
        Date d4= new Date(2000, 4, 1);
        Date d5= new Date(2000, 5, 1);

        u1.addPoIUser(p1, d1);
        u1.addPoIUser(p2, d2);
        u1.addPoIUser(p3, d3);

        u2.addPoIUser(p1, d1);
        u2.addPoIUser(p2, d2);

        u3.addPoIUser(p1, d1);
        u3.addPoIUser(p2, d2);
        u3.addPoIUser(p3, d3);
        u3.addPoIUser(p1,d4);

        u4.addPoIUser(p4,d1);

        u5.addPoIUser(p1, d1);
        u5.addPoIUser(p2, d2);
        u5.addPoIUser(p3, d3);
        u5.addPoIUser(p4,d4);
        u5.addPoIUser(p5,d5);

        p1.addUserPoi(u1,d1);

        p2.addUserPoi(u1,d1);
        p2.addUserPoi(u2,d2);

        p3.addUserPoi(u1,d1);
        p3.addUserPoi(u2,d2);
        p3.addUserPoi(u3,d3);

        p4.addUserPoi(u1,d1);
        p4.addUserPoi(u2,d2);
        p4.addUserPoi(u3,d3);
        p4.addUserPoi(u4,d4);

        p5.addUserPoi(u1,d1);
        p5.addUserPoi(u2,d2);
        p5.addUserPoi(u3,d3);
        p5.addUserPoi(u4,d4);
        p5.addUserPoi(u5,d5);

        System.out.println(u1.top_5_user(city.getUsers(),d1,d5).toString() );
        System.out.println(p1.top_5_poi(city.getPois(),d1,d5).toString());*/

        //milestone 2
        Etiqueta eti=new Etiqueta("oi","mem");
        Etiqueta eti2=new Etiqueta("oi","mim");
ArrayList<Etiqueta> etis=new ArrayList<>();
etis.add(eti);
etis.add(eti2);
        Node n1 =new Node(1,null,p1);
        Node n2=new Node (2,etis,p2);
        Node n3=new Node (3,null,p3);
        Node n4 =new Node(4,null,p4);
        Node n5 =new Node(0,null,p5);
        Way w1 =new Way(1,n1,n2,10,null);
        Way w2=new Way(2,n2,n3,15,null);
        Way w3 =new Way(3,n3,n4,4,null);
        Way w4 =new Way(4,n4,n5,2,null);
        Way w5 =new Way(5,n5,n1,5,null);
        NodeManager global=new NodeManager();
        global.addNode(n1);
        global.addNode(n2);
        global.addNode(n3);
        global.addNode(n4);
        global.addNode(n5);
        global.createGlobalGraph();
        global.createEdge(w1);
        global.createEdge(w2);
        global.createEdge(w3);
        global.createEdge(w4);
        global.createEdge(w5);
        global.writetxtnode();
        global.writewaytxt();/*
        global.isConexo(global.getGlobalGraph());
        global.shortestPathBetween(n1,n2,global.getGlobalGraph(),Cost.TIME);*/
    }
    public static void test2() throws GlobalGraphNotCreated, LocationsNotInitException {
City c =new City("aaa");
      c.readtxtuser_poi(".idea/data/output_user_poi");
      NodeManager nodeManager=new NodeManager();
      nodeManager.readtxtnode(".idea/data/output_node_txt",c);
        System.out.println(nodeManager.getNodes().toString());
        nodeManager.readtxtway(".idea/data/output_way_txt");
        System.out.println(nodeManager.getWays().toString());
    }
}
