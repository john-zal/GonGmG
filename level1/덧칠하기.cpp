#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    for (int i = 0; i < section.size(); ++i)
    {
        answer++;
        for (int j = i + 1; j < section.size(); ++j)
        {
            if (section[j] >= section[i] + m)
            {
                i = j - 1;
                break;
            }
            if (j == section.size() - 1)
                i = j;
        }
    }
    return answer;
}