public class HugeInteger {
    private boolean isPositive;
    private Node head;
    private Node tail;
    private int length;

    public HugeInteger() {
        isPositive = true;
        this.head = null;
        this.tail = null;
        length = 0;
    }

    public HugeInteger(String number) {
        String regEx = "^0";
        number = number.replaceAll(regEx, "");
        // take string input and convert/store in long type
        long numConvert = Long.parseLong(number);

        // takes remainder(number after decimal after calc is done)
        // stores it in num
        while (numConvert != 0) {
            long num = numConvert % 10;
            numConvert = numConvert / 10;

            // checks if linked list is null,
            // sets first extracted number (remainder) as head if true
            // when head exists, sets extracted number (remainder) as next node
            if (head == null) {
                head = new Node(num);
            }
            else
            {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(num);
            }
        }
    }

    public void addPositive(HugeInteger num2) {
        // returns new HugeInteger containing result of
        // adding num2 to stored number.
        // must assume num2 and number being added are BOTH positive
    }

    public int compareTo(HugeInteger num2) {
        // returns -1 if number stored is less than num2
        // returns 0 if number stored is equal to num2
        // returns 1 if number stored is greater than num2
        return 0; // !!placeholder to avoid error
    }

    @Override
    public String toString() {
        // returns string representation of number
        if(head == null){
            return "O";
        }
        StringBuilder ll = new StringBuilder();
        Node current = head;
        while (current != null){
            ll.insert(0, current.data);
            current = current.next;
        }
        return ll.toString();
    }

    public void concatenateDigit(int digit) {
        // adds digit to end of number (front of list)
        // if list is empty, leading zeros shouldn't be added
    }

    public void addLast(int digit) {
        // adds digit to front of number (end of list)
        // can be used in 'addPositive' method
    }
}
