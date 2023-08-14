package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 환상의짝꿍 {
    static boolean check_prime(long num) {
        for(int i = 2; i*i <= num; ++i) {
            if(num%i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; ++i) {
            String[] couple_list = br.readLine().split(" ");
            long sum = Long.parseLong(couple_list[0]) + Long.parseLong(couple_list[1]);
            
            if(sum >= 4 && sum%2 == 0)
                bw.write("YES\n");
            else {
                
            }
        }
        bw.close();
    }
}
