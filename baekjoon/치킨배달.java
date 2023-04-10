import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 치킨배달 {
    static boolean[] is_used = new boolean[14];
    static int m;
    static int min_distance = 10000;

    static void dfs(ArrayList<int[]> chicken , ArrayList<int[]> customer, int deepth, int index) {
        if(deepth == m) {
            int temp_min_distance = 0;
            for(int i = 0; i < customer.size(); ++i) {
                int[] present_customer = customer.get(i);
                int c_c_distance = 10000;
                for(int j = 0; j < chicken.size(); ++j) {
                    if(is_used[j]){
                        int[] present_chicken = chicken.get(j);
                        int distance = Math.abs(present_chicken[0]-present_customer[0]) + Math.abs(present_chicken[1] - present_customer[1]);
                        c_c_distance = Math.min(c_c_distance,distance);
                    }
                }
                temp_min_distance += c_c_distance;
            }
            min_distance = Math.min(min_distance,temp_min_distance);
            return ;
        }
        for(int i = index; i < chicken.size(); ++i) {
            if(!is_used[i]){
                is_used[i] = true;
                dfs(chicken, customer, deepth+1, i);
                is_used[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        String[][] town = new String[n][n];
        for(int i = 0; i < n; ++i) {
            String[] town_line = br.readLine().split(" ");
            town[i] = town_line;
        }

        ArrayList<int[]> chicken = new ArrayList<>();
        ArrayList<int[]> customer = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                int[] point = {i,j};
                if(town[i][j].equals("2"))
                    chicken.add(point);
                if(town[i][j].equals("1"))
                    customer.add(point);
            }
        }

        dfs(chicken, customer, 0, 0);

        bw.write(String.valueOf(min_distance));
        
        bw.close();
    }
}