import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 회전하는큐 {
    static int right_circle(Deque<Integer> r_dq,int k) {
        int answer = 0;
        while(r_dq.peekFirst() != k) {
            r_dq.addLast(r_dq.pollFirst());
            ++answer;
        }
        r_dq.pollFirst();
        return answer;
    }
    static int left_circle(Deque<Integer> l_dq, int k) {
        int answer = 1;
        while(l_dq.peekLast() != k) {
            l_dq.addFirst(l_dq.pollLast());
            ++answer;
        }
        l_dq.pollLast();
        return answer;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new ArrayDeque<>();
        
        String[] num = br.readLine().split(" ");
        String[] poplist = br.readLine().split(" ");
        int answer = 0;
        for(int i = 1; i <= Integer.parseInt(num[0]); i++)
            dq.add(i);
        
        for(String i : poplist) {
            int k = Integer.parseInt(i);
            while(true) {
                if(dq.peekFirst() == k) 
                    dq.pollFirst();
                
                else {
                    Deque<Integer> l_dq = new ArrayDeque<>(dq);
                    Deque<Integer> r_dq = new ArrayDeque<>(dq);
                    if(right_circle(r_dq,k) < left_circle(l_dq,k)) {
                        answer += right_circle(dq, k);
                    }
                    
                    else 
                        answer += left_circle(dq, k);
                }
                break;
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}