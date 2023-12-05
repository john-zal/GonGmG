#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer(photo.size(), 0);
    map<string, int> map;

    for(int i = 0; i < name.size(); ++i)
        map.insert({name[i], yearning[i]});
    for (int i = 0; i < photo.size(); ++i)
    {
        for (int j = 0; j < photo[i].size(); ++j)
            if (map.find(photo[i][j]) != map.end())
                answer[i] += map.find(photo[i][j])->second;
    }
    return answer;
}