package GonGmG.level1;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); ++i) {
            Character present_s = s.charAt(i);
            answer[i] = -1;
            for(int j = i-1; j >= 0; --j) {
                Character previous_s = s.charAt(j);
                if(present_s == previous_s){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        return answer;
    }
}
public class 가장가까운같은글자 {
    
}
