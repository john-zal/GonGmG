import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 단어정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i < num; ++i){
            String voca = br.readLine();
            if(!arr.contains(voca))
                arr.add(voca);
        }
        Collections.sort(arr);
        Collections.sort(arr,new voca_length());
        for(String s : arr)
            bw.write(s+"\n");
        bw.close();
    }
}

class voca_length implements Comparator<String> { 
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        else if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}