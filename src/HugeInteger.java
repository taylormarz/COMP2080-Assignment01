import org.w3c.dom.Node;
import java.util.LinkedList;

public class HugeInteger {
    private boolean isPositive;
    private Node head;
    private Node tail;
    private int length;

    public HugeInteger() {
        // Empty linked list is created
        // That is: isPositive must be set to true by default
        // Head and tail are set to null
        // If this variable is to be displayed, a '0' should be printed (zero not stored)
        // Length must be set to 0
        isPositive = true;
        head = null;
        tail = null;
        length = 0;
    }

    public HugeInteger(String number) {
        // Creates number from string with all leading zeros removed.
    }

    public void addPositive(HugeInteger num2) {
        // Returns new HugeInteger containing result of
        // adding num2 to stored number.
        // Must assume num2 and number being added are BOTH positive
    }

    public int compareTo(HugeInteger num2) {
        // Returns -1 if number stored is less than num2
        // Returns 0 if number stored is equal to num2
        // Returns 1 if number stored is greater than num2
        return 0;
    }

    public String toString() {
        // Returns string representation of number
        if (length == 0) {
            return "0";
        }
        return toString();
    }

    public void concatenateDigit(int digit) {
        // Adds digit to end of number (front of list)
        // If list is empty, leading zeros shouldn't be added
    }

    public void addLast(int digit) {
        // Adds digit to front of number (end of list)
        // Can be used in 'addPositive' method
    }
}
