package GonGmG.level2;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        String[] change ;

        for(int i = 0; i < record.length; ++i) {
            change = record[i].split(" ");

            if(!change[0].equals("Leave")) 
                map.put(change[1],change[2]);
        }

        for(int i = 0; i < record.length; ++i) {
            change = record[i].split(" ");
            if(change[0].equals("Enter")) 
                ans.add(map.get(change[1]) + "님이 들어왔습니다.");
            
            else if(change[0].equals("Leave")) 
                ans.add(map.get(change[1]) + "님이 나갔습니다.");
            
        }
        return ans;
    }
}
public class 오픈채팅방 {
    
}
