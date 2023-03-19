package GonGmG.level2;

class Solution {
    static boolean[] isused = new boolean[21];
    static int[] ans ;
    static long kk;
    public void dfs(int n, int index) {
        if(index == n) {
            --kk;
            return ;
        }
        if(kk != 0) {
            for(int i = 1; i <= n; ++i) {
                if(!isused[i] && kk != 0) {
                    isused[i] = true;
                    ans[index] = i;
                    dfs(n , index+1);
                    isused[i] = false;
                }
            }
        }
    }
    public void fun(long num, long each_num; long start,int n, long k, int index) {
        long num = 1;
        long each_num = 0;
        long start = 0;
        for(int i = 1; i <= n; ++i) 
            num *= i;
        each_num = number/n;
        start = k/each_num;
        isused[(int)(start+1)] = true;
        ans[index] = (int)(start+1);
    }
    public int[] solution(int n, long k) {
        ans = new int[n];
        long number = 1;
        long each_num = 0;
        long start = 0;
        for(int i = 1; i <= n; ++i) 
            number *= i;
        each_num = number/n;
        start = k/each_num;
        isused[(int)(start+1)] = true;
        ans[0] = (int)(start+1);
        k = k%each_num;
        kk = k;
        dfs(n, 1);
        return ans;
    }
}

public class 줄서는방법 {
    
}
