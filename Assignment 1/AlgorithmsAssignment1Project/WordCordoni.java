/** 
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * 
 * Purpose: This class creates the stack <br>
 * 
 * Input: A word/statement from the input file .<br>
 * 
 * Output: The program will push each letter of the word/statement into the stack. <br>
 *
 * @author Shannon Cordoni <br>
 * 
 */

 public class WordCordoni
{
	
	
	/**
	 * Instance Variable for item name, quantity and price <br>
	 */
	private String myWord;
	
	
	/**
	 * The default Constructor for ItemCordoni
	 */
	public WordCordoni()
		{
		myWord = "None";
		}//Word Cordoni
	
	/**
	 * the full constructor of ItemCordoni
	 * @param newWord the incoming word
	 */
	public WordCordoni(String newWord)
	{
		myWord = newWord;
	}//Word Cordoni
	
	/**
	 * The setter for the item name
	 * @param newWord The incoming Word
	 */
	public void setWord(String newWord)
		{myWord = newWord;} //set name

	/**
	 * The getter for the item name
	 * @return The incoming Word
	 */
	public String getWord()
		{return myWord;} //get name
	
	/**
	 * Text description of each song
	 */
	public String toString()
		{
			String result = "Statement: " + myWord;
			return result;
		}//to string	

}//Word Cordoni
