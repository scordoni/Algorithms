
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
    private  ArrayList <String> neighbors= new ArrayList <String>();
    private VertexCordoni myNext;

    /**
    * The default Constructor for VertexCordoni
    */
    public VertexCordoni()
    {
    myId = new String();
    myIsProcessed = false;
    myNext = null;
    }//vertex Cordoni

     /**
    * The full constructor for NodeCordoni
    * @param newData the incoming data of the item
    */
   public NodeCordoni(String newData)
   {
        myId = newData;
        myIsProcessed = false;
        myNext = null;
        
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
    * the setter for the next vertex in the queue
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
    * The setter for the process status
    * @param newIsProcessed the incoming process status
    */
    public void setProcessStatus(boolean newIsProcessed)
    {myIsProcessed = newIsProcessed;}//set Node

    /**
    * the getter for the process status
    * @return the incoming process status
    */
    public boolean getProcessStatus()
    { return myIsProcessed;}//get node 

    
    public void setneighbor(int index, String newId)
    { neighbors.add(index, newId);}//get node

    public String getneighbor(int index)
    { return neighbors.get(index);}//get node

    
}//Vertex Cordoni


   

    
