#include <iostream>
#include <string>
#include <unordered_map>

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	freopen("input.txt", "r", stdin);

	std::unordered_map<std::string, int> map;
	std::string str;
	int	t, n, ret;

	std::cin >> t;
	for (int i = 0; i < t; ++i)
	{
		ret = 0;
		std::cin >> n;
		for (int j = 0; j < n; ++j)
		{
			std::cin >> str;
			std::cin >> str;
			if (map.find(str) == map.end())
				map.insert({str, 1});
			else
				map[str]++;
		}
		for (std::pair<std::string, int> j : map)
		{
			if (ret == 0)
				ret = j.second + 1;
			else
				ret *= j.second + 1;
		}
		map.clear();
		if (ret)
			std::cout << ret - 1 << "\n";
		else
			std::cout << 0 << "\n";
	}
}