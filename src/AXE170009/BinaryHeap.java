// Starter code for bounded-size Binary Heap implementation

package AXE170009;
import java.util.Comparator;
import java.util.Iterator;

public class BinaryHeap<T extends Comparable<? super T>> {
    T[] pq;
    Comparator<T> comp;
    private int size;
    private int capacity;
    // Constructor for building an empty priority queue using natural ordering of T

    public BinaryHeap(T[] q) {
	// Use a lambda expression to create comparator from compareTo
	    this(q, (T a, T b) -> a.compareTo(b));
    }

    // Constructor for building an empty priority queue with custom comparator
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

    public void add(T x) { /* throw exception if pq is full */
        boolean inserted = offer(x);
        if(!inserted){
            throw new UnsupportedOperationException("Queue full");
        }
    }

    public boolean offer(T x) { /* return false if pq is full */
        if(size==capacity){
            return false;
        }
        pq[size] = x;
        percolateUp(size);
        ++size;
        return true;
    }

    public T remove() { /* throw exception if pq is empty */
	    return poll();
    }

    public T poll() { /* return null if pq is empty */
        if(size==0){
            throw new UnsupportedOperationException("Queue is empty");
        }
        T returnVal = pq[0];
        if(size>1) {
            pq[0] = pq[size - 1];
            percolateDown(0);
        }
        --size;
	    return returnVal;
    }

    /**
        * return null if pq is empty
     */
    public T peek() {
        return size==0?null:pq[0];
    }

    /** pq[i] may violate heap order with parent */
    void percolateUp(int i) { /* to be implemented */
        int parent = parent(i);
        T temp = pq[i];
        while(i!=0&&comp.compare(pq[parent],temp)>0){
            pq[i] = pq[parent];
            i=parent;
            parent = parent(i);
        }
        pq[i] = temp;
    }

    /** pq[i] may violate heap order with children */
    void percolateDown(int i) {
        int leftChild = leftChild(i);
        while(true){

            if()
        }

    }

    // Assign x to pq[i].  Indexed heap will override this method
    void move(int i, T x) {
	    pq[i] = x;
    }

    int parent(int i) {
	    return (i-1)/2;
    }

    int leftChild(int i) {
	    return 2*i + 1;
    }

// end of functions for team project




// start of optional problem: heap sort (Q2)

    /** Create a heap.  Precondition: none. 
     *  Implement this ifsolving optional problem
     */
    void buildHeap() {
    }

    /* sort array arr[].
       Sorted order depends on comparator used to buid heap.
       min heap ==> descending order
       max heap ==> ascending order
       Implement this for optional problem
     */
    public static<T> void heapSort(T[] arr, Comparator<T> c) { /* to be implemented */

    }

    // Sort array using natural ordering
    public static<T extends Comparable<? super T>> void heapSort(T[] arr) {
	    heapSort(arr, (T a, T b) -> a.compareTo(b));
    }
    // end of optional problem: heap sort (Q2)



    // start of optional problem: kth largest element (Q3)

    public void replace(T x) {
	/* TO DO.  Replaces root of binary heap by x if x has higher priority
	     (smaller) than root, and restore heap order.  Otherwise do nothing. 
	   This operation is used in finding largest k elements in a stream.
	   Implement this if solving optional problem.
	 */
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