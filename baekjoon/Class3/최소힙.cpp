#include <iostream>
#include <queue>

using namespace std;

int main()
{
	priority_queue<int>	q;
	int					n, x;

	cin.tie(NULL);
	ios_base :: sync_with_stdio(false);
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		cin >> x;
		if (x == 0)
		{
			if (q.empty())
				cout << 0 << "\n";
			else
			{
				cout << q.top() * (-1) << "\n";
				q.pop();
			}
		}
		else
			q.push(x * (-1));
	}
}
