package leetcode

/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

/**
 * Notes from attempt:
 *     Input: a list of words, and a string containing a permutation of all lowercase letters.
 *
 *     Output: Boolean
 *         return true if first letter of each word is in order of the order string.
 *         return false otherise.
 *
 *         Observations:
 *         Lexographical ordering:
 *         1. if two words are equal length we compare the based of the first character i where two words don't match.
 *         2. if words have different sizes, we pad the smaller one with spaces at the end and use rule 1.
 *
 *
 *     Plan:
 *
 *     1. create a hashmap of ordered letter to index.
 *     2. iterate through each word, starting with index 1.
 *     3. compare with the word before it. (if it exists)
 *         FOR (index in 0.. word.lastIndex)
 *             if (map.find(previousWord[i] > map.find(currentWord))
 *                 return false
 */

/**
 * This is my solution, which didn't score well on leetcode. I'll have to come back later to make it better.
 */
fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val alphabet = order.mapIndexed() { index, letter -> letter to index }.toMap()

    if (words.size == 1) {
        return true
    }

    var previousWord = words[0]
    for (i in 1..words.lastIndex) {

        var hasDifferentPrefix = false
        for (j in 0..minOf(previousWord.lastIndex, words[i].lastIndex)) {
            if (alphabet[previousWord[j]]!! < alphabet[words[i][j]]!!) {
                hasDifferentPrefix = true
                break
            }

            if (alphabet[previousWord[j]]!! > alphabet[words[i][j]]!!) {
                return false
            }


        }

        if (!hasDifferentPrefix && (previousWord.length > words[i].length)) return false

        previousWord = words[i]
    }

    return true
}

