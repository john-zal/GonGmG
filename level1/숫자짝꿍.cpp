#include <string>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    int x_c[10] = {0, };
    int y_c[10] = {0, };
    int count;

    for (int i = 0; i < X.size(); ++i)
        x_c[X[i] - '0']++;
    for (int i = 0; i < Y.size(); ++i)
        y_c[Y[i] - '0']++;
    for (int i = 9; i >= 0; --i)
    {
        if (x_c[i] != 0 && y_c[i] != 0)
        {
            count = min(x_c[i], y_c[i]);
            while (count > 0)
            {
                answer += i + '0';
                count--;
            }
        }
    }
    if (answer.size() == 0)
        return ("-1");
    if (answer[0] == '0')
        return ("0");
    return answer;
}