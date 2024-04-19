#include <iostream>
#include <algorithm>

int	minecraft(int map[250000], int N, int M, int B, int h)
{
	int	sec = 0;
	int map_cp[250000];

	for (int i = 0; i < N * M; ++i)
		map_cp[i] = map[i];
	for (int i = 0; i < N * M; ++i)
	{
		if (map_cp[i] != h)
		{
			if (map_cp[i] > h)
			{
				sec += 2 * (map_cp[i] - h);
				B += map_cp[i] - h;
				map_cp[i] = h;
			}
			else if (map_cp[i] < h)
			{
				sec += h - map_cp[i];
				B -= h - map_cp[i];
				if (B < 0)
					return (-1);
				map_cp[i] = h;
			}
		}
	}
	return (sec);
}

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	// freopen("input.txt", "r", stdin);

	int	N, M, B;
	int	map[250000] = {0, };
	int	ret_sec = -1, h = -1;
	int	sec;
	int	max = 0;

	std::cin >> N >> M >> B;
	for (int i = 0; i < N * M; ++i)
	{
		std::cin >> map[i];
		max = std::max(map[i], max);
	}
	std::sort(map, map + 250000, std::greater<int>());
	for (int i = 0; i <= max; ++i)
	{
		sec = minecraft(map, N, M, B, i);
		if (ret_sec != -1 && ret_sec < sec)
			break ;
		if (sec >= 0)
		{
			if (ret_sec == -1)
				ret_sec = sec;
			else
				ret_sec = std::min(sec, ret_sec);
			if (ret_sec == sec)
				h = i;
		}
	}
	std::cout << ret_sec << " " << h << "\n";
}