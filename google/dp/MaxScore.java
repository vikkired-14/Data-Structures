package google.dp;

public class MaxScore {
    public static int maxScore(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];
        dp[0] = 0; // Base case: no jumps needed to reach the first stone

        // Iterate through all stones
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MIN_VALUE; // Initialize to a very small value

            // Iterate through all previous stones
            for (int j = 0; j < i; j++) {
                int score = dp[j] + (i - j) * stones[i]; // Calculate score for jumping from stone j to stone i
                dp[i] = Math.max(dp[i], score); // Update dp[i] with maximum score
            }
        }



        return dp[stones.length-1];
    }

    public static int maxScore2(int[] stones) {
        int[] dp = new int[stones.length];
        dp[0] =0;
        for(int i=1;i< stones.length;i++){
            dp[i] = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],dp[j]+(i-j)*stones[i]);
            }
        }
        return dp[stones.length-1];
    }


    public static void main(String[] args){
        System.out.println(maxScore(new int[]{7,0,8,9}));
        System.out.println(maxScore2(new int[]{7,0,8,9}));
        System.out.println(maxScore(new int[]{4,10,8,10,12,15}));
        System.out.println(maxScore2(new int[]{4,10,8,10,12,15}));
    }

}
