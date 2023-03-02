import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num; ++i) {
            String parenthesis = br.readLine();
            int flag = 0;
            for(int j = 0; j < parenthesis.length(); ++j) {
                if(parenthesis.charAt(j) == '(')
                    st.push('(');
                else {
                    if(st.isEmpty()){
                        bw.write("NO\n");
                        flag = 1;
                        break;
                    }
                    else
                        st.pop();
                }
            }
            if(flag == 0){
                if(!st.isEmpty())
                    bw.write("NO\n");
                else
                    bw.write("YES\n");
            }
            st.clear();
        }
        bw.close();
    }    
}
