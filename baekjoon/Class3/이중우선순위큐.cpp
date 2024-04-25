#include <iostream>
#include <queue>
#include <unordered_map>
#include <algorithm>

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	freopen("input.txt", "r", stdin);

	std::priority_queue<long long>	a_q, d_q;
	std::unordered_map<long long, int> map;
	long long	n;
	int		r_size;
	int		max, min, flag;
	int		t, k;
	char	c;

	std::cin >> t;
	for (int i = 0; i < t; ++i)
	{
		std::cin >> k;
		r_size = 0;
		for (int j = 0; j < k; ++j)
		{
			std::cin >> c >> n;
			if (c == 'I')
			{
				a_q.emplace(n * -1);
				d_q.emplace(n);
				r_size++;
				if (map.find(n) != map.end())
					map[n] += 1;
				else
					map.insert({n, 1});
			}
			else if (c == 'D')
			{
				if (n == -1 && !a_q.empty())
				{
					while (map[a_q.top() * -1] == 0)
						a_q.pop();
					map[a_q.top() * -1] -= 1;
					r_size--;
					a_q.pop();
				}
				else if (n == 1 && !d_q.empty())
				{
					while (map[d_q.top()] == 0)
						d_q.pop();
					map[d_q.top()] -= 1;
					r_size--;
					d_q.pop();
				}
				if (r_size == 0)
				{
					while (!a_q.empty())
						a_q.pop();
					while (!d_q.empty())
						d_q.pop();
				}
			}
		}
		flag = 0;
		while (!a_q.empty())
		{
			if (map[a_q.top() * -1] > 0 && flag == 0)
			{
				min = a_q.top() * -1;
				flag = 1;
			}
			a_q.pop();
		}
		while (!d_q.empty())
		{
			if (map[d_q.top()] > 0 && flag == 1)
			{
				max = d_q.top();
				flag = 2;
			}
			d_q.pop();
		}
		map.clear();
		if (flag == 0)
			std::cout << "EMPTY\n";
		else
			std::cout << max << " " << min << "\n";
	}
}