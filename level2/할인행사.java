package GonGmG.level2;

import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day = 0;
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < discount.length - 9; ++i) {
            day = 0;
            
            for(int j = 0; j < want.length; ++j) 
                map.put(want[j],number[j]);
            
            for(int j = i; j < i + 10; ++j) {
                if(map.get(discount[j]) != null) 
                    map.put(discount[j],map.get(discount[j])-1);
            }
            for(String k : map.keySet()) { 
                if(map.get(k) > 0) {
                    day = 0;
                    break;
                }
                else //flag변수는 boolean으로 해보자
                    day = i+1;
            }
            if(day != 0)
                ++answer;
        }
        return answer;
    }
}

public class 할인행사 {
    
}
