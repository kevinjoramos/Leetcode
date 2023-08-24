package leetcode

/**
 * Given an array arr of integers, check if there exist two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * Example 2:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 500
 * -103 <= arr[i] <= 103
 */

/**
 * My notes from atempt:
 * Input: and array of integers
 *     Output: Boolean
 *         -true if there exists two indices where the value at one indice is double of the value at the other.
 *
 *
 *     Observations:
 *     - the indice with the double value can come before or after the other indice, there's no ordering there.
 *     - I could use a hashmap to store all the double values for quick checking.
 *
 *     1. build a set of each number.
 *     2. iterate through our array to check if that number's double is in that set.
 */

/**
 * In this solution, I made a set for checking if the double is there as we iterate through the arr.
 * However, what gave me difficulty was the number 0.
 */
fun checkIfExist(arr: IntArray): Boolean {

    val numberSet = arr.toSet()

    val zeroCount = arr.fold(0) { acc, number ->
        if (number == 0) acc + 1 else acc
    }

    if (zeroCount > 1) return true

    return arr.foldIndexed(false) { i, acc, number ->
        val doubleValue = number * 2
        if (numberSet.contains(doubleValue) && arr[i] != doubleValue) true else acc
    }

}