package GonGmG.level2;

class Solution {
    String knumber(int n,int k) {
        StringBuffer sb = new StringBuffer();
        while(n!=0) {
            String num = String.valueOf(n%k);
            n /= k;
            sb.append(num);
        }
        return String.valueOf(sb.reverse());
    }
    
    boolean prime(long n) {
        if(n == 0 || n == 1)
            return false;
        for(long i = 2; i*i <= n; i++) { // i가 int형일경우 i*i가 int형 범위 밖으로 나갈 수 있음. 
            //그럴경우 오버플로우 발생한 뒤 int형 최솟값으로 i가 변해 무한루프를 돌게됨.
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String kn = knumber(n, k);
        StringBuffer num = new StringBuffer("");

        for(int i = 0; i < kn.length(); ++i) {
            if(kn.charAt(i) != '0') 
                num.append(String.valueOf(kn.charAt(i)));
            else {
                if(num.length() > 0 && prime(Long.parseLong(String.valueOf(num))))
                    answer++;
                num.setLength(0);;
            }
        }
        if(num.length() > 0 && prime(Long.parseLong(String.valueOf(num))))
            answer++;
        return answer;
    }
}
public class k진수에서소수개수구하기 {
    
}
