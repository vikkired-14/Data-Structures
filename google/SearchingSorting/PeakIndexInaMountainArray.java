package google.SearchingSorting;

/*
An array arr is a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1


Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
 */
public class PeakIndexInaMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int left =0;
        int right = arr.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]<arr[mid+1])
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}
/*
In a mountain array with peak index i, any element at index with index less than i would obey arr[index] < arr[index + 1]. Furthermore, any index greater than or equal to i would follow the rule arr[index] > arr[index + 1] (and not obey arr[index] < arr[index + 1]).

A scenario like this where our task is to search for an element i from a given range (l, r) where all values smaller than i satisfy a certain condition and all values greater than or equal to i do not satisfy it (or vice-versa) can be solved optimally with a binary search algorithm. In binary search, we repeatedly divide the solution space where the answer could be in half until the range contains just one element.

Following the above discussion, we use binary search to solve this problem. We create an integer l and initialize it to the starting index 0. We also create another integer variable r and set it to the last index of arr, i.e., arr.length - 1.

We get the middle of the range mid = (l + r) / 2 and compare arr[mid] with the next element. If arr[mid] < arr[mid + 1], we move to the upper half of the range by setting l = mid + 1 as our peak index is definitely greater than mid. Otherwise, if arr[mid] > arr[mid + 1], we move to the lower half of the range by setting r = mid as the peak index is either mid or some index smaller than mid.

The answer would be within the range (l, r) at any point. All the indices smaller than l are indices smaller than the peak index and all indices greater than r are indices greater than the peak index. We continue the search as long as l < r.

When l == r, l (or r) denotes the required peak index.

Here is a visual representation of an example to illustrate how it works:
 */