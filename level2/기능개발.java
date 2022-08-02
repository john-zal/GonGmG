package GonGmG.level2;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;
        while(i != progresses.length) {
            int distribute = 0;
            int present = progresses[i];
            while(present >= 100){
                i++;    
                distribute++;
                if(i == progresses.length)
                    break;
                present = progresses[i];
            }
            
            for(int j = i; j < progresses.length; j++)
                progresses[j] += speeds[j];
            
            if(distribute != 0)
                answer.add(distribute);
        }
        int[] ans = new int[answer.size()];
        for(int j = 0; j < answer.size(); j++) 
            ans[j] = answer.get(j);
        return ans;
    }
}
public class 기능개발 {
    public static void main(String[] args) {
    }
}
