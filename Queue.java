package Distribution.Part2;
/*
 * @author Mihir Yadav
 * 
 */
public class Queue<E> {
	
	/*
	 * Node Class
     *  |  Purpose:  defines body of a node in linked list
     *  |
     *  |  Parameters: None
     *  |      
     *  |  Returns: None
	 */
	
	class Node {
		
		E val;
		Node next;
		
		/*
		 * Node Constructor
	     *  |  Purpose:  sets value of elements inside a node
	     *  |
	     *  |  Parameters: None
	     *  |      
	     *  |  Returns: None
		 */
		public Node(E val) {
			this.val = val;
			this.next = null;
		}
	}

	// pointers 
	private Node front;
	private Node back;
	private int size = 0;
	
	/*
	 * Name: Queue constructor
     *  |  Purpose: Sets front and back pointer to null
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: none
	 */
	public Queue() {
		this.front = null;
		this.back = null;
	}
	
	/*
	 * Name: enqueue
     *  |  Purpose: Adds item to the back of the queue
     *  |
     *  |  Parameters: E item
     *  |      
     *  |  Returns:none
	 */
	void enqueue(E item) {
		Node temp = new Node(item);
		
		if (this.back == null) {
			this.front = temp;
			this.back = temp;
			size++;
			return;
		}
		this.back.next = temp;
		this.back = temp;
		size++;
		
	}
	
	/*
	 * Name: dequeue
     *  |  Purpose: removes item from front of the queue
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: E (value of the front node)
	 */
	E dequeue() throws EmptyQueueException{
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		Node temp = this.front;
		this.front = this.front.next;
		
		if (this.front == null) {
            this.back = null;
		}
		
		size--;
		return temp.val;
	}
	
	/*
	 * Name: isEmpty
     *  |  Purpose: checks if queue is empty
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: boolean (true or false)
	 */
	boolean isEmpty() {
		return (this.front == null);
		
	}
	
	/*
	 * Name: size
     *  |  Purpose: returns size of the queue
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: int
	 */
	int size() {
		return this.size;
	}
	
	/*
	 * Name: peek
     *  |  Purpose: returns the item at the front of queue without removing
     *  |
     *  |  Parameters:none
     *  |      
     *  |  Returns: E (value at front node)
	 */
	public E peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return this.front.val;
		
	}
	
	
}
