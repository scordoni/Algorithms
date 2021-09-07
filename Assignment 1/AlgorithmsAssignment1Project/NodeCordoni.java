/** 
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * 
 * Purpose: This class creates the linked list (Node Class) <br>
 * 
 *
 * @author Shannon Cordoni <br>
 * 
 */

public class NodeCordoni 
{
   /**
    * Instance Variable for word data and node <br>
    */
   private WordCordoni myData;
   private NodeCordoni myNext;

   
   /**
    * The default Constructor for ItemCordoni
    */
   public NodeCordoni()
       {
       myData = new WordCordoni();
       myNext= null;
       }//Node Cordoni
   
   /**
    * The full constructor for NodeCordoni
    * @param newData the incoming data of the item
    */
   public NodeCordoni(WordCordoni newData)
       {
       myData = newData;
       myNext = null;
       }//NodeCordoni
   
   /**
    * the setter for the item data
    * @param newData the incoming data of the item
    */
   public void setData(WordCordoni newData)
       {myData = newData;} //set data
   
   /**
    * The getter for the item data
    * @return the incoming data of the item
    */
   public WordCordoni getData()
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

}//Word Cordoni

    