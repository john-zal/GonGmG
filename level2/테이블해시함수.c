#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void key_rsort(int **data, size_t data_rows)
{
    int *tmp;

    for (int i = data_rows - 1; i >= 0; --i)
    {
        for (int j = 0; j < i; ++j)
        {
            if (data[j][0] < data[j + 1][0])
            {
                tmp =  data[j];
                data[j] = data[j + 1];
                data[j + 1] = tmp;
            }
        }
    }
}

void col_sort(int **data, size_t data_rows, int col)
{
    int *tmp;

    for (int i = data_rows - 1; i >= 0; --i)
    {
        for (int j = 0; j < i; ++j)
        {
            if (data[j][col] > data[j + 1][col])
            {
                tmp =  data[j];
                data[j] = data[j + 1];
                data[j + 1] = tmp;
            }
        }
    }
}
// data_rows는 2차원 배열 data의 행 길이, data_cols는 2차원 배열 data의 열 길이입니다.
int solution(int** data, size_t data_rows, size_t data_cols, int col, int row_begin, int row_end) {
    int answer = 0;
    return answer;
}