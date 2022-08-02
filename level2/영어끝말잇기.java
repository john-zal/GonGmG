package GonGmG.level2;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {100,100};
        
        for(int i = 0; i < words.length-1; i++){
            String prlast = String.valueOf(words[i].charAt(words[i].length()-1));
            String nxfirst = String.valueOf(words[i+1].charAt(0));
            if(!prlast.equals(nxfirst) && answer[1] > (i+1)/n+1){
                answer[0] = (i+1)%n+1;
                answer[1] = (i+1)/n+1;
            }
            for(int j = i+1; j < words.length; j++){
                if(words[j].equals(words[i]) && answer[1] > j/n+1){
                    answer[0] = j%n+1;
                    answer[1] = j/n+1;
                }
            }
        }
        if(answer[1] == 100) {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
public class 영어끝말잇기 {
    public static void main(String[] args) {
        
    }
}
