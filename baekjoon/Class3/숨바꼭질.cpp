#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>

using namespace std;

int main()
{
	queue<pair<int, int>> q;
	pair<int, int> n, k;
	int	visited[100001] = {0,};
	int	N, K;

	cin >> N >> K;
	q.push(make_pair(N, 0));
	while (!q.empty())
	{
		n = q.front();
		if (n.first == K)
		{
			cout << n.second << "\n";
			return (0);
		}
		visited[n.first] = 1;
		q.pop();
		if (n.first * 2 <= 100000 && !visited[n.first * 2])
		{
			k = make_pair(n.first * 2, n.second + 1);
			q.push(k);
			visited[k.first] = 1;
		}
		if (n.first + 1 <= 100000 && !visited[n.first + 1])
		{
			k = make_pair(n.first + 1, n.second + 1);
			q.push(k);
			visited[k.first] = 1;
		}
		if (n.first > 0 && !visited[n.first - 1])
		{
			k = make_pair(n.first - 1, n.second + 1);
			q.push(k);
			visited[k.first] = 1;
		}
	}
	return (0);
}
