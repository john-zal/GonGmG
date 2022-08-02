package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 윷놀이 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++){
            String[] yoot = br.readLine().split(" ");
            int sum = 0;
            for(int j = 0; j < 4; j++) 
                sum += Integer.parseInt(yoot[j]);
            switch(sum) {
                case 0: bw.write("D" + "\n"); break;
                case 1: bw.write("C" + "\n"); break;
                case 2: bw.write("B" + "\n"); break;
                case 3: bw.write("A" + "\n"); break;
                case 4: bw.write("E" + "\n"); break;
            }
        }
        br.close();
        bw.close();
    }
}