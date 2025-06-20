package google.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem URL : https://leetcode.com/problems/find-and-replace-in-string/
 * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
 * Output: "eeebffff"
 * Explanation: "a" occurs at index 0 in s, so we replace it with "eee". "cd" occurs at index 2 in s, so we replace it with "ffff".-
 * */
public class FindAndReplaceInStringProblem {

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};

        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        int[] map = new int[S.length()];
        for (int i = 0; i < indexes.length; i++)
            map[indexes[i]] = i + 1;

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            char ch = S.charAt(i);
            if (map[i] == 0) {
                builder.append(ch);
                i++;
                continue;
            }

            int index = map[i] - 1;
            String src = sources[index];
            String sub = S.substring(i, i + src.length());
            if (!sub.equals(src)) {
                builder.append(ch);
                i++;
                continue;
            }

            builder.append(targets[index]);
            i += src.length();
        }

        return builder.toString();
    }

    public String findReplaceString2(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int idx=0;idx<indices.length;idx++){
            if(s.startsWith(sources[idx],indices[idx])){
                map.put(indices[idx],idx);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();){
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i+= sources[map.get(i)].length();
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}


