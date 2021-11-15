
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
    private  ArrayList <VertexCordoni> neighbors= new ArrayList <VertexCordoni>();

    /**
    * The default Constructor for VertexCordoni
    */
    public VertexCordoni()
    {
    myId = new String();
    myIsProcessed = false;
    ArrayList myNeighbors;
    }//vertex Cordoni

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

    
}//Vertex Cordoni


   

    
