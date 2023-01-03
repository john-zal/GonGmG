package GonGmG.level2;

import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] count = new int[tangerine.length];
        
        Arrays.sort(tangerine);
        int j = 0;

        for(int i = 0; i < tangerine.length-1; ++i) {
            ++count[j];
            if(tangerine[i] != tangerine[i+1]) 
                ++j;
        }
        ++count[j];
        Arrays.sort(count);

        for(int i = count.length-1; i > 0; --i) {
            if(count[i] < k){
                k -= count[i];
                answer++;
            }
            else {
                answer++;
                break;
            }
        }
        return answer;
    }
}
public class 귤고르기 {
    
}
