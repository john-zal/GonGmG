package GonGmG.level2;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        long lk = left/n;
        long ls = left%n;
        long num = lk+1;
        if (left - n*lk > lk + 1) {
            num = ls; 
        }
        for(int i = 0; i < answer.length; ++i ){
            if ( i + left - n*lk < lk+1){
                answer[i] = (int)num;
            }
            else {
                if ( (i + left)/n != lk ){
                    answer[i] = (int)(++lk)+1;
                    num = lk+1;
                }
                else {
                    answer[i] = (int)++num;
                }
            }
        }
        return answer;
    }
}

