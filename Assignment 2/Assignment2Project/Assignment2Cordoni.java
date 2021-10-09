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

import jdk.internal.jshell.tool.resources.l10n;

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

        int p = 1;
        int r = 665;

        
        selectionWordArray = wordarray;
        selectionSort(selectionWordArray);

        insertionWordArray = wordarray;
        insertionSort(insertionWordArray);

        mergeWordArray = wordarray;
        mergeSort(mergeWordArray);

        quickWordArray = wordarray;
        quickSort(quickWordArray, p, r);

        
    }//main

    //This method
    public static void selectionSort(String[] selectionWordArray)
    {

        int numberOfSortComparisons = 0;

       //comment
       for(int i = 0; i < selectionWordArray.length - 2; i++){

            //comment
            int smallpostion = i;
            
            //comment
            for(int j = i + 1; j < selectionWordArray.length - 1; j++){

                //comment
                if (selectionWordArray[j].compareToIgnoreCase(selectionWordArray[smallpostion]) < 0){
                    smallpostion = j;
                    
                    //224184
                    numberOfSortComparisons++;
                    //System.out.println(numberOfSortComparisons);

                }//if


                //220780
                numberOfSortComparisons++;
                //System.out.println(numberOfSortComparisons);
                
            }//for j

            //swap wordarray[i] with wordarray[smallpostion]
            if (selectionWordArray[smallpostion]!= selectionWordArray[i]){
                
                //System.out.println("hi");
                String temp = selectionWordArray[i];
                selectionWordArray[i] = selectionWordArray[smallpostion];
                selectionWordArray[smallpostion] = temp;

            }//if

       }//for i 

       System.out.println("Selection Sort Comparisons: " + numberOfSortComparisons);

    }//selection sort

    //This method
    public static void insertionSort(String[] insertionWordArray)
    {
        int numberOfInsertComparisons = 0;

        //comment
        for(int i = 1; i < insertionWordArray.length - 2; i++){

            //comment
            String key = insertionWordArray[i];

            int j = i - 1;
            
            //comment
            while(( j >= 0)&&(insertionWordArray[j].compareToIgnoreCase(key) < 0)){

                //comment
                insertionWordArray[j + 1] = insertionWordArray[j];
                j = j - 1;
                numberOfInsertComparisons++;

            }//while

            insertionWordArray[j + 1] = key;

       }//for i 

       System.out.println("Insertion Sort Comparisons: " + numberOfInsertComparisons);
       
    }//insertion sort

    //This method
    public static void mergeSort(String[] wordarray)
    {
        int numberOfMergeComparisons = 0;

        int p = 1;
        int q = 333;
        int r = 666;

        int i = 0;
        int j = 0;

        int n1 = q-p+1;
        int n2 = r-q;

        String [] temparray1 = new String[666];
        String [] temparray2 = new String[666];

        for (i = 0; i< n1; i++){
            temparray1[i] = wordarray[p+i-1];
        }//for

        for(j = 0; j < n2; j++){
            temparray2[j] = wordarray[q+j];
        }//for

        i = 1;
        j = 1;
        for(int k = p; k < r; k++){
            if(temparray1[i].compareToIgnoreCase(temparray2[j]) <= 0 ){
                wordarray[k] = temparray1[i];
                i = i + 1;
                numberOfMergeComparisons++;
            }//if
            else if (wordarray[k] == temparray2[j]){
                j = j+1;
                numberOfMergeComparisons++;
            }//else
        }//for
       
        System.out.println("Merge Sort Comparisons: " + numberOfMergeComparisons);
    }//merge sort

    //This method
    public static void quickSort(String[] wordarray, int p, int r)
    {
        int numberOfQuickComparisons = 0;

        int i = 0;

        if (wordarray[p].compareToIgnoreCase(wordarray[r]) < 0){
            numberOfQuickComparisons++;
            int q = partition(wordarray, p, r);

            quickSort(wordarray, p, q - 1);
            quickSort(wordarray, q + 1, r);
        }//if

        System.out.println("Quick Sort Comparisons: " + numberOfQuickComparisons);
       
    }//quick sort

    public static int partition(String[] wordarray, int p, int r){

        String temp = "none";
        String temp2 = "none";
        String temp3 = "none";

        int i = 0;

        temp = wordarray[r];
        i = p-1;

        for (j = p; j < r-1; j++){
            if (wordarray[j].compareToIgnoreCase(temp) < 0){
                numberOfQuickComparisons++;
                i = i + 1;

                temp2 = wordarray[i];
                wordarray[i] = wordarray[j];
                wordarray[j] = temp2;
            }//if

            temp3 = wordarray[i + 1];
            wordarray[i + 1] = wordarray[r];
            wordarray[r] = temp3;

        }//for

        return i + 1;
    }//partition
    
}//MainCordoni