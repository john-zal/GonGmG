package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 홀수 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = 101;
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num%2 != 0) {
                sum += num;
                if(min > num)
                    min = num;
            }
        }
        if(sum == 0) 
            bw.write("-1");
        else 
            bw.write(String.valueOf(sum) + "\n" + String.valueOf(min));
        br.close();
        bw.close();
    }
}