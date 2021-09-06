/**
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * 
 * Purpose: This class creates the stack <br>
 * 
 * Input: The user will be inputting a word.<br>
 * 
 * Output: The program will push each letter of the word into the stack. <br>
 *
 * @author Shannon Cordoni <br>
 * 
 */
public class Stack {

	public static final int MAXSIZE = 100;
	private AlgorithmsAssignment1[] myWord;
	private int myTop;
	
	public Stack()
	{
		myWord = new AlgorithmsAssignment1[MAXSIZE];
		for (int i = 0; i < MAXSIZE;i++)
			myWord[i]=null;
		myTop = -1;
	}//StackCordoni
	
	public boolean push(AlgorithmsAssignment1 newword)
	{
		boolean success = false;
		if(!isFull())
		{
			success = true;
			myTop++;
			myWord[myTop]=newword;
		}//if
		
		return success;		
	}//push
	
	public AlgorithmsAssignment1 pop()
	{
		AlgorithmsAssignment1 answer = null;
		if(!isEmpty())
		{
			answer = myWord[myTop];
			myTop--;
		}//if
		return answer;
	}//pop
	
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(myTop == -1)
			{
			empty = true;
			}//if
		return empty;
	}//empty
	
	public boolean isFull()
	{
		boolean full = false;
		
		if(myTop == myWord.length)
			{
			full = true;
			}//if 
		
		return full;
	}//full

}
