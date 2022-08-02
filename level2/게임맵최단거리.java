package GonGmG.level2;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    int[][] distance = new int[101][101];
    boolean[][] isused = new boolean[101][101];
    
    public int solution(int[][] maps) {
        Queue<Pair> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        int answer;

        distance[0][0] = 1;
        distance[n-1][m-1] = -1;
        q.offer(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p = new Pair(q.peek().x,q.peek().y);
            q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(isused[nx][ny] || maps[nx][ny] != 1) continue;
                isused[nx][ny] = true;
                distance[nx][ny] = distance[p.x][p.y]+1;
                q.offer(new Pair(nx, ny));
            }
        }
        answer = distance[n-1][m-1];
        return answer;
    }
}
public class 게임맵최단거리 {
    
}
