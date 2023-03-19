import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int min = 0;
        int max = 0;

        for(int i = 1; i <= n; ++i) {
            if(n%i == 0 && m%i == 0) {
                if(i > max)
                    max = i;
            }
        }
        for(int i = 1; ; ++i) {
            if(n < m) {
                if((n*i)%m == 0){
                    min = n*i;
                    break;
                }
            }
            else {
                if((m*i)%n == 0) {
                    min = m*i;
                    break;
                }
            }
        }
        bw.write(String.valueOf(max) + "\n" + String.valueOf(min));
        bw.close();
    }
}