package GonGmG.level2;

import java.util.ArrayList;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        for(int i = 0; i < n; ++i ) 
            arr.add(new ArrayList<>());
        for(int i = n-1; i >= 0; --i) 
            for(int j = m-1; j >= 0; --j) 
                arr.get(i).add(board[j].charAt(i));
        while(true) { 
            int cnt = 0;
            for(int i = 0; i < n-1; ++i) {
                for(int j = arr.get(i).size()-1; j > 0; --j) {
                    if(arr.get(i).size() < 2 || arr.get(i+1).size() <= j)
                        continue;
                    char a = Character.toUpperCase(arr.get(i).get(j));
                    if(Character.toUpperCase(arr.get(i).get(j)) == a 
                    && Character.toUpperCase(arr.get(i).get(j-1)) == a 
                    && Character.toUpperCase(arr.get(i+1).get(j-1)) == a 
                    && Character.toUpperCase(arr.get(i+1).get(j)) == a) {
                        arr.get(i).set(j,Character.toLowerCase(a));
                        arr.get(i).set(j-1,Character.toLowerCase(a));
                        arr.get(i+1).set(j,Character.toLowerCase(a));
                        arr.get(i+1).set(j-1,Character.toLowerCase(a));
                    }
                }
            }
            for(int i = 0; i < n; ++i) {
                for(int j = arr.get(i).size()-1; j >= 0 ; --j){ 
                    if(Character.isLowerCase(arr.get(i).get(j))) {
                        arr.get(i).remove(j);
                        ++cnt;
                    }
                }
            }
            answer += cnt;
            if(cnt == 0)
                break;
        }

        return answer;
    }
}

public class 프렌즈4블록 {
    
}
