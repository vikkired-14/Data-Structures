package google.SearchingSorting;

import java.util.*;

/*
Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].



Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class CountOfSmallerNumbersAfterSelf {

    class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.count = 0;
            this.left = null;
            this.right = null;
        }
    }

    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            // Find the range of numbers in nums
            int min = Arrays.stream(nums).min().getAsInt();
            int max = Arrays.stream(nums).max().getAsInt();

            // Build the segment tree with the range of numbers
            SegmentTreeNode root = buildSegmentTree(min, max);

            // Traverse the nums array from right to left
            for (int i = nums.length - 1; i >= 0; i--) {
                // Count the number of elements smaller than nums[i] to the right
                result.add(query(root, min, nums[i] - 1));
                // Update the segment tree with nums[i]
                update(root, nums[i]);
            }

            // Reverse the result list to match the original order of elements in nums
            Collections.reverse(result);
            return result;
        }

        // Build the segment tree with the range [start, end]
        private SegmentTreeNode buildSegmentTree(int start, int end) {
            if (start > end) {
                return null;
            }
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start < end) {
                int mid = start + (end - start) / 2;
                node.left = buildSegmentTree(start, mid);
                node.right = buildSegmentTree(mid + 1, end);
            }
            return node;
        }

        // Query the segment tree to count the number of elements smaller than target in the range [start, end]
        private int query(SegmentTreeNode root, int start, int target) {
            if (root == null || start > target) {
                return 0;
            }
            if (root.start == start && root.end <= target) {
                return root.count;
            }
            int mid = root.start + (root.end - root.start) / 2;
            if (target <= mid) {
                return query(root.left, start, target);
            } else {
                return query(root.left, start, mid) + query(root.right, mid + 1, target);
            }
        }

        // Update the segment tree with the value val
        private void update(SegmentTreeNode root, int val) {
            if (root == null || val < root.start || val > root.end) {
                return;
            }
            root.count++;
            if (root.start == root.end) {
                return;
            }
            int mid = root.start + (root.end - root.start) / 2;
            if (val <= mid) {
                update(root.left, val);
            } else {
                update(root.right, val);
            }
        }
    }
}
