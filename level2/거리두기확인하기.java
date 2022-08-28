package GonGmG.level2;

class Solution {
    int checkpoint = 0;
    boolean[][] ischecked = new boolean[5][5];

    void check(String[][] pl, int x, int y) {
        if( x + y == 8 || checkpoint == 1)
            return ;
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                if ( pl[i][j].equals("P") && !ischecked[i][j]) {
                    ischecked[i][j] = true;
                    check(pl,i,j);
                }
                if(pl[i][j].equals("P") && (Math.abs(x-i) + Math.abs(y-j) <= 2) && (Math.abs(x-i) + Math.abs(y-j) > 0)){
                    int xcheck = 0;
                    for(int a = Math.min(x,i); a <= Math.max(x,i); ++a) {
                        for(int b = Math.min(y,j); b <= Math.max(y,j); ++b) {
                            if(pl[a][b].equals("O")) {
                                ++xcheck;
                                break;
                            }
                        }
                    }
                    if( xcheck > 0 || (Math.abs(x-i) + Math.abs(y-j) == 1))
                        checkpoint = 1; 
                }
            }
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; ++i) {
            String[][] place = new String[5][5];
            for(int j = 0; j < 5; ++j) {
                for(int k = 0; k < 5; ++k) {
                    place[j][k] = String.valueOf(places[i][j].charAt(k));
                    ischecked[j][k] = false;
                }
            }
            check(place,100,100);
            if(checkpoint == 0) {
                answer[i] = 1;
            }
            else {
                answer[i] = 0;
            }
            checkpoint = 0;
        }
        return answer;
    }
}
public class 거리두기확인하기 {
    
}
