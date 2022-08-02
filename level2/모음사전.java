package GonGmG.level2;

class Solution {
    String[] aeiou = {"A","E","I","O","U"};
    int search = 0;
    int answer;
    StringBuilder s = new StringBuilder("");
    void fun(int k,String w) {
        if(k == 5 )
            return ;
        for(int i = 0; i < 5; i++) {
            s.append(aeiou[i]);
            search++;
            if(String.valueOf(s).equals(w))
                answer = search;
            fun(k+1,w);
            s.deleteCharAt(k);
        }
    }
    public int solution(String word) {
        fun(0,word);
        return answer;
    }
}
public class 모음사전 {
    public static void main(String[] args) {
        
    }
}
