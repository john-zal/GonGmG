#include <iostream>

bool	check_length(long long line[10001], int K, int N, long long mid)
{
	int	cnt = 0;

	for (int i = 0; i < K; ++i)
	{
		cnt += line[i] / mid;
	}
	if (cnt >= N)
		return (true);
	return (false);
}

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int			K, N;
	long long	line[10001] = {0,};
	long long	st, end, mid;

	std::cin >> K >> N;
	for (int i = 0; i < K; ++i)
		std::cin >> line[i];
	st = 0;
	end = 2147483648;
	while (st < end - 1)
	{
		mid = (st + end) / 2;
		if (check_length(line, K, N, mid))
			st = mid;
		else
			end = mid;
	}
	std::cout << st << "\n";
}