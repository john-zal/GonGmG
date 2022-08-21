package GonGmG.level2;

class Solution {
    int[] answer = new int[2];

    void fun ( int[][] arr , int a , int b , int size) {
        int k = arr[a][b];
        for ( int i = a ; i < size+a; ++i ) {
            for ( int j = b; j < size+b; ++j) {
                if (k == arr[i][j]) {
                    if( i == size+a-1 && j == size+b-1) {
                        ++answer[k];
                    }
                }
                else {
                    fun(arr, a , b , size/2);
                    fun(arr, a + size/2, b, size/2);
                    fun(arr, a , b + size/2, size/2);
                    fun(arr, a + size/2, b + size/2, size/2);
                    return ;
                }
            }
        }
    }
    
    public int[] solution(int[][] arr) {
        fun(arr, 0,0, arr.length);
        return answer;
    }
}

public class 쿼드압축후개수세기 {
    
}
