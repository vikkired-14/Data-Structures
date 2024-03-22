package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/


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
public class LetterCombinationsOfAPhoneNumber {
    static Map<Character,String> letters = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",
            '7',"pqrs",'8',"tuv",'9',"wxyz");
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;
        backTrack(0,new StringBuilder(),digits,result);
        return result;
    }

    private static void backTrack(int index, StringBuilder sb, String digits, List<String> result) {
        if(sb.length()==digits.length())
        {
            result.add(sb.toString());
            return;
        }

        String word = letters.get(digits.charAt(index));
        for(char ch : word.toCharArray()){
            sb.append(ch);
            backTrack(index+1,sb,digits,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
}
