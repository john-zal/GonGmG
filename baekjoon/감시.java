package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class 감시 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m; //n세로, m가로
    static int camera,ca = 0; //카메라의 개수
    static int result = 1000; 
    static int[][] map = new int[8][8]; //임시 사무실
    static int[][] o_map = new int[8][8]; //원본 사무실
    static int[] f_camera = {1,2,3,4}; //1,3,4번 카메라의 방향
    static int[] t_camera = {1,2}; //2번 카메라의 방향
    static int[] direction; //각 카메라의 방향
    
    static void fill_left(int x,int y) {
        for(int i = (x-1); i >= 0; i--) {
            if(map[i][y] == 0 )
                map[i][y] = 7;
            else if(map[i][y] == 6)
                break;
        }
    }
    static void fill_right(int x,int y) {
        for(int i = (x+1); i < n; i++) {
            if(map[i][y] == 0 )
                map[i][y] = 7;
            else if(map[i][y] == 6)
                break;
        }
    }
    static void fill_up(int x,int y) {
        for(int j = (y-1); j >= 0; j--) {
            if(map[x][j] == 0 )
                map[x][j] = 7;
            else if(map[x][j] == 6)
                break;
        }
    }
    static void fill_down(int x,int y) {
        for(int j = (y+1); j < m; j++) {
            if(map[x][j] == 0)
                map[x][j] = 7;
            else if(map[x][j] == 6)
                break;
        }
    }
    static void fun(int x,int y) {
        if(ca == camera) {
            int bs = 0;
            int d = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++){
                    if(map[i][j]==1){ //1번 카메라
                        if(direction[d] == 1) {//좌
                            d++;
                            fill_left(i, j);
                        }
                        else if(direction[d] == 2) { //아래
                            d++;
                            fill_down(i, j);
                        }
                        else if(direction[d] == 3) { //우
                            d++;
                            fill_right(i, j);
                        }
                        else if(direction[d] == 4) { //위
                            d++;
                            fill_up(i, j);
                        }
                    }
                    else if(map[i][j]==2){ //2번 카메라
                        if(direction[d] == 1) {//좌우
                            d++;
                            fill_left(i, j);
                            fill_right(i, j);
                        }
                        else if(direction[d] == 2) { //상하
                            d++;
                            fill_up(i, j);
                            fill_down(i, j);
                        }
                    }
                    else if(map[i][j]==3){ //3번 카메라
                        if(direction[d]==1){//좌상
                            d++;
                            fill_left(i, j);
                            fill_up(i, j);
                        }
                        else if(direction[d]==2){//좌하
                            d++;
                            fill_left(i, j);
                            fill_down(i, j);
                        }
                        else if(direction[d]==3){//우하
                            d++;
                            fill_right(i, j);
                            fill_down(i, j);
                        }
                        else if(direction[d]==4){//우상
                            d++;
                            fill_right(i, j);
                            fill_up(i, j);
                        }
                    }
                    else if(map[i][j]==4) {//4번 카메라
                        if(direction[d]==1){//좌상하
                            d++;
                            fill_left(i, j);
                            fill_up(i, j);
                            fill_down(i, j);
                        }
                        else if(direction[d]==2){//좌우하
                            d++;
                            fill_left(i, j);
                            fill_right(i, j);
                            fill_down(i, j);
                        }
                        else if(direction[d]==3){//우상하
                            d++;
                            fill_right(i, j);
                            fill_up(i, j);
                            fill_down(i, j);
                        }
                        else if(direction[d]==4){//좌우상
                            d++;
                            fill_left(i, j);
                            fill_right(i, j);
                            fill_up(i, j);
                        }
                    }
                    else if(map[i][j]==5) { //5번 카메라
                        d++;
                        fill_left(i, j);
                        fill_right(i, j);
                        fill_up(i, j);
                        fill_down(i, j);
                    }
                    if(d == ca) {
                        for(int a = 0; a < n; a++){
                            for (int b = 0; b < m; b++){
                                if(map[a][b]==0)
                                    bs++;
                                map[a][b] = o_map[a][b];
                            }
                        }
                        if(bs < result)
                            result = bs;
                        return ;
                    }
                }
            }
        }
        for(int i = x; i < n; i++){
            for(int j = y; j < m; j++){
                if(map[i][j] == 1 || map[i][j] == 3 || map[i][j] == 4){
                    for(int k = 0; k < 4; k++) {
                        direction[ca] = f_camera[k];
                        ca++;
                        fun(i,j+1);
                        ca--;
                    }
                }
                else if(map[i][j] == 2) {
                    for(int k = 0; k < 2; k++) {
                        direction[ca] = t_camera[k];
                        ca++;
                        fun(i,j+1);
                        ca--;
                    }
                }
                else if(map[i][j] == 5) {
                    direction[ca] = 5;
                    ca++;
                    fun(i,j+1);
                    ca--;
                }
            }
            y = 0;
        }
    }
    public static void main(String[] args) throws Exception{
        
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        
        for(int i = 0; i < n; i++){
            String[] ma = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(ma[j]);
                o_map[i][j] = Integer.parseInt(ma[j]); 
                if(Integer.parseInt(ma[j])!=0 && Integer.parseInt(ma[j])!=6)
                    camera++;
            }
        }
        direction = new int[camera];

        fun(0,0);
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}