#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int	N;
	int	p[1000] = {0,};
	int	ret = 0;

	cin  >> N;
	for (int i = 0; i < N; ++i)
		cin >> p[i];
	sort(p, p + N);
	for (int i = 0; i < N; ++i)
		ret += p[i] * (N - i);
	cout << ret << "\n";
}
