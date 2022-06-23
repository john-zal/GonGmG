package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 로또 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int k;
    static int[] s = new int[49];
    static int[] element = new int[6];
    static boolean[] isused = new boolean[49];

    static void fun(int m) throws Exception{
        if(m == 6) {
            for(int i = 0; i < 6; i++){
                bw.write(String.valueOf(element[i]) + " ");
            }
            bw.write("\n");
            return ;
        }
        for(int i = 0; i < k; i++){
            if(!isused[i]){
                if(m == 0 ){
                    element[m] = s[i];
                    isused[i] = true;
                    fun(m+1);
                    isused[i] = false;
                }
                else {
                    element[m] = s[i];
                    if(element[m] > element[m-1]){
                        isused[i] = true;
                        fun(m+1);
                        isused[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        ArrayList<String[]> arrlist = new ArrayList<>();
        
        while(true){
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("0"))
                break;
            else {
                arrlist.add(arr);
            }
        }

        for(int i = 0; i < arrlist.size(); i++) {
            k = Integer.parseInt(arrlist.get(i)[0]);
            if(k!=0){
                for(int j = 0; j < k; j++){
                    s[j] = Integer.parseInt(arrlist.get(i)[j+1]);
                    isused[j] = false;
                }
                fun(0);
                bw.write("\n");
            }

        }

        bw.close();
        br.close();
    }
}
