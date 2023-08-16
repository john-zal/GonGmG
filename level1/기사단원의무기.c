#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int div_count(int n)
{
    int cnt = 0;

    if (n == 1)
        return (1);
    for (int i = 1; i * i <= n; ++i)
    {
        if (n % i == 0)
            cnt += 2;
    }
    return (cnt);
}

int solution(int number, int limit, int power) {
    int answer = 0;
    int div_num;

    for (int i = 1; i <= number; ++i)
    {
        div_num = div_count(i);
        if (div_num > limit)
            div_num = power;
        answer += div_num;    
    }
    return answer;
}