package google.dp;
/*
https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/3087/
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int globalProd = nums[0];
        for(int i=1;i< nums.length;i++){
            int temp = maxProd;
            maxProd = Math.max(nums[i],Math.max(maxProd*nums[i],minProd*nums[i]));
            minProd = Math.min(nums[i],Math.min(temp*nums[i],minProd*nums[i]));
            globalProd = Math.max(maxProd,globalProd);
        }
        return globalProd;
    }
    public static void main(String[] args){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));//6
        System.out.println(maxProduct(new int[]{-2,0,-1}));//0

    }
}
