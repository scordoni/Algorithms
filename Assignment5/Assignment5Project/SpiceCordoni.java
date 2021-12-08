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

public class SpiceCordoni{

    /**
    * Instance Variable 
    */
    private String myColor;
    private Double myPrice;
    private Integer myQty;
    private Double myUnitPrice;
   
   /**
    * The default Constructor for SpiceCordoni
    */
    public SpiceCordoni()
    {
       myColor = new String();
       myPrice = 0.0;
       myQty = 0;
       myUnitPrice = 0.0;
    }//Spice Cordoni
   

    /**
    * The full constructor for SpiceCordoni
    */
    public SpiceCordoni(String newColor, Double newPrice, Integer newQty, Double newUnitPrice)
    {
        myColor = newColor;
        myPrice = newPrice;
        myQty = newQty;
        myUnitPrice = newUnitPrice;
        
    }//SpiceCordoni

    /**
    * the setter for the spice data
    * @param newmyColor the incoming data of the spice
    */
    public void setColor(String newColor)
    {myColor = newColor;} //set Name

    /**
    * The getter for the spice data
    * @return the incoming data of the item
    */
    public String getColor()
    {return myColor;}//get name

    /**
    * The setter for the spice
    * @param newPrice the incoming spice data
    */
    public void setPrice(Double newPrice)
    {myPrice = newPrice;}//set Price

    /**
    * the getter for the spice data
    * @return the incoming spice data
    */
    public Double getPrice()
    { return myPrice;}//get node

    /**
    * The setter for the spice
    * @param newQty the incoming spice data
    */
    public void setQty(Integer newQty)
    {myQty = newQty;}//set Qty

    /**
    * the getter for the spice data 
    * @return the incoming spice data
    */
    public Integer getQty()
    { return myQty;}//get node

    /**
    * The setter for the spice
    * @param newUnitPrice the incoming spice data
    */
    public void setUnitPrice(Double newUnitPrice)
    {myUnitPrice = newUnitPrice;}//set unit price

    /**
    * the getter for the spice data 
    * @return the incoming spice data
    */
    public Double getUnitPrice()
    { return myUnitPrice;}//get unit price
    
}//Spice Cordoni Class
