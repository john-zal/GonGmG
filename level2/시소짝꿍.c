#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int compare(const void *a , const void *b) 
{ 
    if( *(int*)a > *(int*)b )
        return (1);

    else if( *(int*)a < *(int*)b )
        return (-1);

    else
        return (0);
}

void    cnt_partner(int *w, int n)
{
    int partner;

    w[n * 2]++;
    if (n % 2 == 0)
        w[(n / 2) * 3]++;
    if (n % 3 == 0)
        w[(n / 3) * 4]++;
}
// weights_len은 배열 weights의 길이입니다.
long long solution(int weights[], size_t weights_len) {
    long long answer = 0;
    int partner[2001];
    int cnt = 1;
    
    qsort(weights , weights_len , sizeof(weights[0]) , compare);
    for (int i = 0; i < 2001; ++i)
        partner[i] = 0;
    for (int i = 0; i < weights_len; ++i)
    {
        cnt_partner(partner, weights[i]);
        answer += partner[weights[i]];
    }
    for (int i = 0; i < weights_len; ++i)
    {
        while (i < weights_len && (weights[i] == weights[i + 1]))
        {
            cnt++;
            i++;
        }
        while (--cnt > 0)
            answer += cnt;
        cnt = 1;
    }
    return (answer);
}