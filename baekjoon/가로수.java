package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;

public class 가로수 {

    static int euclidean(int n, int m) {
        int extra = Math.max(n,m)%Math.min(n,m);
        if(extra == 0)
            return Math.min(n,m);
        
        n = Math.min(n,m);
        while(extra != 0) {
            int temp = extra;
            extra = n%extra;
            n = temp;
        }
        return n;
    }
    static int max_common_divisor(int n, int m) {
        int min = Math.min(n,m);
        for(int i = min; i > 1; --i) {
            if(n%i == 0) {
                if(m%i == 0)
                    return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] existing_tree = new int[n];
        for(int i = 0; i < n; ++i)
            existing_tree[i] = Integer.parseInt(br.readLine());
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n-1; ++i) 
            set.add(existing_tree[i+1] - existing_tree[i]);
        
        Iterator<Integer> iter = set.iterator();
        int min_between_tree = iter.next();

        while(iter.hasNext()) 
            min_between_tree = euclidean(iter.next(),min_between_tree);
        
        int range = existing_tree[existing_tree.length-1] - existing_tree[0];
        bw.write(range/min_between_tree-n+1+"");
        bw.close();
    }
}