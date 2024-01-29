package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 구간합구하기사 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        String[] number = br.readLine().split(" ");
        int[] num = new int[n];
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(number[i]);

        int[] d = new int[n+1];
        d[0] = 0;
        for(int i = 1; i <= n; i++)
            d[i] = d[i-1] + num[i-1];
        
        for(int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int j = Integer.parseInt(range[0]);
            int k = Integer.parseInt(range[1]);
            bw.write(String.valueOf(d[k] - d[j-1]) + "\n");
        }
        br.close();
        bw.close();
    }
}