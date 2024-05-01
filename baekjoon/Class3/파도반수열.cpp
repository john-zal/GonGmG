#include <iostream>

void	fill_dp(long long dp[101])
{
	for (int i = 1; i < 101; ++i)
	{
		if (i <= 3)
			dp[i] = 1;
		else
			dp[i] = dp[i - 3] + dp[i - 2];
	}
}

int main()
{
    std::cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

	long long	dp[101] = {0, };
    int	t, n;

	std::cin >> t;
	fill_dp(dp);
	for (int i = 0; i < t; ++i)
	{
		std::cin >> n;
		std::cout << dp[n] << "\n";
	}
}
