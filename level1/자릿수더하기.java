import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 0;n>0;i++){
            answer += n%10;
            n = n/10;
        }
        return answer;
    }
}