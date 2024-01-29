package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부분수열의합 {
    static int n,s;
    static int cnt = 0;
    static int[] input =  new int[30];
    static void fun(int k,int sum) {
        if(k == n){
            if(sum==s){
                cnt++;
            }
            return ;
        }
        fun(k+1,sum);
        fun(k+1,sum+input[k]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] ns = br.readLine().split(" ");
        String[] li = br.readLine().split(" ");

        n = Integer.parseInt(ns[0]);
        s = Integer.parseInt(ns[1]);

        for(int i = 0; i < n; i++){
            input[i] = Integer.parseInt(li[i]);
        }
        
        fun(0,0);
        if(s==0){
            cnt--;
        }
        bw.write(String.valueOf(cnt));
        
        bw.close();
        br.close();
    }
}