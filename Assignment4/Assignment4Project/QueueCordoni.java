/** 
 * 
 * Assignment 1 
 * Due Date and Time: 9/24/21 before 12:00am 
 * Purpose: This class creates the stack 
 * Input: A word/statement from the input file .
 * Output: The program will push each letter of the word/statement into the Queue. 
 * @author Shannon Cordoni 
 * 
 */
public class QueueCordoni {

	private VertexCordoni myHead;
	private VertexCordoni myTail;
	
	//This method adds a node to the queue, it does so by adding it to the end of the queue
	public void enqueue(String newword)
	{	
		//this sets a temp variable to hold the current tail node
		VertexCordoni oldTail = myTail;

		//this sets the tail to be a new node and its data to be the new string
		myTail = new VertexCordoni();
		myTail.setId(newword);
		
		//This checks to see if the queue is empty
		//if it is not empty then the old tail is set to now point to the new Node
		if (!isEmpty()){
			oldTail.setNext(myTail);		
		}//if

		//if the queue is empty then all variables are the same because there is nothing
		//in the queue. Then the head and tail pointer would be pointing to the same thing.
		else{
			myHead = myTail;
		}//else

	}//enqueue
	
	//This method removes a node from the queue
	public VertexCordoni dequeue()
	{
		//This sets the temp variable to null so that it can be set later.
		VertexCordoni answer = null;
		
		//If the queue is not empty then it will remove the first node from the queue
		if(!isEmpty())
		{
			//This sets the temp variable to the first node in the list and then sets
			//the new head pointer to the second node in the queue
			answer = myHead;
			myHead = myHead.getNext();
			
			//if the queue is empty then the head is null 
			if(isEmpty()){
				myHead = null;
			}//if
		}//if

		else{
			System.out.println("The Queue is empty");
		}
		return answer;
	}//dequeue
	
	//THis checks to see if the queue is empty
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
