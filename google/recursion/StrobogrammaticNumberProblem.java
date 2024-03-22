package google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 1st Problem URL : https://leetcode.com/problems/strobogrammatic-number/
 * Input: num = "69"
 * Output: true
 *
 * 2nd Problem URL : https://leetcode.com/problems/strobogrammatic-number-ii/
 * Input: n = 2
 * Output: ["11","69","88","96"]
 * */
public class StrobogrammaticNumberProblem {

    List<String> list;
    Map<Character, Character> hm = new HashMap<Character, Character>() {
        {
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }
    };

    public static void main(String[] args) {
        /* First Problem */
        String num = "69";
        System.out.println(new StrobogrammaticNumberProblem().isStrobogrammatic(num));

        /* Second Problem */
        int n = 1;
        System.out.println(new StrobogrammaticNumberProblem().findStrobogrammatic(n));
    }

    /*
     * Time Complexity : O(N) : depends on the length of nums
     * Space Complexity : O(1) : const space
     * */
    public boolean isStrobogrammatic(String num) {

        for (int left = 0, right = num.length() - 1; left < right; left++, right--) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!hm.containsKey(leftChar) && hm.get(leftChar) != rightChar) return false;
        }
        return true;
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public List<String> findStrobogrammatic(int n) {
        list = new ArrayList<>();
        if (n == 0) return list;
        char[] ch = new char[n];
        helper(ch, 0, n - 1, list);
        return list;
    }

    private void helper(char[] ch, int left, int right, List<String> list) {
        if (left > right) {
            if (ch.length == 1 || ch[0] != '0')
                list.add(String.valueOf(ch));
            return;
        }

        for (char item : hm.keySet()) {
            if (left == right && item != hm.get(item)) continue;

            ch[left] = item;
            ch[right] = hm.get(item);
            helper(ch, left + 1, right - 1, list);
        }
    }
}
/*
bfs
class Solution {
    public char[][] reversiblePairs = {
        {'0', '0'}, {'1', '1'},
        {'6', '9'}, {'8', '8'}, {'9', '6'}
    };

    public List<String> findStrobogrammatic(int n) {
        Queue<String> q = new LinkedList<>();
        int currStringsLength;

        // When n is even, it means when decreasing by 2 we will go till 0.
        if (n % 2 == 0) {
            // We will start with 0-digit strobogrammatic numbers.
            currStringsLength = 0;
            q.add("");
        } else {
            // We will start with 1-digit strobogrammatic numbers.
            currStringsLength = 1;
            q.add("0");
            q.add("1");
            q.add("8");
        }

        while (currStringsLength < n) {
            currStringsLength += 2;
            for (int i = q.size(); i > 0; --i) {
                String number = q.poll();

                for (char[] pair : reversiblePairs) {
                    if (currStringsLength != n || pair[0] != '0') {
                        q.add(pair[0] + number + pair[1]);
                    }
                }
            }
        }

        List<String> stroboNums = new ArrayList<>();
        while (!q.isEmpty()) {
            stroboNums.add(q.poll());
        }

        return stroboNums;
    }
}

dfs
class Solution {
    public char[][] reversiblePairs = {
        {'0', '0'}, {'1', '1'},
        {'6', '9'}, {'8', '8'}, {'9', '6'}
    };

    public List<String> generateStroboNumbers(int n, int finalLength) {
        if (n == 0) {
            // 0-digit strobogrammatic number is an empty string.
            return new ArrayList<>(List.of(""));
        }

        if (n == 1) {
            // 1-digit strobogrammatic numbers.
            return new ArrayList<>(List.of("0", "1", "8"));
        }

        List<String> prevStroboNums = generateStroboNumbers(n - 2, finalLength);
        List<String> currStroboNums = new ArrayList<>();

        for (String prevStroboNum : prevStroboNums) {
            for (char[] pair : reversiblePairs) {
                // We can only append 0's if it is not first digit.
                if (pair[0] != '0' || n != finalLength) {
                    currStroboNums.add(pair[0] + prevStroboNum + pair[1]);
                }
            }
        }

        return currStroboNums;
    }

    public List<String> findStrobogrammatic(int n) {
        return generateStroboNumbers(n, n);
    }
}
 */