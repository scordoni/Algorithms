
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
		WordCordoni word = null;
		StackCordoni stack = new StackCordoni();
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

				statement = input.next();

				wordarray[i] = statement;
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
		
		System.out.println(wordarray);
		
		splitPush(wordarray);
		
		}//main
	
		//split and push/enqueue
		public static void splitPush(String[] array)
		{
			String statement = "none";
			String noSpaceStatement;
			WordCordoni word = null;
			StackCordoni stack = new StackCordoni();
			int num = 0;

			for(int i = 0; i < array.length; i++){
				
				array[num] = statement;
				noSpaceStatement = statement.replaceAll("\\s", "");
				System.out.println(noSpaceStatement);
			
			}//for
			
			
			//String[] letters = noSpaceStatement.split("");
			//word = new WordCordoni();
			//stack.push(word);


		}//split and push

		
}//MainCordoni
