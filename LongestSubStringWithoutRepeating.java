import java.util.HashSet;
import java.util.Set;


//"pwwkew"
public class LongestSubStringWithoutRepeating {

    public static int getLongestSubString(String str){

        int left =0;
        int maxLen =0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            while(set.contains(str.charAt(i))){
               set.remove(str.charAt(left));
               left++;
            }
            set.add(str.charAt(i));
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args){
        System.out.println(getLongestSubString("pwwkew"));
    }

}
