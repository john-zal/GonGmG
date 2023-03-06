import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < test_num; ++i) {
            String[] n_m = br.readLine().split(" ");
            String[] importance = br.readLine().split(" ");

            int index = Integer.parseInt(n_m[1]);
            int[] importance_i = new int[importance.length];
            int sequence = 0;
            Queue<Integer> que = new LinkedList<>();
            
            for(int j = 0; j < importance.length; ++j)
                importance_i[j] = Integer.parseInt(importance[j]);

            for(int j = 0; j < importance_i.length; ++j)
                que.add(importance_i[j]);
            
            Arrays.sort(importance_i);
            
            for(int k = importance_i.length-1; k >= 0; --k) {
                while(que.peek() < importance_i[k]) {
                    que.add(que.poll());
                    --index;
                    if(index < 0)
                        index += que.size();
                }
                que.poll();
                --index;
                ++sequence;
                if(index == -1)
                    break;
            }
            bw.write(sequence + "\n");
        }
        bw.close();
    }
}