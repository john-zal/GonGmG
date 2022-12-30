package level2;

import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        ArrayList<Integer> number = new ArrayList<>();
        
        for (int i = 1; i < s.length()-1; ++i ) {
            if(s.charAt(i) == '{') {
                cnt = 0;
                for(int j = i+1 ; ; ++j) {
                    if(s.charAt(j) != ',')
                        ++cnt;
                    if(s.charAt(j) == '}')
                        break;
                }
            }
            if(s.charAt(i) != '{' && s.charAt(i) != '}' && s.charAt(i) != ',') {
                for(int j = 0; ;++j) {
                    
                }
                if(!number.contains(s.charAt(i))) {
                    number.add(s.charAt(i));
                }
                else {
                    if(cnt < number.size()) {
                        number.remove(s.charAt(i));
                        number.add(0,s.charAt(i));
                    }
                }
            }    
        }
        for (int i = 0; i < number.size(); ++i)
            answer[i] = Character.getNumericValue(number.get(i));
        return answer;
    }
}

public class 튜플 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        
    }
}