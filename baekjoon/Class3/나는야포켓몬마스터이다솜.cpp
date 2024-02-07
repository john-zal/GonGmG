#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
#include <cctype>

using namespace std;

int main()
{
	unordered_map<string, int>	name_num;
	unordered_map<int, string>	num_name;
	vector<string>				v;
	int		N, M;
	string	name;

	cin >> N >> M;
	for (int i = 1; i <= N; ++i)
	{
		cin >> name;
		name_num.insert(make_pair(name, i));
		num_name.insert(make_pair(i, name));
	}
	for (int i = 0; i < M; ++i)
	{
		cin >> name;
		v.push_back(name);
	}
	for (int i = 0; i < M; ++i)
	{
		if (isdigit(v[i][0]))
			cout << num_name[stoi(v[i])] << "\n";
		else
			cout << name_num[v[i]] << "\n";
	}
}