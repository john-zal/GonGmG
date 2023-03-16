import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 소수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        boolean[] number = new boolean[m+1];
        int score = 0;

        for(; n <= m; ++n) {
            if(!number[n]) {
                if(primary(n)) {
                    bw.write(String.valueOf(n)+"\n");
                    for(int i = n; i <= m; i +=i) 
                        number[i] = true;
                }
            }
        }
        bw.close();
    }
    private static boolean primary(int n) {
        if(n == 1)
            return false;
        for(int i = 2; i*i <= n; ++i) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}