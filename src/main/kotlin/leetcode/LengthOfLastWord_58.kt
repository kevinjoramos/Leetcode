package leetcode

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */

/**
 * My Notes from working on the problem:
 *
 *     input: a string.
 *     ouput: the length of the last substring after a space character.
 *
 *     Observations:
 *     -there can be any number of consecutive spaces.
 *     -there can be spaces at the end.
 *
 *     1. We can iterate the string backwards (for loop.)
 *     2. Once we find letters, we start updating a length variable.
 *         Use a boolean variable and update it to true after reaching a letter.
 *     3. When we find the first space after letters (going backwards) we've finished counting.
 *         If we find a space and our bool is true then we found the space at the end.
 */

fun lengthOfLastWord(s: String): Int {

    var lastWordLength = 0

    // This variable simply allows us to ignore our exit condition if there are spaces at the end of the last word.
    var hasFoundLastWord = false

    // Gotta love Kotlin for including reversed() for strings as a BIF.
    // We iterate backwards so that way we know that the first group of letter we find is the last word.
    for (letter in s.reversed()) {

        if (letter.isLetter()) {
            hasFoundLastWord = true
            lastWordLength++
        } else if (hasFoundLastWord) {
            break
        }
    }

    return lastWordLength
}