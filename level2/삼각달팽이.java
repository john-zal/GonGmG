package GonGmG.level2;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(1+n))/2];
        int[][] snail = new int[n][n];
        int nn = n;
        int r = -1;
        int c = 0;
        int a = 0;
        int index = 0;
        while(n > 0) {
            for(int i = 0; i < n; i++) {
                snail[++r][c] = ++a;
            }
            for(int i = 0; i < n-1; i++) {
                snail[r][++c] = ++a;
            }
            for(int i = 0; i < n-2; i++) {
                snail[--r][--c] = ++a;
            }
            n -= 3;
        }
        for(int i = 0; i < nn; i++) {
            for(int j = 0; j < i+1; j++) {
                answer[index++] = snail[i][j];
            }
        }
        return answer;
    }
}
public class 삼각달팽이 {
    
}
