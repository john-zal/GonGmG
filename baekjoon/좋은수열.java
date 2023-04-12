import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 좋은수열 {
    static String min ; 
    static boolean flag = true;

    public static boolean check(String s) { //좋은 수열을 확인하는 부분 - 어렵..
        for(int i = 1; i <= s.length()/2; ++i) {
            String first = s.substring(s.length()-2*i, s.length()-i);
            String second = s.substring(s.length()-i);
            if(first.equals(second))
                return false;
        }
        return true;
    }

    public static void fun(String s, int n) {
        if(flag){
            if(!check(s))
                return ;
            if(n == 0) {
                min = s;
                flag = false;
                return ;
            }
            for(int i = 1; i <= 3; ++i) {
                s = s+String.valueOf(i);
                fun(s,n-1);
                s = s.substring(0, s.length()-1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        fun("",n);

        bw.write(min);
        bw.close();
    }   
}