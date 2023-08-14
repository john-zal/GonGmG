package GonGmG.level1;

import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        for(int i = 1; i < food.length; ++i) {
            for(int j = 0; j < food[i]/2; ++j){
                sb.append(i);
                sb2.append(i);
            }
        }

        sb.append("0"+sb2.reverse());
        
        answer = String.valueOf(sb);
        return answer;
    }
}
public class 푸드파이트대회 {
    
}
