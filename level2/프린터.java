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
            if (i == arr.size()-1) //테스트 케이스 2, 5, 18번 의 경우해결을 위해 필요. 마지막 원소가 하나만 남았을 경우 두번째 for문으로 들어가지 못해 마지막 남은 문서를 출력하지 못해 answer의 값이 1 모자라게 됨.
                return ++answer;
        }
        return answer;
    }
}
public class 프린터 {
    
}
