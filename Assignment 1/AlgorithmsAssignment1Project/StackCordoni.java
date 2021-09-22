/** 
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * Purpose: This class creates the stack <br>
 * Input: The user will be inputting a word.<br>
 * Output: The program will push each letter of the word into the stack. <br>
 * @author Shannon Cordoni <br>
 * 
 */
public class StackCordoni {

	private NodeCordoni myTop = null;
	private String myData;
	
	//This method takes in a new word or letter and pushes it into the stack
	public  void push(String newword)
	{
		NodeCordoni oldTop = myTop;
		myTop = new NodeCordoni();
		myTop.setData(newword);
		myTop.setNext(oldTop);
	
	}//push
	
	//This method removes a letter from the stack and returns it
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
	
	//This method checks whether or not the stack is empty
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
