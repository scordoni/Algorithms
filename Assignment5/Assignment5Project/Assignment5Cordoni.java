/*
 * 
 * Assignment 4
 * Due Date and Time: 11/19/21 before 12:00am 
 * Purpose: to implement graph and tree data structures, and to understand the performance of their traversals.
 * Input: The user will be inputting a file containing a list of edges and vertices. 
 * Output: The program will output graph and tree data structures. 
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
                //Input into array 
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
            }
  

            input.close();  

        }//try
        
        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch


        //Print to check array 
        for (int i = 0; i < spicearray.length; i++){
            //System.out.println(spicearray[i]);
        }//for

        //split up into 2D array 
        for (int i = 0; i < splitspicearray1.length; i++){
            for( int j = 0; j < splitspicearray1[i].length; j++){
            splitspicearray1[i] = spicearray[i].split(";");
            }//for j 
        }//for

        //split up into 2D array 
        for (int i = 0; i < splitspicearray1.length; i++){
            for( int j = 0; j < splitspicearray1[i].length; j++){
            System.out.println(splitspicearray1[i][j]);
            }//for j 
        }//for

        //split up into 2D array 
        for (int i = 0; i < splitspicearray1.length; i++){
            for( int j = 0; j < splitspicearray1[i].length; j++){
            splitspicearray2[i] = splitspicearray1[i][j].split(" ");
            }//for j 
        }//for

        //split up into 2D array 
        for (int i = 0; i < splitspicearray2.length; i++){
            for( int j = 0; j < splitspicearray2[i].length; j++){
            System.out.println(splitspicearray2[i][j]);
            }//for j 
        }//for


         

        //Print to check array 
        for (int i = 0; i < instructionarray.length; i++){
           // System.out.println(instructionarray[i]);
        }//for

        //Put instructions into graph 1 array
        for (int i = 0; i < graph1array.length; i++){
            graph1array[i] = instructionarray[i];
        }//for

        //Put instructions into graph 2 array
        for (int i = 0; i < graph2array.length; i++){
            graph2array[i] = instructionarray[i + 23];
        }//for

        //Put instructions into graph 3 array
        for (int i = 0; i < graph3array.length; i++){
            graph3array[i] = instructionarray[i + 45];
        }//for

        //Put instructions into graph 4 array
        for (int i = 0; i < graph4array.length; i++){
            graph4array[i] = instructionarray[i + 67];
        }//for
        
        //split up into 2D array 
        for (int i = 0; i < splitinstructionarray.length; i++){
            for( int j = 0; j < splitinstructionarray[i].length; j++){
            splitinstructionarray[i] = instructionarray[i].split(" ");
            }//for j 
        }//for

        //split up into 2D array for graph 1
        for (int i = 0; i < graph1splitarray.length; i++){
            for( int j = 0; j < graph1splitarray[i].length; j++){
            graph1splitarray[i] = graph1array[i].split(" ");
            }//for j 
        }//for

        //split up into 2D array for graph 2
        for (int i = 0; i < graph2splitarray.length; i++){
            for( int j = 0; j < graph2splitarray[i].length; j++){
            graph2splitarray[i] = graph2array[i].split(" ");
            }//for j 
        }//for

        //split up into 2D array for graph 3
        for (int i = 0; i < graph3splitarray.length; i++){
            for( int j = 0; j < graph3splitarray[i].length; j++){
            graph3splitarray[i] = graph3array[i].split(" ");
            }//for j 
        }//for

        //split up into 2D array for graph 4
        for (int i = 0; i < graph4splitarray.length; i++){
            for( int j = 0; j < graph4splitarray[i].length; j++){
            graph4splitarray[i] = graph4array[i].split(" ");
            }//for j 
        }//for

       
        //Graphs!!

        System.out.println("Graph 1");

        //make linked list
        makeLinkedObjects(graph1splitarray);



        System.out.println(" ");
        System.out.println("Graph 2");

        //make linked list
        makeLinkedObjects(graph2splitarray);



        System.out.println(" ");
        System.out.println("Graph 3");

        //make linked list
        makeLinkedObjects(graph3splitarray);



        System.out.println(" ");
        System.out.println("Graph 4");

        //make linked list
        makeLinkedObjects(graph4splitarray);



        //Spices!

        //spiceItUp(splitspicearray);

    }//main

    //This method creates the linked objects of the undirected graph
    public static void makeLinkedObjects(String[][] instructions) {

        GraphCordoni graphCordoni = new GraphCordoni();

        //create 
        for (int i = 0; i < instructions.length; i++){

            if (instructions[i][0].compareToIgnoreCase("add")==0){

                //create new vertex and set id to add to vertex array
                if(instructions[i][1].compareToIgnoreCase("vertex")==0){

                    VertexCordoni vertex = new VertexCordoni();

                    vertex.setId(instructions[i][2]);
                        
                    graphCordoni.vertexes.add(vertex);
                    
                    
                }//if
                
                //add edge 
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

            
        System.out.println("Vertex " + graphCordoni.vertexes.size());
        System.out.println("Edge " + graphCordoni.edges.size());


        bellmanFord(graphCordoni, graphCordoni.vertexes.get(0));
    }//make linked objects 


    //return weight 
    public static void bellmanFord(GraphCordoni graph, VertexCordoni source) {
 
        singlesource(graph, source);

        for (int i = 1; i < graph.vertexes.size() - 1; i++){

            //graph.vertexes.setDistance(Double.POSITIVE_INFINITY);

            for (int j = 0; j < graph.edges.size(); j++){

                relax(graph.edges.get(j).getTo(), graph.edges.get(j).getFrom());  
            
            }//for
        
        }//for


        for (int i = 1; i < graph.vertexes.size() - 1; i++){

            
        
        }//for


    }//BellmanFord

    //This method 
    public static void singlesource(GraphCordoni graph, VertexCordoni source) {
 
        for (int i = 0; i < graph.vertexes.size(); i++){

            //graph.vertexes.setDistance(Double.POSITIVE_INFINITY);

            //graph.pi?   
        
        }//for

        source.setDistance(0.0);
    
    }//singlesource

    //This method 
    public static void relax(VertexCordoni vertexEdge1, VertexCordoni vertexEdge2) {
 

        

    }//relax

    //Spices!

    //This method creates the spice object
    public static void spiceItUp(String[][] spices) {
 
        ArrayList <SpiceCordoni> spicelist = new ArrayList <SpiceCordoni>();
        
        //increment index to create spice array
        for (int i = 0; i < spices.length; i++){

            if (spices[i][0].compareToIgnoreCase("spice")==0){
                //System.out.println(" new spice ");

                SpiceCordoni spice = new SpiceCordoni();

                spice.setColor(spices[i][3]);

                System.out.println(spices[i][9]);

                spice.setPrice(Double.parseDouble(spices[i][7]));

                spice.setQty(Integer.parseInt(spices[i][12]));
                        
                spicelist.add(spice);
            }// if  
            
        }//for i
         
        
        //print spice to check
        //System.out.println(spicelist);

        spiceUnitPrice(spicelist, spices);
    }//spiceitup

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
 
        int capacity = 0 ;
        double worth = 0;
        int scoop = 0;
        String color = "none";


        for(int i = 0; i < knapsacklist.size(); i++){

            capacity = knapsacklist.get(i).getCapacity();

            for(int j = 0; j < spicelist.size(); j++){

                //take spice and add it to knapsack
    
                spicelist.get(j).getColor();

                spicelist.get(j).getPrice();

                spicelist.get(j).getQty();

                spicelist.get(j).getUnitPrice();


    
    
            }//for

        }//for


       



        //keep adding biggest one until we cant anymore


        

    }//fillKnapsack

}//Assignment4Cordoni
