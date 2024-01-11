#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int>		answer;
	map<char, int>	map;
	int				tmp;

	for (int i = 0; i < keymap.size(); ++i)
	{
		for (int j = 0; j < keymap[i].size(); ++j)
		{
			if (map.find(keymap[i][j]) == map.end())
				map.insert({keymap[i][j], j + 1});
			else
			{
				if (map[keymap[i][j]] > j + 1)
					map[keymap[i][j]] = j + 1;
			}

		}
	}
	for (int i = 0; i < targets.size(); ++i)
	{
		tmp = 0;
		for (int j = 0; j < targets[i].size(); ++j)
		{
			if (map.find(targets[i][j]) == map.end())
			{
				tmp = -1;
				break ;
			}
			else
				tmp += map[targets[i][j]];
		}
		answer.push_back(tmp);
	}
    return answer;
}
