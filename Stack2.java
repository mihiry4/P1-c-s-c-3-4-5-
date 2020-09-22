package Distribution.Part1;

/**
 * @author mihir yadav
 * Class: stack2.java
 */

public class Stack2<E>{

	private final int DEFAULT_CAPACITY = 10;
	private int capacity;
	private int top;
	private int count;
	private int incVal;
	E[] array;
	
	/*
	 * Stack2 constructor 
     *  |  Purpose:  sets capacity, marks top pointer and creates array
     *  |
     *  |  Parameters: int inc
     *  |      
     *  |  Returns: None
	 */
	public Stack2(int inc) {
		this.top = -1;
		this.incVal = inc;
		this.capacity = DEFAULT_CAPACITY;
		this.array = (E[]) new Object[capacity];
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
			int pushFlag = 1;
			this.resize(this.capacity + this.incVal);
		}
		this.count++;
		array[++top] = item;
		
		
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
		
		if(top < (this.capacity-2*this.incVal) &&(this.capacity - this.incVal >= 10)) {
			resize(this.capacity-this.incVal);
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
     *  |  Parameters: int incVal
     *  |      
     *  |  Returns: none
	 */
	private void resize(int incVal) {
		E[] newArray = (E[]) new Object[incVal];
        for(int i = 0; i <= this.top; i++) {
            newArray[i] = this.array[i];
            this.count++;
            this.count++;
        }
        this.array = newArray;
        this.capacity = incVal;
	}
	
}

