#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>>

int solution(int storey) {
    int answer = 0;
    int max;

    while (storey)
    {
        max = storey % 10;
        if (max == 5)
        {
            if (storey / 10 > 0)
            {
                if (storey % 100 > 50)
                    storey += 10;
            }
            answer += max;
        }
        else if (max > 5)
        {
            answer += (10 - max);
            storey += 10;
        }
        else
            answer += max;
        storey /= 10; 
    }
    return answer;
}