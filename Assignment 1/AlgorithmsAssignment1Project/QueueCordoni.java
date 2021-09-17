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

	//public static final int MAXSIZE = 100;
	//private NodeCordoni[] myWord;
	//private int myTop;

	private NodeCordoni myHead;
	private NodeCordoni myTail;
	
	/*
	public QueueCordoni()
	{
		myWord = new NodeCordoni[MAXSIZE];
		for (int i = 0; i < MAXSIZE;i++)
			myWord[i]=null;
		myTop = -1;
	}//StackCordoni
	*/

	public void enqueue(String newword)
	{
		
		NodeCordoni oldTail = new NodeCordoni(newword);
		
		
		if (!isEmpty()){
			myTail.setNext(oldTail);
			myTail = oldTail;
			
		}//if

		else{
			myHead = myTail = oldTail;
		}//else

	}//enqueue
	
	public NodeCordoni dequeue()
	{
		NodeCordoni answer = null;
		
		if(!isEmpty())
		{
			answer = myHead;
			myHead = myHead.getNext();
			
			if(isEmpty()){
				myHead = null;
			}//if
		}//if

		else{
			System.out.println("The Queue is empty");
		}
		return answer;
	}//dequeue
	
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(myHead == null)
			{
			empty = true;
			}//if
		return empty;
	}//empty
	
}//QueueCordoni
