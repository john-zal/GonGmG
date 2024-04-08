#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	vector<int>	vec;
	int		M, N;
	string	s;

	// freopen("input.txt", "r", stdin);
	cin >> M;
	for (int i = 0; i < M; ++i)
	{
		cin >> s;
		if (!s.compare("add"))
		{
			cin >> N;
			if (find(vec.begin(), vec.end(), N) == vec.end())
				vec.push_back(N);
		}
		else if (!s.compare("remove"))
		{
			cin >> N;
			if (find(vec.begin(), vec.end(), N) != vec.end())
				vec.erase(find(vec.begin(), vec.end(), N));
		}
		else if (!s.compare("check"))
		{
			cin >> N;
			if (find(vec.begin(), vec.end(), N) != vec.end())
				cout << "1\n";
			else
				cout << "0\n";
		}
		else if (!s.compare("toggle"))
		{
			cin >> N;
			if (find(vec.begin(), vec.end(), N) != vec.end())
				vec.erase(find(vec.begin(), vec.end(), N));
			else
				vec.push_back(N);
		}
		else if (!s.compare("all"))
		{
			vec.erase(vec.begin(), vec.end());
			for (int i = 1; i <= 20; ++i)
				vec.push_back(i);
		}
		else if (!s.compare("empty"))
			vec.erase(vec.begin(), vec.end());
	}
}
