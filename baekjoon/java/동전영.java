package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 동전영 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);
        int[] kind = new int[n];
        for(int i = 0; i < n; i++)
            kind[i] = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for(int i = n-1; i >= 0; i--) {
            answer += money / kind[i];
            money = money%kind[i];
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}