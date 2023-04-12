package GonGmG.level2;

import java.util.HashSet;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);
        s = s.replace("{", "");
        String[] text_process = s.split("}");
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[text_process.length];

        for(int i = 1; i < text_process.length; ++i) 
            text_process[i] = text_process[i].substring(1);

        for(int i = 0; i < text_process.length; ++i) {
            int index = i;
            for(int j = i+1; j < text_process.length; ++j) {
                if(text_process[index].length() > text_process[j].length())
                    index = j;
            }
            String temp = text_process[i];
            text_process[i] = text_process[index];
            text_process[index] = temp;
        }

        int k = 0;
        for(int i = 0; i < text_process.length; ++i) {
            String[] split = text_process[i].split(",");
            int present_size = set.size();
            for(int j = 0; j < split.length; ++j) {
                set.add(split[j]);
                if(present_size != set.size()) {
                    answer[k++] = Integer.parseInt(split[j]);
                    break;
                }
            }
        }

        return answer;
    }
}