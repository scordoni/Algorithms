/*
 * 
 * Assignment 2
 * Due Date and Time: 10/8/21 before 12:00am 
 * Purpose: To develop multiple sorting methods
 * Input: The user will be inputting a file containing a list of words/statements
 * Output: The program will use differnt methods to sort them 
 * @author Shannon Cordoni 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Assignment20Cordoni {

    //Declare keyboard 
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Declare and initialize variables 
        String line;
        
        String[] wordarray = new String[666];
        String[] selectionWordArray = new String[666];
        String[] insertionWordArray = new String[666];
        String[] mergeWordArray = new String[666];
        String[] quickWordArray = new String[666];
            
        //create new file object
        File myFile = new File("magicitems.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile);
            line = null;
            
            int i = 0;

            //while there are more lines in the file it inputs them into a word array
            while(input.hasNext())
             {  
                //Input into array 
                wordarray[i] = input.nextLine();        
                i++;
             }//while

            input.close();  

        }//try
        
        //error for file not found
        catch(FileNotFoundException ex)
        {
          System.out.println("Failed to find file: " + myFile.getAbsolutePath()); 
        }//catch

        //Error in case of a null pointer exception
        catch(NullPointerException ex)
        {
            System.out.println("Null pointer exception.");
            System.out.println(ex.getMessage());
        }//catch

        //General error message
        catch(Exception ex)
        {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }//catch
        
        selectionWordArray = wordarray;
        insertionWordArray = wordarray;
        mergeWordArray = wordarray;
        quickWordArray = wordarray;

        //Passes word array 
        //selectionSort(selectionWordArray);
        //insertionSort(insertionWordArray);
        //mergeSort(mergeWordArray);
        //quickSort(quickWordArray);
        
    }//main
}//class