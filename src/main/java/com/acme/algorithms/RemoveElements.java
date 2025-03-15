package com.acme.algorithms;

/**
 * This class implements the solution for Remove Elements algorithm. The directions are:
 * <br/>
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not
 * equal to val.
 * <br/>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted,
 * you need to do the following things:
 * <br/>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal
 * to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <br/>
 * Custom Judge:
 * <br/>
 * The judge will test your solution with the following code:
 * <br/>
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 * <br/>
 * int k = removeElement(nums, val); // Calls your implementation
 * <br/>
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <br/><br/>
 * <br/>
 * Example 1:
 * <br/>
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <br/>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums
 * containing 0, 0, 1, 3, and 4.
 * <br/>
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <br/>
 * Constraints:
 * <br/>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElements {

    public int remove(int[] nums, int val) {

        int tempValue = 0;
        int fakeValue = -1;
        int result = nums.length;

        for (int  i = 0; i < nums.length; i++) {

            if (nums[i] == val) {

                nums[i] = fakeValue;
                result--;

                for (int j = (nums.length-1); j > i; j--) {

                    if (nums[j] != val && nums[j] != fakeValue) {
                        tempValue = nums[j];

                        nums[j] = nums[i];

                        nums[i] = tempValue;

                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] startArray = {0, 4, 4, 0, 4, 4, 4, 0, 2};
        //int[] startArray = {0, 1, 2, 2, 3, 0, 4, 2};
        int valuesToRemove = 4;
        //int valuesToRemove = 2;

        RemoveElements re = new RemoveElements();
        int result = re.remove(startArray, valuesToRemove);

        System.out.println("Valid items: " + result);
    }
}
