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



public class Assignment4Cordoni {

    //Declare keyboard 
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Declare and initialize variables 
        String line;

        //For binary search tree
        String[] wordarray = new String[666];
        NodeCordoni[] nodeWordArray = new NodeCordoni[666];
        String[] instructionarray = new String[375];
        String[] searcharray = new String[42];
        String[] splitinstructionarray = new String[375];
        NodeCordoni NodeCordoni = new NodeCordoni();
        NodeCordoni root = new NodeCordoni();
        VertexCordoni VertexCordoni = new VertexCordoni();
        VertexCordoni rootVertex = new VertexCordoni();
        int numberOfLookupComparisons = 0;

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


        /*
        //Print to check array 
        for (int i = 0; i < wordarray.length; i++){
            System.out.println(wordarray[i]);
        }//for
        */

        /*
        //Print to check array 
        for (int i = 0; i < wordarray.length; i++){
            System.out.println(searcharray[i]);
        }//for
        */


    
        //Print to check array 
        for (int i = 0; i < instructionarray.length; i++){

            System.out.println(instructionarray[i]);

        }//for


        //Print to check array 
        for (int i = 0; i < splitinstructionarray.length; i++){

            splitinstructionarray[i] = Arrays.toString(instructionarray[i].split(" "));
                
        }//for

        
       for (int i = 0; i < splitinstructionarray.length; i++){
    
            System.out.println(splitinstructionarray[i]);

        }//for


        //Graphs!!

        //making the matrix
        //makeMatrix(splitinstructionarray);

        //make the adjacency list
        //makeAdjacencyList(splitinstructionarray);

        //make linked list
        //makeLinkedObjects(splitinstructionarray);

        //breadth first traversal
        //breadthTraversal(rootVertex);

        //depth first traversal
        //depthTraversal(rootVertex);



        //Binary Search Trees!!

        //insert the word array into the tree
        for (int i = 0; i < wordarray.length; i++){
            insertTree(root, wordArray[i]);
        }//for


        //Search for the 42 magic items
        for (int i = 0; i < searcharray.length; i++){
            numberOfLookupComparisons = numberOfLookupComparisons + searchTree(rootnode, searcharray[i]);
        }//for

    }//main

    //lets make the graphs

    //This method creates the matrix of the undirected graph
    public static void makeMatrix(String[] instructions) {

        //instantiate matrix
        int length = 0;
        int height = 0;
        int[][] matrix = new int[length][height];

        for (int i = 0; i < instructions.length; i++){

            
            //if(((Arrays.toString(instructionarray[i].split(" ")))) == "--"){
                System.out.println("new graph here!");
            //}//if

           // else if (((Arrays.toString(instructionarray[i].split(" ")))) == "vertex"){
                length++;
                height++;
            //}//else

            //else if (((Arrays.toString(instructionarray[i].split(" ")))) == "edge"){
            
                //grab index 3 make it length and grab index 5 and make it height

                //put one

                //grab index 5 make it length and grab index 3 and make it height

                //put one
                
            //}//else
            

        }//for

        
        for (int i = 0; i < instructions.length; i++) {
            for (int j = 0; j < instructions[i].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }//for j

            System.out.println();

        }//for i

    }//make Matrix

    //This method creates the adjacency list of the undirected graph
    public static void makeAdjacencyList(String[] instructions) {

        int size = 0;


        for (int i = 0; i < instructions.length; i++){

            if(((Arrays.toString(instructionarray[i].split(" ")))) == "--"){
                System.out.println("new graph here!");
            }//if

            else if (((Arrays.toString(instructionarray[i].split(" ")))) == "vertex"){
                size++;
                
            }//else

            else if (((Arrays.toString(instructionarray[i].split(" ")))) == "edge"){
            
                //grab index 3 make it length and grab index 5 and make it height

                //put one

                //grab index 5 make it length and grab index 3 and make it height

                //put one
                
            }//else
            

        }//for i

       

        
    }//make adjacency list

    //This method creates the linked objects of the undirected graph
    public static void makeLinkedObjects(String[] instructions) {

        int size = 0;


        for (int i = 0; i < instructions.length; i++){

            if(((Arrays.toString(instructionarray[i].split(" ")))) == "--"){
                System.out.println("new graph here!");
            }//if

            else if (((Arrays.toString(instructionarray[i].split(" ")))) == "vertex"){
                size++;
                
            }//else

            else if (((Arrays.toString(instructionarray[i].split(" ")))) == "edge"){
            
                //grab index 3 make it length and grab index 5 and make it height

                //put one

                //grab index 5 make it length and grab index 3 and make it height

                //put one
                
            }//else
            

        }//for i


        
    }//make linked objects


    //Searching far and wide!
    public static void breadthTraversal( VertexCordoni vertex) {

        QueueCordoni thequeue = new QueueCordoni();
        VertexCordoni theVertex = new VertexCordoni();

        VertexCordoni currentvertex;
         
        thequeue.enqueue(vertex.getId());

        vertex.setProcessStatus(true);

        while(!(thequeue.isEmpty())){

            currentvertex = thequeue.dequeue();

            System.out.println(currentvertex.getId());

            //for(int i = 0 ; i < currentvertex.neighbors ; i++){

            //    if ( i.getProcessStatus() == false){

            //        thequeue.enqueue(i);
            //       i.setProcessStatus(true);

            //    }//if
            //}//for
        }//while
    }//breadth Traversal

    //Searching far and wide!
    public void depthTraversal(VertexCordoni vertex) {

        VertexCordoni VertexCordoni = new VertexCordoni();

        if(!(vertex.getProcessStatus())){

            System.out.println(vertex.getId());
            vertex.setProcessStatus(true);

        }//if

        for(int neighbor = 0; neighbor < vertex.getNeighbors().length; neighbor++){

            if(!(vertex.getProcessStatus())){
                breadthTraversal(neighbor);
            }//if

        }//for

    }//depth Traversal


    //lets make the trees!

    //This method inserts the nodes into the tress
    public void insertTree(String[] tree, NodeCordoni newnode) {

        NodeCordoniTree trailing = null;
        NodeCordoniTree current = tree.root;


        while (current.getData() != null){

            trailing = current;

            if(newnode.key < current.key){

                current = current.getleft();
                System.out.println("L ");

            }//if

            else{

                current = current.getright();
                System.out.println("R ");

            }//else

        }//while

        node.parent = trailing;

        if(trailing == null){

            tree.root = node;
            System.out.println("Root ");

        }//if

        else{

            if(node.key < trailing.key){

                node = trailing.getleft();
                System.out.println("L ");

            }//if

            else{

                trailing.right = node;
                System.out.println("R ");

            }//else
        }//else

    }//insertTree

    //This method inserts the nodes into the tress
    public NodeCordoni searchTree(NodeCordoni rootnode, String target) {

        int numberOfComparisons = 0;

        if((rootnode == null) || (rootnode.getData() == target)){
            return rootnode;
        }//if

        else{

            if(target.compareToIgnoreCase(rootnode.getData()) < 0){
                numberOfComparisons++;
                searchTree(rootnode.getleft(), target);
            }//if

            else{
                searchTree(rootnode.getright(), target);
            }//else
        }//else

    }//searchTree

    
}//Assignment4Cordoni