#include <string>
#include <vector>
#include <queue>

using namespace std;

int answer = 0;

pair<int, int> find_start(vector<string> maps)
{
    for (int i = 0; i < maps.size(); ++i)
    {
        for (int j = 0; j < maps.size(); ++j)
        {
            if (maps[i][j] == 'S')
                return make_pair(i,j);
        }
    }
}

void find_lever(vector<string> maps)
{

}

int solution(vector<string> maps) {
    int answer = 0;

    return answer;
}