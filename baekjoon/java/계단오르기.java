package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 계단오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] d = new int[305][2];
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[305];

        for(int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());
        
        d[1][0] = stair[1];
        d[1][1] = 0;
        d[2][0] = stair[2];
        d[2][1] = stair[1] + stair[2];
        for(int i = 3; i <= n; i++) {
            d[i][0] = Math.max(d[i-2][0],d[i-2][1]) + stair[i];
            d[i][1] = d[i-1][0] + stair[i];
        }

        bw.write(String.valueOf(Math.max(d[n][0],d[n][1])));

        bw.close();
        br.close();
    }  
}