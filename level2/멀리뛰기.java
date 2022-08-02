package GonGmG.level2;

class Solution {
    public long solution(int n) {
        int[] d = new int[2001];
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++) 
            d[i] = (d[i-1] + d[i-2]) % 1234567;
        return d[n] ;
    }
}

public class 멀리뛰기 {
    public static void main(String[] args) {

    }
}
