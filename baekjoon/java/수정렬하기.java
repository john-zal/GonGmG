package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기 {
    static int n;
    static int[] arr = new int[1001];
    static int[] temp = new int[1001];

    static void merge(int st, int en){
        int mid = (st+en)/2;
        int lidx = st;
        int ridx = mid;

        for(int i = st; i < en; i++) {
            if(ridx == en) temp[i] = arr[lidx++];
            else if(lidx == mid) temp[i] = arr[ridx++];
            else if(arr[lidx] <= arr[ridx]) temp[i] = arr[lidx++];
            else temp[i] = arr[ridx++];
        }

        for(int i = st ; i < en; i++) 
            arr[i] = temp[i];
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
        
        for(int i = 0; i< n; i++) 
            arr[i] = Integer.parseInt(br.readLine());
        
        merge_sort(0,n);

        for(int i = 0; i < n; i++) 
            bw.write(String.valueOf(arr[i]) + "\n");
        
        br.close();
        bw.close();
    }
}