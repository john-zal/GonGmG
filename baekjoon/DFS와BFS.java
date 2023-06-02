package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS {
    static boolean[][] number;
    static boolean[] check_dfs;
    static boolean[] check_bfs;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> que = new LinkedList<>();

    static void dfs(int V) throws Exception {
        if(check_dfs[V]) {
            bw.write(String.valueOf(V) + " ");
            check_dfs[V] = false;
        }
        for(int i = 1; i < number[V].length; ++i) {
            if(number[V][i]) {
                if(check_dfs[i]){
                    bw.write(String.valueOf(i) + " ");
                    check_dfs[i] = false;
                    dfs(i);
                }
            }
        }
    }

    static void bfs(int V) throws Exception {
        que.add(V);
        check_bfs[V] = false;
        while(!que.isEmpty()) {
            for(int i = 1; i < number[V].length; ++i) {
                if(number[V][i]) {
                    if(check_bfs[i]) {
                        que.add(i);
                        check_bfs[i] = false;
                    }
                }
            }
            bw.write(String.valueOf(String.valueOf(que.poll())) + " ");
            if(!que.isEmpty())
                V = que.peek();
        }
    }
    public static void main(String[] args) throws Exception {

        String[] N_M_V = br.readLine().split(" ");

        int N = Integer.parseInt(N_M_V[0]);
        int M = Integer.parseInt(N_M_V[1]);
        int V = Integer.parseInt(N_M_V[2]);
        
        number = new boolean[N+1][N+1];
        check_dfs = new boolean[N+1];
        check_bfs = new boolean[N+1];

        for(int i = 0; i < M; ++i) {
            String[] line = br.readLine().split(" ");
            
            int dot1 = Integer.parseInt(line[0]);
            int dot2 = Integer.parseInt(line[1]);
            
            number[dot1][dot2] = true;
            number[dot2][dot1] = true;

            check_bfs[dot1] = true;
            check_bfs[dot2] = true;
            check_bfs[V] = true;

            check_dfs[dot1] = true;
            check_dfs[dot2] = true;
            check_dfs[V] = true;
        }

        dfs(V);
        bw.write("\n");
        bfs(V);

        bw.close();
    }
}