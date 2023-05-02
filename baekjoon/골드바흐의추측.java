package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 골드바흐의추측 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime_number = new boolean[10000001];
        
        for(int i = 2; i*i <= 1000000; ++i) {
            if(!prime_number[i]){
                for(int j = 2; i*j <= 1000000; ++j) {
                    prime_number[i*j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        while(n != 0) {
            for(int i = n-3; i > 2; i = i-2) {
                if(!prime_number[i]) {
                    if(!prime_number[n-i]) {
                        bw.write(String.valueOf(n) + " = " + String.valueOf(n-i) + " + " + String.valueOf(i) + "\n");
                        break;
                    }
                }
                if(i < (n-i)) {
                    bw.write("Goldbach's conjecture is wrong.");
                    break;
                }
            }

            n = Integer.parseInt(br.readLine());
        }

        bw.close();
    }
}