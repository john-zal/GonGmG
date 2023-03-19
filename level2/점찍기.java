package GonGmG.level2;

class Solution {
    public long solution(int k, long d) {
        long answer = 0;

        int[] vertical = new int[(int)d/k + 1];
        
        for(int i = 1; i < vertical.length; ++i) 
            vertical[i] = k*i;
        
        for(int i = 0; i < vertical.length; ++i) {
            long x = vertical[i];
            long y = (long)Math.sqrt(d*d-x*x);
            answer += y/k;
        }
        return answer+vertical.length;
    }
}

public class 점찍기 {
    
}
