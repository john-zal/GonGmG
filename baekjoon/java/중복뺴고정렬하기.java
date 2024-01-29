import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class 중복뺴고정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num_num = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");

        HashSet<Integer> set = new HashSet<>();

        for(String i : num)
            set.add(Integer.parseInt(i));

        int[] i_num = new int[set.size()];
        int k = 0;
        for(int i : set)
            i_num[k++] = i;
        
        Arrays.sort(i_num);

        for(int i : i_num)
            bw.write(i + " ");

        bw.close();
    }
}