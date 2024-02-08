public class Main {
    public static void main(String[] args) {

        // Working
        HugeInteger hi = new HugeInteger();
        System.out.println(hi);

        // Working
        HugeInteger hi1 = new HugeInteger("34545234");
        System.out.println(hi1);

        // Half working, removing 0's, not printing back to normal order
        HugeInteger hi2 = new HugeInteger("-2455434324344");
        System.out.println(hi2);

        // Working
        HugeInteger hi3 = new HugeInteger("000034545234");
        System.out.println(hi3);

        // Half working, printing
        HugeInteger hi4 = new HugeInteger("-00000002455434324344");
        System.out.println(hi4);

        // Works for test case given, unsure if its what we actually need.
        HugeInteger hi5 = new HugeInteger();
        System.out.println(hi5);
        hi5.concatenateDigit(3);
        System.out.println(hi5);

        /* ********** WILL BE USED TO TEST ***************
        // testing concatenate with a single digit
        HugeInteger hi5 = new HugeInteger();
        System.out.println(hi5);
        hi5.concatenateDigit(3);
        System.out.println(hi5);
        // testing add with two positive numbers
        HugeInteger hi6 = new HugeInteger("9");
        HugeInteger hi7 = new HugeInteger("6");
        HugeInteger hi8 = hi6.addPositive(hi7);
        System.out.println(hi6+" + "+hi7+" = "+hi8);
        HugeInteger hi9 = new HugeInteger("9996354");
        HugeInteger hi10 = new HugeInteger("4656");
        HugeInteger hi11 = hi9.addPositive(hi10);
        System.out.println(hi9+" + "+hi10+" = "+hi11);
        System.out.println(hi5.compareTo(hi4));
        System.out.println(hi2.compareTo(hi1));
         */

        /* SAMPLE OUTPUTS *\
        Sample output:
        0
        34545234
        -2455434324344
        34545234
        -2455434324344
        0
        3
        9 + 6 = 15
        9996354 + 4656 = 10001010
        1
        -1
         */

    }
}
