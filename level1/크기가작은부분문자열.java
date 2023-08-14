package GonGmG.level1;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int p_len = p.length();
        long p_num = Long.parseLong(p);

        for(int i = 0; i <= t.length()-p_len; ++i) {
            long t_part = Long.parseLong(t.substring(i,i+p_len));
            if(t_part <= p_num)
                ++answer;
        }
        
        return answer;
    }
}

public class 크기가작은부분문자열 {
    
}
