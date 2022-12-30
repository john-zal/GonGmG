package GonGmG.level2;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int a : scoville)
            heap.add(a);
        
        while (heap.size() != 1 && heap.peek() < K) {
            if(heap.peek() < K && heap.size() > 1) {
                int num = heap.poll() + heap.poll()*2;
                heap.add(num);
                ++answer;
            }
        }
        if(heap.peek() < K)
            return -1;
        return answer;
    }
}
public class 더맵게 {
    
}
