import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 두수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numnum = br.readLine();
        String num = br.readLine();
        int x = Integer.parseInt(br.readLine());
        String[] arr = num.split(" ");
        int[] all = new int[2000000];
        for(int i = 0; i < arr.length; i++){
            
        }
        int answer = 0;
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}