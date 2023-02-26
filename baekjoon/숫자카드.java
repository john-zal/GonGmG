import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class 숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n_num = br.readLine();
        String[] n = br.readLine().split(" ");
        String m_num = br.readLine();
        String[] m = br.readLine().split(" ");

        HashSet<String> set = new HashSet<>();

        for(String n_string : n)
            set.add(n_string);
        
        for(String m_string : m) {
            if(set.contains(m_string))
                bw.write("1 ");
            else
                bw.write("0 ");
        }
        bw.close();
    }
}
