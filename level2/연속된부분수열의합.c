#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>


// sequence_len은 배열 sequence의 길이입니다.
int* solution(int sequence[], size_t sequence_len, int k) {
    int* answer = (int*)malloc(sizeof(int) * 2);
    int tmp_k;
    int j;

    answer[0] = 0;
    answer[1] = 1000000;
    for (int i = 0; i < sequence_len; ++i)
    {
        tmp_k = k;
        if (sequence[i] <= k)
        {
            for (j = i; (j < sequence_len && tmp_k > 0); ++j)
                tmp_k -= sequence[j];
        }
        if (tmp_k == 0 && ((j - i) < (answer[1] - answer[0])))
        {
            answer[0] = i;
            answer[1] = j;
        }
    }
    return answer;
}