package BackTracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Given an array of distinct integers candidates and a target integer target, return a list of all unique
combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
        frequency
        of at least one of the chosen numbers is different.

        The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

        Example 1:

        Input: candidates = [2,3,6,7], target = 7
        Output: [[2,2,3],[7]]
        Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.
*/
public class CombinationSum {

    static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> combo = new LinkedList<>();
        getAllCombinations(target,candidates,0,combo);
        return list;
    }

    private static void getAllCombinations(int target, int[] candidates, int i, LinkedList<Integer> combo) {

        if(target ==0)
            list.add(new ArrayList<>(combo));
        else if(target<0)
            return;
        else
        {
            for(int start = i;start<candidates.length;start++){
                combo.add(candidates[start]);
                getAllCombinations(target-candidates[start],candidates,start,combo);
                combo.removeLast();
            }
        }
    }

    public static void main(String[] args){

        int[] candidates = new int[]{2,3,6,7};
        int target = 12;
        combinationSum(candidates,target);

        for(List<Integer> l : list){
            if(l!=null)
            System.out.println(l.toString());
        }

    }
}
