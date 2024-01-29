import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스타트와링크 {
    static int min = 100000;
    static int n;
    static boolean[] is_used;
    static int[][] s;
    static void fun(int index, int deep) {
        if(deep == s[0].length / 2) {
            int start = 0;
            int link = 0;
            for(int i = 0; i < n; ++i) {
                boolean team = is_used[i];
                for(int j = 0; j < n; ++j) {
                    if(team == is_used[j]) {
                        if(team == true)
                            start += s[i][j];
                        else 
                            link += s[i][j];
                    }
                }
            }
            if(Math.abs(start-link) < min) 
                min = Math.abs(start-link);
        }
        for(int i = index; i < n; ++i) { //0 부터 시작시 시간초과
            if(!is_used[i]) {
                is_used[i] = true;
                fun(i, deep+1);
                is_used[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        is_used = new boolean[n];
        for(int i = 0; i < n; ++i) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; ++j) 
                s[i][j] = Integer.parseInt(line[j]);
        }

        fun(0,0);

        bw.write(String.valueOf(min));

        bw.close();
    }
}