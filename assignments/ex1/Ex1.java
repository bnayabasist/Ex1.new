

    package



            assignments.ex1;

    /**
     * This class represents a simple solution for Ex1.
     * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
     * In this assignment, we will design a number formatting converter and calculator.
     * In general, we will use Strings as numbers over basis of binary till Hexa.
     * [2-16], 10-16 are represented by A,B,..G.
     * The general representation of the numbers is as a String with the following format:
     * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
     * The following are NOT in the format (not a valid number):
     * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
     * You should implement the following static functions:
     */
    public class Ex1 {

        public static void main(String[] args) {
        // good: "1", "1b2", "01b2", "123bA", "ABbG", "0bA"
            //bad:"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"
            //suppose bad: " BbG","abB",

            if (isNumber(" BbG")) {
            System.out.println("GOOD");
        }
        else System.out.println("BAD");
        }

        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param //num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String str) {
            boolean isNum = true;
                for (int i = 0; i<str.length(); i++){
                    int ch = str.charAt(i);
                    if(ch<48 || ch > 57){
                        isNum=false;
                    }
                }


            if (str == null || str.isEmpty() || !isNumber(str)) {
                return -1; // Invalid input
            }

            // If no 'b' is present, assume base 10
            if (!str.contains("b")) {
                str += "b10";
            }


            //split the string for 2 parts- before b and after b and convert them
            String[] parts = str.split("b");
            String number = parts[0].toUpperCase();
            int base = 0;
            for (char c : parts[1].toCharArray()) {
                base = base * 10 + (Character.isDigit(c) ? c - '0' : c - 'A' + 10);
            }

            if (base < 2 || base > 16) {
                return -1; // Invalid base
            }

            // Convert the number string to decimal platform
            int num = 0;
            int power = 1;
            for (int i = number.length() - 1; i >= 0; i--) {
                char digit = number.charAt(i);
                int value = Character.isDigit(digit) ? digit - '0' : digit - 'A' + 10;
                if (value >= base) {
                    return -1; // Invalid digit for the base
                }

                num += value * power;
                power *= base;
            }



            return num;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            //boolean ans = true;
            a = a.trim();
            if (a == null || a.isEmpty()) { // if number is empty or not reffering to any object or without b return false
                return false;
            }
            if (!a.contains("b")) {
                a += "bA";
            }
            int Indexb = a.indexOf('b');
            if (Indexb == -1) {
                return a.matches("[0-9A-Ga-g]+"); // No "b", check as base-10 by default
            }
            if (Indexb == 0 || Indexb == a.length() - 1) {
                return false; // "b" at invalid position
            }
            String numPart = a.substring(0, Indexb).toUpperCase();
            String baseStr = a.substring(Indexb + 1).toUpperCase();

            // Validate the base
            if (!baseStr.matches("[2-9A-G]")) {
                return false;
            }
            if (!numPart.matches("[0-9A-G]+")) { // Ensure valid characters
                return false;
            }

            // validate base checking
            int base = 0;
            for (char c : baseStr.toCharArray()) {
                base = base * 10 + (Character.isDigit(c) ? c - '0' : c - 'A' + 10);

            }
            if (base < 2 || base > 16) {
                return false;
            }

            // check the number part before b

//            if (!numPart.matches(".*\\d.*")) { // Ensure there's at least one digit
//                return false;
//            }
            for (char c : numPart.toCharArray()) {
                int digitValue = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
                if (digitValue >= base) {
                    return false;
                }


            }

            return true;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            if (num < 0){
                return "";
            }
            if (base < 2 || base > 16) {
            return "";
            }
            char[] customDigits = {
                    'A', // 10
                    'B', // 11
                    'C', // 12
                    'D', // 13
                    'E', // 14
                    'F', // 15
                    'G'  // 16
            };
            StringBuilder str = new StringBuilder();
            while (num > 0) {
                int mod = num % base;
                char ch;
                if (mod < 10){
                    ch = (char) + ('0' + mod);
                }else {
                    ch = customDigits[mod - 10]; // for 10-15
                }
                str.insert(0, ch); // add number to beginning of string from last to first
                num /= base; // divide number in base


            }
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {

            int num1 = number2Int(n1);
            int num2 = number2Int(n2);
            if (num1 == num2) {
                return true;
            }
            return number2Int(n1) == number2Int(n2);
        }


        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;

            int[] Numbers = {}
            // add your code here

            ////////////////////
            return ans;





        }
//        public static int NormalNum(String S){
//            int NewNum = Integer.parseInt(S);
//            System.out.println("num1" + " = );
////            System.out.print( " , value: " + S);
//
//
//            return NewNum;

//        public static int BaseCheck(String str){
//          if(str == null ||str.isEmpty()|| str.equals("") || str.length() >1){
//              return -1;
//          }
//          if (str.charAt(0) == 48 || str.charAt(0) == 49 ){
//              return -1;
//            }
//          if (str.charAt(0) >= 50 && str.charAt(0) <= 57){
//              return Integer.parseInt(str);
//          }
//          if (str.charAt(0) >= 65 && str.charAt(0) <= 71){
//              String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
//
//              for (int i = 0; i<letters.length; i++ ){
//                  if (letters[i].equals(str)){
//                      return i + 10;
//                  }
//              }
//
//          }
//          return  -1;
//        }

        }





