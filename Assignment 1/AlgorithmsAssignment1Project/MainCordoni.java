
/**
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * 
 * Purpose: To see if a word is a palindrome <br>
 * 
 * Input: The user will be inputting a file containing a list of words/statements .<br>
 * 
 * Output: The program will output the palindromes. <br>
 *
 * @author Shannon Cordoni <br>
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCordoni {

	/**
	 * Declare keyboard 
	 */
	static Scanner keyboard = new Scanner(System.in);


	public static void main(String[] args) {

		/**
		 * Remember to ignore case and remove space! 
		 * 
		 */
		
		/**
		 * Declare and initialize variables 
		 * 
		 */
			
		StackCordoni theStack = new StackCordoni();
		String filename;
		String line;
		String statement;
		String noSpaceStatement;
		NodeCordoni word = null;
		QueueCordoni queue = new QueueCordoni();
		String[] wordarray = new String[666];
			

		/**
		 * Say Hello
		 * 		 
		 */
		System.out.println("Hello!");
	
		/**
		 * ask user to enter file name
		 */
		System.out.println("Please enter a file name containing your deck:");
		filename = keyboard.next();
		
		/**
		 * create new file object
		 */
		File myFile = new File(filename);
		
		try
		{
			/**
			 * create scanner
			 */
			Scanner input = new Scanner(myFile);
			line = null;
			
			int i = 0;
		    while(input.hasNext())
		     {	
				
				/**
				 * Input into array 
				 */

				wordarray[i] = input.nextLine();
				
				i++;

		     }//while

			input.close();	

		}//try
		
		catch(FileNotFoundException ex)
	    {
	      System.out.println("Failed to find file: " + myFile.getAbsolutePath()); 
	    }//catch
	    catch(InputMismatchException ex)
	    {
	    	System.out.println("Type mismatch for the number I just tried to read.");
	        System.out.println(ex.getMessage());
	    }

	    catch(NullPointerException ex)
	    {
	      System.out.println("Null pointer exception.");
	      System.out.println(ex.getMessage());
	    }//catch
	    catch(Exception ex)
	    {
	    	System.out.println("Something went wrong");
	      ex.printStackTrace();
	    }//catch
		
		for(int i = 0; i < wordarray.length; i++){
			System.out.println(wordarray[i]);
			correctLine(wordarray[i]);
		}//for
		
		//splitPush(wordarray);
		
		}//main
	
		//split and push/enqueue

		//this method takes in one element of the array and make all letters
		//the same case and gets rid of spaces
		public static void correctLine(String line)
		{
			String statement = "none";
			String noSpaceStatement;

				statement = line.toLowerCase();
				noSpaceStatement = statement.replaceAll("\\s", "");
				System.out.println(noSpaceStatement);
				String[] charArray = noSpaceStatement.split("");
				//System.out.println(charArray);
				pushStack(charArray);

		}//correctline

		public static void pushStack(String[] chararray){

			StackCordoni theStack = new StackCordoni();

			for(int i = 0; i < chararray.length; i++){
			
				theStack.push(new NodeCordoni(chararray[i]));
				//System.out.println(theStack.push(new NodeCordoni(chararray[i])));
			}//for
			
		}//pushStack

		public static void enqueueQueue(String[] chararray){

			QueueCordoni theQueue = new QueueCordoni();

			for(int i = 0; i < chararray.length; i++){
			
				theQueue.enqueue(new NodeCordoni(chararray[i]));
				//System.out.println(theQueue.push(new NodeCordoni(chararray[i])));
			}//for
			
		}//pushStack

		public static void compare(){

			

			
			
		}//pushStack

}//MainCordoni
