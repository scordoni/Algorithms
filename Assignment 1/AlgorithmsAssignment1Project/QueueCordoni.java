/** 
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * 
 * Purpose: This class creates the stack <br>
 * 
 * Input: A word/statement from the input file .<br>
 * 
 * Output: The program will push each letter of the word/statement into the Queue. <br>
 *
 * @author Shannon Cordoni <br>
 * 
 */
public class QueueCordoni {

	public static final int MAXSIZE = 100;
	private MainCordoni[] myWord;
	private int myTop;
	
	public QueueCordoni()
	{
		myWord = new MainCordoni[MAXSIZE];
		for (int i = 0; i < MAXSIZE;i++)
			myWord[i]=null;
		myTop = -1;
	}//StackCordoni

	public boolean enqueue(MainCordoni newword)
	{
		boolean success = false;
		if(!isFull())
		{
			success = true;
			myTop++;
			myWord[myTop]=newword;
		}//if
		
		return success;		
	}//enqueue
	
	public MainCordoni dequeue()
	{
		MainCordoni answer = null;
		
		if(!isEmpty())
		{
			int i = 0;
			answer = myWord[i];
			myTop++;
		}//if
		return answer;
	}//dequeue
	
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

}//QueueCordoni
