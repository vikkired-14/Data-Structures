| ✅ | Problem Name | Leetcode Link | Category | Your Explanation | Key Insight / Trick | Status | Solved On     | Review 1 | Review 2 | Review 3 |
|----|--------------|----------------|----------|------------------|----------------------|--------|---------------|-----------|-----------|-----------|
| 🔲 | Two Sum | [Link](https://leetcode.com/problems/two-sum/) | Arrays & Two Pointers | I'm given an array of integers and a target sum. I need to find two distinct indices i and j such that nums[i] + nums[j] == target.To solve this, I use a HashMap to store the numbers I've already seen, along with their indices.For each number in the array, I calculate the complement (i.e., target - current number).If this complement is already in the HashMap, it means I've already seen a number that adds up to the current number to form the target, so I return their indices.Otherwise, I store the current number and its index in the map.This ensures I can find the pair in one pass over the array in O(n) time. |  | New |               |  |  |  |
| 🔲 | Best Time to Buy and Sell Stock | [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Arrays & Two Pointers | I’m given a list of stock prices where prices[i] is the price on day i. I need to find the maximum profit I can achieve by buying once and selling once later.I initialize min as the first day’s price (my current best buy price), and max as 0 (max profit so far).As I iterate through the array: I update min if I find a lower price (better day to buy).I compute the profit prices[i] - min for today’s price, and update max if it's higher than my current best.At the end, max holds the best profit I could have made by buying low and selling high.This works in one pass, efficiently. |  | New |               |  |  |  |
| 🔲 | Move Zeroes | [Link](https://leetcode.com/problems/move-zeroes/) | Arrays & Two Pointers | Use two pointers: one to track insertion point (insertPos), another to iterate. Move all non-zeroes forward, fill the rest with 0. | Use one pass to shift non-zeroes forward and then another pass to fill 0s. Avoid unnecessary swaps. | New | 8th july 2025 |  |  |  |
| 🔲 | Container With Most Water | [Link](https://leetcode.com/problems/container-with-most-water/) | Arrays & Two Pointers | Use two pointers at both ends and move the one with the smaller height inward, calculating area at each step. Maximize the result. | Always move the pointer at the shorter height, since increasing the shorter wall may increase area. | New | 14th July     |  |  |  |
| 🔲 | Remove Duplicates from Sorted Array | [Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Arrays & Two Pointers | Use two pointers — left tracks unique elements, right iterates. If elements differ, move left forward and copy value from right. |Only copy when nums[left] != nums[right], ensuring uniqueness at the start of array. In-place, O(1) space.  | New |               |  |  |  |
| 🔲 | Merge Sorted Array | [Link](https://leetcode.com/problems/merge-sorted-array/) | Arrays & Two Pointers | Start from the end of both arrays and fill nums1 from the back to avoid overwriting. Compare and insert larger elements from either array. | Use reverse merging with three pointers (left, right, idx). In-place and avoids shifting. | New |               |  |  |  |
| 🔲 | Rotate Array | [Link](https://leetcode.com/problems/rotate-array/) | Arrays & Two Pointers |Use 3-step reverse: whole → first k → remaining. Handles in-place, O(1) space.  | Reverse to rotate efficiently. Avoid shifting. | New |               |  |  |  |
| 🔲 | Two Sum II – Input Array is Sorted | [Link](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Arrays & Two Pointers | Use two pointers (left, right) since array is sorted. Move them inward based on the current sum. Return 1-indexed positions. | Use sorted property to eliminate need for hashmap. Constant space two-pointer approach. | New |               |  |  |  |
| 🔲 | 3Sum | [Link](https://leetcode.com/problems/3sum/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Valid Mountain Array | [Link](https://leetcode.com/problems/valid-mountain-array/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Maximum Subarray | [Link](https://leetcode.com/problems/maximum-subarray/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Remove Element | [Link](https://leetcode.com/problems/remove-element/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Product of Array Except Self | [Link](https://leetcode.com/problems/product-of-array-except-self/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Majority Element | [Link](https://leetcode.com/problems/majority-element/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Find Pivot Index | [Link](https://leetcode.com/problems/find-pivot-index/) | Arrays & Two Pointers |  |  | New |               |  |  |  |
| 🔲 | Longest Substring Without Repeating Characters | [Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Minimum Size Subarray Sum | [Link](https://leetcode.com/problems/minimum-size-subarray-sum/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Permutation in String | [Link](https://leetcode.com/problems/permutation-in-string/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Maximum Sum of Subarray of Size K | [Link](https://leetcode.com/problems/maximum-sum-of-subarray-of-size-k/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Longest Repeating Character Replacement | [Link](https://leetcode.com/problems/longest-repeating-character-replacement/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Sliding Window Maximum | [Link](https://leetcode.com/problems/sliding-window-maximum/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Count Occurrences of Anagrams | [Link](https://leetcode.com/problems/count-occurrences-of-anagrams/) | Sliding Window |  |  | New |               |  |  |  |
| 🔲 | Subarray Sum Equals K | [Link](https://leetcode.com/problems/subarray-sum-equals-k/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Two Sum | [Link](https://leetcode.com/problems/two-sum/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Longest Consecutive Sequence | [Link](https://leetcode.com/problems/longest-consecutive-sequence/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Group Anagrams | [Link](https://leetcode.com/problems/group-anagrams/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Valid Anagram | [Link](https://leetcode.com/problems/valid-anagram/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Top K Frequent Elements | [Link](https://leetcode.com/problems/top-k-frequent-elements/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Contains Duplicate | [Link](https://leetcode.com/problems/contains-duplicate/) | Hashing & Prefix Sum |  |  | New |               |  |  |  |
| 🔲 | Valid Parentheses | [Link](https://leetcode.com/problems/valid-parentheses/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Min Stack | [Link](https://leetcode.com/problems/min-stack/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Daily Temperatures | [Link](https://leetcode.com/problems/daily-temperatures/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Next Greater Element I | [Link](https://leetcode.com/problems/next-greater-element-i/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Evaluate Reverse Polish Notation | [Link](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Largest Rectangle in Histogram | [Link](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Asteroid Collision | [Link](https://leetcode.com/problems/asteroid-collision/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Remove K Digits | [Link](https://leetcode.com/problems/remove-k-digits/) | Stack / Monotonic Stack |  |  | New |               |  |  |  |
| 🔲 | Binary Search | [Link](https://leetcode.com/problems/binary-search/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Search in Rotated Sorted Array | [Link](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Find Minimum in Rotated Sorted Array | [Link](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Search Insert Position | [Link](https://leetcode.com/problems/search-insert-position/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Koko Eating Bananas | [Link](https://leetcode.com/problems/koko-eating-bananas/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Capacity To Ship Packages | [Link](https://leetcode.com/problems/capacity-to-ship-packages/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Median of Two Sorted Arrays | [Link](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Peak Index in a Mountain Array | [Link](https://leetcode.com/problems/peak-index-in-a-mountain-array/) | Binary Search |  |  | New |               |  |  |  |
| 🔲 | Subsets | [Link](https://leetcode.com/problems/subsets/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Subsets II | [Link](https://leetcode.com/problems/subsets-ii/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Combination Sum | [Link](https://leetcode.com/problems/combination-sum/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Combination Sum II | [Link](https://leetcode.com/problems/combination-sum-ii/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Permutations | [Link](https://leetcode.com/problems/permutations/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | N-Queens | [Link](https://leetcode.com/problems/n-queens/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Generate Parentheses | [Link](https://leetcode.com/problems/generate-parentheses/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Word Search | [Link](https://leetcode.com/problems/word-search/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Letter Combinations of a Phone Number | [Link](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Palindrome Partitioning | [Link](https://leetcode.com/problems/palindrome-partitioning/) | Recursion / Backtracking |  |  | New |               |  |  |  |
| 🔲 | Reverse Linked List | [Link](https://leetcode.com/problems/reverse-linked-list/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Merge Two Sorted Lists | [Link](https://leetcode.com/problems/merge-two-sorted-lists/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Remove Nth Node From End | [Link](https://leetcode.com/problems/remove-nth-node-from-end/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Linked List Cycle | [Link](https://leetcode.com/problems/linked-list-cycle/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Detect Cycle in Linked List | [Link](https://leetcode.com/problems/detect-cycle-in-linked-list/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Add Two Numbers | [Link](https://leetcode.com/problems/add-two-numbers/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Reorder List | [Link](https://leetcode.com/problems/reorder-list/) | Linked List |  |  | New |               |  |  |  |
| 🔲 | Maximum Depth of Binary Tree | [Link](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Same Tree | [Link](https://leetcode.com/problems/same-tree/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Symmetric Tree | [Link](https://leetcode.com/problems/symmetric-tree/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Binary Tree Level Order Traversal | [Link](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Validate Binary Search Tree | [Link](https://leetcode.com/problems/validate-binary-search-tree/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Lowest Common Ancestor of BST | [Link](https://leetcode.com/problems/lowest-common-ancestor-of-bst/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Construct Binary Tree from Preorder and Inorder | [Link](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Diameter of Binary Tree | [Link](https://leetcode.com/problems/diameter-of-binary-tree/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Path Sum | [Link](https://leetcode.com/problems/path-sum/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Invert Binary Tree | [Link](https://leetcode.com/problems/invert-binary-tree/) | Trees & Binary Trees |  |  | New |               |  |  |  |
| 🔲 | Kth Smallest Element in a BST | [Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Binary Search Trees |  |  | New |               |  |  |  |
| 🔲 | Delete Node in BST | [Link](https://leetcode.com/problems/delete-node-in-bst/) | Binary Search Trees |  |  | New |               |  |  |  |
| 🔲 | Convert Sorted Array to BST | [Link](https://leetcode.com/problems/convert-sorted-array-to-bst/) | Binary Search Trees |  |  | New |               |  |  |  |
| 🔲 | Kth Largest Element in an Array | [Link](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Heap / Priority Queue |  |  | New |               |  |  |  |
| 🔲 | Merge K Sorted Lists | [Link](https://leetcode.com/problems/merge-k-sorted-lists/) | Heap / Priority Queue |  |  | New |               |  |  |  |
| 🔲 | Top K Frequent Elements | [Link](https://leetcode.com/problems/top-k-frequent-elements/) | Heap / Priority Queue |  |  | New |               |  |  |  |
| 🔲 | Find Median from Data Stream | [Link](https://leetcode.com/problems/find-median-from-data-stream/) | Heap / Priority Queue |  |  | New |               |  |  |  |
| 🔲 | Task Scheduler | [Link](https://leetcode.com/problems/task-scheduler/) | Heap / Priority Queue |  |  | New |               |  |  |  |
| 🔲 | Number of Islands | [Link](https://leetcode.com/problems/number-of-islands/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Clone Graph | [Link](https://leetcode.com/problems/clone-graph/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Course Schedule | [Link](https://leetcode.com/problems/course-schedule/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Pacific Atlantic Water Flow | [Link](https://leetcode.com/problems/pacific-atlantic-water-flow/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Word Ladder | [Link](https://leetcode.com/problems/word-ladder/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Graph Valid Tree | [Link](https://leetcode.com/problems/graph-valid-tree/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Redundant Connection | [Link](https://leetcode.com/problems/redundant-connection/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Accounts Merge | [Link](https://leetcode.com/problems/accounts-merge/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Minimum Number of Vertices to Reach All Nodes | [Link](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Number of Connected Components | [Link](https://leetcode.com/problems/number-of-connected-components/) | Graphs (DFS/BFS/Union Find) |  |  | New |               |  |  |  |
| 🔲 | Climbing Stairs | [Link](https://leetcode.com/problems/climbing-stairs/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | House Robber | [Link](https://leetcode.com/problems/house-robber/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | House Robber II | [Link](https://leetcode.com/problems/house-robber-ii/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Longest Palindromic Substring | [Link](https://leetcode.com/problems/longest-palindromic-substring/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Coin Change | [Link](https://leetcode.com/problems/coin-change/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Maximum Product Subarray | [Link](https://leetcode.com/problems/maximum-product-subarray/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Longest Increasing Subsequence | [Link](https://leetcode.com/problems/longest-increasing-subsequence/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Edit Distance | [Link](https://leetcode.com/problems/edit-distance/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Word Break | [Link](https://leetcode.com/problems/word-break/) | Dynamic Programming |  |  | New |               |  |  |  |
| 🔲 | Decode Ways | [Link](https://leetcode.com/problems/decode-ways/) | Dynamic Programming |  |  | New |               |  |  |  |


Interview Thinking Framework: "B.O.S.T.O.N." 

Each letter helps guide your next move:

Step	What It Stands For	What You Do

B	Brute-force	Think of the most naive way to solve the problem (even if not optimal). Helps unlock patterns.

O	Observe Patterns	Use small examples to observe input → output relationships. Write them down.

S	State Constraints	Think about input size, time/space limits. Helps rule out inefficient methods.

T	Think in Patterns	Ask: “Is this a known pattern?” E.g., sliding window? two-pointer? reverse trick?

O	Optimize Gradually	Start with what works. Then refactor to reduce time/space.

N	Narrate Your Thoughts	Talk through your ideas. Even wrong ones. Interviewers care more about your approach than your solution speed.
