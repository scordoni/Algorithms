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

public class EdgeCordoni
{
   /**
    * Declare Variables 
    */
    private VertexCordoni myTo;
    private VertexCordoni myFrom;
    private int myweight;


    /**
    * The default Constructor for EdgeCordoni
    */
   public EdgeCordoni()
   {
   myTo = null;
   myFrom = null;
   myWeight = new Integer();
   }//Edge Cordoni

    /**
    * The full constructor for NodeCordoni
    * @param newData the incoming data of the item
    */
    public EdgeCordoni(VertexCordoni newTo, VertexCorodni newFrom, Integer newWeight)
    {
        myTo = newTo;
        myFrom = newFrom;
        myWeight = newWeight;
        
    }//EdgeCordoni

    /**
    * the setter for the edge data
    * @param newTo the incoming data of the item
    */
    public void setTo(VertexCordoni newTo)
        {myTo = newTo;} //set data

    /**
     * The getter for the edge data
     * @return the incoming data of the item
     */
    public VertexCordoni getTo()
        {return myTo;}//get data

    /**
    * the setter for the edge data
    * @param newFrom the incoming data of the item
    */
    public void setFrom(VertexCordoni newFrom)
        {myFrom = newFrom;} //set data

    /**
     * The getter for the edge data
     * @return the incoming data of the item
     */
    public VertexCordoni getFrom()
        {return myFrom;}//get data

    /**
    * the setter for the edge data
    * @param newWeight the incoming data of the item
    */
    public void setWeight(Integer newWeight)
        {myWeight = newWeight;} //set data

    /**
     * The getter for the edge data
     * @return the incoming data of the item
     */
    public Integer getWeight()
        {return myWeight;}//get data


}//edge Cordoni