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

public class TreeCordoni
{
   /**
    * Instance Variables
    */
   private String myData;
   private TreeCordoni myNext;
   private TreeCordoni myRoot;
   private TreeCordoni myRight;
   private TreeCordoni myLeft;
   private TreeCordoni myParent;

   
   /**
    * The default Constructor for TreeCordoni
    */
   public TreeCordoni()
       {
       myData = new String();
       myRoot = null;
       myLeft = null;
       myRight = null;
       myParent = null;
       myNext= null;
       }//Node Cordoni
   
    /**
    * The full constructor for TreeCordoni
    * @param newData the incoming data of the item
    */
   public TreeCordoni(String newData)
   {
        myData = newData;
        myRoot = null;
        myLeft = null;
        myRight = null;
        myParent = null;
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
    * The setter for the next
    * @param NewNext the incoming data
    */
   public void setNext(TreeCordoni newNext)
       {myNext = newNext;}//set Next
   
   /**
    * the getter for the next
    * @return the incoming data
    */
   public TreeCordoni getNext()
       { return myNext;}//get Next


    /**
    * The setter for the root
    * @param NewRoot the incoming data
    */
   public void setRoot(TreeCordoni newroot)
   {myRoot = newroot;}//set Root

    /**
    * the getter for the root
    * @return the incoming data
    */
    public TreeCordoni getRoot()
    { return myRoot;}//get Root

    /**
    * The setter for the left tree
    * @param NewLeft the incoming data
    */
   public void setLeft(TreeCordoni newLeft)
   {myLeft = newLeft;}//set Left

    /**
    * the getter for the Left
    * @return the incoming data
    */
    public TreeCordoni getLeft()
    { return myLeft;}//get Left


    /**
    * The setter for the Right
    * @param NewRight the incoming data
    */
   public void setRight(TreeCordoni newRight)
   {myLeft = newRight;}//set RIght

    /**
    * the getter for the Right
    * @return the incoming data
    */
    public TreeCordoni getRight()
    { return myRight;}//get Right

     /**
    * The setter for the parent
    * @param NewParent the incoming data
    */
   public void setParent(TreeCordoni newParent)
   {myParent = newParent;}//set Parent

    /**
    * the getter for the parent
    * @return the incoming data
    */
    public TreeCordoni getParent()
    { return myParent;}//get parent

}//Tree Cordoni
