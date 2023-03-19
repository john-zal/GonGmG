package GonGmG.level2;

import java.util.HashMap;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(numbers.length-1,-1);
        answer[numbers.length-1] = -1;
        int k ;
        for(int i = numbers.length-2; i >= 0; --i) {
            if(numbers[i] < numbers[i+1] ) {
                answer[i] = numbers[i+1];
                map.put(i,i+1);
            }
            else {
                if(numbers[i] < answer[i+1]) {
                    answer[i] = answer[i+1];
                    map.put(i,map.get(i+1));
                }
                else {
                    k = map.get(i+1);
                    while(true) {
                        if(k == -1 || answer[k] == -1){
                            answer[i] = -1;
                            map.put(i,-1);
                            break;
                        }
                        if(numbers[i] < answer[k]) {
                            answer[i] = answer[k];
                            map.put(i,k);
                            break;
                        }
                        k = map.get(k);

                    }
                }
            }
        }
        return answer;
    }
}

public class 뒤에있는큰수찾기 {
    
}
