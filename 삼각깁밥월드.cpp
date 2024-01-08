#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int main()
{
	int	num;
	int	s, e;
	int	dp[10001];
	int	k = 1;
	int	answer;
	int	max;

	for (int i = 1; k < 10001; ++i)
	{
		for (int j = i; j > 0; --j)
		{
			dp[k] = i;
			k++;
		}
	}
	cin >> num;
	for (int i = 1; i <= num; ++i)
	{
		cin >> s >> e;
		if (s > e)
			swap(s,e);
		answer = dp[e] - dp[s];
		max = s;
		for (int j = dp[s] + 1; j <= dp[e]; j++)
			max += j;
		if (e > max)
			answer += e - max;
		else if (e < max - answer)
			answer += max - answer - e;
		cout << "#" << i << " " <<  answer << "\n";
	}
	return (0);
}
