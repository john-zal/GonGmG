import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> que = new LinkedList<>();

        String[] n_k = br.readLine().split(" ");

        for(int i = 1; i <= Integer.parseInt(n_k[0]); ++i ) 
            que.add(i);
        
        bw.write("<");
        while(!que.isEmpty()) {
            int k = Integer.parseInt(n_k[1]);
            while(k > 1) {
                --k;
                que.add(que.poll());
            }
            if(que.size() != 1)
                bw.write(que.poll() + ", ");
            else
                bw.write(String.valueOf(que.poll()));
        }
        bw.write(">");
        bw.close();
    }
}