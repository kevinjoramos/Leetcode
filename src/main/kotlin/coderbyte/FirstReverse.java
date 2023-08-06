package coderbyte;


/**
 * Have the function FirstReverse(str) take the str parameter
 * being passed and return the string in reversed order. For example:
 * if the input string is "Hello World and Coders" then your program
 * should return the string sredoC dna dlroW olleH.
 *
 * Simple backwards for loop.
 */
public class FirstReverse {

    public static String firstReverse(String str) {
        // code goes here

        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }
}
