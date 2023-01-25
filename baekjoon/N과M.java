package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M  {
    static int n,m;
    static boolean[] isused = new boolean[10];
    static int[] arr = new int[10];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void fun(int k) throws Exception{
        if (k == m) {
            for(int i = 0; i < m; i++){
                bw.write(String.valueOf(arr[i]) + " ");
            }
            bw.write("\n");
            return ;
        }
        for(int i = 1; i <= n; i++){
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                fun(k+1);
                isused[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        fun(0);
        
        bw.close();
        br.close();
    }
}