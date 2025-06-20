package google.arraysAndStrings;

import java.util.PriorityQueue;

/*
 * Problem URL : https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * */
public class KthLargestElementInArrayProblem {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest_approach1(nums, k));
        System.out.println(findKthLargest_approach1(nums, k));
    }

    /*
     * Time Complexity : O(nlogk)
     * Space Complexity : O(k)
     * */
    public static int findKthLargest_approach1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int n : nums) {
            heap.add(n);

            if (heap.size() > k)
                heap.poll();
        }

        return (!heap.isEmpty()) ? heap.poll() : -1;
    }
//countsort

    /*
    Counting sort is a non-comparison sorting algorithm. It can be used to sort an array of positive integers.

In this approach, we will sort the input using a slightly modified counting sort, and then return the kthk^{th}k
th
  element from the end (just like in the first approach).

Here is how we will sort the array:

First, find the maxValue in the array. Create an array count with size maxValue + 1.
Iterate over the array and find the frequency of each element. For each element num, increment count[num].
Now we know the frequency of each element. Each index of count represents a number. Create a new array sortedArr and iterate over count. For each index num, add count[num] copies of num to sortedArr. Because we iterate over the indices in sorted order, we will also add elements to sortedArr in sorted order.
The following animation demonstrates this process:

Current


There is one problem: as we are associating indices with numbers, this algorithm will not work if negative numbers are in the input. The constraints state that negative numbers can be in the input, so we need to account for this.

Let's also find minValue, the minimum value in the array. Instead of count having a size of maxValue + 1, we will make it have a size of maxValue - minValue + 1 (if minValue < 0, then this will appropriately increase the size of count).

Now, we can just apply an offset of minValue when mapping numbers to indices and vice-versa. When we populate count, given a num we will increment count[num - minValue]. count[num] will represent the frequency of num + minValue.

One more small optimization

Since we don't actually need to sort the array but only need to return the kthk^{th}k
th
  largest value, we will iterate over the indices of count in reverse order (get the larger numbers first). At each number, we will decrement k (or a variable we initialize as remain = k to avoid modifying the input) by the frequency. If remain <= 0, we can return the current number. With this optimization, we don't need to create sortedArr, saving us O(n)O(n)O(n) space.

Algorithm

Find the maxValue and minValue of nums.
Create count, an array of size maxValue - minValue + 1.
Iterate over nums. For each num, increment count[num - minValue].
Set remain = k and iterate over the indices of count backward. For each index num:
Subtract the frequency of num from remain: remain -= count[num].
If remain <= 0, return the number that the current index represents: num + minValue.
The code should never reach this point. Return any value.
Implementation


Complexity Analysis

Given nnn as the length of nums and mmm as maxValue - minValue,

Time complexity: O(n+m)O(n + m)O(n+m)

We first find maxValue and minValue, which costs O(n)O(n)O(n).

Next, we initialize count, which costs O(m)O(m)O(m).

Next, we populate count, which costs O(n)O(n)O(n).

Finally, we iterate over the indices of count, which costs up to O(m)O(m)O(m).

Space complexity: O(m)O(m)O(m)

We create an array count with size O(m)O(m)O(m).
     */
    public static int findKthLargest_approach2(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int n : nums){
            minValue = Math.min(minValue,n);
            maxValue = Math.max(maxValue,n);
        }
        int[] count = new int[maxValue-minValue+1];
        for(int num : nums){
            count[num-minValue]++;
        }
        for(int i= count.length-1;i>=0;i--){
            k -= count[i];
            if(k<=0){
                return i+minValue;
            }
        }
        return  -1;
    }
}
