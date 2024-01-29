package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 수정렬하기5 {
    
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);

        for(int i =0 ; i < n; i++)
            bw.write(String.valueOf(arr[i]) + "\n");

        bw.close();
        br.close();
    }    
}