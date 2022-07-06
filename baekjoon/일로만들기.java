package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일로만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d = new int[10000001];
        int n = Integer.parseInt(br.readLine());
        d[1] = 0;

        for(int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;
            if(i%2 == 0) d[i] = Math.min(d[i],d[i/2] + 1);            
            if(i%3 == 0) d[i] = Math.min(d[i],d[i/3] + 1);
        }
        
        bw.write(String.valueOf(d[n]));
        
        br.close();
        bw.close();
    }
}