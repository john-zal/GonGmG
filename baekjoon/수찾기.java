import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class 수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> set = new HashSet<>();
        String n_num = br.readLine();
        String[] n = br.readLine().split(" ");
        String m_num = br.readLine();
        String[] m = br.readLine().split(" ");

        for(String n_string : n) 
            set.add(n_string);
        
        for(String m_string : m) {
            if(set.contains(m_string)) 
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.close();
    }
}