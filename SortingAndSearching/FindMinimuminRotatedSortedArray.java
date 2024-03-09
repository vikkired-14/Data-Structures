package SortingAndSearching;
/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
 [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.


Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
 */
public class FindMinimuminRotatedSortedArray {

    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(nums[0]<nums[nums.length-1])// increasing array
            return nums[0];
        int left=0,right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]> nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1]>nums[mid])
                return nums[mid];

            if(nums[mid]>nums[0])
                left = mid+1;
            else
                right = mid-1;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args){
        System.out.println(findMin(new int[]{3,4,5,1,2}));//1
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));//0
    }
}

/*
Choosing between `while(left <= right)` and `while(left < right)` depends on the specific problem and the conditions you want to satisfy.

- If you want to include the boundary elements (`left` and `right`) in your search space and continue iterating until `left` and `right` become equal (i.e., until there's no element left to examine), you should use `while(left <= right)`. This is typically used when you want to search for an element in a range and you want to make sure that you've considered all possible elements in that range.

- On the other hand, if you want to exclude the boundary elements and stop iterating when `left` becomes equal to `right` (i.e., when there's only one element left to examine), you should use `while(left < right)`. This is commonly used in binary search implementations when you want to narrow down the search space to a single element.

Regarding the choice between `right = mid` and `right = mid - 1`, it also depends on the problem and the conditions you're checking. Here's a general guideline:

- If you want to exclude the mid element from the next search space because you have already checked it and found it to be not the solution, you should use `right = mid - 1`. This is commonly used in scenarios where you're searching for the first occurrence of a target element or a condition.

- If you want to include the mid element in the next search space because you haven't checked it yet and it could potentially be the solution, you should use `right = mid`. This is typically used when you're searching for the last occurrence of a target element or a condition.

To remember when to use what, it's helpful to understand the problem requirements clearly and carefully analyze how the search space should be adjusted in each iteration based on those requirements. Practice and experience with different problems will also help in making the right choice instinctively.
 */
