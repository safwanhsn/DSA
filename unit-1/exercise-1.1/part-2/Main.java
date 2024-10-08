import java.io.*;
import java.util.*;

/**
 * The difference between this question and the last question is that
 * it will be helpful to have an operation to be able to access the data structure by index.
 * It will be good to use an implementation of the List interface.
 * 
 * With that being said, the Stack class does implement the List interface.
 * But we can make use of the added operations.
 * 
 * We also know the size from beforehand and it is fixed so
 * we can take that into account when initializing the object/instance
 * 
 * NOTE: (https://www.geeksforgeeks.org/stack-class-in-java/)
 * The Stack class in Java is a legacy class and inherits from Vector in Java. It is a thread-safe class and hence involves overhead when we do not need thread safety. It is recommended to use ArrayDeque for stack implementation as it is more efficient in a single-threaded environment.
 * 
 * The two approaches seem to be
 * 1) Iteration
 * 2) Reading only 50 lines at a time (preferred by the question)
 * 
 * To do the latter, I can simply go line by line and use some sort of tracker variable (lineNum)
 * 
 * Reflection:
 * We were able to accomplish without using index elements by strategically using Stack and a tracking variable.
 * The approach I used makes sense because the structure never holds more than 50 lines
 * and we have not learned yet about array-based lists and accessing ranges using index positions.
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Instantiation stack
            Stack<String> myStack = new Stack<String>();
            File myFile = new File("text.txt");
            Scanner myScanner = new Scanner(myFile);
            int lineNum = 0;

            for (int i = 0; i < 2; i++) {
                // myScanner has the methods .hasNextLine() and .nextLine() the latter of which i can read to a string
                while (myScanner.hasNextLine() && lineNum < 50) {
                    myStack.push(myScanner.nextLine());
                    // Don't forget to iterate lineNum
                    lineNum += 1;
                }
                // Now we can return the values
                while (!myStack.empty()) {
                    System.out.println(myStack.pop());
                }
                lineNum = 0;
            }
            // To ensure no mem. leak, close the scanner
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}