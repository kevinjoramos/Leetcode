package coderbyte;
import java.util.*;
import java.io.*;


/**
 * Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:
 *
 * 1. The username is between 4 and 25 characters.
 * 2. It must start with a letter.
 * 3. It can only contain letters, numbers, and the underscore character.
 * 4. It cannot end with an underscore character.
 *
 * If the username is valid then your program should return the string true, otherwise return the string false.
 */
public class CodelandUsernameValidation {
    public static String codelandUsernameValidation(String str) {
        // code goes here

        String result = "true";

        // return false and exit if str is empty.
        if (str.length() == 0) {
            return "false";
        }

        // 1. The username is between 4 and 25 characters.
        if (str.length() < 4 || str.length() > 25) {
            result = "false";
        }

        // 2. It must start with a letter.
        if (!Character.isLetter(str.charAt(0))) {
            result = "false";
        }

        // 4. It cannot end with an underscore character.
        if (str.charAt(str.length() - 1) == '_') {
            result = "false";
        }

        // 3. It can only contain letters, numbers, and the underscore character.
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c) && c != '_') {
                result = "false";
            }
        }

        return result;
    }
}
