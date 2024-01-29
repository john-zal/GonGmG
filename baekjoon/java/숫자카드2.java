import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 숫자카드2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        HashMap<String,Integer> map = new HashMap<>();

        int n_num = Integer.parseInt(br.readLine());
        String[] n = br.readLine().split(" ");

        int m_num = Integer.parseInt(br.readLine());
        String[] m = br.readLine().split(" ");

        for(String i : n){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i,map.get(i)+1);
        }

        for(int i = 0; i < m_num; ++i) {
            if(!map.containsKey(m[i]))
                m[i] = "0";
            else
                m[i] = String.valueOf(map.get(m[i]));
        }

        for(String i : m)
            bw.write(i + " ");
        
        bw.close();
    }
}