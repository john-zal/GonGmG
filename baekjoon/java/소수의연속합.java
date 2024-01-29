package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 소수의연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] prime_check = new boolean[n+2];

        for(int i = 2; i*i <= n; ++i) {
            for(int j = 2; j*i <= n; ++j)
                prime_check[j*i] = true;
        }

        int answer = 0;

        for(int i = 2; i < prime_check.length; ++i) {
            int sum = 0;
            if(!prime_check[i]){
                for(int j = i; sum < n; ++j) {
                    if(!prime_check[j])
                        sum += j;
                }
            }
            if(sum == n)
                ++answer;
        }

        bw.write(answer+"");
        bw.close();
    }
}