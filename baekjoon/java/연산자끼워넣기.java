package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 연산자끼워넣기 {
    static int min = 1000000001;
    static int max = -1000000001;
    static int[] num_list;
    static void dfs( int[] cal, int k, int num) {
        if(k == num_list.length) {
            if(num > max)
                max = num;
            if(num < min)
                min = num;
            return ;
        }
        else {
            int present_num = num_list[k];
            for(int i = 0; i < 4; ++i) {
                if(cal[i] != 0) {
                    if(i == 0) {
                        num += present_num;
                        --cal[i];
                        dfs(cal, k+1, num);
                        num -= present_num;
                        ++cal[i];
                    }
                    if(i == 1) {
                        num -= present_num;
                        --cal[i];
                        dfs(cal, k+1, num);
                        ++cal[i];
                        num += present_num;
                    }
                    if(i == 2) {
                        num *= present_num;
                        --cal[i];
                        dfs(cal, k+1, num);
                        ++cal[i];
                        num /= present_num;
                    }
                    if(i == 3) {
                        num /= present_num;
                        --cal[i];
                        dfs(cal, k+1, num);
                        ++cal[i];
                        num *= present_num;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] num_list_s = br.readLine().split(" ");

        num_list = new int[n];
        for(int i = 0; i < n; ++i) 
            num_list[i] = Integer.parseInt(num_list_s[i]);

        String[] cal_s = br.readLine().split(" ");
        int[] cal = new int[4];
        for(int i = 0; i < 4; ++i)
            cal[i] = Integer.parseInt(cal_s[i]);
            
        dfs(cal,1, num_list[0]);
        bw.write(String.valueOf(max) + "\n" + String.valueOf(min));

        bw.close();
    }
}