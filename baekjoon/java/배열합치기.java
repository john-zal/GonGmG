package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 배열합치기 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");

        int[] merge = new int[first.length+second.length];
        int f = 0;
        int s = 0;

        for(int i = 0; i < merge.length; i++) {
            if(f==first.length){
                merge[i] = Integer.parseInt(second[s++]);
            }
            else if(s == second.length) {
                merge[i] = Integer.parseInt(first[f++]);
            }
            else if(Integer.parseInt(first[f]) <= Integer.parseInt(second[s]) ){
                merge[i] = Integer.parseInt(first[f++]);
            }
            else {
                merge[i] = Integer.parseInt(second[s++]);
            }
        }
        for(int i = 0; i < merge.length; i++) 
            bw.write(String.valueOf(merge[i]) + " ");


        bw.close();
        br.close();
    }
}
