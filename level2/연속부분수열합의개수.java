package GonGmG.level2;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < elements.length; ++i) {
            for(int  j = 1; j <= elements.length; ++j) {
                int sum = 0;
                int x = i;
                int y = j;
                while(y != 0){
                    sum += elements[x];
                    --y;
                    ++x;
                    if(y != 0 && x > elements.length-1) 
                        x = 0;
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}

public class 연속부분수열합의개수 {
    
}
