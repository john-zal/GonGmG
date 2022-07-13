package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일로만들기이 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[1000001];
        int[] num = new int[1000001];
        
        d[1] = 0;
        for(int i = 2; i <= n; i++) {
            num[i] = i-1;
            d[i] = d[i-1] + 1;
            if(i%2==0 && d[i] > (d[i/2]+1)) {
                d[i] = d[i/2] + 1;
                num[i] = i/2;
            }
            if(i%3==0 && d[i] > (d[i/3]+1)) {
                d[i] = d[i/3] + 1;    
                num[i] = i/3;
            }
        }
        bw.write(String.valueOf(d[n])+"\n" + String.valueOf(n) + " ");
        while(n!=1) {
            bw.write(String.valueOf(num[n]) + " ");
            n = num[n];
        }
        bw.close();
        br.close();
    }
}