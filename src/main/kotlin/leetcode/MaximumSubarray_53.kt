/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */


/**
 * Solution
 * The O(n) solution here is to iterate across the array left to right, updating the max sum value.
 * We maintain a current sum value, and if the current sum ever becomes negative, we have found the end of subarray
 * that does not contribute to the final maximum sum, and reset the current sum to 0.
 */
fun maxSubArray(nums: IntArray): Int {

    // max starts out with the value at index 0 instead of 0 in case nums is an array with a single negative integer.
    var max = nums[0]
    var currentSum = 0
    var pointerIndex = 0

    while (pointerIndex <= nums.lastIndex) {

        // Add the current value to the sum.
        currentSum += nums[pointerIndex]

        // update the current maximum if it has been exceeded.
        max = maxOf(currentSum, max)

        // if the current sum is negative, all the numbers left of the index (including the index)
        // have a negative sum, and therefore do not contribute to the maximum sum, meaning they
        // are not part of the subarray we care about.
        if (currentSum < 0) {

            // In this case we set the currentSum to 0 so that we distinguish the end of one subarray from the start of a new one.
            currentSum = 0
        }

        pointerIndex++
    }

    return max
}