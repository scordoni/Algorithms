
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

	//static StackCordoni theStack = new StackCordoni();
	//static QueueCordoni theQueue = new QueueCordoni();
	
	
	public static void main(String[] args) {

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
		QueueCordoni theQueue = new QueueCordoni();
		String[] wordarray = new String[666];
			

		/**
		 * create new file object
		 */
		File myFile = new File("magicitems.txt");
		
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
		
		//for(int i = 0; i < wordarray.length; i++){
			//System.out.println(wordarray);
			correctLine(wordarray);
		//}//for
		
		}//main
	

		//this method takes in one element of the array and make all letters
		//the same case and gets rid of spaces
		public static void correctLine( String[] wordarray)
		{
		
			//System.out.println(wordarray);
			String line = "none";
			String statement = "none";
			String noSpaceStatement;

			
			for(int i = 0; i<wordarray.length; i++){

				StackCordoni theStack = new StackCordoni();
				QueueCordoni theQueue = new QueueCordoni();

				//System.out.println(wordarray[i]);
				line = wordarray[i];
				statement = line.toLowerCase();
				noSpaceStatement = statement.replaceAll("\\s", "");
				//System.out.println(noSpaceStatement);
				String[] charArray = noSpaceStatement.split("");
				//System.out.println(charArray);

				pushStack(charArray, theStack);
				enqueueQueue(charArray, theQueue);
				compare(line, theStack, theQueue);
				
			}//for

		}//correctline

		public static void pushStack(String[] chararray, StackCordoni stack){

			for(int i = 0; i < chararray.length; i++){
			
				stack.push(chararray[i]);
				//System.out.println(chararray[i]);
			}//for
			
		}//pushStack

		public static void enqueueQueue(String[] chararray, QueueCordoni queue){

			for(int i = 0; i < chararray.length; i++){
			
				queue.enqueue(chararray[i]);
				//System.out.println(chararray[i]);
			}//for
			
		}//enqueueQueue

		public static void compare(String chararray, StackCordoni stack, QueueCordoni queue){

			NodeCordoni popVal;
			NodeCordoni dequeueVal;
			String valPop;
			String valDequeue;

			//pop
			popVal = stack.pop();
			valPop = popVal.getData();

			//dequeue
			dequeueVal = queue.dequeue();
			valDequeue = dequeueVal.getData();

			
			if(valPop.equals(valDequeue)){

				while((valPop.equals(valDequeue))&&(!(stack.isEmpty()))){
					popVal = stack.pop();
					valPop = popVal.getData();
					dequeueVal = queue.dequeue();
					valDequeue = dequeueVal.getData();
				}//while
				
				if(stack.isEmpty()){
					System.out.println(chararray);
				}//if
				
			}//if

		}//compare

}//MainCordoni
