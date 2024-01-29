package GonGmG.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스도쿠 {
    static int[][] sudoku = new int[9][9];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean flag = true;
    static boolean check(int row, int col, int num) {
        //horizontal
        for(int i = 0; i < 9; ++i) {
            if(sudoku[row][i] == num)
                return false;
        }
        //vertical
        for(int i = 0; i < 9; ++i) {
            if(sudoku[i][col] == num)
                return false;
        }
        //square
        int start_i = row/3*3;
        int start_j = col/3*3;

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if(sudoku[start_i+i][start_j+j] == num)
                    return false;
            }
        }

        return true;
    }
    static void backtracking(int row,int col) throws Exception {
        if(row == 9) {
            for(int i = 0; i < 9; ++i) {
                for(int j = 0; j < 9; ++j) {
                    bw.write(sudoku[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.close();
            flag = false;
        }
        if(flag) {
            if(col == 9) {
                backtracking(row+1, 0);
                return ;
            }
            if(sudoku[row][col] == 0) {
                for(int i = 1; i <= 9; ++i) {
                    if(check(row, col, i)) {
                        if(row == 0 && col == 2)
                            System.out.println(i);  
                        sudoku[row][col] = i;
                        backtracking(row, col+1);
                    }
                }
                sudoku[row][col] = 0;
                return ;
            }
            backtracking(row, col+1);
        }
    }
    public static void main(String[] args) throws Exception {
        sudoku = new int[9][9];
        for(int i = 0; i < 9; ++i) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 9; ++j) 
                sudoku[i][j] = Integer.parseInt(line[j]);
        }
        backtracking(0, 0);
    }
}
