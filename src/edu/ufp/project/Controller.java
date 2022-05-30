package edu.ufp.project;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Controller {
    protected static final int GROUP_MARGIN = 20;

    public TextArea edgesField;
    public TextField verticesNumberField;
    private GeoGraph gG;
    public Group graphGroup;
    private double radius = 20;

    public void createGraphGroup(){

        graphGroup.getChildren().clear();

        for(int i=0; i <gG.V(); i++){
            Circle c = new Circle(gG.getVertexPosX(i), gG.getVertexPosY(i), radius);
            c.setFill(Color.WHITE);

            StackPane stack = new StackPane();
            stack.setLayoutX(gG.getVertexPosX(i) - radius);
            stack.setLayoutY(gG.getVertexPosY(i) - radius);
            stack.getChildren().addAll(c, new Text(i + ""));

            graphGroup.getChildren().add(stack);

            if(gG.E() > 0){
                for(Integer adj: gG.adj(i)) {
                    Line line = new Line(gG.getVertexPosX(i), gG.getVertexPosY(i), gG.getVertexPosX(adj), gG.getVertexPosY(adj));
                    graphGroup.getChildren().add(line);
                }
            }
        }
    }

    private void createNewGraph(int nVertices){
        if(gG == null)
            gG = new GeoGraph(nVertices);
        else
            gG = new GeoGraph(gG, nVertices);
    }

    public void handleVerticesButtonAction(ActionEvent actionEvent) {
        try {
            createNewGraph(Integer.parseInt(verticesNumberField.getText()));
            createGraphGroup();
        }catch(NumberFormatException e){
            System.out.println("Error: Vertices not inserted!");
        }
    }

    public void handleEdgesButtonAction(ActionEvent actionEvent) {
        try {
            if (gG != null)
                gG = new GeoGraph(gG);
            else
                createNewGraph(Integer.parseInt(verticesNumberField.getText()));

            String[] lines = edgesField.getText().split("\n");
            for (String line : lines) {
                String[] position = line.split(";");
                int v = Integer.parseInt(position[0]);
                int adj = Integer.parseInt(position[1]);

                if (!gG.containsEdge(v, adj))
                    gG.addEdge(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
            }
            createGraphGroup();
        } catch(NumberFormatException e) {
            System.out.println("Error: Edges or Vertices not inserted!");
        }
    }

    public void handleClearButtonAction(ActionEvent actionEvent) {
        graphGroup.getChildren().clear();
        edgesField.setText("");
        verticesNumberField.setText("");
        gG = null;
    }
}
