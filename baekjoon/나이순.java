package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 나이순 {
    static int n;
    static int[] arr = new int[100001];
    static String[] name = new String[100001];
    static int[] tmp = new int[100001];
    static String[] nametmp = new String[100001];

    static void merge(int st, int en){
        int mid = (st+en)/2;
        int lidx = st;
        int ridx = mid;

        for(int i = st; i < en; i++) {
            if(ridx == en) {
                nametmp[i] = name[lidx];
                tmp[i] = arr[lidx++];
            }
            else if(lidx == mid) {
                nametmp[i] = name[ridx];
                tmp[i] = arr[ridx++];
            }
            else if(arr[lidx] <= arr[ridx]) {
                nametmp[i] = name[lidx];
                tmp[i] = arr[lidx++];
            }
            else {
                nametmp[i] = name[ridx];
                tmp[i] = arr[ridx++];
            }
        }

        for(int i = st ; i < en; i++) {
            arr[i] = tmp[i];
            name[i] = nametmp[i];
        }
    }

    static void  merge_sort(int st, int en){
        if(st+1 == en) return ;
        int mid = (st+en)/2 ;
        merge_sort(st,mid);
        merge_sort(mid,en);
        merge(st,en);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i< n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = Integer.parseInt(input[0]);
            name[i] = input[1];
        }
        
        merge_sort(0,n);

        for(int i = 0; i < n; i++) 
            bw.write(String.valueOf(arr[i]) + " " + name[i] + "\n");
        
        br.close();
        bw.close();
    }
}