import java.io.*;
import java.util.*;

/**
 * Need to show unique lines only, therefore, the obvious choice would be implementing
 * a USet interface. This way, we avoid unnecessary memory usage. We can use the HashSet class.
 * The following operations are available to us:
 * 
*  size()
 * add(x)
 * remove(x)
 * find(x)
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Instantiation
            HashSet<String> mySet = new HashSet<String>();
            // Comes with methods addFirst addLast removeFirst removeLast
            File myFile = new File("text.txt");
            Scanner myScanner = new Scanner(myFile);

            // myScanner has the methods .hasNextLine() and .nextLine() the latter of which i can read to a string
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                if (mySet.contains(line)) {
                    System.out.println(line);
                }
                mySet.add(line);
            }
            // To ensure no mem. leak, close the scanner
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}