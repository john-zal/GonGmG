#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// sequence_len은 배열 sequence의 길이입니다.
int* solution(int sequence[], size_t sequence_len, int k) {
    int* answer = (int*)malloc(sizeof(int) * 2);
    int j = 0;

    answer[0] = 0;
    answer[1] = 1000000;
    for (int i = 0; i < sequence_len; i++)
    {
        while (k > 0 && j < sequence_len)
        {
            k -= sequence[j];
            j++;
        }
        if (k == 0 && (j - 1 - i) < (answer[1] - answer[0]))
        {
            answer[0] = i;
            answer[1] = j - 1;
        }
        k += sequence[i];
    }
    return answer;
}