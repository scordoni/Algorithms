/*
 * 
 * Assignment 5
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