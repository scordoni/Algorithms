/*
 * 
 * Assignment 5
 * Due Date and Time: 12/10/21 before 12:00am 
 * Purpose: to implement directed graphs and greedy algorithm structures.
 * Input: The user will be inputting a file containing a list of edges and vertices. 
 * Output: The program will output direct graph shortest paths and greedy algorithms. 
 * @author Shannon Cordoni 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;



public class Assignment5Cordoni {

    //Declare keyboard 
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Declare and initialize variables 
        String line;

        //For binary search tree
        String[] spicearray = new String[14];
        String[][] splitspicearray1 = new String[14][13];
        String[][] splitspicearray2 = new String[14][23];
       
        String[] instructionarray = new String[88];
        String[] graph1array = new String[17];
        String[] graph2array = new String[21];
        String[] graph3array = new String[21];
        String[] graph4array = new String[21];

        String[][] splitinstructionarray = new String[88][17];
        String[][] graph1splitarray = new String[17][17];
        String[][] graph2splitarray = new String[21][17];
        String[][] graph3splitarray = new String[21][17];
        String[][] graph4splitarray = new String[21][17];


        //Reads in the spice items 
        //create new file object
        File myFile = new File("spice.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile);
            line = null;
            
            int i = 0;

            //while there are more lines in the file it inputs them into a word array
            while(input.hasNext())
            {  
                spicearray[i] = input.nextLine();       
                i++;
            }//while

            input.close();  

        }//try

        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch

        //Reads in the graph file to create graphs 
        //create new file object
        File myFile1 = new File("graphs2.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile1);
            line = null;
            
            int i = 0;

            while(input.hasNext()){

                instructionarray[i] = input.nextLine();
                i++;
            }//while
  
            input.close();  

        }//try
        
        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch

        //Spices!

        //Print to check array 
        for (int i = 0; i < spicearray.length; i++){
            //System.out.println(spicearray[i]);
        }//for

        //spiceItUp(spicearray);


        //Graphs

        //Print to check array 
        for (int i = 0; i < instructionarray.length; i++){
           //System.out.println(instructionarray[i]);
        }//for

        //split up into 2D array 
        for (int i = 0; i < splitinstructionarray.length; i++){
            for( int j = 0; j < splitinstructionarray[i].length; j++){
            splitinstructionarray[i] = instructionarray[i].split(" ");
            }//for j 
        }//for

        //graphItUp(splitinstructionarray);

        
        //Put instructions into graph 1 array
        for (int i = 0; i < graph1array.length; i++){
            graph1array[i] = instructionarray[i];
        }//for

        //split up into 2D array for graph 1
        for (int i = 0; i < graph1splitarray.length; i++){
            for( int j = 0; j < graph1splitarray[i].length; j++){
            graph1splitarray[i] = graph1array[i].split(" ");
            }//for j 
        }//for
       
        //Graphs!!
        System.out.println(" ");
        System.out.println("Graph 1");

        //make linked list
        graphItUp(graph1splitarray);
        

    }//main

    //This method creates the linked objects of the directed graph
    public static void graphItUp(String[][] instructions) {

        GraphCordoni graphCordoni = new GraphCordoni();
        int k = 1;

        //create 
        for (int i = 0; i < instructions.length; i++){    
            
            if(instructions[i][0].compareToIgnoreCase("new")==0){
                
                //graphCordoni = new GraphCordoni();
                //System.out.println("Graph " + k);
                k++;

            }//if

            //add
            else if (instructions[i][0].compareToIgnoreCase("add")==0){

                //create new vertex and set id to add to vertex array
                if(instructions[i][1].compareToIgnoreCase("vertex")==0){

                    VertexCordoni vertex = new VertexCordoni();

                    vertex.setId(instructions[i][2]);
                        
                    graphCordoni.vertexes.add(vertex);
                    
                    
                }//if
                
                //create new edge and set id to add to edge array
                else if(instructions[i][1].compareToIgnoreCase("edge")==0){
        
                    EdgeCordoni edge = new EdgeCordoni();

                    for (int j = 0; j < graphCordoni.vertexes.size(); j++){

                        if (graphCordoni.vertexes.get(j).getId().compareToIgnoreCase(instructions[i][2])==0){
                            edge.setFrom(graphCordoni.vertexes.get(j));
                        }//if

                        if (graphCordoni.vertexes.get(j).getId().compareToIgnoreCase(instructions[i][4])==0){
                            edge.setTo(graphCordoni.vertexes.get(j));
                        }//if
                    
                    }//for
                    
                    

                    if ((instructions[i][5].compareToIgnoreCase("") == 0)){
                        edge.setWeight(Integer.parseInt(instructions[i][6]));
                    }
                    
                    else{
                        edge.setWeight(Integer.parseInt(instructions[i][5]));
                    }//else

                    graphCordoni.edges.add(edge);

                }//else if
            }//if
        }//for i

        /*
        for(int i = 0; i < graphCordoni.edges.size(); i++){

            System.out.println(" ");
            System.out.println("From: "  + graphCordoni.edges.get(i).getFrom().getId());
            System.out.println("To: "  + graphCordoni.edges.get(i).getTo().getId());
            System.out.println("Weight: "  + graphCordoni.edges.get(i).getWeight());
            System.out.println(" ");

        }//for
        */

        bellmanFord(graphCordoni, graphCordoni.edges.get(0).getWeight(),  graphCordoni.vertexes.get(0));
    }//graph it up 


    //This method preforms the bellman ford algorithm to find the shortest path
    public static boolean bellmanFord(GraphCordoni graph, int weight, VertexCordoni source) {
 
        System.out.println("bellman ford");

        ArrayList <String> path = new ArrayList <String>();

        singlesource(graph, source);

        boolean value = false;

        for (int i = 1; i < graph.vertexes.size() - 1; i++){

            for (int j = 0; j < graph.edges.size(); j++){

                //System.out.println("relax");
                relax(graph.edges.get(j).getTo(), graph.edges.get(j).getFrom(), graph.edges.get(j).getWeight());  
            
                /*
                System.out.println(" ");
                System.out.println("From: "  + graph.edges.get(j).getFrom().getId());
                System.out.println("To: "  + graph.edges.get(j).getTo().getId());
                System.out.println("Weight: "  + graph.edges.get(j).getWeight());
                System.out.println(" ");


                path.add(graph.edges.get(j).getFrom().getId());

                */
                
            }//for 

        }//for

        for (int i = 0; i < graph.edges.size(); i++){

            //System.out.println(" ");
            //System.out.println("From Distance: "  + graph.edges.get(i).getFrom().getDistance());
            //System.out.println("To Distance: "  + graph.edges.get(i).getTo().getDistance());
            //System.out.println("Weight: "  + graph.edges.get(i).getWeight());
            //System.out.println(" ");

            
            if(graph.edges.get(i).getTo().getDistance() > graph.edges.get(i).getFrom().getDistance() + graph.edges.get(i).getWeight() ){
                value = false;
                shortestPath(value, graph, path);
                return value;
            
            }//if
            
        }//for
   
        value = true;

        shortestPath(value, graph, path);

        return value;

    }//BellmanFord

    //This method sets the initial single source
    public static void singlesource(GraphCordoni graph, VertexCordoni source) {

        System.out.println("single source ");

        for (int i = 0; i < graph.vertexes.size(); i++){

            graph.vertexes.get(i).setDistance(Double.POSITIVE_INFINITY);

            graph.vertexes.get(i).setPrevious(null);
        
        }//for

        source.setDistance(0.0);
    
    }//singlesource

    //This method "relaxs" the vertex distance to determine the shortest path
    public static void relax(VertexCordoni vertexEdge1, VertexCordoni vertexEdge2, Integer weight) {

        System.out.println("relax");

        /*

        System.out.println(" ");
        System.out.println("Vertex 1 distance: "  + vertexEdge1.getDistance());
        System.out.println("Vertex 2 distance: "  + vertexEdge2.getDistance());
        System.out.println("Weight: "  + weight);
        System.out.println(" ");

        */

        if(vertexEdge1.getDistance() > vertexEdge2.getDistance() + weight){

            vertexEdge1.setDistance(vertexEdge2.getDistance() + weight);

            vertexEdge1.setPrevious(vertexEdge2);

        }//if

    }//relax

    //This method prints out the shortest path
    public static void shortestPath(boolean value, GraphCordoni graph, ArrayList path) {

        VertexCordoni current = null;

        for(int i = 0; i < graph.vertexes.size(); i++){

            current = graph.vertexes.get(i);

            System.out.println(" ");
            System.out.println("From " + graph.vertexes.get(0).getId() + " to " + graph.vertexes.get(i).getId() +
                                " the cost is " + graph.vertexes.get(i).getDistance());

            System.out.println("The path is ");

            for(int j = 0; j < path.size(); j++){

                //System.out.print(path.get(j) + ", ");

            }//for

        }//for
        

    }//shortestPath

    
    //Spices!

    //This method creates the spice object
    public static void spiceItUp(String[] spices) {

        System.out.println(" spices ");

        String[][] splitspicearray = new String[14][13];
        String[][] splitspicearray1 = new String[14][23];
        String[][] splitspicearray2 = new String[14][23];
        
        
        for (int i = 0; i < spices.length; i++){
            
            System.out.println(spices[i]);
            System.out.println(spices[i]==("--"));
            System.out.println(spices[i].equalsIgnoreCase("spice"));
            System.out.println(spices[i].compareToIgnoreCase("knapsack")==0);

            if (spices[i].compareToIgnoreCase("--")==0){
                System.out.println("hello");
            }//if

            else if (spices[i].compareToIgnoreCase("spice")==0){
                System.out.println("spice");
            }//if

            else if (spices[i].compareToIgnoreCase("knapsack")==0){
                System.out.println("knapsack");
            }//if

            
        }//for


        //createSpice(splitspicearray);
    }//spiceitup

    public static void createSpice(String[][] spices) {

        ArrayList <SpiceCordoni> spicelist = new ArrayList <SpiceCordoni>();

        //increment index to create spice array
        for (int i = 0; i < spices.length; i++){

            if (spices[i][0].compareToIgnoreCase("spice")==0){
                //System.out.println(" new spice ");

                SpiceCordoni spice = new SpiceCordoni();

                spice.setColor(spices[i][3]);

                System.out.println(spices[i][11]);

                spice.setPrice(Double.parseDouble(spices[i][8]));

                spice.setQty(Integer.parseInt(spices[i][12]));
                        
                spicelist.add(spice);
            }// if  
            
        }//for i
         
        
        //print spice to check
        //System.out.println(spicelist);

        spiceUnitPrice(spicelist, spices);

    }//createSpice

    //This method creates each spice's unit price
    public static void spiceUnitPrice(ArrayList<SpiceCordoni> spicelist, String[][] spices) {
 
        //Create unit price for each spice
        for(int i = 0; i < spicelist.size(); i++){

            spicelist.get(i).setUnitPrice(spicelist.get(i).getPrice()/spicelist.get(i).getQty());

        }//for

        sort(spicelist, spices);
    }//spiceUnitPrice

    //This method sorts spices from high to low unit price
    public static void sort(ArrayList<SpiceCordoni> spicelist, String[][] spices)
    {

        Collections.reverse(spicelist);

        //Check unit price for each spice
        for(int i = 0; i < spicelist.size(); i++){

            //System.out.println("Spice " + spicelist.get(i).getColor());
            //System.out.println("Price " + spicelist.get(i).getUnitPrice());

        }//for

        createKnapsack(spicelist, spices);

    }//sort

    //This method creates the knapsacks
    public static void createKnapsack(ArrayList<SpiceCordoni> spicelist, String[][] spices) {
 
        ArrayList <KnapsackCordoni> knapsacklist = new ArrayList <KnapsackCordoni>();
        
        //increment index to create spice array
        for (int i = 0; i < spices.length; i++){

            if (spices[i][0].compareToIgnoreCase("knapsack")==0){
                //System.out.println(" new knapsack ");

                KnapsackCordoni knapsack = new KnapsackCordoni();

                knapsack.setCapacity(Integer.parseInt(spices[i][3]));
                        
                knapsacklist.add(knapsack);
            }// if  
            
        }//for i
         
        //Create unit price for each spice
        for(int i = 0; i < knapsacklist.size(); i++){

            //System.out.println("Capacity " + knapsacklist.get(i).getCapacity());

        }//for

        fillKnapsack(spicelist, knapsacklist);

    }//createKnapsack

    //This method fills the knapsacks
    public static void fillKnapsack( ArrayList<SpiceCordoni> spicelist, ArrayList<KnapsackCordoni> knapsacklist) {
 
        int knapsackcapacity = 0 ;
        
        double worth = 0;
        int scoop = 0;
        String color = "none";


        for(int i = 0; i < knapsacklist.size(); i++){

            capacity = knapsacklist.get(i).getCapacity();

            for(int j = 0; j < spicelist.size(); j++){

                
                worth = spicelist.get(j).getUnitPrice();

                scoop++;

                color = spicelist.get(j).getColor();
    
                System.out.println("Knapsack of capacity " + capacity + " is worth " + worth + " quatloos and contains "
                                    + scoop + " scoop(s) of " + color + ".");


    
    
            }//for

        }//for        

    }//fillKnapsack

}//Assignment4Cordoni
