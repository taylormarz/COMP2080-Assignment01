public class Main {
    public static void main(String[] args) {

        // Working: Expected output = 0
        HugeInteger hi = new HugeInteger();
        System.out.println(hi);

        // Working: Expected output = 34545234
        HugeInteger hi1 = new HugeInteger("34545234");
        System.out.println(hi1);

        // Working: Expected output = -2455434324344
        HugeInteger hi2 = new HugeInteger("-2455434324344");
        System.out.println(hi2);

        // Working: Expected output = 34545234
        HugeInteger hi3 = new HugeInteger("000034545234");
        System.out.println(hi3);

        // Working: Expected output = -2455434324344
        HugeInteger hi4 = new HugeInteger("-00000002455434324344");
        System.out.println(hi4);

        // Working: Expected output = 0
        HugeInteger hi5 = new HugeInteger();
        System.out.println(hi5);

        // Working: Expected output = 3
        hi5.concatenateDigit(3);
        System.out.println(hi5);

        // Working: Expected output = 19
        // Adds digit to END of number, FRONT OF LIST
        HugeInteger hi6 = new HugeInteger("1");
        hi6.concatenateDigit(9);
        System.out.println(hi6);

        // Working: Expected output = 912345
        // Adds digit to FRONT of number, END of list
        HugeInteger hi7 = new HugeInteger("12345");
        hi7.addLast(9);
        System.out.println(hi7);

        // FOR TESTING ADD POSITIVE
        HugeInteger hi8 = new HugeInteger("9");
        HugeInteger hi9 = new HugeInteger("6");
        HugeInteger hi10 = hi8.addPositive(hi9);
        System.out.println(hi10); // Should print '15'

        HugeInteger hi11 = new HugeInteger("9996354");
        HugeInteger hi12 = new HugeInteger("4656");
        HugeInteger hi13 = hi11.addPositive(hi12);
        System.out.println(hi10); // Should print '10001010'

        HugeInteger hi14 = new HugeInteger("9996353");

        // NEED TO ADD OPTIONS TO TEST COMPARE TO METHOD
        System.out.println(hi11.compareTo(hi12));
        System.out.println(hi12.compareTo(hi11));
        System.out.println(hi11.compareTo(hi11));
        System.out.println(hi11.compareTo(hi14));
    }
}
