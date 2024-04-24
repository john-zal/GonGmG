#include <iostream>
#include <queue>

int	count_zero(int tomato[100][100][100], int m, int n, int h)
{
	int	cnt_z = 0;

	for (int i = 0; i < h; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			for (int k = 0; k < m; ++k)
			{
				if (tomato[i][j][k] == 0)
					cnt_z++;
			}
		}
	}
	return (cnt_z);
}

int	change_tomato(int tomato[100][100][100], int m, int n, int h)
{
	std::queue<std::pair<int, std::pair<int, int> > >	q;
	int	dx[6] = {0, 0, 0, 0, -1, 1};
	int	dy[6] = {-1, 0, 1, 0, 0, 0};
	int	dz[6] = {0, -1, 0, 1, 0, 0};
	int	n_x, n_y, n_z;
	int	day, cnt = -1;

	for (int i = 0; i < h; ++i)
		for (int j = 0; j < n; ++j)
			for (int k = 0; k < m; ++k)
				if (tomato[i][j][k] == 1)
					q.push({i, {j, k}});
	day = q.size();
	while (!q.empty())
	{
		for (int i = 0; i < 6; ++i)
		{
			n_x = q.front().first + dx[i];
			n_y = q.front().second.first + dy[i];
			n_z = q.front().second.second + dz[i];
			if (n_x < 0 || n_y < 0 || n_z < 0 || n_x >= h || n_y >= n || n_z >= m)
				continue ;
			if (tomato[n_x][n_y][n_z] != 0)
				continue ;
			tomato[n_x][n_y][n_z] = 1;
			q.push({n_x, {n_y, n_z}});
		}
		q.pop();
		day--;
		if (day == 0)
		{
			day = q.size();
			cnt++;
		}
	}
	if (count_zero(tomato, m, n, h) != 0)
		return (-1);
	return (cnt);
}

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	freopen("input.txt", "r", stdin);

	int	m, n, h;
	int	tomato[100][100][100];
	int	check_zero, tmp_zero;
	int	ret = 0;

	std::cin >> m >> n >> h;
	std::fill(&tomato[0][0][0], &tomato[99][99][99], -1);
	for (int i = 0; i < h; ++i)
		for (int j = 0; j < n; ++j)
			for (int k = 0; k < m; ++k)
				std::cin >> tomato[i][j][k];
	std::cout << change_tomato(tomato, m, n, h) << "\n";
}