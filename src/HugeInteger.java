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
        if (number.startsWith("-")) isPositive = false;
        else isPositive = true;
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
