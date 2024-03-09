package BackTracking;
import java.util.*;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,target,0,new LinkedList<Integer>(),result);
        return result;
    }

    private static void backTrack(int[] candidates, int target, int start,
                           LinkedList<Integer> path, List<List<Integer>> result) {
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            path.add(candidates[i]);
            backTrack(candidates,target-candidates[i],i+1,path,result);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//        int[] candidates = {10,1,2,7,6,1,5};
//        System.out.println(combinationSum2(candidates,8));
        int[] candidates = {1,1,1,1};
        System.out.println(combinationSum2(candidates,2));
    }
}
