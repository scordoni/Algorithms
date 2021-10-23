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

public class Hashing
{
   /**
    * Declare Variables 
    */
    private static final String FILE_NAME = "magicitems.txt";
    private static final int LINES_IN_FILE = 666;
    private static final int HASH_TABLE_SIZE = 250;

    private static int makeHashCode(String str) {
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
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
        
  
        return hashCode;
    }//make hash code
     

}//Hashing
