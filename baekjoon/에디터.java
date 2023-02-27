import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class 에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i = 0 ; i < str.length(); ++i)
            st1.push(str.charAt(i));

        for(int i = 0; i < num; ++i) {
            String command = br.readLine();
            if(command.length() > 1) {
                st1.push(command.charAt(2));
            }
            else {
                if(command.equals("L")) {
                    if(!st1.isEmpty())
                        st2.push(st1.pop());
                }
                else if(command.equals("D")) {
                    if(!st2.isEmpty())
                        st1.push(st2.pop());
                }
                else if(command.equals("B"))
                    if(!st1.isEmpty())
                        st1.pop();
            }
        }
        while(!st1.isEmpty())
            st2.push(st1.pop());
        
        while(!st2.isEmpty())
            bw.write(st2.pop());
        br.close();
        bw.close();
    }
}