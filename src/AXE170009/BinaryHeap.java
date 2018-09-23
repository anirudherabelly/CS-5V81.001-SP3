// Starter code for bounded-size Binary Heap implementation

package AXE170009;
import java.util.Comparator;
import java.util.Iterator;

public class BinaryHeap<T extends Comparable<? super T>> {
    T[] pq;
    Comparator<T> comp;
    private int size;
    private int capacity;

    /**
     * Constructor for building an empty priority queue using natural ordering of T
     * @param q array to store priority queue
     */
    public BinaryHeap(T[] q) {
    	// Use a lambda expression to create comparator from compareTo
	    this(q, (T a, T b) -> a.compareTo(b));
    }

    /**
     * Constructor for building an empty priority queue with custom comparator
     * @param q array to store priority queue
     * @param c comparator to specify ordering between elements
     */
    public BinaryHeap(T[] q, Comparator<T> c) {
	    pq = q;
	    comp = c;
	    capacity = q.length;
	    size = 0;
    }
    
    /** Build a priority queue with a given array q, using q[0..n-1].
     *  It is not necessary that n == q.length.
     *  Extra space available can be used to add new elements.
     *  Implement this if solving optional problem.  To be called from heap sort.
     */
    private BinaryHeap(T[] q, Comparator<T> c, int n) {
	    pq = q;
	    comp = c;
	    // You need to add more code here to build queue
    }

    /**
     * adds the new element to the priority queue
     * @param x element to be added
     * @throws UnsupportedOperationException when queue is full
     * @throws IllegalArgumentException when x is null
     */
    public void add(T x) {
        if(x == null){
            throw new IllegalArgumentException("Input element can't be null");
        }
        boolean isInserted = offer(x);
        if(!isInserted){
            throw new UnsupportedOperationException("Queue is full");
        }
    }

    /**
     * add a new element to the priority queue
     * @param x element to be added
     * @return returns false if pq is full or if x is empty, true otherwise
     */
    public boolean offer(T x) {
        if(x==null){
            return false;
        }
        if(size == capacity){
            return false;
        }
        pq[size] = x;
        percolateUp(size);
        size++;
        return true;
    }

    /**
     * removes and returns the top most element from the priority queue
     * @return element with the max priority of the queue
     * @throws UnsupportedOperationException when called on empty queue.
     */
    public T remove() { /* throw exception if pq is empty */
	    T returnVal = poll();
	    if(returnVal==null){
            throw new UnsupportedOperationException("Queue is empty");
        }
        return returnVal;
    }

    /**
     * removes and returns the top most element from the priority queue
     * @return element with the max priority of the queue or null is queue is empty
     */
    public T poll() {
        if(size==0){
            return null;
        }
        
        T returnVal = pq[0];
        if(size > 1) {
            pq[0] = pq[size - 1];
            percolateDown(0);
        }
        size--;
	    return returnVal;
    }

    /**
     * returns the top most element from the queue.
     * @return top most element of the heap or null if empty
     */
    public T peek() { /* return null if pq is empty */
        return size == 0 ? null : pq[0];
    }

    /**
     * pq[i] may violate heap order with parent.
     * This method rearranges the required elements in the heap so that order constraint is met
     * by sending the elements with higher priority to upper parts of the heap
     * @param index index from which structure has to be rearranged
     */
    private void percolateUp(int index) {
    	int parentIndex = parent(index);
        T temp = pq[index];
        
        while(index != 0 && comp.compare(pq[parentIndex], temp) > 0){
            pq[index] = pq[parentIndex];
            index = parentIndex;
            parentIndex = parent(index);
        }
        pq[index] = temp;
    }

    /**
     * pq[i] may violate heap order with children.
     * This method rearranges the required elements in the heap so that order constraint is met
     * by sending the elements with lower priority to bottom parts of the heap
     * @param index index from which structure has to be rearranged
     */
    private void percolateDown(int index) {
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        int temp = index;
        
        if(leftChildIndex < this.size && comp.compare(this.pq[index], this.pq[leftChildIndex]) > 0) {
        	temp = leftChildIndex;
        }
        if(rightChildIndex < this.size && comp.compare(this.pq[temp], this.pq[rightChildIndex]) > 0) {
        	temp = rightChildIndex;
        }
        
        if(temp != index) {
            swap(index, temp);
        	percolateDown(temp);
        }
    }

    /**
     * Assign x to pq[i].  Indexed heap will override this method
     */
    public void move(int index, T x) {
	    pq[index] = x;
    }

    /**
     * returns the index of parent of the element at given index
     * @return index of parent node
     */
    private int parent(int index) {
	    return (index - 1) / 2;
    }

    /**
     * returns the index of left child of the element at given index
     * @return index of left child
     */
    private int leftChild(int index) {
	    return 2 * index + 1;
    }

    /**
     * returns the index of left child of the element at given index
     * @return index of left child
     */
    private int rightChild(int index) {
    	return 2 * index + 2;
    }

    /**
     * Util function to swap elements
     */
    private void swap(int a, int b) {
    	T temp = pq[a];
    	pq[a] = pq[b];
    	pq[b] = temp;
    }
    // end of functions for team project



    // start of optional problem: heap sort (Q2)

    /** Create a heap.  Precondition: none. 
     *  Implement this if solving optional problem
     */
    void buildHeap() {
    }

    /** sort array arr[].
     * Sorted order depends on comparator used to buid heap.
     * min heap ==> descending order
     * max heap ==> ascending order
     * Implement this for optional problem
     */
    public static<T> void heapSort(T[] arr, Comparator<T> c) { /* to be implemented */

    }

    /** Sort array using natural ordering */
    public static<T extends Comparable<? super T>> void heapSort(T[] arr) {
	    heapSort(arr, (T a, T b) -> a.compareTo(b));
    }
    
    // end of optional problem: heap sort (Q2)



    // start of optional problem: kth largest element (Q3)
    
    /** TO DO.  Replaces root of binary heap by x if x has higher priority
     * (smaller) than root, and restore heap order.  Otherwise do nothing. 
     * This operation is used in finding largest k elements in a stream.
     * Implement this if solving optional problem.
     */
    public void replace(T x) {
		
    }

    /** Return the kth largest element of stream using custom comparator.
     *  Assume that k is small enough to fit in memory, but the stream is arbitrarily large.
     *  If stream has less than k elements return null.
     */
    public static<T extends Comparable<? super T>> T kthLargest(Iterator<T> stream, int k, Comparator<T> c) {
	    return null;
    }

    /** Return the kth largest element of stream using natural ordering.
     *  Assume that k is small enough to fit in memory, but the stream is arbitrarily large.   
     *  If stream has less than k elements return null.
     */
    public static<T extends Comparable<? super T>> T kthLargest(Iterator<T> stream, int k) {
    	return kthLargest(stream, k, (T a, T b) -> a.compareTo(b));
    }
    
    // end of optional problem: kth largest element (Q3)

}