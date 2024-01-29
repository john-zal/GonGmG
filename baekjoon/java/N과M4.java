package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n,m;
    static int[] arr = new int[10];
    
    static void fun(int k) throws Exception {
        if(k==m) {
            for(int i = 0; i < m; i++){
                bw.write(String.valueOf(arr[i]) + " ");
            }
            bw.write("\n");
            return ;
        }
        for(int i = 1; i <= n; i++){
            if(k == 0){
                arr[k] = i;
                fun(k+1);
            }
            else {
                arr[k] = i;
                if(arr[k] >= arr[k-1]) 
                    fun(k+1);
            }

        }
    }
    public static void main(String[] args) throws Exception {
        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        fun(0);
        br.close();
        bw.close();
    }
}