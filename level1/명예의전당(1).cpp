#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer(score.size(), 0);
    int day_rank[score.size()];

    for (int i = 0; i < score.size(); ++i)
    {
        day_rank[i] = score[i];
        sort(day_rank, day_rank + i + 1);
        if (i < k)
            answer[i] = day_rank[0];
        else
            answer[i] = day_rank[i - k + 1];
    }
    return answer;
}
