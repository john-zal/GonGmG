#include <iostream>
#include <cmath>
#include <string>

using namespace std;

int	val = 1000000;

void	dfs(int num, int N, int N_len, int deep, int check_num[10])
{
	if (deep == 6)
		return ;
	for (int i = 0; i < 10; ++i)
	{
		if (check_num[i] == 0)
		{
			num = num * 10 + i;
			if (abs(N - num) + to_string(num).length() < abs(N - val) + to_string(val).length())
				val = num;
			dfs(num, N, N_len, deep + 1, check_num);
			num = num / 10;
		}
	}
}

int main()
{
	int		N, M, B;
	int		N_len;
	int		check_num[10] = {0,};

	cin >> N >> M;
	for (int i = 0; i < M; ++i)
	{
		cin >> B;
		check_num[B] = 1;
	}
	N_len = to_string(N).length();
	dfs(0, N, N_len, 0, check_num);
	if (abs(N - val) + to_string(val).length() >= abs(N - 100) || M == 10)
		cout << abs(N - 100) << "\n";
	else
		cout << abs(N - val) + to_string(val).length() << "\n";
}
