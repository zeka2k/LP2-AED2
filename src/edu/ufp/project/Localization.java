package edu.ufp.project;

import edu.ufp.project.exceptions.VertexNotFoundException;
import java.io.Serializable;

public class Localization implements Serializable {
    private int vertexId = - 1;
    private double x;
    private double y;
    private TypeOfPoI typeOfPoI;
    //private String zona;


    public Localization(double x, double y, String node,TypeOfPoI typeOfPoI) {
        this.typeOfPoI = typeOfPoI;
        this.x = x;
        this.y = y;
    }
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
     * Calculates the distance between a Location and other Location
     * based on the coordinates
     * @param other Location we want the distance from
     * @return the total distance from one Location and other
     */
    public double getDistanceFromOtherLocation(Localization other){
        return Math.sqrt((other.getY() - this.y) * (other.getY() - this.y) + (other.getX() - this.x) * (other.getX() - this.x));
    }
    public double getDistanceFromCoordinate(int x , int y){
        return Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x));
    }
}
