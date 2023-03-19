package GonGmG.level2;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 1; i <= order.length; ++i) {
            st.push(i);
            while(!st.isEmpty() && st.peek() == order[j]) {
                st.pop();
                ++answer;
            }
        }
        return answer;
    }
}

public class 택배상자 {
    
}
