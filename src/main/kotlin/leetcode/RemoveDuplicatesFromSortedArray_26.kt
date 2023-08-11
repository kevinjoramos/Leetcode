package leetcode

/**
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */


/**
 * This solution was my second attempt after reading the top solution.
 * The take away here is that I didn't need to overwrite all the values. Instead,
 * I just keep track of simple pointer to the next location for a unique value,
 * and put it there using the same method I used in version 1.
 */
fun removeDuplicates(nums: IntArray): Int {

    var previousValue = nums[0]

    // This value starts at index 1 since index 0 will always be unique.
    var nextUniqueValueSpot = 1

    // We iterate the array and if the current value does not match the previous value,
    // it is unique, and we put it at the unqiue value spot and increment it by one.
    for (i in 1..nums.lastIndex) {
        if (nums[i] != previousValue) {
            nums[nextUniqueValueSpot] = nums[i]
            previousValue = nums[i]
            nextUniqueValueSpot++
        }
    }

    // Since the nextUniqueValueSpot will always point to the index after the last unique value, it is also the
    // size k because Size = lastIndex + 1. 
    return nextUniqueValueSpot

}

/**
 * This solution was my first try at this problem. Here are my notes from when solving:
 * // Parameters: an array of ints from least to greatest.
 * // returns: the size of the array with all duplicated removed.
 * // You also need to change the array in place so that duplicated are given an empty space. while
 * // preserving the order of things.
 *
 *
 * // traverse the array searching or duplicated
 * //     1. compare past value with current value.
 *
 * // Shorten intarray? (not sure how to do that in Kotlin.)
 * //      1. traverse array looking for "empty spots" (negative values for now
 * //      2. if we have an empty spot, and run into a number, move the number into that empty spot.
 *
 *
 * I realized that it didn't matter what we put in the "empty" spaces, so I put 101 since that max value in nums was 100.
 */
fun removeDuplicates_v1(nums: IntArray): Int {

    // Here we iterate the array comparing the previous value with the current one to see
    // if there is a duplicate.
    var previousValue = 101
    for (i in 0..nums.lastIndex) {
        val currentValue = nums[i]

        if (nums[i] == previousValue) {
            nums[i] = 101
        }

        previousValue = currentValue
    }

    var emptyPointer = 0
    for ((i, number) in nums.withIndex()) {

        // We traverse the array again, but this time we update the empty pointer so that it points to the 101
        // closest to the start that hasn't been filled yet.
        while (nums[emptyPointer] != 101 && emptyPointer < nums.lastIndex) {
            emptyPointer++
        }

        // We need to check to see if the empty pointer has already reached the end. If it did, then
        // we are done.
        if (emptyPointer == nums.lastIndex && nums[nums.lastIndex] != 101) {
            break;
        }

        // If we find a number, and empty pointer points to a 101 before the current index, we swap values
        // with those places.
        if (number != 101 && emptyPointer < i) {
            nums[emptyPointer] = nums[i]
            nums[i] = 101
        }
    }

    // Finally we count the non 101 values to get the size.
    var size = 0
    for (number in nums) {
        if (number != 101) size++
    }

    return size

}