import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * The appropriate interface to implement for this problem is likely
 * a stack (LIFO queuing discipline). The following 2 operations are defined:
 *  push(x)
 *  pop()
 * From the textbook, we know that the List interface has all the functionality
 * of the queue, stack, and deck interfaces and essentially subsumes them
 * 
 * Thus, let's use the Stack implementation (class from java.util) and use the following methods:
 *  push(e)
 *  pop()
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize stack
            Stack<String> myStack = new Stack<String>();
            File myFile = new File("text.txt");
            Scanner myScanner = new Scanner(myFile);
            // myScanner has the methods .hasNextLine() and .nextLine() the latter of which i can read to a string
            while (myScanner.hasNextLine()) {
                myStack.push(myScanner.nextLine());
            }
            // Now we can return the values
            while (!myStack.empty()) {
                System.out.println(myStack.pop());
            }
            // To ensure no mem. leak, close the scanner
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}