package leetcode

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

/**
 * Note: This function performed better, and the only difference was that it used String builder.
 * Complexity: O(n) where n is total number of letters in the array.
 *
 * When coding the solution, I kept getting stuck, not because I didn't understand how to do the problem, but
 * more because I was trying to compare all strings with each other, which made the logic complicated.
 *
 * This solution I found thanks to Neetcode showed me trick! I don't need to compare each string with each other,
 * I can get away by comparing each string to the first string. This is because if A and C match B, then A matches C as well.
 * That makes the logic a lot simpler to code.
 */
fun longestCommonPrefix_v2(strs: Array<String>): String {
    val commonPrefix = StringBuilder()

    // We iterate across the first string because it actually doesn't matter which string we iterate across
    // as long as we traverse the entire string.
    for (index in 0..strs[0].lastIndex) {
        for (text in strs) {
            // If one of the strings has already ended, it's impossible for the prefix to get larger.
            if (index >= text.length) return commonPrefix.toString()

            // As soon as we find a character that doesn't match, the common prefix cannot get larger.
            if (text[index] != strs[0][index]) return commonPrefix.toString()
        }

        // If they all match, then append character to string builder.
        commonPrefix.append(strs[0][index])
    }

    return commonPrefix.toString()
}

/**
Input: array of strings.
Output: a string represent the common prefixes of each string.

for the first letter to be part of a common prefix, all words must have it.

we can check this by starting with a blank value.
and then iteratring through each letter to check if its good.

flower
flow
flight

dog
racecar
car

1. traverse through each index and check the letters there.
- (the tricky part is managing the lengths of each range without getting an array out of bound error.)

if the index exists in the string, compare with each string.
if not or the string doesn't match, we stop iterating.

 */
fun longestCommonPrefix_v1(strs: Array<String>): String {
    var commonPrefix = ""

    for (index in 0..strs[0].lastIndex) {
        for (text in strs) {
            if (index >= text.length) return commonPrefix
            if (text[index] != strs[0][index]) return commonPrefix
        }

        commonPrefix += strs[0][index]
    }

    return commonPrefix
}