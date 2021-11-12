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
    private static  NodeCordoni myHead;
    private static  NodeCordoni myTail;
   

    //This method creates the hashcode for the string, courtesy of Professor Labouseur!
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
        NodeCordoni oldHead = myHead;

        //this sets the tail to be a new node and its data to be the new string
        myHead = new NodeCordoni();
        myHead.setData(newword);
            
        //This checks to see if the hash index is empty
        //if it is not empty then the old tail is set to now point to the new Node
        if (!isEmpty()){
            myHead.setNext(oldHead);		
        }//if
    
       
        else{
            myHead = myTail;
        }//else

        return myHead; 
    
    }//make chain

    
    
	
	//This checks to see if the queue is empty
	public static  boolean isEmpty()
	{
		boolean empty = false;
		
		if(myHead == null)
			{
			empty = true;
			}//if
		return empty;
	}//empty

}//hashCordoni

    
