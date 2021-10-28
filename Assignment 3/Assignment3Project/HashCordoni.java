/** 
 * 
 * Assignment 3
 * Due Date and Time: 11/5/21 before 12:00am 
 * Purpose: to implement searching and hashing, and to understand their performance.
 * @author Shannon Cordoni 
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class HashCordoni
{
   /**
    * Declare Variables 
    */
    private  final String FILE_NAME = "magicitems.txt";
    private  final int LINES_IN_FILE = 666;
    private  final int HASH_TABLE_SIZE = 250;
    private  NodeCordoni myHead;
    private  NodeCordoni myTail;

    //This method creates the hashcode for the string, courtesy of Profesor Labouseur!
    public  int makeHashCode(String str) {
        int hashTableSize = 250;
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;
        
        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;
            
            // Test: print the char and the hash.
            /* 
            System.out.print(" ["); 
            System.out.print(thisLetter); 
            System.out.print(thisValue); 
            System.out.print("] "); 
            // */
        }//for
  
        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % hashTableSize;  // % is the "mod" operator
        
  
        return hashCode;
    }//make hash code

    
        
    //This method adds a node to the chain
    public  NodeCordoni makeChain(String newword)
    {	
        //this sets a temp variable to hold the current tail node
        NodeCordoni oldTail = myTail;

        //this sets the tail to be a new node and its data to be the new string
        myTail = new NodeCordoni();
        myTail.setData(newword);
            
        //This checks to see if the hash index is empty
        //if it is not empty then the old tail is set to now point to the new Node
        if (!isEmpty()){
            oldTail.setNext(myTail);		
        }//if
    
        //if the queue is empty then all variables are the same because there is nothing
        //in the queue. Then the head and tail pointer would be pointing to the same thing.
        else{
            myHead = myTail;
        }//else

        return myHead; 
    
    }//make chain

    //This method adds a node to the chain
    public  NodeCordoni searchChain()
    {

        //This sets the temp variable to null so that it can be set later.
        NodeCordoni answer = null;
        
        //If the queue is not empty then it will remove the first node from the queue
        if(!isEmpty())
        {
            //This sets the temp variable to the first node in the list and then sets
            //the new head pointer to the second node in the queue
            answer = myHead;
            myHead = myHead.getNext();
                
            //if the queue is empty then the head is null 
            if(isEmpty()){
                myHead = null;
            }//if
        }//if

        else{
            System.out.println("The Hashtable is empty");
        }

        return answer;

    }//searchChain
	
	//THis checks to see if the queue is empty
	public  boolean isEmpty()
	{
		boolean empty = false;
		
		if(myHead == null)
			{
			empty = true;
			}//if
		return empty;
	}//empty

}//hashCordoni

    
