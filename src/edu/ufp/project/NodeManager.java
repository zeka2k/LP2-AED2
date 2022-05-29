package edu.ufp.project;

import edu.princeton.cs.algs4.*;
import edu.ufp.project.exceptions.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public class NodeManager implements Serializable {
    private EdgeWeightedDigraph globalGraph;       // global graph with all the sub-graphs
    private ArrayList<Node> nodes;
    private ArrayList<Way> ways;
    private ArrayList<Subgraph> subgraphs;
    private ArrayList<Node> indisponiveis;
    protected static Cost cost = Cost.DISTANCE;

    public NodeManager() {
        this.nodes = new ArrayList<>();
        this.ways = new ArrayList<>();
        this.subgraphs=new ArrayList<>();
        this.indisponiveis=new ArrayList<>();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Way> getWays() {
        return ways;
    }

    public void setWays(ArrayList<Way> ways) {
        this.ways = ways;
    }

    public ArrayList<Subgraph> getSubgraphs() {
        return subgraphs;
    }

    public void setSubgraphs(ArrayList<Subgraph> subgraphs) {
        this.subgraphs = subgraphs;
    }

    public ArrayList<Node> getIndisponiveis() {
        return indisponiveis;
    }

    public void setIndisponiveis(ArrayList<Node> indisponiveis) {
        this.indisponiveis = indisponiveis;
    }

    public void addSubGraph(Subgraph subgraph){
        if(this.subgraphs.contains(subgraph)){
            System.out.println("subgraph already exists!");
    return;
}
        this.subgraphs.add(subgraph);
    System.out.println("subgraph successfully added ");

}
    /**
     * Add a location to the ArrayList of locations and sets the VertexId
     *
     * @param node being added to nodes
     */
    public void addNode(Node node) {
        if (this.nodes.contains(node)) {
            System.out.println("Node already exists!");
            return;
        }

        this.nodes.add(node);
        System.out.println("Node successfully added ");
    }
public void createGlobalGraph() throws LocationsNotInitException{
        if(this.nodes.isEmpty()) throw new LocationsNotInitException();
        this.globalGraph=new EdgeWeightedDigraph(this.nodes.size());
    System.out.println("Global graph was created successfully with " + this.nodes.size() + " nodes!");
}
    public Localization getLocationWherenodeIs(int nodeId) throws VertexNotFoundException {
        for (Node node : this.nodes) if (node.getId() == nodeId) return node.getLocalization();
        return null;
    }
   public void createEdge(Way way) throws GlobalGraphNotCreated{
        if(this.globalGraph !=null){
            this.globalGraph.addEdge(way);
            this.ways.add(way);

            System.out.println("An edge from " + way.getNode1() + " to " + way.getNode2()  + " weight  "+way.weight() +  "was added to graph");
   } else throw new GlobalGraphNotCreated();
   }
    public boolean isConexo(EdgeWeightedDigraph g) {
        int s = 0;
        int flag = 0;
        DijkstraSP sp = new DijkstraSP(g, s);
        for (int t = 0; t < g.V(); t++) {
            if (!sp.hasPathTo(t)) {
                System.out.println("Not connected in -> " + t);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("The graph is connected!");
            return true;
        }
        System.out.println("The graph is not connected!");
        return false;
    }
    public void shortestPathBetween(Node source, Node destination ,EdgeWeightedDigraph g,Cost type) {
        cost = type;
        DijkstraSP dijkstraSP = new DijkstraSP(g, source.getId() );
        System.out.println("printing dijkstra ...");
        if (dijkstraSP.hasPathTo(destination.getId() )) {
            StdOut.printf("%d to %d (%.2f)  ", source.getId(), destination.getId(), dijkstraSP.distTo(destination.getId() ));
            for (DirectedEdge e : dijkstraSP.pathTo(destination.getId() )) {
                StdOut.print((e.toString()));
            }
            StdOut.println();
        } else {
            StdOut.printf("%d to %d         no path\n", source.getId() , destination.getId() );
        }
    }
    public ArrayList<Node> listar_vertices_etiqeta_poi(TypeOfPoI tipo_poi){
        ArrayList<Node> end =new ArrayList<>();
        for (Node node:this.nodes){
            if(node.getPoi().getTypeOfPoI()==tipo_poi)
                end.add(node);
        }
        return end;
    }
    public Node getNearestLocation(Localization localization,TypeOfPoI tipo_poi) throws LocationsNotInitException {
        ArrayList<Node> end=listar_vertices_etiqeta_poi(tipo_poi);
        double min=end.get(0).getLocalization().getDistanceFromOtherLocation(localization);
        Node chosen=end.get(0);
        for(Node  node : end){

            double distance = node.getLocalization().getDistanceFromOtherLocation(localization);
            if(distance <= min) {
                min = distance;
                  chosen = node;
            }
        }
        return chosen;
    }
    public void update_graph(Etiqueta e,Node n,Way w){
        if(w==null){
            n.getEtiquetas().add(e);
        }
        else if(n==null){
            w.getEtiquetas().add(e);
        }
        else if(n==null && w==null){
            System.out.println("nao adicionou nodes nem ways para modificar");
        }
        else {
            w.getEtiquetas().add(e);
            w.getNode1().getEtiquetas().add(e);
            w.getNode2().getEtiquetas().add(e);
        }
    }
    public void interrupcao(Node n){
        Etiqueta e =new Etiqueta("obra","parado");
        n.getEtiquetas().add(e);
        this.indisponiveis.add(n);
    }
public void writetxtnode(){
        Out out=new Out(".idea/data/output_node_txt");
        out.println(this.nodes.size());
        for (Node nodes :this.nodes){
            if(nodes.getEtiquetas()==null){
                out.println(nodes.getId()+","+nodes.getPoi().getId()+","+0);
            }
            else{
            out.println(nodes.getId()+","+nodes.getPoi().getId()+","+nodes.getEtiquetas().size());
            for (Etiqueta etiqueta:nodes.getEtiquetas()){
                out.print(etiqueta.getKey()+","+etiqueta.getVal()+",");
            }
            out.println();}
        }
}
public void readtxtnode(String file,City c){
    String linha;
    In in=new In(file);
    if (!in.exists()) {
        System.out.println("Failed to read file");
    } else {
        while(in.hasNextLine()){
            linha=in.readLine();
            int nodeCount=Integer.parseInt(linha);
            for (int i=0;i<nodeCount;i++){
                linha=in.readLine();
                String node[]=linha.split(",",3);
                int eticount,nodeid,poiid;
                nodeid=Integer.parseInt(node[0]);
                poiid=Integer.parseInt(node[1]);
                eticount=Integer.parseInt(node[2]);
                if(eticount==0){
                    Node newnode =new Node(nodeid,null,c.getPois().get(poiid));
                    this.addNode(newnode);
                }else{
                    String key;
                    String value;
                    linha=in.readLine();
                    String eti[]=linha.split(",",eticount);
                    ArrayList<Etiqueta> etis=new ArrayList<>();
                    for (int j=0;j<eticount;j=j+2){
                        key=eti[j];
                        value=eti[j+1];
                        Etiqueta et=new Etiqueta(key,value);
                        etis.add(et);
                    }
                    Node newnode =new Node(nodeid,etis,c.getPois().get(poiid));
                    this.addNode(newnode);

            }}
        }
}}
public void writewaytxt(){
    Out out=new Out(".idea/data/output_way_txt");
    out.println(this.ways.size());
    for (Way ways:this.ways){
        if(ways.getEtiquetas()==null){
            out.println(ways.getId()+","+this.nodes.indexOf(ways.getNode1())+","+this.nodes.indexOf(ways.getNode2())+","+ways.weight()+","+0);
        }
        else{
            out.println(ways.getId()+","+ways.getNode1().getId()+","+ways.getNode2().getId()+","+ways.weight()+","+ways.getEtiquetas().size());
                for (Etiqueta eti:ways.getEtiquetas()){
                    out.print(eti.getKey()+","+eti.getVal()+",");
                }
            out.println();
            }

    }
}
public void readtxtway(String file) throws LocationsNotInitException, GlobalGraphNotCreated {
        this.createGlobalGraph();
    String linha;
    In in=new In(file);
    if (!in.exists()) {
        System.out.println("Failed to read file");
    } else {
        while(in.hasNextLine()){
            linha=in.readLine();
            int wayCount=Integer.parseInt(linha);
            for (int i=0;i<wayCount;i++){
                linha=in.readLine();
                String way[]=linha.split(",",5);
                int wayid,nodeind1,nodeind2,eticount;
                double peso;
                wayid=Integer.parseInt(way[0]);
                nodeind1=Integer.parseInt(way[1]);
                nodeind2=Integer.parseInt(way[2]);
                peso=Double.parseDouble(way[3]);
                eticount=Integer.parseInt(way[4]);
                if(eticount==0){
                    Way newway=new Way(wayid,this.nodes.get(nodeind1),this.nodes.get(nodeind2),peso,null);
                    this.createEdge(newway);
                }
                else {
                    String key;
                    String value;
                    linha=in.readLine();
                    String eti[]=linha.split(",",eticount);
                    ArrayList<Etiqueta> etis=new ArrayList<>();
                    for (int j=0;j<eticount;j=j+2){
                        key=eti[j];
                        value=eti[j+1];
                        Etiqueta et=new Etiqueta(key,value);
                        etis.add(et);
                    }
                    Way newway=new Way(wayid,this.nodes.get(nodeind1),this.nodes.get(nodeind2),peso,etis);
                    this.createEdge(newway);
                }
            }
        }
}}
    public EdgeWeightedDigraph getGlobalGraph() {
        return globalGraph;
    }

    public void setGlobalGraph(EdgeWeightedDigraph globalGraph) {
        this.globalGraph = globalGraph;
    }

}
