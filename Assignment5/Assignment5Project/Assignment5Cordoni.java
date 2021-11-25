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
        String[][] splitspicearray = new String[14][13];
       
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
        for (int i = 0; i < splitspicearray.length; i++){
            for( int j = 0; j < splitspicearray[i].length; j++){
            splitspicearray[i] = spicearray[i].split(" ");
            }//for j 
        }//for

        //split up into 2D array 
        for (int i = 0; i < splitspicearray.length; i++){
            for( int j = 0; j < splitspicearray[i].length; j++){
            //System.out.println(j + splitspicearray[i][j]);
            }//for j 
        }//for


        // i know this is not exactly how I was supposed to split up the text
        //file, but this was the only way I could get it to work with everything 

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

        spiceItUp(splitspicearray);

        createKnapsack(splitspicearray);


    }//main

    //This method creates the linked objects of the undirected graph
    public static VertexCordoni makeLinkedObjects(String[][] instructions) {
 
        int index = 0;
        VertexCordoni[] vertexlist;
        
        //increment index to create vertex array
        for (int i = 0; i < instructions.length; i++){

            if (instructions[i][0].compareToIgnoreCase("add")==0){

                if(instructions[i][1].compareToIgnoreCase("vertex")==0){

                    //System.out.println("Id: " + instructions[i][2]);
                    //System.out.println("Id get: " + vertex.getId()); 
                    index++;
                }//if

            }//else if  
            
        }//for i

        //create vertex array
        vertexlist = new VertexCordoni[index];

        int j = 0;

        //create neighbor array
        for (int i = 0; i < instructions.length; i++){

            if (instructions[i][0].compareToIgnoreCase("add")==0){

                //create new vertex and set id to add to vertex array
                if(instructions[i][1].compareToIgnoreCase("vertex")==0){

                    VertexCordoni vertex = new VertexCordoni();

                    vertex.setId(instructions[i][2]);
                        
                    vertexlist[j] = vertex;
                    //System.out.println(vertexlist[j]);
                    j++;
                    
                    
                }//if
                
                //add edge to neighbor array
                else if(instructions[i][1].compareToIgnoreCase("edge")==0){
        
                    for(int k = 0; k < vertexlist.length; k++){
                       // System.out.println(vertexlist[k].getId());

                        //if the vertex is in the vertex array then add new edge
                        if(vertexlist[k].getId().compareToIgnoreCase(instructions[i][2])==0){
                            //System.out.println("hello1");

                            for(int l = 0; l < vertexlist.length; l++){
                                //System.out.println("hello2");

                                //if the 2nd vertex is in the vertex array then add the first vertex to their neighbor array
                                if (vertexlist[l].getId().compareToIgnoreCase(instructions[i][4])==0){

                                    vertexlist[k].neighbors.add(vertexlist[l]);
                                    //System.out.println("k" + vertexlist[k].getId());

                                    vertexlist[l].neighbors.add(vertexlist[k]);
                                    //System.out.println("l" +vertexlist[l].getId());

                                }//if                              
                            }//for l
                        }//if
                    }//for k
                }//else if
            }//if
        }//for i

        //print neighbor array size to check
        for(int i = 0; i < vertexlist.length; i++){
            //System.out.println("size " + vertexlist[i].neighbors.size());
        }

        //return
        return vertexlist[0];

    }//make linked objects 


    //This method 
    public static void bellmanFord(VertexCordoni[] graph, Integer weightfunction, VertexCordoni source) {
 
        singlesource(graph, source);




    }//BellmanFord

    //This method 
    public static void singlesource(VertexCordoni[] graph, VertexCordoni source) {
 

    

    }//singlesource

    //This method 
    public static void relax(VertexCordoni[] graph, VertexCordoni source) {
 

        

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

        spiceUnitPrice(spicelist);

    }//spiceitup

    //This method creates each spice's unit price
    public static void spiceUnitPrice(ArrayList<SpiceCordoni> spicelist) {
 
        //Create unit price for each spice
        for(int i = 0; i < spicelist.size(); i++){

            spicelist.get(i).setUnitPrice(spicelist.get(i).getPrice()/spicelist.get(i).getQty());

        }//for

        sort(spicelist);
    }//spiceUnitPrice

    //This method sorts spices from high to low unit price
    public static void sort(ArrayList<SpiceCordoni> spicelist)
    {

        Collections.reverse(spicelist);

       //Create unit price for each spice
       for(int i = 0; i < spicelist.size(); i++){

            System.out.println("Spice " + spicelist.get(i).getColor());
            System.out.println("Price " + spicelist.get(i).getUnitPrice());

       }//for

    }//sort

    //This method creates the knapsacks
    public static void createKnapsack(String[][] spices) {
 
        ArrayList <KnapsackCordoni> knapsacklist = new ArrayList <KnapsackCordoni>();
        
        //increment index to create spice array
        for (int i = 0; i < spices.length; i++){

            if (spices[i][0].compareToIgnoreCase("knapsack")==0){
                System.out.println(" new knapsack ");

                KnapsackCordoni knapsack = new KnapsackCordoni();

                

                knapsack.setCapacity(Integer.parseInt(spices[i][3]));
                        
                knapsacklist.add(knapsack);
            }// if  
            
        }//for i
         
        //Create unit price for each spice
        for(int i = 0; i < knapsacklist.size(); i++){

        System.out.println("Capacity " + knapsacklist.get(i).getCapacity());

        }//for

        fillKnapsack(knapsacklist);

    }//createKnapsack

    //This method fills the knapsacks
    public static void fillKnapsack(ArrayList<KnapsackCordoni> knapsacklist) {
 
        System.out.println("Knapsack of capacity");




    }//fillKnapsack

}//Assignment4Cordoni
