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

public class KnapsackCordoni{

    /**
    * Instance Variable 
    */
    private Integer myCapacity;
   
   /**
    * The default Constructor for KnapsackCordoni
    */
    public KnapsackCordoni()
    {
       myCapacity = 0;
    }//Knapsack Cordoni

     /**
    * The full constructor for KnapsackCordoni
    */
    public KnapsackCordoni(Integer newCapacity)
    {
        myCapacity = newCapacity;
        
    }//KnapsackCordoni
   

    /**
    * The setter for the knapsack
    * @param newCapacity the incoming knapsack data
    */
    public void setCapacity(Integer newCapacity)
    {myCapacity = newCapacity;}//set Qty

    /**
    * the getter for the knapsack data 
    * @return the incoming knapsack data
    */
    public Integer getCapacity()
    { return myCapacity;}//get node

}//knapsackCordoni