/** 
 * 
 * 
 */

public class NodeCordoni
{
   /**
    * Instance Variable for word data and node 
    */
   private String myData;
   private NodeCordoni myNext;
   private NodeCordoni myRoot;
   private NodeCordoni myRight;
   private NodeCordoni myLeft;

   
   /**
    * The default Constructor for NodeCordoni
    */
   public NodeCordoni()
       {
       myData = new String();
       myRoot = null;
       myLeft = null;
       myRight = null;
       myNext= null;
       }//Node Cordoni
   
    /**
    * The full constructor for NodeCordoni
    * @param newData the incoming data of the item
    */
   public NodeCordoni(String newData)
   {
        myData = newData;
        myRoot = null;
        myLeft = null;
        myRight = null;
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


    /**
    * The setter for the node
    * @param NewRoot the incoming node data
    */
   public void setRoot(NodeCordoni newroot)
   {myRoot = newroot;}//set Node

    /**
    * the getter for the node
    * @return the incoming node data
    */
    public NodeCordoni getRoot()
    { return myRoot;}//get node

    /**
    * The setter for the node
    * @param NewLeft the incoming node data
    */
   public void setLeft(NodeCordoni newLeft)
   {myLeft = newLeft;}//set Node

    /**
    * the getter for the node
    * @return the incoming node data
    */
    public NodeCordoni getLeft()
    { return myLeft;}//get node


    /**
    * The setter for the node
    * @param NewRight the incoming node data
    */
   public void setRight(NodeCordoni newRight)
   {myLeft = newRight;}//set Node

    /**
    * the getter for the node
    * @return the incoming node data
    */
    public NodeCordoni getRight()
    { return myRight;}//get node

}//Node Cordoni
