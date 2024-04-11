#include <iostream>
#include <queue>
#include <climits>

using namespace std;

int	shortest_way(int ret[1001][1001], int x, int y, int n, int m)
{
	int dx[4] = {-1, 0, 1, 0};
	int dy[4] = {0, -1, 0, 1};
	int	tmp_x, tmp_y;
	int s_w = INT_MAX;

	for (int i = 0; i < 4; ++i)
	{
		tmp_x = x + dx[i];
		tmp_y = y + dy[i];
		if (tmp_x < 0 || tmp_y < 0 || tmp_x >= n || tmp_y >= m)
			continue;
		if (ret[tmp_x][tmp_y] == -1 || ret[tmp_x][tmp_y] == 0)
			continue;
		if (ret[tmp_x][tmp_y] == -2)
			s_w = 1;
		else if (ret[tmp_x][tmp_y] + 1 < s_w)
			s_w = ret[tmp_x][tmp_y] + 1;
	}
	if (s_w == INT_MAX)
		return (-1);
	return (s_w);
}

void	bfs(int ret[1001][1001], pair<int, int> point, int n, int m)
{
	queue<pair<int, int>>	que;
	int	dx[4] = {-1, 0, 1, 0};
	int	dy[4] = {0, -1, 0, 1};
	int	x, y;

	que.push(point);
	while (!que.empty())
	{
		for (int i = 0; i < 4; ++i)
		{
			x = que.front().first + dx[i];
			y = que.front().second + dy[i];
			if (x < 0 || y < 0 || x >= n || y >= m)
				continue;
			if (ret[x][y] == 0 || ret[x][y] == -2 || ret[x][y] > 0)
				continue;
			ret[x][y] = shortest_way(ret, x, y, n, m);
			que.push({x, y});
		}
		que.pop();
	}
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	pair<int, int>	end;
	int	map[1001][1001];
	int	ret[1001][1001];
	int	n, m;

	// freopen("input.txt", "r", stdin);
	cin >> n >> m;
	fill(&ret[0][0], &ret[1000][1000], -1);
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			cin >> map[i][j];
			if (map[i][j] == 2)
			{
				ret[i][j] = -2;
				end.first = i;
				end.second = j;
			}
			else if (map[i][j] == 0)
				ret[i][j] = 0;
		}
	}
	bfs(ret, end, n, m);
	ret[end.first][end.second] = 0;
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			cout << ret[i][j] << " ";
		}
		cout << "\n";
	}
}