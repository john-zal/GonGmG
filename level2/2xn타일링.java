package GonGmG.level2;

class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i < dp.length; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n]%1000000007;
    }
}
public class 2xn타일링 {
    
}
