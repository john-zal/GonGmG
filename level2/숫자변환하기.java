package GonGmG.level2;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] dp = new int[y+1];
        
        for(int i = 0; i <= y; ++i) 
            dp[i] = -1;
        
        dp[x] = 0;
        
        for(int i = x+1; i <= y; ++i) {
            int two = 10000;
            int three = 10000;
            int plus_n = 10000;
            if(i % 2 == 0 && dp[i/2] != -1) 
                two = dp[i/2] + 1;
            if(i % 3 == 0 && dp[i/3] != -1) 
                three = dp[i/3] + 1;
            if(i > n && dp[i-n] != -1) 
                plus_n = dp[i-n] + 1;
            dp[i] = Math.min(two, Math.min(three,plus_n));
        }
        if(dp[y] != 10000)
            answer = dp[y];
        return answer;
    }
}
public class 숫자변환하기 {
    
}
