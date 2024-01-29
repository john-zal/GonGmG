import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 약수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        String[] divisor = br.readLine().split(" ");

        int max = 0;
        int min = 1000000;

        for(int i = 0; i < divisor.length; ++i) {
            if(Integer.parseInt(divisor[i]) > max)
                max = Integer.parseInt(divisor[i]);
            if(Integer.parseInt(divisor[i]) < min)
                min = Integer.parseInt(divisor[i]);
        }
        bw.write(String.valueOf(max*min));
        bw.close();
    }
}