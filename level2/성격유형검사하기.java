package GonGmG.level2;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = {0,0,0,0,0,0,0,0};
        String character = "RTCFJMAN";
        int c;
        String type;
        for(int i = 0; i < survey.length; ++i) {
            c = choices[i];
            if(c < 4) {
                type = String.valueOf(survey[i].charAt(0));
                score[character.indexOf(type)] += 4-c;
            }
            else if(c > 4) {
                type = String.valueOf(survey[i].charAt(1));
                score[character.indexOf(type)] += c%4;
            }
        }
        for(int i = 0; i < score.length; i+=2){
            if(score[i] < score[i+1]) {
                answer += String.valueOf(character.charAt(i+1));
            }
            else {
                answer += String.valueOf(character.charAt(i));
            }
        }
        return answer;
    }
}

public class 성격유형검사하기 {
    
}
