/*
 * 
 * Assignment 3
 * Due Date and Time: 11/5/21 before 12:00am 
 * Purpose: to implement searching and hashing, and to understand their performance.
 * Input: The user will be inputting a file containing a list of words/statements
 * Output: The program will sort them and search through them to find certain elementss
 * @author Shannon Cordoni 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment3Cordoni {

    //Declare keyboard 
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Declare and initialize variables 
        String line;
        String[] wordarray = new String[666];
        String[] randomarray = new String[42];

        int startindex = 0;
        int endindex = 665;

        int linearsum = 0;
        double linearaverage = 0.0;

        int binarysum = 0;
        double binaryaverage = 0.0;

        int hashsum = 0;
        double hashaverage = 0.0;
            
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

        //take the first 42 items before sorted and place them into an array to be searched for later
        for (int i = 0; i < randomarray.length; i++){
            randomarray[i] = wordarray[i];
        }//for

        //pass array to selection sort to be sorted
        selectionSort(wordarray);

        //Call linear search to search for the 42 random items
        for (int i = 0; i < randomarray.length; i++){
            linearsum = linearsum + linearSearch(wordarray, randomarray[i]);
        }//for

        //find the average number of comparisons for linear search
        linearaverage = linearsum / randomarray.length;
        System.out.println("The Linear Search average is " + linearaverage);

        //Call binary search to search for the 42 random items
        for (int i = 0; i < randomarray.length; i++){
            binarysum = binarysum + binarySearch(wordarray, randomarray[i], startindex, endindex);
        }//for

        //find the average number of comparisons for binary search
        binaryaverage = binarysum / randomarray.length;
        System.out.println("The Binary Search average is " + binaryaverage);

        //Call hashing to search for the 42 random items
        for (int i = 0; i < randomarray.length; i++){
            hashsum = hashsum + hashsearch(wordarray, randomarray[i], startindex, endindex);
        }//for

        //find the average number of comparisons for binary search
        hashaverage = hashsum / randomarray.length;
        System.out.println("The Hashing average is " + hashaverage);
       
    }//main

    //This method is the selection sort method that goes through and sorts the array using a Big Oh of n squared
    public static String[] selectionSort(String[] wordArray)
    {
        int numberOfSortComparisons = 0;

       //to loop through the array to determine the next smallest position
       for(int i = 0; i < wordArray.length - 2; i++){

            int smallpostion = i;
            numberOfSortComparisons++;

            //to loop through the array to to compare small position with the rest of the array
            for(int j = i + 1; j < wordArray.length - 1; j++){

                numberOfSortComparisons++;

                //compares to see if the value of j comes before the value of small position in the alphabet
                if (wordArray[j].compareToIgnoreCase(wordArray[smallpostion]) < 0){
                    smallpostion = j;
                }//if

            }//for j

            //swap wordarray[i] with wordarray[smallpostion]
            if (wordArray[smallpostion]!= wordArray[i]){
                
                String temp = wordArray[i];
                wordArray[i] = wordArray[smallpostion];
                wordArray[smallpostion] = temp;

            }//if

       }//for i 

       System.out.println("Selection Sort Comparisons: " + numberOfSortComparisons);

       return(wordArray);
    }//selection sort

    //This method uses linear search to find the 42 items
    public static int linearSearch(String[] wordArray, String target)
    {
        int numberofLinearComparisons = 0;
        
        int index = 0;

        for (int i = 0; i < wordArray.length; i++){

            numberofLinearComparisons++; 

            if (target.compareToIgnoreCase(wordArray[i])==0){
                i = index;
                return numberofLinearComparisons;
            }//if

        }//for
        
        return numberofLinearComparisons;
        
    }//Linear Search

    //This method uses binary search to find the 42 items
    public static int binarySearch(String[] wordArray, String target, int startindex, int endindex)
    {
        int numberofBinaryComparisons = 0;
        int low = 0;
        int high = 0;
        int mid = 0;
        int temp = 0;
        
        low = startindex;
        high = endindex;
        

        while (low < high){
            mid = (low + high)/2;
            numberofBinaryComparisons++;
            if ( target.compareToIgnoreCase(wordArray[mid]) < 0){
                
                high = mid;
            }//if

            else {
                low = mid + 1;
            }//else

        }//while
         
        return numberofBinaryComparisons;
         
    }//Binary Search

    //This method uses hashing to retrieve the 42 items
    public static int hashsearch(String[] wordArray, String target, int startindex, int endindex)
    {

        HashCordoni HashCordoni = new HashCordoni();
        int[] hashValues = new int[666];
        NodeCordoni[] hashTable = new NodeCordoni [250];
        int numberofHashComparisons = 0;
        int low = 0;
        int high = 0;

        low = startindex;
        high = endindex;

        //make hashcode for each string and place that hashcode in a new array
        for (int i = 0; i < wordArray.length; i++){
            hashValues[i] = HashCordoni.makeHashCode(wordArray[i]);
            //System.out.println(hashValues[i]);
        }//for


        //input the node containing the string to either start or continue the chain
        for (int i = hashValues[0]; i < hashValues.length; i++){
            

            if(hashTable[i] != null){
                hashTable[i].setData(HashCordoni.makeChain(wordArray[i]).toString());
            }//if

            else{
                hashTable[i].setData(wordArray[i]);
            }//else

            System.out.println(hashTable[i]);
        }//for
       
        int i = 0;

        //Go through the hash table and search for the 42 items
        while(target.compareToIgnoreCase(hashTable[hashValues[i]].getData()) != 0){
            i++;
            numberofHashComparisons++;
        }//while
        

        return numberofHashComparisons;
         
    }//Hash

}//Assignment3Cordoni