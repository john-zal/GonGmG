import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] numbers = new int[num];

        Stack<Integer> st = new Stack<>();
        ArrayList<String> push_pop = new ArrayList<>();
        
        for(int i = 0; i < num; ++i) 
            numbers[i] = Integer.parseInt(br.readLine());
        
        int k = 1;
        for(int i = 0; i < num; ++i) {
            int present_num = numbers[i];
            if(st.isEmpty()) {
                st.push(k++);
                push_pop.add("+\n");
            }
            while(st.peek() != present_num && k <= num+1){
                st.push(k++);
                push_pop.add("+\n");
            }
            st.pop();
            push_pop.add("-\n");
            if(k > num+1){
                bw.write("NO");
                break;
            }
        }
        if(k <= num+1)
            for(String i : push_pop)
                bw.write(i);
        bw.close();
    }   
}