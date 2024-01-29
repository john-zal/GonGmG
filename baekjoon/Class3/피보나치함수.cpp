#include <vector>
#include <string>
#include <iostream>

using namespace std;

void	make_dp(int zero[41], int one[41], int n)
{
	zero[0] = 1;
	zero[1] = 0;
	one[0] = 0;
	one[1] = 1;
	if (zero[n] != 0)
		return ;
	for (int i = 2; i <= n; ++i)
	{
		if (zero[i] != 0)
			continue;
		zero[i] = zero[i - 1] + zero[i - 2];
		one[i] = one[i - 1] + one[i - 2];	
	}
}

int main()
{
	int	T;
	int	n;
	int	zero[41] = {0,};
	int	one[41] = {0,};

	cin >> T;
	for (int i = 0; i < T; ++i)
	{
		cin >> n;
		make_dp(zero, one, n);
		cout << zero[n] << " " << one[n] << "\n";
	}
}
