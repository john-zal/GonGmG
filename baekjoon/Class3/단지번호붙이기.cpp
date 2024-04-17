#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int	bfs (int map[25][25], int N, int idx, int jdx)
{
	queue<pair<int, int>>	que;
	int						dir_x[4] = {-1, 0, 1, 0};
	int						dir_y[4] = {0, -1, 0, 1};
	int 					cnt = 0;
	int						x, y;

	que.push({idx, jdx});
	while (!que.empty())
	{
		cnt++;
		map[que.front().first][que.front().second] = 0;
		for (int i = 0; i < 4; ++i)
		{
			x = que.front().first + dir_x[i];
			y = que.front().second + dir_y[i];
			if (x < 0 || y < 0 || x >= N || y >= N)
				continue;
			if (map[x][y] == 1)
			{
				que.push({x, y});
				map[x][y] = 0;
			}
		}
		que.pop();
	}
	return (cnt);
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	// freopen("input.txt", "r", stdin);

	vector<int>	vec;
	int			map[25][25] = { {0, }, };
	int			N;
	char		c;

	cin >> N;
	for (int i = 0; i < N; ++i)
	{
		for (int j = 0; j < N; ++j)
		{
			cin >> c;
			map[i][j] = c - '0';
		}
	}
	for (int i = 0; i < N; ++i)
	{
		for (int j = 0; j < N; ++j)
		{
			if (map[i][j] == 1)
				vec.push_back(bfs(map, N, i, j));
		}
	}
	sort(vec.begin(), vec.end());
	cout << vec.size() << "\n";
	for (int i = 0; i < vec.size(); ++i)
		cout << vec[i] << "\n";
}
