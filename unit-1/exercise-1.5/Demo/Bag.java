/**
 * Using Uset interface, Bag implementation
 * 
 * There is an alternative way if we think a little abstractly
 * away from the question description. We can technically just keep a "count"
 * of the elements as the value of the key, which is easier to implement.
 * And we can still do the same operations. (since its based on the Uset, we don't actually
 * need to store the elements individually).
 * 
 * Also think about it like this, a normal USet contains <Key, CONSTANT>. So our bag, can simply be
 * <Key, COUNT> and extend that functionality.
 */

 package Demo;

 // Imports
import java.util.*;

public class Bag {
    private transient HashMap<Integer, String> bag;
    public Bag() {
        // Constructor: Creating internally backing USet (HashSet) obj
        bag = new HashMap<>();
    }

    // Method: add(x)
    // Why use override decorator
    // @Override
    public void add(String x) {
        // Use size to determine the key
        int key = bag.size();
        bag.put(key, x);
    }

    public void remove(String x) {
        if (bag.containsValue(x)) {
            // Using an iterator to safely remove entries
            Iterator<Map.Entry<Integer, String>> iterator = bag.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                if (entry.getValue().equals(x)) {
                    iterator.remove(); // Safe removal
                }
            }
        }
    }

    public void showAll() {
        for (Map.Entry<Integer, String> entry : bag.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public String find(String x) {
        if (bag.containsValue(x)) { return x; }
        else { return null; }
    }
}
