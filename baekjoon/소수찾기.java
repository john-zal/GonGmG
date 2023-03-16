import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 소수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        String[] num = br.readLine().split(" ");

        int score = 0;

        for(int i = 0; i < num.length; ++i) {
            int number = Integer.parseInt(num[i]);
            if(primary(number))
                ++score;
        }
        bw.write(String.valueOf(score));
        bw.close();
    }
    private static boolean primary(int n) {
        if(n == 1)
            return false;

        for(int i = 2; i*i <= n; ++i){
            if(n % i == 0)
                return false;
        }
        
        return true;
    }
}