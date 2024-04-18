#include <iostream>

using namespace std;

bool	check_cut(int tree[1000001], int N, int M, int mid)
{
	long long	cnt = 0;

	for (int i = 0; i < N; ++i)
	{
		if (tree[i] - mid > 0)
			cnt += tree[i] - mid;
	}
	if (cnt >= M)
		return (true);
	return (false);
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	// freopen("input.txt", "r", stdin);

	int			N, M;
	int			tree[1000001] = {0, };
	long long	st, en, mid;

	cin >> N >> M;
	for (int i = 0; i < N; ++i)
		cin >> tree[i];
	st = 0;
	en = 1000000000;
	while (st < en - 1)
	{
		mid = (st + en) / 2;
		if (check_cut(tree, N, M, mid))
			st = mid;
		else
			en = mid;
	}
	cout << st << "\n";
}