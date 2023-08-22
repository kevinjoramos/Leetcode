package leetcode

/**
 * There is a programming language with only four operations and one variable X:
 *
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 *
 * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 *
 *
 *
 * Example 1:
 *
 * Input: operations = ["--X","X++","X++"]
 * Output: 1
 * Explanation: The operations are performed as follows:
 * Initially, X = 0.
 * --X: X is decremented by 1, X =  0 - 1 = -1.
 * X++: X is incremented by 1, X = -1 + 1 =  0.
 * X++: X is incremented by 1, X =  0 + 1 =  1.
 * Example 2:
 *
 * Input: operations = ["++X","++X","X++"]
 * Output: 3
 * Explanation: The operations are performed as follows:
 * Initially, X = 0.
 * ++X: X is incremented by 1, X = 0 + 1 = 1.
 * ++X: X is incremented by 1, X = 1 + 1 = 2.
 * X++: X is incremented by 1, X = 2 + 1 = 3.
 * Example 3:
 *
 * Input: operations = ["X++","++X","--X","X--"]
 * Output: 0
 * Explanation: The operations are performed as follows:
 * Initially, X = 0.
 * X++: X is incremented by 1, X = 0 + 1 = 1.
 * ++X: X is incremented by 1, X = 1 + 1 = 2.
 * --X: X is decremented by 1, X = 2 - 1 = 1.
 * X--: X is decremented by 1, X = 1 - 1 = 0.
 *
 *
 * Constraints:
 *
 * 1 <= operations.length <= 100
 * operations[i] will be either "++X", "X++", "--X", or "X--".
 */

/**
 * My notes from attempt:
 * Input: an array of string representing the possible operations:
 *         X-- or --X for decrementing
 *         X++ or ++X for incrementing.
 *
 *     Output: an interger that represents the final value X after performing all operations.
 *
 *
 *     observations
 *     - X always starts at 0.
 *     - A when statemtne in Kotlin would be good for this problem.
 *
 *
 *     1. iterate through each operation
 *     2. use a when statement to determine the proper behavior for a given operation.
 *     3. modify x
 *     4. return after finshed iterating.
 *
 */

// my solution here is very straight forward.
fun finalValueAfterOperations(operations: Array<String>): Int {
    return operations.fold(0) { acc, op ->
        when (op) {
            "++X", "X++" -> acc + 1
            else -> acc - 1
        }
    }
}