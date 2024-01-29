#include <vector>
#include <string>
#include <iostream>
#include <stack>
#include <memory.h>

using namespace std;

int	map[50][50];
int	visited[50][50];
int	dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int	dfs(int m, int n)
{
	stack<pair<int, int>>	st;
	pair<int, int>			point;
	int						chain = 0;
	int						nx, ny;

	for (int i = 0; i < m; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			if (map[i][j] == 0 || visited[i][j] == 1)
				continue ;
			st.push(make_pair(i,j));
			chain++;
			while (!st.empty())
			{
				point = st.top();
				st.pop();
				visited[point.first][point.second] = 1;
				for (int k = 0; k < 4; ++k)
				{
					nx = point.first + dx[k];
					ny = point.second + dy[k];
					if (nx < 0 || nx >= m || ny < 0 || ny >= n)
						continue ;
					if (map[nx][ny] != 1 || visited[nx][ny] == 1)
						continue ;
					visited[nx][ny] = 1;
					st.push(make_pair(nx, ny));
				}
			}
		}
	}
	return (chain);
}

int main()
{
	int	T;
	int	m, n, k;
	int	x, y;

	cin >> T;
	for (int i = 0; i < T; ++i)
	{
		cin >> m >> n >> k;
		memset(map, 0, sizeof(map));
		memset(visited, 0, sizeof(visited));
		for (int j = 0; j < k; ++j)
		{
			cin >> x >> y;
			map[x][y] = 1;
		}
		cout << dfs(m, n) << "\n";
	}
}
