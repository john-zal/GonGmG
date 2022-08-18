package GonGmG.level2;

class Solution {
    int n;
    int answer = 0;
    void targetnumber(int k, int[] numbers, int target, int a) {
        if (k == n) {
            if (a == target) 
                ++answer;
            return ;
        }
        targetnumber(k+1, numbers, target, a+numbers[k]);
        targetnumber(k+1, numbers, target, a-numbers[k]);
    }
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        
        targetnumber(0, numbers, target,0);

        return answer;
    }
}
public class 타겟넘버 {
    
}
