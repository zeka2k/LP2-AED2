package edu.ufp.project;

import edu.ufp.project.exceptions.VertexNotFoundException;
import java.io.Serializable;

public class Localization implements Serializable {
    private int vertexId = - 1;
    private double x;
    private double y;
    private TypeOfPoI typeOfPoI;
    //private String zona;


    /**
     * Contrutor Localization de um node
     * @param x -> latitude do node
     * @param y -> longitude do node
     * @param node -> nome do node
     * @param typeOfPoI -> tipo do poi localizado no node
     */
    public Localization(double x, double y, String node,TypeOfPoI typeOfPoI) {
        this.typeOfPoI = typeOfPoI;
        this.x = x;
        this.y = y;
    }
    /**
     * Contrutor Localization geral
     * @param x -> latitude
     * @param y -> longitude
     */
    public Localization(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public String toString() {
        return "Localization{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public TypeOfPoI getTypeOfPoI() {
        return typeOfPoI;
    }
    public int getVertexId() throws VertexNotFoundException {
        if (this.vertexId == - 1) throw new VertexNotFoundException("The vertexId is not define, sub-graph not yet created");
        return this.vertexId;
    }


    /**
     * Calcula a distancia entre duas locatizações
     * @param other -> loacalização a calcular a distancia
     * @return -> retorna a distancia entre localizaçoes
     */
    public double getDistanceFromOtherLocation(Localization other){
        return Math.sqrt((other.getY() - this.y) * (other.getY() - this.y) + (other.getX() - this.x) * (other.getX() - this.x));
    }
    /**
     * Calcula a distancia baseado em outras cordenadas
     * @param x -> latitude
     * @param y -> longitude
     * @return -> retorna a distancia entre coordenadas
     */
    public double getDistanceFromCoordinate(int x , int y){
        return Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x));
    }
}
