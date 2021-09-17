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
public class StackCordoni {

	//public static final int MAXSIZE = 100;
	//private NodeCordoni[] myWord;
	private NodeCordoni myTop = null;
	private String myData;
	
	/*
	public StackCordoni()
	{
		myWord = new NodeCordoni[MAXSIZE];
		for (int i = 0; i < MAXSIZE;i++)
			myWord[i]=null;
		myTop = -1;
	}//StackCordoni
	*/

	public  void push(String newword)
	{
		NodeCordoni oldTop = myTop;
		myTop = new NodeCordoni();
		myTop.setData(newword);
		myTop.setNext(oldTop);
	
	}//push
	
	public NodeCordoni pop()
	{
		NodeCordoni answer = null;
		if(!isEmpty())
		{
			answer = myTop;
			myTop = myTop.getNext();
		}//if

		else{
			System.out.println("The stack is empty");
		}

		return answer;
	}//pop
	
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(myTop == null)
			{
			empty = true;
			}//if
		return empty;
	}//empty

}//Stackcordoni
