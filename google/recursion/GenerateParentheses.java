package google.recursion;
import java.util.*;

/*
https://leetcode.com/explore/interview/card/google/62/recursion-4/3079/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res,"",n,n);
        return res;
    }

    public void backTrack(List<String> res,String combination,int left,int right){
        if(left==0 && right ==0)
        {
            res.add(combination);
            return;
        }
        if(left>0)
            backTrack(res,combination+"(",left-1,right);
        if(left<right)
            backTrack(res,combination+")",left,right-1);
    }
}
