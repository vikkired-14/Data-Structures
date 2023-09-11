import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestSequence(int[] arr){
        if(arr.length==0)
            return  0;
        Set<Integer> set = new HashSet<>();

        for(int n : arr){
            set.add(n);
        }
        int longStreak = 1;
        for(int n : arr){
            if(!set.contains(n-1)){
                int currNum =n;
                int currStreak =1;
                while(set.contains(currNum+1)){
                    currStreak += 1;
                    currNum += 1;
                }
                longStreak = Math.max(longStreak,currStreak);
            }
        }
        return longStreak;
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestSequence(arr));
    }
}
