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

public class Assignment2Cordoni {

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

        int startindex = 0;
        int endindex = 665;

        //create selection array to match word array
        selectionWordArray = wordarray;

        //pass selection array to selection sort
        selectionSort(selectionWordArray);

        //read file again to create new array
        //create new file object
        File myFile2 = new File("magicitems.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile2);
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

        //create insertion array to match word array
        insertionWordArray = wordarray;

        //pass insertion array to insertion sort method
        insertionSort(insertionWordArray);

        //read file again to create new array
        //create new file object
        File myFile3 = new File("magicitems.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile3);
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

        //create merge array to match word array
        mergeWordArray = wordarray;

        //pass merge array to merge sort method
        merge(mergeWordArray, startindex, endindex);

        System.out.println("Merge Sort Comparisons: " + merge(mergeWordArray, startindex, endindex));

        //read file again to create new array
        //create new file object
        File myFile4 = new File("magicitems.txt");
        
        try
        {
            //create scanner
            Scanner input = new Scanner(myFile4);
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

        //create quick array to match word array
        quickWordArray = wordarray;

        //pass quick array to quick sort method
        quickSort(quickWordArray, startindex, endindex);

        System.out.println("Quick Sort Comparisons: " + quickSort(quickWordArray, startindex, endindex));

        
    }//main

    //This method is the selection sort method that goes through and sorts the array using a Big Oh of n squared
    public static void selectionSort(String[] selectionWordArray)
    {

        int numberOfSortComparisons = 0;

       //to loop through the array to determine the next smallest position
       for(int i = 0; i < selectionWordArray.length - 2; i++){

            int smallpostion = i;
            
            //to loop through the array to to compare small position with the rest of the array
            for(int j = i + 1; j < selectionWordArray.length - 1; j++){

                //compares to see if the value of j comes before the value of small position in the alphabet
                if (selectionWordArray[j].compareToIgnoreCase(selectionWordArray[smallpostion]) < 0){
                    smallpostion = j;
                    numberOfSortComparisons++;
                }//if

                numberOfSortComparisons++;
            }//for j

            //swap wordarray[i] with wordarray[smallpostion]
            if (selectionWordArray[smallpostion]!= selectionWordArray[i]){
                
                String temp = selectionWordArray[i];
                selectionWordArray[i] = selectionWordArray[smallpostion];
                selectionWordArray[smallpostion] = temp;

            }//if

       }//for i 

       System.out.println("Selection Sort Comparisons: " + numberOfSortComparisons);

    }//selection sort

    //This method is the insertion sort method that goes through and sorts the array using a Big Oh of n squared
    public static void insertionSort(String[] insertionWordArray)
    {
        int numberOfInsertComparisons = 0;

        //to loop through the array to determine the next key
        for(int i = 1; i < insertionWordArray.length - 2; i++){

            //sets the key to be a value of the array
            String key = insertionWordArray[i];

            int j = i - 1;
            
            //while j comes before the key this loop pushes the key to where it falls in the array
            while(( j >= 0)&&(insertionWordArray[j].compareToIgnoreCase(key) < 0)){

                insertionWordArray[j + 1] = insertionWordArray[j];
                j = j - 1;
                numberOfInsertComparisons++;

            }//while

            //this sets the new key
            insertionWordArray[j + 1] = key;

       }//for i 

       System.out.println("Insertion Sort Comparisons: " + numberOfInsertComparisons);
       
    }//insertion sort

    //This method is the merge sort method that goes through and sorts the array using a Big Oh of n log n
    public static int merge(String[] wordarray, int startindex, int endindex){
        int numberOfMergeComparisons1 = 0;
        int numberOfMergeComparisons = 0;

        //if the first value comes before the last value then we can move to the merge sort
        if (wordarray[startindex].compareToIgnoreCase(wordarray[endindex]) < 0){
            numberOfMergeComparisons1++;

            //int temp1 = endindex - 1;
            //int temp2 = temp1/2;
            int split = (startindex + endindex) / 2;
            merge(wordarray, startindex, split);
            merge(wordarray, split + 1, endindex);
            mergeSort(wordarray, startindex, split, endindex);
            numberOfMergeComparisons = mergeSort(wordarray, startindex, split, endindex) + numberOfMergeComparisons1;
        }//if

        
        return(numberOfMergeComparisons);
    }//merge

    //This method merges the subarrays back together
    public static int mergeSort(String[] wordarray, int startindex, int split, int endindex)
    {
        int numberOfMergeComparisons2 = 0;
        

        int i = 0;
        int j = 0;

        int n1 = split - startindex + 1;
        int n2 = endindex - split;

        String [] temparray1 = new String[n1 + 1];
        String [] temparray2 = new String[n2 + 1];

        //sets the values of the first temp array
        for (i = 1; i < n1 + 1 ; i++){
            temparray1[i] = wordarray[startindex + i - 1];
            
        }//for

        //sets the values of the second temp array
        for(j = 1; j < n2 + 1; j++){
            temparray2[j] = wordarray[split + j];
             
        }//for

        i = 1;
        j = 1;
        
        //this  helps put the smallest elements of the temp arrays in sorted order
        for(int k = startindex; k < endindex ; k++){


            if(temparray1[i].compareToIgnoreCase(temparray2[j]) <= 0 ){
                wordarray[k] = temparray1[i];
                i = i + 1;
                numberOfMergeComparisons2++;
            }//if

            else if (wordarray[k].compareToIgnoreCase(temparray2[j]) == 0){
                j = j + 1;
                numberOfMergeComparisons2++;
            }//else

        }//for


        return numberOfMergeComparisons2;
    }//merge sort

    //This method is the quick sort method that goes through and sorts the array using a Big Oh of n log n
    public static int quickSort(String[] wordarray, int startindex, int endindex)
    {
        int numberOfQuickComparisons = 0;

        numberOfQuickComparisons++;

        //this looks to see if the first value comes before the last value in the alphabet
        //if so we can move to creat the partition the array
        if ((wordarray[startindex].compareToIgnoreCase(wordarray[endindex])) < 0){
            
    
            //creates the partition
            int split = partition(wordarray, startindex, endindex);

            //calls quick sort to sort both halfs of the array
            quickSort(wordarray, startindex, split - 1);
            quickSort(wordarray, split + 1, endindex);

        }//if

        return numberOfQuickComparisons;
        
       
    }//quick sort

    //this method creates the partition of the arary
    public static int partition(String[] wordarray, int startindex, int endindex){

        String temp = "none";
        String temp2 = "none";
        String temp3 = "none";

        int i = 0;
        int j = 0;

        temp = wordarray[endindex];
        i = startindex-1;

        //this looks to create the partition
        for (j = startindex; j < endindex-1; j++){

            //this looks to see whether the value is smaller than the pivot value
            if (wordarray[j].compareToIgnoreCase(temp) < 0){
                
                i = i + 1;

                //these 2 swaps help swap the pivot with the leftmost element greater than the temp
                //value, putting the pivot in its correct place.
                temp2 = wordarray[i];
                wordarray[i] = wordarray[j];
                wordarray[j] = temp2;
            }//if

            temp3 = wordarray[i + 1];
            wordarray[i + 1] = wordarray[endindex];
            wordarray[endindex] = temp3;

        }//for

        return i + 1;
    }//partition
    
}//MainCordoni