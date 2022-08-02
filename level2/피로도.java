package GonGmG.level2;

class Solution {
    int answer;
    int cleard = 0;
    boolean[] vis = new boolean[9];
    int[] min;
    int[] need;
    int dn,tired;
    void fun(int d) {
        if(d == dn) {
            if(cleard > answer) 
                answer = cleard;
            return ;
        }
        for(int i = 0; i < dn; i++) {
            if(!vis[i]) {
                if(min[i] <= tired && need[i] <= tired) {
                    cleard++;
                    tired -= need[i];
                    vis[i] = true;
                    fun(d+1);
                    cleard--;
                    tired += need[i];
                    vis[i] = false;
                }
                else {
                    vis[i] = true;
                    fun(d+1);
                    vis[i] = false;
                }

            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        dn = dungeons.length;
        min = new int[dn];
        need = new int[dn];
        tired = k;
        for(int i = 0; i < dn; i++) {
            min[i] = dungeons[i][0];
            need[i] = dungeons[i][1];
            vis[i] = false;
        }
        fun(0);
        return answer;
    }
}

public class 피로도 {
    
}
