package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일이삼더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d = new int[11];
        int n = Integer.parseInt(br.readLine());
        int[] nn = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            nn[i] = Integer.parseInt(br.readLine());
            if(nn[i] > max) max = nn[i];
        }

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for(int i = 4; i <= max; i++) 
            d[i] = d[i-1] + d[i-2] + d[i-3];
        
        for(int i: nn)
            bw.write(String.valueOf(d[i]) + "\n");
        
        bw.close();
        br.close();
    }
}