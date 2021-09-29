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
import java.util.Random;

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
		shuffle(wordarray);
		
	}//main

	//This method 
	public static void shuffle(String[] wordarray)
	{
		//String[] temp = wordarray;
		 
		Random r = new Random();
		
		//swap
		//A = B
		//B = Temp

		for ( int i = wordarray.length - 1; i > 0  ; i--){

			int j = r.nextInt(i);
			String temp = wordarray[i];
			wordarray[i] = wordarray[j];
			wordarray[j] = temp;

		}//for

		System.out.println(wordarray.toString());
		selectionSort(wordarray);
	   
	}//shufle

	//This method
	public static void selectionSort(String[] wordarray)
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
			if (wordarray[smallpostion]!= wordarray[i]){
				String temp = wordarray[i];
				wordarray[i] = wordarray[smallpostion];
				wordarray[smallpostion] = temp;
				
			}//if


	   }//for i 

	   System.out.println("Selection Sort Comparisons: " + numberOfSortComparisons);

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
		String[] temparray1 = new String[666];
		String[] temparray2 = new String[666];



	   
		return numberOfMergeComparisons;
	}//merge sort

	//This method
	public int quickSort(String[] wordarray)
	{
		int numberOfQuickComparisons = 0;

		return numberOfQuickComparisons;
	   
	}//quick sort

}//MainCordoni