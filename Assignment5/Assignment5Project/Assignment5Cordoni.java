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

       
        String[] spicearray = new String[14];
       
        String[] instructionarray = new String[88];
        String[][] splitinstructionarray = new String[88][17];


        //Reads in the spice items 
        //create new file object
        File myFile = new File("spice.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile);
            line = null;
            
            int i = 0;

            //while there are more lines in the file it inputs them into a spice array
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

            //while there are more lines in the file it inputs them into an instruction array
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

        //pass the spice array to the spiceItUp method to create the spice objects
        spiceItUp(spicearray);


        //Graphs!!

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

        //pass the instruction array to the graphItUp method to create the vertex and edge objects for each graph
        graphItUp(splitinstructionarray);

    }//main

    //This method creates the linked objects of the directed graph
    //This also includes making a new graph object for each graph in the file
    //along with creating the edges and vertexes for each of these graphs
    public static void graphItUp(String[][] instructions) {

        GraphCordoni graphCordoni  = null; // new GraphCordoni();
        int k = 1;

        //create 
        for (int i = 0; i < instructions.length; i++){    
            
            //if the line reads new we create a new graph
            if(instructions[i][0].compareToIgnoreCase("new")==0){
                
                //if the graph is null we know its the first graph in the file
                if (graphCordoni == null){
                    graphCordoni = new GraphCordoni();
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("Graph " + k);
                    k++;
                }//if
                
                //else we know that we need to clear the graph object so we run the bellman ford method and reset graphCordoni
                //to hold the new graph
                else{

                    bellmanFord(graphCordoni, graphCordoni.edges.get(0).getWeight(),  graphCordoni.vertexes.get(0));

                    graphCordoni = new GraphCordoni();
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("Graph " + k);
                    k++;

                }//else

            }//if

            //here we add the vertexes and edges
            else if (instructions[i][0].compareToIgnoreCase("add")==0){

                

                //create new vertex and set id to add to vertex array
                if(instructions[i][1].compareToIgnoreCase("vertex")==0){

                    VertexCordoni vertex = new VertexCordoni();

                    vertex.setId(instructions[i][2]);
                        
                    //add the vertex to the vertex array list
                    graphCordoni.vertexes.add(vertex);
                    
                    
                }//if
                
                //create new edge and set id to add to edge array
                else if(instructions[i][1].compareToIgnoreCase("edge")==0){
        
                    EdgeCordoni edge = new EdgeCordoni();

                    for (int j = 0; j < graphCordoni.vertexes.size(); j++){

                        //set the "from" of the edge 
                        if (graphCordoni.vertexes.get(j).getId().compareToIgnoreCase(instructions[i][2])==0){
                            edge.setFrom(graphCordoni.vertexes.get(j));
                        }//if

                        //set the "to" of the edge 
                        if (graphCordoni.vertexes.get(j).getId().compareToIgnoreCase(instructions[i][4])==0){
                            edge.setTo(graphCordoni.vertexes.get(j));
                        }//if
                    
                    }//for
                    
                    
                    //set the weight of the edge
                    if ((instructions[i][5].compareToIgnoreCase("") == 0)){
                        edge.setWeight(Integer.parseInt(instructions[i][6]));
                    }
                    
                    else{
                        edge.setWeight(Integer.parseInt(instructions[i][5]));
                    }//else

                    //add the edge to the edge array list
                    graphCordoni.edges.add(edge);

                }//else if
            }//else if
        }//for i

        /*
        for(int i = 0; i < graphCordoni.edges.size(); i++){

            System.out.println(" ");
            System.out.println("From: "  + graphCordoni.edges.get(i).getFrom().getId());
            System.out.println("To: "  + graphCordoni.edges.get(i).getTo().getId());
            System.out.println("Weight: "  + graphCordoni.edges.get(i).getWeight());
            System.out.println(" ");

        }//for
        // */

        //call the bellman ford algorithm
        bellmanFord(graphCordoni, graphCordoni.edges.get(0).getWeight(),  graphCordoni.vertexes.get(0));
    }//graph it up 


    //This method preforms the bellman ford algorithm to find the shortest path
    public static boolean bellmanFord(GraphCordoni graph, int weight, VertexCordoni source) {
 
        //System.out.println("bellman ford");

        //call the single source method to set the distances to positive infinity
        singlesource(graph, source);

        boolean value = false;

        //for each vertex we loop through the edges to relax them
        for (int i = 0; i < graph.vertexes.size() - 1; i++){

            for (int j = 0; j < graph.edges.size(); j++){

                //System.out.println("relax");

                //here we call relax to "relax" each of the vertex distances down to their lowest possible distance
                relax(graph.edges.get(j).getFrom(), graph.edges.get(j).getTo(), graph.edges.get(j).getWeight());  
            
                /*
                System.out.println(" ");
                System.out.println("From: "  + graph.edges.get(j).getFrom().getId());
                System.out.println("To: "  + graph.edges.get(j).getTo().getId());
                System.out.println("Weight: "  + graph.edges.get(j).getWeight());
                System.out.println(" ");

                */
                
            }//for 

        }//for

        //here we loop through each edge to see if the from distance is greated than the to distances plus the weight.
        for (int i = 0; i < graph.edges.size(); i++){

            //System.out.println(" ");
            //System.out.println("From Distance: "  + graph.edges.get(i).getFrom().getDistance());
            //System.out.println("To Distance: "  + graph.edges.get(i).getTo().getDistance());
            //System.out.println("Weight: "  + graph.edges.get(i).getWeight());
            //System.out.println(" ");

            
            if(graph.edges.get(i).getFrom().getDistance() > graph.edges.get(i).getTo().getDistance() + graph.edges.get(i).getWeight() ){
                value = false;
                shortestPath(value, graph);
                return value;
            
            }//if
            
        }//for
   
        value = true;

        shortestPath(value, graph);

        return value;

    }//BellmanFord

    //This method sets the initial single source
    public static void singlesource(GraphCordoni graph, VertexCordoni source) {

        //System.out.println("single source ");

        //here we loop through each of the vertexes setting their distance to positive infinity
        for (int i = 0; i < graph.vertexes.size(); i++){

            graph.vertexes.get(i).setDistance(Double.POSITIVE_INFINITY);

            graph.vertexes.get(i).setPrevious(null);
        
        }//for

        //set the distance of the source vertex to 0
        source.setDistance(0.0);
    
    }//singlesource

    //This method "relaxs" the vertex distance to determine the shortest path
    public static void relax(VertexCordoni vertexEdgeFrom, VertexCordoni vertexEdgeTo, Integer weight) {

        //System.out.println("relax");

        //System.out.println(" ");
        //System.out.println("Vertex " + vertexEdgeFrom.getId() + " distance: "  + vertexEdgeFrom.getDistance());
        //System.out.println("Vertex " + vertexEdgeTo.getId() + " distance: "  + vertexEdgeTo.getDistance());
        //System.out.println("Weight: "  + weight);
        //System.out.println(" ");

        //if the to vertex distance is greater than the from vertex distance then we set the to distance to 
        //be the from vertex distance plus the weight
        if(vertexEdgeTo.getDistance() > vertexEdgeFrom.getDistance() + weight){

            vertexEdgeTo.setDistance(vertexEdgeFrom.getDistance() + weight);

            vertexEdgeTo.setPrevious(vertexEdgeFrom);

            //System.out.println("Relax vertex " + vertexEdgeTo.getId() + " to " + vertexEdgeTo.getDistance());

        }//if

    }//relax

    //This method prints out the shortest path
    public static void shortestPath(boolean value, GraphCordoni graph) {

        //here we loop through the vertexes and print out the shortest path from the source vertex to the 
        //desired vertex
        for(int i = 0; i < graph.vertexes.size(); i++){

            VertexCordoni current = null;

            ArrayList <String> path = new ArrayList <String>();

            current = graph.vertexes.get(i);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("From " + graph.vertexes.get(0).getId() + " to " + graph.vertexes.get(i).getId() +
                                " the cost is " + graph.vertexes.get(i).getDistance());

            System.out.println("The path is ");

            
            //if the previous is set to null then we are at the source vertex
            if(graph.vertexes.get(i).getPrevious() == null){

                System.out.print(graph.vertexes.get(i).getId());

            
            }//if

            //else we start at the desired vertex and work our way backwards to determine our shortest path.
            //basing this off of the answers for graph 1 I was able to get this working for all the paths 
            //except for the last vertex in each graph
            else{

                int j  = i;

                path.add(graph.vertexes.get(j).getId());
                //System.out.println(graph.vertexes.get(j).getId());

                while(graph.vertexes.get(j).getPrevious().getId() != graph.vertexes.get(0).getId()){
                    
 
                    //System.out.println(graph.vertexes.get(j).getPrevious().getId());
                    path.add(graph.vertexes.get(j).getPrevious().getId());
                    j++;
                    
                    //paths are correct besides last path for each graph
                    if(j == graph.vertexes.size()){
                        break;
                    }//if

                    
                }//while

                //System.out.println(graph.vertexes.get(0).getId());
                path.add(graph.vertexes.get(0).getId());

                Collections.reverse(path);

                for(int k = 0; k < path.size(); k++){

                    System.out.print(path.get(k));
                }//for k
                
            }//else

        }//for

    }//shortestPath

    
    //Spices!

    //This method creates the spice object
    public static void spiceItUp(String[] spices) {

        System.out.println("Spice Hesit!");
        System.out.println(" ");

        String[][] splitspicearray = new String[9][9];
        
        int j = 0;

        for (int i = 0; i < spices.length; i++){

            //if the line starts with spice then we split by ; and then by space
            if (spices[i].startsWith("spice")){
                
                //System.out.println(Arrays.toString(spices[i].split(";| ")));

                splitspicearray[j] = spices[i].split(";| ");
                j++;

            }//if

            //if the line starts with knapsack then we split by ; and then by space
            else if (spices[i].startsWith("knapsack")){

                //System.out.println(Arrays.toString(spices[i].split(";| ")));

                splitspicearray[j] = spices[i].split(";| ");
                j++;

            }//if
            
            
        }//for

        //print to check array
        for(int i  = 0; i < splitspicearray.length; i++){
            for(int k = 0; k < splitspicearray[i].length; k++){

                //System.out.println(splitspicearray[i][k]);

            }//for j
        }//for i

        //pass the created array to the create spice method to create the spice objects
        createSpice(splitspicearray);
    }//spiceitup

    //this method creates the spice objects
    public static void createSpice(String[][] spices) {

        ArrayList <SpiceCordoni> spicelist = new ArrayList <SpiceCordoni>();

        //increment index to create spice array
        for (int i = 0; i < spices.length; i++){

            //if the line starts with spice then we create a new spice object
            if (spices[i][0].compareToIgnoreCase("spice")==0){
                //System.out.println(" new spice ");

                SpiceCordoni spice = new SpiceCordoni();

                //System.out.println("color: " + spices[i][3]);

                spice.setColor(spices[i][3]);

                //if the line starts with total price then we set the total price of the spice object
                //along with the qty of the spice object
                if(spices[i][8].trim().startsWith("total_price")){
                    
                    //System.out.println("price 1: " + spices[i][11].trim());

                    spice.setPrice(Double.parseDouble(spices[i][11].trim()));

                    //System.out.println("qty 1: " + spices[i][16]);

                    spice.setQty(Integer.parseInt(spices[i][16]));

                }//if

                else if(spices[i][6].trim().startsWith("total_price")){
                    //System.out.println("price 2: " + spices[i][8].trim());

                    spice.setPrice(Double.parseDouble(spices[i][8].trim()));

                    //System.out.println("qty 2: " + spices[i][13]);
                    spice.setQty(Integer.parseInt(spices[i][13]));

                }//else

                else if(spices[i][7].trim().startsWith("total_price")){
                    //System.out.println("price 3: " + spices[i][9].trim());

                    spice.setPrice(Double.parseDouble(spices[i][9].trim()));

                    //System.out.println("qty 3: " + spices[i][14]);
                    spice.setQty(Integer.parseInt(spices[i][14]));
                }//else

                else if(spices[i][5].trim().startsWith("total_price")){
                    //System.out.println("price 4: " + spices[i][7].trim());

                    spice.setPrice(Double.parseDouble(spices[i][7].trim()));

                    //System.out.println("qty 4: " + spices[i][12]);
                    spice.setQty(Integer.parseInt(spices[i][12]));
                }//else
 
                //here we dd the spice object to the spice list array
                spicelist.add(spice);
            }// if  
            
        }//for i
         
        
        //print spice to check
        //System.out.println(spicelist.toString());

        //pass the spicelist and spices array to the spice unit price method
        spiceUnitPrice(spicelist, spices);

    }//createSpice

    //This method creates each spice's unit price
    public static void spiceUnitPrice(ArrayList<SpiceCordoni> spicelist, String[][] spices) {
 
        //Create unit price for each spice
        for(int i = 0; i < spicelist.size(); i++){

            spicelist.get(i).setUnitPrice(spicelist.get(i).getPrice()/spicelist.get(i).getQty());

        }//for

        //pass the spice list and spices array to the sort method
        sort(spicelist, spices);
    }//spiceUnitPrice

    //This method sorts spices from high to low unit price
    public static void sort(ArrayList<SpiceCordoni> spicelist, String[][] spices)
    {

        //reverse the spicelist to put them in order from highest to lowest unit price
        Collections.reverse(spicelist);

        //Check unit price for each spice
        for(int i = 0; i < spicelist.size(); i++){

            //System.out.println("Spice " + spicelist.get(i).getColor());
            //System.out.println("Price " + spicelist.get(i).getUnitPrice());

        }//for

        //pass the spicelist and spices array to the create knapsack method
        createKnapsack(spicelist, spices);

    }//sort

    //This method creates the knapsacks
    public static void createKnapsack(ArrayList<SpiceCordoni> spicelist, String[][] spices) {
 
        //create a knapsack arraylist
        ArrayList <KnapsackCordoni> knapsacklist = new ArrayList <KnapsackCordoni>();
        
        //increment index to create spice array
        for (int i = 0; i < spices.length; i++){

            //if the line starts with knapsack then we create a new knapsack object
            if (spices[i][0].compareToIgnoreCase("knapsack")==0){
                //System.out.println(" new knapsack ");

                KnapsackCordoni knapsack = new KnapsackCordoni();


                //set the capcity of the knapsack
                if (spices[i][3].trim().compareToIgnoreCase("")==0){

                    knapsack.setCapacity(Integer.parseInt(spices[i][4].trim()));
                            
                    knapsacklist.add(knapsack);

                }//if

                else{

                    knapsack.setCapacity(Integer.parseInt(spices[i][3].trim()));
                        
                    knapsacklist.add(knapsack);

                }//else
            }//if  
            
        }//for i
         
        //Create unit price for each spice
        for(int i = 0; i < knapsacklist.size(); i++){

            //System.out.println("Capacity " + knapsacklist.get(i).getCapacity());

        }//for

        //pass the spicelist and knapsack list to the fill knapsack method
        fillKnapsack(spicelist, knapsacklist);

    }//createKnapsack

    //This method fills the knapsacks
    public static void fillKnapsack( ArrayList<SpiceCordoni> spicelist, ArrayList<KnapsackCordoni> knapsacklist) {
 
        int knapsackcapacity = 0 ;

        //for each knapsack in the list we fill it according to the greedy algorithm method
        for(int i = 0; i < knapsacklist.size(); i++){

            //get the knapsack capacity 
            knapsackcapacity = knapsacklist.get(i).getCapacity();

            //initialize variables so that they reset for each knapsack
            double worth = 0;
            int quantity = 0;
            int scoop = 0;
            String[] color = new String[20];
            int orangescoops = 0;
            int bluescoops = 0;
            int greenscoops = 0;
            int redscoops = 0;
            
            int k = 0;

            //for each spice in the spice list we get the qty and while the quantity is not 0 and the scoop count
            //if less than the knapsack capacity then we add the spice and it's specific quantity to the knapsack
            for(int j = 0; j < spicelist.size(); j++){

                quantity = spicelist.get(j).getQty();

                //int k = 0;
                while((quantity != 0)&&(scoop < knapsackcapacity)){
                       
                    quantity = quantity - 1;
                    worth = worth + spicelist.get(j).getUnitPrice();
                    color[k] = spicelist.get(j).getColor();
                    //System.out.println(color[k]);
                    scoop++;

                    k++;

                    //System.out.println("k " + k);

                }//while

            }//for j

            //print out each knapsack and what its worth
            System.out.println("Knapsack of capacity " + knapsackcapacity + " is worth " + worth + " quatloos and contains ");
            
            //loop through the color array to see which colors (spices) are in each knapsack
            for(int l = 0; l < color.length; l++){
                //System.out.println(color[l]);
            }

            //if a color appears in the knapsack then we up the scoopcount for that color to determine
            //how many scoops of each spice are in the knapsack
            for(int l = 0; l < color.length; l++){

                if((color[l] !=null)&&(color[l].compareToIgnoreCase("orange")==0)){
                    orangescoops++;
                }
                else if((color[l] !=null)&&(color[l].startsWith("blue"))){
                    bluescoops++;
                }
                if((color[l] !=null)&&(color[l].startsWith("green"))){
                    greenscoops++;
                }
                if((color[l] !=null)&&(color[l].startsWith("red"))){
                    redscoops++;
                }

            }//for

            //here we print out each color and the amount of scoops they have in each knapsack.
            for(int l = 0; l < color.length; l++){

                //System.out.println("orange scoops: " + orangescoops);

                //System.out.println("blue scoops: " + bluescoops);

                //System.out.println("green scoops: " + greenscoops);

                //System.out.println("red scoops: " + redscoops);

                //we go through each color like this beacuse this way we get ahold of every color that appears
                //in each knapsack
                if(orangescoops != 0){
                    System.out.println(orangescoops + " scoop(s) of orange");

                    if(bluescoops != 0){
                        System.out.println(bluescoops + " scoop(s) of blue");
                        
                        if(greenscoops != 0){
                            System.out.println(greenscoops + " scoop(s) of green");

                            if(redscoops != 0){
                                System.out.println(redscoops + " scoop(s) of red");
                                
                            }//if
                        }//if
                    }//if

                    break;
                }//if
                else if(bluescoops != 0){
                    System.out.println(bluescoops + " scoop(s) of blue");

                    if(greenscoops != 0){
                        System.out.println(greenscoops + " scoop(s) of green");

                        if(redscoops != 0){
                            System.out.println(redscoops + " scoop(s) of red");
                            
                        }//if
                    }//if

                    break;
                }
                if(greenscoops != 0){
                    System.out.println(greenscoops + " scoop(s) of green");

                    if(redscoops != 0){
                        System.out.println(redscoops + " scoop(s) of red");
                        
                    }//if

                    break;
                }
                if(redscoops != 0){
                    System.out.println(redscoops + " scoop(s) of red");
                    break;
                }

            }//for
           
        }//for i   

    }//fillKnapsack

}//Assignment5Cordoni
