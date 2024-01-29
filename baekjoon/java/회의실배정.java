package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class 회의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        int conference = 0;

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(input[0]);
            time[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(time,new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if(a1[1] == a2[1]) 
                    return a1[0] - a2[0];
                return a1[1] - a2[1];
            }
        });

        int finish = 0;
        for(int i = 0; i < n; i++) {
            if(finish <= time[i][0]) {
                finish = time[i][1];
                conference++;
            }
        }
        bw.write(String.valueOf(conference));

        br.close();
        bw.close();
    }    
}