package google.recursion;
import java.util.*;
//https://leetcode.com/explore/interview/card/google/62/recursion-4/3078/
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsofaPhoneNumber {
    Map<Character,String> digitMap = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
    String phoneNumber;
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits.length()==0)
            return new ArrayList<>();
        phoneNumber = digits;

        backTrack(0,new StringBuilder());
        return result;
    }

    public void backTrack(int index,StringBuilder path){

        if(path.length() == phoneNumber.length()){
            result.add(path.toString());
            return ;
        }
        String letter  = digitMap.get(phoneNumber.charAt(index));
        for(char c : letter.toCharArray()){
            path.append(c);
            backTrack(index+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
