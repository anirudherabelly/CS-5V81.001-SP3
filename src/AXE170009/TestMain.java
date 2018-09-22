package AXE170009;
//Created by Kautil & Anirudh on 09/17/2018.

/**
 * This is a driver class that essentially runs tests (like a JUnit test class).
 * Motivation to write such a class is to eliminate adding JUnit or TestNG dependency.
 *
 * To add a new test case,
 * 1.Create a test function.
 * 2.Call the test function from main.
 * @author Kautil & Anirudh
 */
public class TestMain {
    /**
     * the Main here runs the individual test functions.
     * @param args this argument is added just to maintain consistency with java spec.
     */
    public static void main(String[] args) {
        try {
            assert false;
            System.out.println("Please use the -ea jvm-option. Ex: java -ea pxs176230.TestMain");
            System.exit(0);
        }catch (AssertionError error){
            System.out.println("-ea option enabled good to go");
        }
        TestMain tester = new TestMain();
        tester.testAdd();
        tester.testRemove();
        System.out.println("All Tests passed");
    }

    private void testAdd() {
        Integer[] q = new Integer[4];
        BinaryHeap<Integer> heap = new BinaryHeap<>(q);
        heap.add(0);
        assert heap.peek()==0;
        heap.add(5);
        assert heap.peek()==0;
        heap.add(2);
        assert heap.peek()==0;
        heap.add(-2);
        assert heap.peek()==-2;
        checkException(()->heap.add(1),UnsupportedOperationException.class);
        boolean inserted = heap.offer(1);
        assert !inserted;
    }
    
    private void testRemove() {
        Integer[] q = new Integer[4];
        BinaryHeap<Integer> heap = new BinaryHeap<>(q);
        heap.add(2);
        heap.add(-2);
        int removed = heap.remove();
        assert removed == -2;
        heap.add(0);
        heap.add(5);
        removed = heap.remove();
        assert removed == 0;
        heap.add(-3);
        heap.add(3);
        removed = heap.remove();
        assert removed == -3;
        removed = heap.remove();
        assert removed == 2;
        removed = heap.remove();
        assert removed == 3;
        removed = heap.remove();
        assert removed == 5;
        checkException(()->heap.remove(),UnsupportedOperationException.class);
    }
    /**
     * Runs the given function inside a try-catch block to capture and assert that NoSuchElementException is raised
     * @param function function that needs to be run inside the try block
     * @param expectedEx the class type the function should throw
     */
    private void checkException(Runnable function, Class<?> expectedEx){
        try {
            function.run();
            assert false;
        }catch (Exception e){
            assert e.getClass() == expectedEx;
        }
    }
}
