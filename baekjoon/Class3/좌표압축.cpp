#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	unordered_map<int, int> map;
	vector<int>	vec;
	vector<int>	sort_vec;
	int	N, X;
	int	cnt;

	cin >> N;
	for (int i = 0; i < N; ++i)
	{
		cin >> X;
		vec.push_back(X);
		sort_vec.push_back(X);
	}
	sort(sort_vec.begin(), sort_vec.end());
	cnt = 0;
	for (int i = 0; i < N; ++i)
		if (map.find(sort_vec[i]) == map.end())
			map.insert({sort_vec[i], cnt++});
	for (int i = 0; i < N; ++i)
		cout << map[vec[i]] << " ";
	cout << "\n";
}