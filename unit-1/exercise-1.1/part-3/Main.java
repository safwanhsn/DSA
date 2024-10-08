import java.io.*;
import java.util.*;

/**
 * We can use the same data structure, but we must ensure the conditions are met
 
    Because of this it makes more sense to implement the Deque interface.
 
    Only works after first 42 lines because in the initial steps, obviously there is no elem. that far ago
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Instantiation
            Deque<String> myDeque = new ArrayDeque<>();
            // Comes with methods addFirst addLast removeFirst removeLast
            File myFile = new File("text.txt");
            Scanner myScanner = new Scanner(myFile);
            int lineNum = 0;

            // myScanner has the methods .hasNextLine() and .nextLine() the latter of which i can read to a string
            while (myScanner.hasNextLine()) {
                lineNum += 1;
                String line = myScanner.nextLine();
                myDeque.addLast(line);

                // We can always removeFirst on the element to keep it within the size
                // yet still be able to access the 42 lines ago
                // We only want to start removing once we have hit the limit
                if (lineNum > 42) {
                    String lineToRemove = myDeque.removeFirst(); // We have to remove regardless
                    if (line.length() == 0) {
                        // But only display in this condition and we have the return val
                        System.out.println((lineToRemove));
                    }
                    // Technically we could also use get(index) using a different interface,
                    // but here it is clear we don't need to
                }
            }

            // To ensure no mem. leak, close the scanner
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}