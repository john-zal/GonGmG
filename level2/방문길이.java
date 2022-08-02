package GonGmG.level2;

class Solution {
    public int solution(String dirs) {
        String[][] point = new String[11][11];
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                point[i][j] = "";
            }
        }
        int answer = 0;
        int[] present = {5,5};
        
        for(int i = 0; i < dirs.length(); i++) {
            switch(dirs.charAt(i)){
                case 'U' : if(present[1] + 1 < 11) {
                    present[1]++;
                    if(!point[present[0]][present[1]].contains("4") && !point[present[0]][present[1]-1].contains("2")) {
                        answer++;
                        point[present[0]][present[1]-1] += "2";
                        point[present[0]][present[1]] += "4";
                    }
                    break;
                }
                case 'D' : if(present[1] - 1 >= 0) {
                    present[1]--;
                    if(!point[present[0]][present[1]].contains("2") && !point[present[0]][present[1]+1].contains("4")) {
                        answer++;
                        point[present[0]][present[1]+1] += "4";
                        point[present[0]][present[1]] += "2";
                    }
                    break;
                }
                case 'R' : if(present[0] + 1 < 11) {
                    present[0]++;
                    if(!point[present[0]][present[1]].contains("1") && !point[present[0]-1][present[1]].contains("3")) {
                        answer++;
                        point[present[0]-1][present[1]] += "3";
                        point[present[0]][present[1]] += "1";
                    }
                    break;
                }
                case 'L' : if(present[0] - 1 >= 0) {
                    present[0]--;
                    if(!point[present[0]][present[1]].contains("3") && !point[present[0]+1][present[1]].contains("1")) {
                        answer++;
                        point[present[0]+1][present[1]] += "1";
                        point[present[0]][present[1]] += "3";
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
public class 방문길이 {
    
}
