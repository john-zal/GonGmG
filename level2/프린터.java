package GonGmG.level2;

import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < priorities.length; ++i) 
            arr.add(priorities[i]);

        for (int i = 0; i < arr.size(); ++i) {
            for (int j = i+1; j < arr.size(); ++j) {
                if (arr.get(i) < arr.get(j)) {
                    arr.add(arr.get(i));
                    if(i == location) 
                        location = arr.size()-1;
                    break;
                }
                else if (j == arr.size()-1 && arr.get(i) >= arr.get(j)) {
                    ++answer;
                    if(i == location) 
                        return answer;
                }
            }
            if (i == arr.size()-1) {
                return ++answer;
            }
        }
        return answer;
    }
}

public class 프린터 {
    
}
