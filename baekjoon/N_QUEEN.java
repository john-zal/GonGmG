package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N_QUEEN {
    static int n;
    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];
    static int cnt = 0;
    static void func(int k) {
        if(k == n) {
            cnt++;
            return ;
        }
        for(int i = 0; i < n; i++){
            if (isused1[i] || isused2[i+k] || isused3[k-i+n-1])
                continue;
            isused1[i] = true;
            isused2[i+k] = true;
            isused3[k - i + n -1] = true;
            func(k+1);
            isused1[i] = false;
            isused2[i+k] = false;
            isused3[k - i + n -1] = false;
            }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 40; i++){
            isused1[i] = false;
            isused2[i] = false;
            isused3[i] = false;
        }
        n = Integer.parseInt(br.readLine());
        func(0);
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
}