package GonGmG.level2;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        int zero;
        int decimal;
        while(!s.equals("1")) {
            StringBuffer ss = new StringBuffer(s);
            zero = 0;
            decimal = 0;
            for(int i = 0; i < ss.length(); i++) {
                if(String.valueOf(ss.charAt(i)).equals("0")){
                    zero++;
                    ss.deleteCharAt(i);
                    i--;
                }
            }
            decimal = ss.length();
            
            s = Integer.toBinaryString(decimal);

            answer[0]++;
            answer[1] += zero;
        }
        return answer;
    }
}
public class 이진변환반복하기 {
    
}
