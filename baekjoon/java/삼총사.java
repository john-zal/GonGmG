package GonGmG.baekjoon;

class Solution {
    int answer = 0;
    int[] num;
    boolean[] check;
    
    void dfs(int sum, int index, int deep) {
        if(deep == 3) {
            if(sum == 0)
                ++answer;
            return ;
        }
        for(int i = index; i < num.length; ++i) {
            if(!check[i]) {
                sum += num[i];
                check[i] = true;
                dfs(sum, i, deep+1);
                sum -= num[i];
                check[i] = false;
            }
        }
    }
    public int solution(int[] number) {
        num = number;
        check = new boolean[number.length];
        
        dfs(0,0,0);
        
        return answer;
    }
}

public class 삼총사 {
    
}