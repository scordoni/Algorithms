/**
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

public class MainCordoni {

	//Declare keyboard 
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {

		//Declare and initialize variables 
		String line;
		
		String[] wordarray = new String[666];
			
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
		
		//Passes word array into the shuffle method to shuffle the array
		//shuffle(wordarray);
		
	}//main

	//This method 
	public static String[] shuffle(String[] wordarray)
	{
		//swap
		//temp = A
		//A = B
		//B = Temp

		for ( int i = 0; i < wordarray.length; i++){

		}//for

		return wordarray;
	   
	}//shufle

	//This method
	public int selectionSort(String[] wordarray)
	{
		int numberOfSortComparisons = 0;

	   //comment
	   for(int i = 0; i < wordarray.length - 2; i++){

			//comment
			int smallpostion = i;
			
			//comment
			for(int j = i+1; j < wordarray.length - 1; i++){

				//comment
				if (wordarray[j].compareToIgnoreCase(wordarray[smallpostion]) > 0){
					smallpostion = j;
				}//if

				numberOfSortComparisons++;

			}//for j

			//swap wordarray[i] with wordarray[smallpostion]


	   }//for i 

	   return numberOfSortComparisons;

	}//selection sort

	//This method
	public int insertionSort(String[] wordarray)
	{
		int numberOfInsertComparisons = 0;

		//comment
	    for(int i = 1; i < wordarray.length - 2; i++){

			//comment
			String key = wordarray[i];

			int j = i - 1;
			
			//comment
			while(( j >= 0)&&(wordarray[j].compareToIgnoreCase(key) < 0)){

				//comment
				wordarray[j + 1] = wordarray[j];
				j = j - 1;
				numberOfInsertComparisons++;

			}//while

			wordarray[j + 1] = key;

	   }//for i 

	   return numberOfInsertComparisons;
	   
	}//insertion sort

	//This method
	public int mergeSort(String[] wordarray)
	{
		int numberOfMergeComparisons = 0;
	   
		return numberOfMergeComparisons;
	}//merge sort

	//This method
	public int quickSort(String[] wordarray)
	{
		int numberOfQuickComparisons = 0;

		return numberOfQuickComparisons;
	   
	}//quick sort

}//MainCordoni