package SortingAndSearching;
/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int left=0,curr=0;
        int right= nums.length-1;
       while(curr<=right){
           if(nums[curr]==0){
               swap(nums,curr,left);
               curr++;
           }else if(nums[curr]==2){
               swap(nums,curr,right);
               right--;
           }else{
               curr++;
           }
       }
       for(int i=0;i< nums.length;i++){
           System.out.println(nums[i]);
       }

    }

    private static void swap(int[] nums, int curr, int left) {
        int temp = nums[curr];
        nums[curr]= nums[left];
        nums[left] = temp;
    }

    public static void main(String[] args){
        sortColors(new int[]{2,0,2,1,1,0});
        System.out.println("*********");
        sortColors(new int[]{2,0,1});
        System.out.println("*********");
        sortColors(new int[]{0,1,0});
        System.out.println("*********");
        sortColors(new int[]{1,2,0});

    }
}
/*
The problem is known as Dutch National Flag Problem
and first was proposed by Edsger W. Dijkstra.
The idea is to attribute a color to each number and then to
arrange them following the order of colors on the Dutch flag.
 */