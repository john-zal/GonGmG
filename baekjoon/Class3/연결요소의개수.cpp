#include <iostream>
#include <unordered_map>
#include <vector>
#include <queue>

using namespace std;

void	check_cc(unordered_map<int, vector<int>> map, int visited[1001], int idx)
{
	queue<int>	q;

	visited[idx] = 1;
	for (int i = 0; i < map[idx].size(); ++i)
		q.push(map[idx][i]);
	while (!q.empty())
	{
		idx = q.front();
		visited[idx] = 1;
		q.pop();
		for (int i = 0; i < map[idx].size(); ++i)
		{
			if (!visited[map[idx][i]])
			{
				q.push(map[idx][i]);
				visited[map[idx][i]] = 1;
			}
		}
	}	
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	unordered_map<int, vector<int>> map;
	int	N, M, u, v;
	int	visited[1001] = {0,};
	int	ret = 0;

	cin >> N >> M;
	for (int i = 0; i < M; ++i)
	{
		cin >> u >> v;
		if (map.find(u) == map.end())
			map.insert({u, vector<int>()});
		map[u].push_back(v);
		map[v].push_back(u);
	}
	for (int i = 1; i <= N; ++i)
	{
		if (!visited[i])
		{
			ret++;
			check_cc(map, visited, i);
		}
	}
	cout << ret << "\n";
}