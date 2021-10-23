/** 
 * 
 * Assignment 3
 * Due Date and Time: 11/5/21 before 12:00am 
 * Purpose 1: to implement searching and hashing, and to understand their performance.
 * Purpose 2: This class creates the linked list (Node Class) 
 * @author Shannon Cordoni 
 * 
 */

public class NodeCordoni 
{
   /**
    * Instance Variable for word data and node 
    */
   private String myData;
   private NodeCordoni myNext;
   
   /**
    * The default Constructor for NodeCordoni
    */
   public NodeCordoni()
       {
       myData = new String();
       myNext= null;
       }//Node Cordoni
   
   /**
    * The full constructor for NodeCordoni
    * @param newData the incoming data of the item
    */
   public NodeCordoni(String newData)
       {
       myData = newData;
       myNext = null;
       }//NodeCordoni
   
   /**
    * the setter for the item data
    * @param newData the incoming data of the item
    */
   public void setData(String newData)
       {myData = newData;} //set data
   
   /**
    * The getter for the item data
    * @return the incoming data of the item
    */
   public String getData()
       {return myData;}//get data
   
   /**
    * The setter for the node
    * @param NewNext the incoming node data
    */
   public void setNext(NodeCordoni newNext)
       {myNext = newNext;}//set Node
   
   /**
    * the getter for the node
    * @return the incoming node data
    */
   public NodeCordoni getNext()
       { return myNext;}//get node

}//Node Cordoni
