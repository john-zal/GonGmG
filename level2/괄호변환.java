package GonGmG.level2;
import java.util.*;

class Solution {
    static StringBuffer ans = new StringBuffer();

    boolean right_check(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == ')') {
                if(st.isEmpty())
                    return false;
                st.pop();
            }
            else
                st.add('(');
        }
        return true;
    }
    void recur(String s,StringBuffer sb) {
        int left = 0;
        int right = 0;
        if(s.length() == 0)
            return ;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') 
                ++left;
            else if (s.charAt(i) == ')')
                ++right;
            if(left == right)
                break;
        }

        String u = s.substring(0, left + right);
        String v = s.substring(left+right);
        if(right_check(u)) {
            sb.append(u);
            recur(v,sb);
        }
        else {
            sb.append("(");
            recur(v,sb);
            sb.append(")");
            for(int i = 1; i < u.length()-1; ++i) {
                if(u.charAt(i) == '(')
                    sb.append(")");
                else
                    sb.append("(");
            }
        }
    }
    public String solution(String p) {
        recur(p,ans);
        return String.valueOf(ans);
    }
}

public class 괄호변환 {
    
}
