/**
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * Purpose: To see if a word is a palindrome <br>
 * Input: The user will be inputting a file containing a list of words/statements .<br>
 * Output: The program will output the palindromes. <br>
 * @author Shannon Cordoni <br>
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCordoni {

	//Declare keyboard 
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {

		//Declare and initialize variables 
		StackCordoni theStack = new StackCordoni();
		String filename;
		String line;
		String statement;
		String noSpaceStatement;
		NodeCordoni word = null;
		QueueCordoni theQueue = new QueueCordoni();
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
		
		//Passes word array into the palindrome funtion to remove spaces and change
		//letter case so that letters can be passed into stack and queue
		palindrome(wordarray);
		
		}//main
	

		//this method takes in one element of the array and make all letters
		//the same case and gets rid of spaces
		public static void palindrome( String[] wordarray)
		{
		
			//System.out.println(wordarray);
			String line = "none";
			String statement = "none";
			String noSpaceStatement;

			
			for(int i = 0; i<wordarray.length; i++){

				//creation of stack and queue
				StackCordoni theStack = new StackCordoni();
				QueueCordoni theQueue = new QueueCordoni();

				//takes each index of the array and inputs it into a variable
				line = wordarray[i];

				//Takes each letter of the string and makes it lowercase
				statement = line.toLowerCase();

				//Takes the string and removes spaces between words
				noSpaceStatement = statement.replaceAll("\\s", "");
				
				//Takes each letter of the string and puts them into an array
				String[] charArray = noSpaceStatement.split("");
				
				//Pushes each letter in the array into the stack
				pushStack(charArray, theStack);

				//Enqueues each letter in the array into the queue
				enqueueQueue(charArray, theQueue);

				//compares each letter from the stack and queue
				compare(line, theStack, theQueue);
				
			}//for
		}//palindrome

		//This method pushes each letter of the array into the stack
		public static void pushStack(String[] chararray, StackCordoni stack){

			//goes through the arracy to push each letter
			for(int i = 0; i < chararray.length; i++){
				stack.push(chararray[i]);
			}//for
			
		}//pushStack

		public static void enqueueQueue(String[] chararray, QueueCordoni queue){

			//goes through the array to enqueue each letter
			for(int i = 0; i < chararray.length; i++){
				queue.enqueue(chararray[i]);
			}//for
			
		}//enqueueQueue

		//This method pops and dequeues a letter from the stack and queue respectivley
		//Then it compares each letter to see if the word is a palindrome
		public static void compare(String chararray, StackCordoni stack, QueueCordoni queue){

			NodeCordoni popVal;
			NodeCordoni dequeueVal;
			String valPop;
			String valDequeue;

			//pop from the queue and store letter in a variable
			popVal = stack.pop();
			valPop = popVal.getData();

			//dequeue from the queue and store letter in a variable
			dequeueVal = queue.dequeue();
			valDequeue = dequeueVal.getData();

			//Looks to see if the letters are the same
			if(valPop.equals(valDequeue)){

				/*
				*while the letters are equal we go through the rest of the stack and queue 
				*until we reach letters that are not the same or the stack is empty
				*(since we are putting the same amount of letters into the stack/queue we only
				*have to see if one of them is empty, since i pushed before enqueue I used the stack)
				*/

				while((valPop.equals(valDequeue))&&(!(stack.isEmpty()))){
					popVal = stack.pop();
					valPop = popVal.getData();
					dequeueVal = queue.dequeue();
					valDequeue = dequeueVal.getData();
				}//while
				
				/*
				*If we reach the end of the stack and all of the letters are the same
				*then the word is a palindrome and we print it out
				*/
				if(stack.isEmpty()){
					System.out.println(chararray);
				}//if	
			}//if
		}//compare
}//MainCordoni
