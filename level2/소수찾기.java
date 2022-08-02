package GonGmG.level2;

import java.util.ArrayList;

class Solution {
    int n;
    int answer = 0;
    String[] num;
    boolean[] isused;
    ArrayList<String> makenum = new ArrayList<>();
    StringBuilder sb = new StringBuilder("");

    boolean prime(int n) {
        if(n == 0 || n == 1)
            return false;
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    void fun(int k) {
        if(k == n) 
            return ;
        for(int i = 0; i < n; i++) {
            if(!isused[i]){
                sb.append(num[i]);
                if(!makenum.contains(String.valueOf(sb)) && sb.charAt(0) != '0'){
                    makenum.add(String.valueOf(sb));
                    if(prime(Integer.parseInt(String.valueOf(sb)))) 
                        answer++;
                }
                fun(k+1);
                sb.deleteCharAt(k);
            }
        }
    }
    public int solution(String numbers) {
        n = numbers.length();
        num = new String[n];
        isused = new boolean[n];
        for(int i = 0; i < n; i++){ 
            num[i] = String.valueOf(numbers.charAt(i));
            isused[i] = false;
        }
        fun(0);
        return answer;
    }
}
public class 소수찾기 { 
    public static void main(String[] args) {
    }
}