import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_num; ++i) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            Deque<String> dq = new ArrayDeque<>();

            if(size > 0) {
                String[] list = br.readLine().split(",");
                list[0] = list[0].substring(1);
                list[list.length-1] = list[list.length-1].substring(0,list[list.length-1].length()-1);
                boolean front_back = true;
                for(String k : list)
                    dq.add(k);
                
                for(int j = 0; j < command.length(); ++j) {
                    if(command.charAt(j) == 'R') 
                        front_back = !front_back;
                    else {
                        if(dq.isEmpty()){
                            bw.write("error\n");
                            break;
                        }
                        else {
                            if(front_back)
                                dq.removeFirst();
                            else 
                                dq.removeLast();
                        }
                    }
                    if(j == command.length()-1) {
                        bw.write("[");
                        while(!dq.isEmpty()) {
                            if(front_back)
                                bw.write(dq.pollFirst());                            
                            else 
                                bw.write(dq.pollLast());
                            if(!dq.isEmpty())
                                bw.write(",");
                        }
                        bw.write("]\n");
                    }
                }
            }
            else {
                String empty = br.readLine();
                for(int j = 0; j < command.length(); ++j) {
                    if(command.charAt(j) == 'D') {
                        bw.write("error\n");
                        break;
                    }
                    if(j == command.length()-1) {
                        bw.write(empty+"\n");
                    }
                }
            }
        }

        bw.close();
    }    
}