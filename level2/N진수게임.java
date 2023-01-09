package GonGmG.level2;

import java.util.*;

//첫 시작 p, 이후 말할 숫자 p+m,p+m+m...n은 진수,t는 개수  
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        HashMap<Integer,String> map = new HashMap<>() {{
            put(0,"0");
            put(1,"1");
            put(2,"2");
            put(3,"3");
            put(4,"4");
            put(5,"5");
            put(6,"6");
            put(7,"7");
            put(8,"8");
            put(9,"9");
            put(10,"A");
            put(11,"B");
            put(12,"C");
            put(13,"D");
            put(14,"E");
            put(15,"F");
        }}; //Song

        int j = 0;

        while(sb.length() < p+m*(t-1)) {
            int k = j;
            StringBuffer sbpart = new StringBuffer();

            do {
                sbpart.append(map.get(k%n));
                k /= n;
            } while(k != 0);
            sb.append(sbpart.reverse());
            ++j; 
        }

        for(int i = p-1; i <= p+m*(t-1); i += m) 
            answer += String.valueOf(sb.charAt(i));
        
        return answer;
    }
}
public class N진수게임 {
    Solution a = new Solution();
    System.out.println(a.solution(2,4,2,1));
}
