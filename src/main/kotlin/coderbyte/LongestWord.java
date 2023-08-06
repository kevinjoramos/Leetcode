package coderbyte;


/**
 * Have the function LongestWord(sen) take the sen parameter being passed and
 * return the longest word in the string. If there are two or more words that
 * are the same length, return the first word from the string with that length.
 * Ignore punctuation and assume sen will not be empty. Words may also contain
 * numbers, for example "Hello world123 567"
 *
 * This is my solution and I believe it is O(n). I simply iterate the string
 * and update the longest word meanwhile. This works by interpreting non-alphanumeric
 * characters as the end of a word.
 */
public class LongestWord {

    public static String longestWord(String sen) {
        // code goes here

        int currentSize = 0;
        int currentLongestSize = 0;
        StringBuilder currentWord = new StringBuilder();
        String longestWord = "";
        // seperate string into words with only alphanumeric characters.

        for (char c : sen.toCharArray()) {

            if (Character.isLetter(c) || Character.isDigit(c)) {

                currentWord.append(c);
                currentSize++;

            } else {

                if (currentSize > currentLongestSize) {

                    currentLongestSize = currentSize;
                    longestWord = currentWord.toString();

                }

                currentWord.replace(0, currentWord.length(), "");
                currentSize = 0;

            }
        }

        if (currentLongestSize < currentWord.length()) {
            longestWord = currentWord.toString();
        }

        return longestWord;
    }
}
