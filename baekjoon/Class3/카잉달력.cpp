#include <iostream>

int	gcd(int x, int y)
{
	if (x < y)
		std::swap(x, y);
	if (y == 0)
		return (x);
	return (gcd(y, x % y));
}

int lcm(int x, int y)
{
	int	greatest_common_division = gcd(x, y);
	int	least_common_multiple;

	least_common_multiple = x * y / greatest_common_division;
	return (least_common_multiple);
}

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	// freopen("input.txt", "r", stdin);

	int	T;
	int	M, N, x, y;
	int	lcm_v, ret;

	std::cin >> T;
	for (int i = 0; i < T; ++i)
	{
		std::cin >> M >> N >> x >> y;
		lcm_v = lcm(M, N);
		ret = -1;
		for (int i = x; i <= lcm_v; i += M)
		{
			if (i % N == y || (i % N == 0 && y == N))
			{
				ret = i;
				break ;
			}
		}
		std::cout << ret << "\n";
	}
}