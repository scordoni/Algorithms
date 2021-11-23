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



public class Assignment5Cordoni {

    //Declare keyboard 
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Declare and initialize variables 
        String line;

        //For binary search tree
        String[] wordarray = new String[666];
       
        String[] instructionarray = new String[375];
        String[] graph1array = new String[20];
        String[] graph2array = new String[38];
        String[] graph3array = new String[127];
        String[] graph4array = new String[138];
        String[] graph5array = new String[48];

        String[] searcharray = new String[42];
        String[][] splitinstructionarray = new String[375][8];
        String[][] graph1splitarray = new String[20][8];
        String[][] graph2splitarray = new String[38][8];
        String[][] graph3splitarray = new String[127][8];
        String[][] graph4splitarray = new String[138][8];
        String[][] graph5splitarray = new String[48][8];
        TreeCordoni tree = new TreeCordoni();
    
        int numberOfLookupComparisons = 0;
        int averagenumberOfLookupComparisons = 0;


        //Reads in the magic items file for the binary search tree
        //create new file object
        File myFile = new File("magicitems.txt");
        
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
                wordarray[i] = input.nextLine();        
                i++;
            }//while

            input.close();  

        }//try
        
        //error for file not found
        catch(FileNotFoundException ex)
        {
          System.out.println("Failed to find file: " + myFile.getAbsolutePath()); 
        }//catch

        //Error in case of a null pointer exception
        catch(NullPointerException ex)
        {
            System.out.println("Null pointer exception.");
            System.out.println(ex.getMessage());
        }//catch

        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch

        //Reads in the graph file to create graphs 
        //create new file object
        File myFile1 = new File("graphs1.txt");
        
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
        
        //error for file not found
        catch(FileNotFoundException ex)
        {
          System.out.println("Failed to find file: " + myFile.getAbsolutePath()); 
        }//catch

        //Error in case of a null pointer exception
        catch(NullPointerException ex)
        {
            System.out.println("Null pointer exception.");
            System.out.println(ex.getMessage());
        }//catch

        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch


        //Reads in the magic items to find in the binary search tree 
        //create new file object
        File myFile2 = new File("magicitems-find-in-bst.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile2);
            line = null;
            
            int i = 0;

             //while there are more lines in the file it inputs them into an instruction array
             while(input.hasNext())
             {  
                //Input into array 
                searcharray[i] = input.nextLine();
                i++;
             }//while

             

            input.close();  

        }//try
        
        //error for file not found
        catch(FileNotFoundException ex)
        {
          System.out.println("Failed to find file: " + myFile.getAbsolutePath()); 
        }//catch

        //Error in case of a null pointer exception
        catch(NullPointerException ex)
        {
            System.out.println("Null pointer exception.");
            System.out.println(ex.getMessage());
        }//catch

        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch

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
            graph2array[i] = instructionarray[i + 22];
        }//for

        //Put instructions into graph 3 array
        for (int i = 0; i < graph3array.length; i++){
            graph3array[i] = instructionarray[i + 61];
        }//for

        //Put instructions into graph 4 array
        for (int i = 0; i < graph4array.length; i++){
            graph4array[i] = instructionarray[i + 189];
        }//for

        //Put instructions into graph 5 array 
        for (int i = 0; i < graph5array.length; i++){
            graph5array[i] = instructionarray[i + 327];
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

        //split up into 2D array for graph 5
        for (int i = 0; i < graph5splitarray.length; i++){
            for( int j = 0; j < graph5splitarray[i].length; j++){
            graph5splitarray[i] = graph5array[i].split(" ");
            }//for j 
        }//for
 
       
        //Graphs!!

        System.out.println("Graph 1");

        //making the matrix
        makeMatrix(graph1splitarray);

        //make the adjacency list
        makeAdjacencyList(graph1splitarray);

        //make linked list
        makeLinkedObjects(graph1splitarray);

        //breadth first traversal
        breadthTraversal(makeLinkedObjects(graph1splitarray));

        //reset process status
        reboot(makeLinkedObjects(graph1splitarray));

        System.out.println(" ");
        System.out.println("Depth Traversal");

        //depth first traversal
        depthTraversal(makeLinkedObjects(graph1splitarray));


        System.out.println(" ");
        System.out.println("Graph 2");

        //making the matrix
        makeMatrix(graph2splitarray);

        //make the adjacency list
        makeAdjacencyList(graph2splitarray);

        //make linked list
        makeLinkedObjects(graph2splitarray);

        //breadth first traversal
        breadthTraversal(makeLinkedObjects(graph2splitarray));

        //reset process status
        reboot(makeLinkedObjects(graph2splitarray));

        System.out.println(" ");
        System.out.println("Depth Traversal");

        //depth first traversal
        depthTraversal(makeLinkedObjects(graph2splitarray));


        System.out.println(" ");
        System.out.println("Graph 3");

        //making the matrix
        makeMatrix(graph3splitarray);

        //make the adjacency list
        makeAdjacencyList(graph3splitarray);

        //make linked list
        makeLinkedObjects(graph3splitarray);

        //breadth first traversal
        breadthTraversal(makeLinkedObjects(graph3splitarray));

        //reset process status
        reboot(makeLinkedObjects(graph3splitarray));

        System.out.println(" ");
        System.out.println("Depth Traversal");

        //depth first traversal
        depthTraversal(makeLinkedObjects(graph3splitarray));


        System.out.println(" ");
        System.out.println("Graph 4");

        //making the matrix
        makeMatrix(graph4splitarray);

        //make the adjacency list
        makeAdjacencyList(graph4splitarray);

        //make linked list
        makeLinkedObjects(graph4splitarray);

        //breadth first traversal
        breadthTraversal(makeLinkedObjects(graph4splitarray));

        //reset process status
        reboot(makeLinkedObjects(graph4splitarray));

        System.out.println(" ");
        System.out.println("Depth Traversal");

        //depth first traversal
        depthTraversal(makeLinkedObjects(graph4splitarray));


        System.out.println(" ");
        System.out.println("Graph 5");

        //making the matrix
        makeMatrix(graph5splitarray);

        //make the adjacency list
        makeAdjacencyList(graph5splitarray);

        //make linked list
        makeLinkedObjects(graph5splitarray);

        //breadth first traversal
        breadthTraversal(makeLinkedObjects(graph5splitarray));

        //reset process status
        reboot(makeLinkedObjects(graph5splitarray));

        System.out.println(" ");
        System.out.println("Depth Traversal");

        //depth first traversal
        depthTraversal(makeLinkedObjects(graph5splitarray));



        //Binary Search Trees!!

        //I know this does not print out the binary search tree correctly but if
        // you uncomment line 854 it looks as though different numbers should be returned 
        //for the comparison.

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Insert the Magic Items into the Tree ");

        
        //insert the word array into the tree
        for (int i = 0; i < wordarray.length; i++){
            insertTree(tree, wordarray[i]);
        }//for

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Search for the Magic Items in the Tree ");

        int comparisons = 0;

        //Search for the 42 magic items
        for (int i = 0; i < searcharray.length; i++){

            System.out.println("Number of Comparisons: " + searchTree(tree.getRoot(), searcharray[i], comparisons));
            numberOfLookupComparisons = numberOfLookupComparisons + searchTree(tree.getRoot(), searcharray[i], comparisons);
            
        }//for

        //get the average lookup comparisons
        averagenumberOfLookupComparisons = numberOfLookupComparisons/searcharray.length;

        System.out.println("Average lookup: " + averagenumberOfLookupComparisons);

    }//main

    //This method creates the matrix of the undirected graph
    public static void makeMatrix(String[][] instructions) {

        //instantiate matrix
        int length = 1;
        int height = 1;

        for (int i = 0; i < instructions.length; i++){

            for(int j = 0; j < instructions[i].length; j ++){

                //skip comment line
                if(instructions[i][j].compareToIgnoreCase("--")==0){
                    System.out.println(" ");
                }//if

                //increment length and heigh to get matrix dimensions
                else if (instructions[i][j].compareToIgnoreCase("vertex")==0){
                    length++;
                    height++;
                    
                }//else if

            }//for j

        }//for i

        //create matrix
        int[][] matrix = new int[length][height];

        //System.out.println("length: " + length);
        //System.out.println("height: " + height);

        //loop through to add value at correct matrix location
        for (int i = 0; i < instructions.length; i++){

            for(int j = 0; j < instructions[i].length; j ++){

                if (instructions[i][j].compareToIgnoreCase("edge")==0){
                
                    //grab index 2 make it length and grab index 4 and make it height
                    //System.out.println("index 2: "+ Integer.valueOf(instructions[i][j + 1]));

                    //grab index 4 make it length and grab index 2 and make it height
                    //System.out.println("index 4: " + Integer.valueOf(instructions[i][j + 3]));
            
                    matrix[Integer.valueOf(instructions[i][j + 1])][Integer.valueOf(instructions[i][j + 3])] = 1;
            
                    matrix[Integer.valueOf(instructions[i][j + 3])][Integer.valueOf(instructions[i][j + 1])] = 1;
                    
                }//if

            }
        }

        //print out the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }//for j

            System.out.println();

        }//for i
    }//make Matrix

    //This method creates the adjacency list of the undirected graph
    public static void makeAdjacencyList(String[][] instructions) {

        System.out.println(" ");

        int height = 1; 

        for (int i = 0; i < instructions.length; i++){

            for(int j = 0; j < instructions[i].length; j ++){

                //skip comment line
                if(instructions[i][j].compareToIgnoreCase("--")==0){
                    System.out.println(" ");
                }//if

                //increment height to create arraylist
                else if (instructions[i][j].compareToIgnoreCase("vertex")==0){
                    height++;
                }//else
            
            }//for j
        }//for i

        //create arraylist
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>(height);

        //add arraylist at each index
        for(int i=0; i < height; i++) {
            adjlist.add(new ArrayList());
        }//for

        //add neighbors to arraylist
        for (int i = 0; i < instructions.length; i++){

            for(int j = 0; j < instructions[i].length; j ++){

                if (instructions[i][j].compareToIgnoreCase("edge")==0){
                    
                    //grab index 2 and add 4 to arraylist
                    //System.out.println(instructions[i][j + 1]);
        
                    adjlist.get(Integer.parseInt(instructions[i][j + 1])).add(Integer.parseInt(instructions[i][j + 3]));
        
                    //grab index 4 and add 2 to arraylist
                    //System.out.println(instructions[i][j + 3]);
        
                    adjlist.get(Integer.parseInt(instructions[i][j + 3])).add(Integer.parseInt(instructions[i][j + 1]));
                    
                }//else
            
            }//for j
        }//for i

        //print out arraylist
        for (int i = 0; i < instructions.length; i++){

            for(int j = 0; j < instructions[i].length; j ++){

                if (instructions[i][j].compareToIgnoreCase("vertex")==0){

                    System.out.println("[" + instructions[i][j + 1] + "]" + adjlist.get(Integer.parseInt(instructions[i][j + 1])));

                }//else
            
            }//for j
        }//for i

    }//make adjacency list

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
                                
                            }//for

                        }//if
        
                    }//for
    
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


    //Searching far and wide!

    //this method preforms the breadth traversal 
    public static void breadthTraversal( VertexCordoni vertex) {

        System.out.println(" ");
        System.out.println("Breadth Traversal");

        QueueVertexCordoni thequeue = new QueueVertexCordoni();

        VertexCordoni currentvertex;
        
        thequeue.enqueue(vertex);

        vertex.setProcessStatus(true);

        while(!(thequeue.isEmpty())){

            currentvertex = thequeue.dequeue();

            System.out.println("Id " + currentvertex.getId());
            
            
            for(int i = 0 ; i < currentvertex.neighbors.size() ; i++){


                if ( currentvertex.neighbors.get(i).getProcessStatus() == false){

                   thequeue.enqueue(currentvertex.neighbors.get(i));
                   currentvertex.neighbors.get(i).setProcessStatus(true);

                }//if
            }//for
            

        }//while

    }//breadth Traversal

    //this method resets the process status for depth traversal 
    public static void reboot( VertexCordoni vertex) {

        System.out.println(" ");
        System.out.println("Reset Processed Status for Depth Traversal");

        QueueVertexCordoni thequeue = new QueueVertexCordoni();

        VertexCordoni currentvertex;
        
        thequeue.enqueue(vertex);

        vertex.setProcessStatus(false);

        while(!(thequeue.isEmpty())){

            currentvertex = thequeue.dequeue();

            
            for(int i = 0 ; i < currentvertex.neighbors.size() ; i++){

                if ( currentvertex.neighbors.get(i).getProcessStatus() == true){

                   thequeue.enqueue(currentvertex.neighbors.get(i));
                   currentvertex.neighbors.get(i).setProcessStatus(false);

                }//if
            }//for
            

        }//while

    }//reboot

    //this method preforms the depth traversal
    public static void depthTraversal(VertexCordoni vertex) {

        if((vertex.getProcessStatus() == false)){

            System.out.println("Id: " + vertex.getId());
            vertex.setProcessStatus(true);

        }//if

        //System.out.println("Size: " + vertex.neighbors.size());

        for(int i = 0; i < vertex.neighbors.size(); i++){

            if(vertex.neighbors.get(i).getProcessStatus() ==  false){
                depthTraversal(vertex.neighbors.get(i));
            }//if

        }//for

    }//depth Traversal


    
    //lets make the trees!

    //This method inserts the nodes into the tres
    public static void insertTree(TreeCordoni tree, String word) {

        TreeCordoni newnode = new TreeCordoni();

        newnode.setData(word);

        TreeCordoni trailing = null;

        //sets current to the tree root
        TreeCordoni current = tree.getRoot();

        //while the root is not null continue down the tree
        while (current != null){

            trailing = current;

            if(newnode.getData().compareToIgnoreCase(current.getData()) < 0){

                current = current.getLeft();
                //System.out.println("L ");


            }//if

            else{

                current = current.getRight();
                //System.out.println("R ");

            }//else

        }//while

        newnode.setParent(trailing);

        //if trailing is null then set the new node to the root
        if(trailing == null){

            tree.setRoot(newnode);
            System.out.println("Root: " + newnode.getData());

        }//if

        //else we set the new node in the tree
        else{

            if(newnode.getData().compareToIgnoreCase(trailing.getData()) < 0){

                trailing.setLeft(newnode);
                System.out.println("L ");

                //to print!
                printTree(tree.getRoot());

            }//if

            else{

                trailing.setRight(newnode);
                System.out.println("R ");
                
                //to print!
                printTree(tree.getRoot());

            }//else
        }//else


    }//insertTree


    //This method prints the tree (kind of)
    public static void printTree(TreeCordoni root) {

        if (root != null){

            root.setRoot(root.getLeft());
            printTree(root.getRoot());

            System.out.println(root.getData() + " ");
            
            root.setRoot(root.getRight());
            printTree(root.getRoot());

        }//id

    }//print tree

    //This method searches the tree for the 42 items
    public static int searchTree(TreeCordoni root, String target, int comparisons) {

        //if the root is null or equal to the target then return
        if((root == null) || (root.getData().compareToIgnoreCase(target)==0)){
            comparisons++;
        }//if

        //else we continue down the tree recursively to find the target
        else{

            if(target.compareToIgnoreCase(root.getData()) < 0){

                comparisons++;
                System.out.println("L");
                searchTree(root.getLeft(), target, comparisons);
                
            }//if

            else{
                comparisons++;
                System.out.println("R");
                searchTree(root.getRight(), target, comparisons);
                
            }//else
        }//else

    //if you uncomment this line it does show different numbers for compare
    //but i am not sure why it is not returning them correctly
    //System.out.println(comparisons);
    return comparisons;

    }//searchTree
    

}//Assignment4Cordoni
