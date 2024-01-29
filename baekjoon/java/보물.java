package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 보물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        int[] aa = new int[n];
        int[] bb = new int[n];
        for(int i = 0;i < n; i++){
            aa[i] = Integer.parseInt(a[i]);
            bb[i] = Integer.parseInt(b[i]);
        }

        Arrays.sort(aa);
        Arrays.sort(bb);

        int answer = 0;
        for(int i = 0; i < n; i++) 
            answer += aa[i]*bb[n-i-1];

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }   
}