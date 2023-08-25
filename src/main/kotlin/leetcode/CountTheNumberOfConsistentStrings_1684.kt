package leetcode

/**
 * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 *
 *
 *
 * Example 1:
 *
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 * Example 2:
 *
 * Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * Output: 7
 * Explanation: All strings are consistent.
 * Example 3:
 *
 * Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * Output: 4
 * Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * The characters in allowed are distinct.
 * words[i] and allowed contain only lowercase English letters.
 */

/**
 * Notes from attempt:
 * Inputs:
 *             -String -> criteria for "consistency"
 *             -Array<String> -> the data.
 *
 *         Outputs:
 *             Integer -> representing th enumber of "consistent" strings.
 *
 *         Observations:
 *
 *         -A string is consistent if all its characters are only from set of characters in the allowed     string.
 *
 *         - the string doesn't need all of the allowed characters, it just needs to only use characters from allowed.
 *
 *     steps:
 *     1. create a character Set object from the allowed string
 *     2. iterate through each character in each word and check.
 *     3. if each character in a word belongs to the set, then we increment the counter.
 *     4. return the counter at the end.
 */

fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    val allowedSet = allowed.map { it }.toSet()

    return words.fold(0) {wordAcc, word ->

        val isConsistent = word.fold(true) {letterAcc, letter ->
            if (!allowedSet.contains(letter)) {
                false
            } else {
                letterAcc
            }
        }

        if (isConsistent) {
            wordAcc + 1
        } else {
            wordAcc
        }
    }
}