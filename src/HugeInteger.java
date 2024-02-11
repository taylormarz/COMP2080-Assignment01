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

    public HugeInteger addPositive(HugeInteger num2) {
        // returns new HugeInteger containing result of
        // adding num2 to stored number.
        // must assume num2 and number being added are BOTH positive
        // Add Positive to be used here

        // NOTE: I THINK LENGTH AND ISPOSTIVE CAN BE USED HERE
        return new HugeInteger(); // !!PLACE HOLDER TO AVOID ERROR
    }

    public int compareTo(HugeInteger num2) {
        System.out.println();
        if (num2.length > this.length) return -1;
        if (num2.length < this.length) return 1;

        Node current = head;
        Node num2current =  num2.head;
        while (current.next != null) {
            if (num2current.data > current.data) return -1;
            if (num2current.data < current.data) return 1;
            num2current = num2current.next;
            current = current.next;
        }
        return 0;
    }

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

    public void concatenateDigit(int digit) {
        Node concatNode = new Node(digit);
        concatNode.next = head;
        head = concatNode;
    }

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
