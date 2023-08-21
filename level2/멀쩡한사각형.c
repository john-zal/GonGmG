#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#define MIN(a,b) ((a < b) ? a : b)

long long solution(int w, int h) {
    long long answer = w * h;
    if (w != h)
        answer -= MIN(w,h) * 2;
    else
        answer -= MIN(w,h);
    return answer;
}