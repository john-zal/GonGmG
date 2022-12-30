package GonGmG.level2;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i) {
            if(!st.empty() && st.peek() == s.charAt(i))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        if(st.empty())
            return 1;
        else
            return 0;
    }
}
public class 짝지어제거하기 {
    
}
