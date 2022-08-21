package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 한수 {
    static boolean check(int n) {
        int a = n%10;
        n /= 10;
        int b = n%10;
        n /= 10;
        int minus = a-b;
        while ( n > 0) {
            a = n%10;
            n /= 10;
            if(b - a != minus)
                return false;
            b = n%10;
            if(a - b != minus && n!=0)
                return false;
            n /= 10;
        }
        return true;
    }
    static int hansu(int n) {
        int ans = 99;
        if(n < 100) {
            return n;
        }
        else {
            for(int i = 100; i <= n; ++i) {
                if (check(i)) {
                    ++ans;
                }
            }
        }
        return ans;
    } 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(hansu(input)));
        br.close();
        bw.close();
    }
}