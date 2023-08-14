#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int compare(const void *a , const void *b) 
{ 
     if( *(int*)a > *(int*)b )

        return 1;

    else if( *(int*)a < *(int*)b )

        return -1;

    else

        return 0;
}

int divisor(int n, int init)
{
    int d;
    if (init == n)
        d = n / 2;
    else
        d--;

    while (n % d != 0)
        d--;
    return (d);
}

int gcd(int *arr, int arr_len)
{
    int min = arr[0];

    for (int i = 0; i < arr_len; ++i)
    {
        if (arr[i] % min != 0)
        {
            min = divisor(min, arr[0]);
            i = 0;
        }
    }
    return (min);
}

int check_ans(int *arr, int arr_len, int gcd, int init)
{
    for (int i = 0; i < arr_len; ++i)
    {
        if(!(arr[i] % gcd))
        {
            gcd = divisor(gcd, init);
            break;
        }
    }
    return (gcd);
}

int solution(int arrayA[], size_t arrayA_len, int arrayB[], size_t arrayB_len) {
    int gcd_a;
    int gcd_b;
    int gcd_a_init;
    int gcd_b_init;

    qsort(arrayA, arrayA_len, sizeof(arrayA[0]), compare);
    qsort(arrayB, arrayB_len, sizeof(arrayB[0]), compare);
    gcd_a = gcd(arrayA, arrayA_len);
    gcd_a_init = gcd(arrayA, arrayA_len);
    gcd_b = gcd(arrayB, arrayB_len);
    gcd_b_init = gcd(arrayB, arrayB_len);
    while (gcd_a != 1 || gcd_b != 1)
    {
        if (gcd_a > gcd_b)
        {
            if (gcd_a == check_ans(arrayB, arrayB_len, gcd_a, gcd_a_init))
                return (gcd_a);
            else
                gcd_a = divisor(gcd_a, gcd_a_init);
        }
        else
        {
            if (gcd_b == check_ans(arrayA, arrayA_len, gcd_b, gcd_b_init))
                return (gcd_b);
            else
                gcd_b = divisor(gcd_b, gcd_b_init);
        }
    }
    return (0);
}