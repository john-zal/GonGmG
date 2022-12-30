package GonGmG.level2;

class Solution {
    int ascroe = 0;
    int lscore = 0;
    int[] answer = new int[11];
    boolean[] ischecked = new boolean[11];
    void fun(int n) {
        if(n == 0) {
            if(lscore > ascroe) {

            }
        }
        for(int i = 0; i < 11; ++i) {
            if(ischecked[i]) {
                            
            }
        }
    }
    public int[] solution(int n, int[] info) {
        for(int i = 0; i < info.length; ++i) {
            if(info[i]!=0)
                ascroe += 10-i;
            ischecked[i] = false;
        }
        return answer;
    }
}
public class 양궁대회 {
    
}
