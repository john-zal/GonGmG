package GonGmG.level1;

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int need_ing = 1;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < ingredient.length; ++i) {
            st.add(ingredient[i]);
            if(need_ing == ingredient[i] || need_ing-3 == ingredient[i])
                ++need_ing;
            else{
                need_ing = 1;
                if(st.peek() == 1)
                    ++need_ing;
            }
            if(need_ing == 5) {
                need_ing = 1;
                for(int j = 0; j < 4; ++j)
                    st.pop();
                ++answer;
                if(!st.isEmpty() && st.peek() == 1) 
                    ++need_ing;
                else if(!st.isEmpty() && st.peek() == 2) {
                    st.pop();
                    if(!st.isEmpty() && st.peek() == 1)
                        need_ing += 2;
                    st.add(2);
                }
            }
        }
        return answer;
    }
}
public class 햄버거만들기 {
    public static void main(String[] args) {

    }
}
