#include <iostream>
#include <algorithm>

#define INF 987654321

using namespace std;

int main()
{
	int	N, M;
	int	A, B;
	int	ans;
	int	tmp;
	int	fw[101][101] = {0,};
	int	ans_score = INF;

	cin >> N >> M;
	for (int i = 0; i < M; ++i)
	{
		cin >> A >> B;
		fw[A][B] = 1;
		fw[B][A] = 1;
	}
	for (int i = 1; i <= N; ++i)
		for (int j = 1; j <= N; ++j)
			if (i != j && fw[i][j] == 0)
				fw[i][j] = INF;
	for (int k = 1; k <= N; ++k)
		for (int i = 1; i <= N; ++i)
			for (int j = 1; j <= N; ++j)
				fw[i][j] = min(fw[i][j], fw[i][k] + fw[k][j]);
	for (int i = 1; i <= N; ++i)
	{
		tmp = 0;
		for (int j = 1; j <= N; ++j)
			tmp += fw[i][j];
		if (tmp < ans_score)
		{
			ans_score = tmp;
			ans = i;
		}
	}
	cout << ans << "\n";
}