package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이곱하기N타일링 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[1005];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        for(int i = 4; i <= n; i++)
            d[i] = (d[i-1] + d[i-2])%10007;
        
        bw.write(String.valueOf(d[n]));

        bw.close();
        br.close();
    }
}