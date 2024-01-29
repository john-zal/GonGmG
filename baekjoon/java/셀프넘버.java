package GonGmG.baekjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class 셀프넘버 {
    static int sn(int n) {
        int ans = n;
        while(n > 0) {
            ans += n%10;
            n /= 10;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] number = new boolean[10001];
        for(int i = 1; i < number.length; ++i) {
            if(sn(i) <= 10000) {
                number[sn(i)] = true;
            }
        }
        for(int i = 1; i < number.length; ++i) {
            if(number[i] != true)
                bw.write(String.valueOf(i) + "\n");
        }
        bw.close();
    }
}