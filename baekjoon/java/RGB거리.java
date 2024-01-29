package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RGB거리 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] rgb = new int[1001][3];
        int[][] d = new int[1001][3];

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] price = br.readLine().split(" ");
            for(int j = 0; j < 3; j++)
                rgb[i][j] = Integer.parseInt(price[j]);
        }
        d[0][0] = rgb[0][0];
        d[0][1] = rgb[0][1];
        d[0][2] = rgb[0][2];
        for(int i = 1; i <= n; i++) {
            d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + rgb[i][0];
            d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + rgb[i][1];
            d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + rgb[i][2];
        }


        bw.write(String.valueOf(Math.min(d[n][0],Math.min(d[n][1],d[n][2]))));

        br.close();
        bw.close();
    }    
}
