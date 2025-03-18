package com.acme.algorithms;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative
 * order of the non-zero elements.
 * <br/><br/>
 * Note that you must do this in-place without making a copy of the array.
 * <br/><br/>
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <br/><br/>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * <br/><br/>
 * Constraints:
 * <br/><br/>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZerosAtTheEnd {

    public static final int ZERO = 0;

    public void move(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            // If the current number is 0, move it to the end
            if (numbers[i] == ZERO) {

                int tempValue = 0;
                // We iterate from next number according to i value in order to compare
                // i against j
                // [0,1,0,3,12] -> [1,3,12,0,0]
                // [i,j,j,j,j] -> [j,i,j,j,j]
                for (int j = i + 1; j < numbers.length; j++) {

                    // If j is different than i
                    if (numbers[j] != numbers[i]) {

                        // Backup the value j
                        tempValue = numbers[j];

                        // Move the number[i] to position j
                        numbers[j] = numbers[i];

                        // Assign the tempValue to number[i] position
                        numbers[i] = tempValue;

                        break;
                    }

                }
            }

        }

    }

    public static void main(String[] args) {

        MoveZerosAtTheEnd mz = new MoveZerosAtTheEnd();

        // Case 1
        //int[] numbers = {0,1,0,3,12}; // -> [1,3,12,0,0]

        // Case 2
        //int[] numbers = {1, 2, 0, 4, 3, 0, 5, 0}; // -> [1, 2, 4, 3, 5, 0, 0, 0]

        // Case 3
        //int[] numbers = {10, 20, 30}; // -> [10, 20, 30]

        // Case 4
        //int[] numbers = {0, 0}; // -> [0, 0]

        // Case 5
        int[] numbers = {45192,0,-659,-52359,-99225,-75991,0,-15155,27382,59818,0,-30645,-17025,81209,887,64648};
        // -> [45192,-659,-52359,-99225,-75991,-15155,27382,59818,-30645,-17025,81209,887,64648,0,0,0]
        mz.move(numbers);

        Arrays.stream(numbers).forEach(System.out::println);
    }
}
