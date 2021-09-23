/** 
 * 
 * Assignment 1 <br>
 * Due Date and Time: 9/24/21 before 12:00am <br>
 * Purpose: This class creates the stack <br>
 * Input: A word/statement from the input file .<br>
 * Output: The program will push each letter of the word/statement into the Queue. <br>
 * Consults: I referenced GeeksforGeeks for some help on the enqueue method.
 * @author Shannon Cordoni <br>
 * 
 */
public class QueueCordoni {

	private NodeCordoni myHead;
	private NodeCordoni myTail;
	
	//This method adds a node to the queue, it does so by adding it to the end of the queue
	public void enqueue(String newword)
	{	
		//this moves the pointer that points to the last node on the list to 
		//now point to the new node added to the end of the queue
		NodeCordoni oldTail = new NodeCordoni(newword);
		
		//This checks to see if the queue is empty
		//if it is not empty then the next tail is set to the old tail
		//and then the tail is set to the old tail
		if (!isEmpty()){
			myTail.setNext(oldTail);
			myTail = oldTail;
			
		}//if

		//if the queue is empty then all variables are the same because there is nothing
		//in the queue. Then the head and tail pointer would be pointing to the same thing.
		else{
			myHead = myTail = oldTail;
		}//else

	}//enqueue
	
	//This method removes a node from the queue
	public NodeCordoni dequeue()
	{
		//This sets the temp variable to null so that it can be set later.
		NodeCordoni answer = null;
		
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
