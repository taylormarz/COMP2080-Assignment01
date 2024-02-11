// Amanda Gurney,   101443253
// Taylor Martin,   100849882
// Ethan Sylvester, 101479568

public class HugeInteger {
    final private boolean isPositive;
    private Node head;
    private Node tail;
    final private int length;

    // Creating empty linked list
    public HugeInteger() {
        isPositive = true;
        this.head = null;
        this.tail = null;
        length = 0;
    }

    // Taking string parameter and converting to long type
    // Removing leading zeros, applying arithmetic operation to isolate remainder
    // Adding remainder to head or head.next (so list is in reverse order)
    public HugeInteger(String number) {
        isPositive = !number.startsWith("-");
        String regEx = "^0";
        number = number.replaceAll(regEx, "");
        length = number.length();
        long numConvert = Long.parseLong(number);

        while (numConvert != 0) {
            long num = numConvert % 10;
            numConvert = numConvert / 10;
            if (head == null) { head = new Node(num); }
            else {
                Node current = head;
                while (current.next != null) { current = current.next; }
                current.next = new Node(num);
            }
        }
    }

    // Adding parameter (num2) with stored number
    // Assuming they're both positive, creating a final new HugeInteger
    // object to hold the sum of the added numbers
    public HugeInteger addPositive(HugeInteger num2) {
        long integer1 = this.head.data, integer2 = num2.head.data;
        Node current = this.head, num2current = num2.head;
        long multiplier = 10;
        while (current.next != null || num2current.next != null) {
            if (current.next != null) {
                integer1 += (current.next.data * multiplier) ;
                current = current.next;
            }
            if (num2current.next != null) {
                integer2 += (num2current.next.data * multiplier);
                num2current = num2current.next;
            }
            multiplier *= 10;
        }
        String result = Long.toString(integer1 + integer2);
        return new HugeInteger(result);
    }

    // Comparing parameter (num2) with stored number
    // Returning -1, 1, and 0 if less than, greater than, or equal
    public int compareTo(HugeInteger num2) {
        // BASE CASES
        if (num2.isPositive && !this.isPositive) return -1;
        if (!num2.isPositive && this.isPositive) return 1;
        if (isPositive && num2.length > this.length) return -1;
        if (isPositive && num2.length < this.length) return 1;
        if (!isPositive && num2.length > this.length) return 1;
        if (!isPositive && num2.length < this.length) return -1;

        Node current = head;
        Node num2current =  num2.head;

        if (isPositive) {
            if (current.data > num2current.data) return 1;
            if (current.data < num2current.data) return -1;

            while (current.next != null) {
                if (num2current.data > current.data) return -1;
                if (num2current.data < current.data) return 1;
                num2current = num2current.next;
                current = current.next;
            }
        } else {
            if (num2current.data > current.data) return -1;
            if (num2current.data < current.data) return 1;

            while (current.next != null) {
                if (num2current.data < current.data) return -1;
                if (num2current.data > current.data) return 1;
                num2current = num2current.next;
                current = current.next;
            }
        }
        return 0;
    }

    // Overriding to string method to print object
    // Prints linked list back into original order from parameter
    // Regular expression removes additional '-' signs from
    // negative numbers stored in list if found
    @Override
    public String toString() {
        if(head == null){ return "O"; }
        StringBuilder ll = new StringBuilder();
        Node current = head;
        while (current != null){
            ll.insert(0, current.data);
            current = current.next;
        }
        String regEx = "(?<=\\d)-";
        return ll.toString().replaceAll(regEx, "");
    }

    // Concatenates digit added to stored number
    // Checks for a head, if found, previous pointer assigns
    // the new node to be new head
    public void concatenateDigit(int digit) {
        Node concatNode = new Node(digit);
        concatNode.next = head;
        if (head != null) {
            head.prev = concatNode;
        }
        head = concatNode;
    }

    // Adds new digit to end of list, beginning of stored number
    public void addLast(int digit) {
        Node addLastNode = new Node(digit);
        if(head == null){
            head = addLastNode;
            return; }
        tail = head;
        while(tail.next != null) { tail = tail.next; }
        tail.next = addLastNode;
    }
}
