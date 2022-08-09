package GonGmG.level2;

import java.util.Stack;

class Solution {
    boolean check(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if(!st.empty() && s.charAt(i)-st.peek() < 3 && s.charAt(i)-st.peek() > 0)  //아스키코드를 이용한 괄호 확인
                st.pop();
            else 
                st.push(s.charAt(i));
        }
        if(st.empty())
            return true;
        
        return false;
    }
    public int solution(String s) {
        int answer = 0;
        if(check(s))
            ++answer;
        for(int i = 0; i < s.length()-1; i++) {
            s = s.substring(1, s.length()) + String.valueOf(s.charAt(0));
            if(check(s))
                ++answer;
        }
        return answer;
    }
}
public class 괄호회전하기 {
    
}
