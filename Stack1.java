package Distribution.Part1;

/**
 * @author mihir yadav
 * Class : stack1.java
 */

public class Stack1<E>{

	
	private final int DEFAULT_CAPACITY = 10;
	private int capacity;
	private int top;
	private int count; // counts array accesses
	E[] array;
	
	/*
	 * Stack1 constructor 
     *  |  Purpose:  sets capacity, marks top pointer and creates array
     *  |
     *  |  Parameters: None
     *  |      
     *  |  Returns: None
	 */
	public Stack1() {
		this.capacity = DEFAULT_CAPACITY;
		this.top = -1;
		this.array = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	/*
	 * Name: push
     *  |  Purpose:  pushes element on to stack and resizes if stack is full
     *  |
     *  |  Parameters: E item
     *  |      
     *  |  Returns: none
	 */
	void push(E item) {
		if (top == capacity - 1) {
			this.resize(2* capacity);
		}
		array[++top] = item;
		this.count++;
		
	}
	
	/*
	 * Name: pop (throws exception)
     *  |  Purpose:  pops top element out of stack
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: E item
	 */
	E pop() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		this.count++;
		E retval = this.array[top];
		this.array[top] = null;
		if(top < Math.floor(capacity/4) && Math.floor(capacity/2) >= 10) {
			resize(capacity/2);
		}
		top--;
		return retval;
		
	}
	
	/*
	 * Name: isEmpty
     *  |  Purpose: checks if stack is empty 
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: boolean true if stack is empty
	 */
	boolean isEmpty() {
		if (this.top == -1) {
			return true;
		}
		return false;
	}
	
	/*
	 * Name: size
     *  |  Purpose:  checks size of stack
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: number of elements in stack
	 */
	int size() {
		return this.top+1;
	}
	
	/*
	 * Name: peek (throws exception)
     *  |  Purpose:  peek an element. get top element without removing it
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: top element
	 */
	E peek() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		this.count++;
		return this.array[top];
	}
	
	/*
	 * Name: getArray
     *  |  Purpose:  get the stack
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: E[] array
	 */
	E[] getArray() {
		return this.array;
	}
	
	/*
	 * Name: getCount
     *  |  Purpose: gets number of array accesses
     *  |
     *  |  Parameters: none
     *  |      
     *  |  Returns: int
	 */
	int getCount() {
		return this.count;
	}
	
	/*
	 * Name: resize
     *  |  Purpose:  to resize the array 
     *  |
     *  |  Parameters: int max
     *  |      
     *  |  Returns: none
	 */
	private void resize(int max) {
		E[] newArray = (E[]) new Object[max];
        for(int i = 0; i <= this.top; i++) {
            newArray[i] = this.array[i];
            this.count++;
            this.count++;
        }
        this.array = newArray;
        this.capacity = max;
	}
	
}

