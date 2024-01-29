package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n,m;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];
    
    static void fun(int k) throws Exception {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                bw.write(String.valueOf(arr[i]) + " ");
            }
            bw.write("\n");
            return ; 
        }
        for(int i = 1; i <= n; i++){
            arr[k] = i;
            fun(k+1);
        }
    }
    public static void main(String[] args) throws Exception {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for(int i = 0; i < isused.length; i++)
            isused[i] = false;

        fun(0);
        br.close();
        bw.close();
    }
}