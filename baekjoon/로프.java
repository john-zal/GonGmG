package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 로프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        for(int i = 0; i < n; i++)
            rope[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(rope);
        int max = 0;
        for(int i = n-1; i >= 0; i--){
            int weight = rope[i]*(n-i);
            if(weight > max)
                max = weight;
        }
        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
}
