package leetcode

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 */


/**
 * Aug 6, 2023
 *
 *  input is a string representing a roman numeral.
 *     return the roman numeral numerical value as an integer.
 *
 *     Observations:
 *     written largest to smallest.
 *     during exceptions, we subtract the smaller from the larger.
 *
 *     1. iterate through characters summing values.
 *     2. keep track of most recently added roman numeral value.
 *     3. if the new value is greater than the previous, subtract the previous from
 *     the sum.
 */
fun integerToRoman_13_v1(s: String): Int {
    var currentValue = 0
    var previousValue = 1000;
    var sum = 0

    for (numeral in s) {

        currentValue = when (numeral) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            else -> 1000
        }

        // for simplicity, I decided to add the integer value each time no matter what.
        sum += currentValue

        // we check to see if the previous value was smaller than the current value.
        // if it's smaller, we were supposed to subtract it from the sum. This is why I subtract twice ( time 2 )
        // once because I had added, and twice because I was supposed to subtract.
        if (currentValue > previousValue) {
            sum -= (previousValue * 2)
        }

        previousValue = currentValue
    }

    return sum
}

/**
 * I didn't realize before, but I had answered this question over a year ago, and it lets me see the growth I've made since then!"
 */
fun integerToRoman_13_v2(s: String): Int {

    //iterate through romanToInt
    //check for case of subtraction with nested if. add to count as needed.
    //convert each numeral into the proper number.


    var answer = 0

    for (i in 0..s.lastIndex) {
        if (s[i] == 'I') {
            if (i != s.lastIndex) {
                if (s[i + 1] == 'V' || s[i + 1] == 'X') {
                    answer += -1
                    continue
                }
            }

            answer += 1
        }

        if (s[i] == 'V') answer += 5


        if (s[i] == 'X') {
            if (i != s.lastIndex) {
                if (s[i + 1] == 'L' || s[i + 1] == 'C') {
                    answer += -10
                    continue
                }

            }
            answer += 10
        }

        if (s[i] == 'L') answer += 50


        if (s[i] == 'C') {
            if (i != s.lastIndex) {
                if (s[i + 1] == 'D' || s[i + 1] == 'M') {
                    answer += -100
                    continue
                }

            }
            answer += 100
        }

        if (s[i] == 'D') answer += 500


        if (s[i] == 'M') answer += 1000

    }

    return answer
}
