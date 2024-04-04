#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

void	cnt_net(unordered_map<int, set<int>> map, int present, set<int> &prev)
{
	for (int val : map[present])
	{
		if (prev.find(val) != prev.end())
			continue;
		prev.insert(val);
		cnt_net(map, val, prev);
	}
}

int	main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int	n, m, x, y;
	unordered_map<int, set<int>>	map;
	set<int>						net;

	cin >> n >> m;
	for (int i = 0; i < m; ++i)
	{
		cin >> x >> y;
		if (map.find(x) == map.end())
			map.insert({x, set<int>()});
		map[x].insert(y);
		if (map.find(y) == map.end())
			map.insert({y, set<int>()});
		map[y].insert(x);
	}
	net.insert(1);
	cnt_net(map, 1, net);
	cout << net.size() - 1 << "\n";
}
