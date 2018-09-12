package AXE170009;
//Created by Kautil & Anirudh on 08/25/2018.

import java.util.NoSuchElementException;

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
        System.out.println("All Tests passed");
    }

    /**
     * Runs the given function inside a try-catch block to capture and assert that NoSuchElementException is raised
     * @param function function that needs to be run inside the try block
     */
    private void checkNoSuchElementException(Runnable function){
        try {
            function.run();
            assert false;
        }catch (Exception e){
            assert e instanceof NoSuchElementException;
        }
    }
}
