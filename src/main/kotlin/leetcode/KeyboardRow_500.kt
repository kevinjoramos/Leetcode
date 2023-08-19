package leetcode

/**
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 * Example 2:
 *
 * Input: words = ["omk"]
 * Output: []
 * Example 3:
 *
 * Input: words = ["adsdf","sfd"]
 * Output: ["adsdf","sfd"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] consists of English letters (both lowercase and uppercase).
 */

/**
 * Notes from attempt:
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 * Example 2:
 *
 * Input: words = ["omk"]
 * Output: []
 * Example 3:
 *
 * Input: words = ["adsdf","sfd"]
 * Output: ["adsdf","sfd"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] consists of English letters (both lowercase and uppercase).
 */

/**
 * This version follows the same logic as the v1, but I didn't know I could
 * put multiple values on the same conition block for a when statement, and was able
 * to remove the inner function call.
 *
 * According to leetcode, this beats 95.8 percent of speed for kotlin and beats 100% of users in memory for kotlin.
 */
fun findWords_v2(words: Array<String>): Array<String> =

    words.filter() { word ->
        var letterRow = when (word[0].toLowerCase()) {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' -> 1
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' -> 2
            else -> 3
        }

        var isWordOneRow = true

        word.fold(true) { acc, letter ->
            when (letter.toLowerCase()) {
                'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' -> {
                    if (letterRow != 1) {
                        isWordOneRow = false
                    }
                    letterRow = 1
                }
                'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' -> {
                    if (letterRow != 2) {
                        isWordOneRow = false
                    }
                }
                else -> {
                    if (letterRow != 3) {
                        isWordOneRow = false
                    }
                    letterRow = 3
                }
            }

            acc && isWordOneRow
        }

    }.toTypedArray()

fun findWords_v1(words: Array<String>): Array<String> {

    // we use sets for quick searching of letters in rows.
    val row1 = setOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')
    val row2 = setOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')

    // a helper function to help figure out what row a letter belongs to.
    fun determineRow(letter: Char): Int {

        if (row1.contains(letter)) {
            return 1
        }

        if (row2.contains(letter)) {
            return 2
        }

        return 3
    }

    return words.filter() { word ->
        var wordRow = determineRow(word[0].toLowerCase())

        word.fold(true) { acc, letter ->
            val letterRow = determineRow(letter.toLowerCase())

            if (wordRow != letterRow) {
                acc && false
            } else {
                acc
            }
        }

    }.toTypedArray()
}