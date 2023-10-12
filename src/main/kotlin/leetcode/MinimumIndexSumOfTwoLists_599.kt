package leetcode

/**
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 *
 * A common string is a string that appeared in both list1 and list2.
 *
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 *
 * Return all the common strings with the least index sum. Return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only common string is "Shogun".
 * Example 2:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
 * Example 3:
 *
 * Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
 * Output: ["sad","happy"]
 * Explanation: There are three common strings:
 * "happy" with index sum = (0 + 1) = 1.
 * "sad" with index sum = (1 + 0) = 1.
 * "good" with index sum = (2 + 2) = 4.
 * The strings with the least index sum are "sad" and "happy".
 *
 *
 * Constraints:
 *
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the strings of list1 are unique.
 * All the strings of list2 are unique.
 * There is at least a common string between list1 and list2.
 */

/**
INPUT - two list of strings.
OUPUT - a list of strings with LCI (can be more than one if equal)

- can be equal
- each list is unique.

1. convert one list into a hashmap storing the index as the value.
2. iterate through the other list, and filter out the items that aren't LCI

how to check for LCI
1. must appear in both lists. filter
2. i + j must be smallest. reduce

 */
fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    val map2 = list2.mapIndexed { index, value -> value to index }.toMap()

    var result = mutableListOf<String>()
    var minimumIndexSum = list1.size + list2.size

    list1.forEachIndexed { index, value ->
        if (map2.contains(value)) {
            if ((map2[value]!! + index) < minimumIndexSum) {
                minimumIndexSum = map2[value]!! + index
                result = mutableListOf(value)
            } else if ((map2[value]!! + index) == minimumIndexSum){
                result.add(value)
            }
        }
    }

    return result.toTypedArray()
}