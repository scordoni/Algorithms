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

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;

public class VertexCordoni
{
     /**
      * Declare Variables 
     */
     private String myId;
     private boolean myIsProcessed;
     public ArrayList <VertexCordoni> neighbors= new ArrayList <VertexCordoni>();
     private VertexCordoni myNext;
     private VertexCordoni myPrevious;
     private Double myDistance;
     

     /**
      * The default Constructor for VertexCordoni
     */
     public VertexCordoni()
     {
     myId = new String();
     myIsProcessed = false;
     myNext = null;
     myPrevious = null;
     myDistance = 0.0;
     }//vertex Cordoni

     /**
     * The full constructor for VertexCordoni
     * @param newData the incoming data 
     */
     public VertexCordoni(String newData)
     {
          myId = newData;
          myIsProcessed = false;
          myNext = null;
          myPrevious = null;
          myDistance = 0.0;
          
     }//NodeCordoni

    /**
     * 
    * the setter for the vertex id
    * @param newId the incoming data of the vertex
    */
    public void setId(String newId)
    {myId = newId;} //set data

    /**
    * The getter for the vertex id
    * @return the incoming data of the vertex
    */
    public String getId()
    {return myId;}//get data


    /**
    * 
    * the setter for the next vertex 
    * @param newNext the incoming data of the vertex
    */
    public void setNext(VertexCordoni newNext)
    {myNext = newNext;} //set data

    /**
    * The getter for the vertex 
    * @return the incoming data of the vertex
    */
    public VertexCordoni getNext()
    {return myNext;}//get data

    /**
    * 
    * the setter for the Previous vertex 
    * @param newPrevious the incoming data of the vertex
    */
    public void setPrevious(VertexCordoni newPrevious)
    {myPrevious = newPrevious;} //set data

    /**
    * The getter for the vertex 
    * @return the incoming data of the vertex
    */
    public VertexCordoni getPrevious()
    {return myPrevious;}//get data

    /**
    * The setter for the process status
    * @param newIsProcessed the incoming process status
    */
    public void setProcessStatus(boolean newIsProcessed)
    {myIsProcessed = newIsProcessed;}//set data

    /**
    * the getter for the process status
    * @return the incoming process status
    */
    public boolean getProcessStatus()
    { return myIsProcessed;}//get data

    /**
    * The setter for the Distance
    * @param newDistance the incoming Distance
    */
    public void setDistance(Double newDistance)
    {myDistance = newDistance;}//set data

    /**
    * the getter for the process status
    * @return the incoming process status
    */
    public Double getDistance()
    { return myDistance;}//get data

   
}//Vertex Cordoni


   

    
