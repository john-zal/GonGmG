package GonGmG.level2;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        
        ArrayList<String> dic = 
            new ArrayList<>(Arrays.asList("0","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        ArrayList<Integer> ans = new ArrayList<>();

        int j;
        for(int i = 0; i < msg.length(); ++i) {
            j = i+1;
            if(dic.indexOf(String.valueOf(msg.charAt(i))) > 0 && j != msg.length()) {
                ++j;
                while(dic.indexOf(msg.substring(i, j)) > 0 && j != msg.length()) 
                    ++j;
                if(j == msg.length() && dic.indexOf(msg.substring(i,j)) > 0){
                    ans.add(dic.indexOf(msg.substring(i, j)));
                    break;
                }
                else if (j == msg.length() && dic.indexOf(msg.substring(i,j)) < 0) {
                    ans.add(dic.indexOf(msg.substring(i,j-1)));
                    ans.add(dic.indexOf(String.valueOf(msg.charAt(j-1))));
                    break;
                }
                ans.add(dic.indexOf(msg.substring(i,j-1)));
                dic.add(msg.substring(i, j));
                i = i+(j-2-i);
            }
            else if (j == msg.length()){
                ans.add(dic.indexOf(String.valueOf(msg.charAt(i))));
            }

        }
        return ans;
    }
}
public class 압축 {
    
}
