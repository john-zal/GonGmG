package GonGmG.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    int bt,bp,ut,up;
    
    int calprice(int min) {
        int fee;
        if(min <= bt) 
            return bp;

        else {
            fee = bp + (int)Math.ceil((double)(min-bt)/ut) * up;
            return fee;
        }
    }
    int tomin(String s) {
        String[] timemin = s.split(":");
        int min = Integer.parseInt(timemin[0])*60 + Integer.parseInt(timemin[1]);
        return min;
    }
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        String[][] angerecords = new String[records.length][4];
        for(int i = 0; i < records.length; ++i) {
            angerecords[i] = records[i].split(" ");
            map.put(angerecords[i][1],new ArrayList<>());
            map2.put(angerecords[i][1],0);
        }
        for(int i = 0; i < angerecords.length; ++i) 
            map.get(angerecords[i][1]).add(angerecords[i][0]);
        
        int min;
        bt = fees[0];
        bp = fees[1];
        ut = fees[2];
        up = fees[3];

        for(String i : map.keySet()) {
            min = 0;
            for(int j = 0; j < map.get(i).size(); ++j) {
                if(map.get(i).size()%2 == 0) {
                    if(j%2==0) {
                        min -= tomin(map.get(i).get(j));
                    }
                    else{
                        min += tomin(map.get(i).get(j));
                    }
                }
                else {
                    if(j == map.get(i).size()-1) {
                        min += 1439;
                    }
                    if(j%2==0){
                        min -= tomin(map.get(i).get(j));
                    }
                    else{
                        min += tomin(map.get(i).get(j));
                    }
                }
            }
            map2.put(i,calprice(min));
        }
        
        answer = new int[map2.size()];
        String[] ans = new String[answer.length];
        
        int i = 0;
        for(String key : map2.keySet())
            ans[i++] = key;
        
        Arrays.sort(ans);
        
        for(int j = 0; j < ans.length; j++){
            answer[j] = map2.get(ans[j]);
        }
        return answer;
    }
}

public class 주차요금계산 {
    
}
