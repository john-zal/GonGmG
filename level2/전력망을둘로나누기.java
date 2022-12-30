package GonGmG.level2;

class Solution {
    int wirenum;
    int answer = 0;
    boolean[] iscut;
    String s = "";

    void fun(int k, int [][] w) {
        if(k == wirenum) {
            if(answer > Math.abs(s.length() - (wirenum + 1 - s.length()))) {

            }
        }
    }
    public int solution(int n, int[][] wires) {
        wirenum = n-1;
        iscut = new boolean[wirenum];
        for(int i = 0; i < iscut.length; i++) 
            iscut[i] = false;
        
        for(int i = 0; i < wirenum; i++) {
            for(int j = 0; j < wirenum; j++) {
                if(!(j==i)) {
                    
                }
            }
        }
        return answer;
    }
}

public class 전력망을둘로나누기 {
    public static void main(String[] args) {
        
    }
}
