#include <iostream>
#include <set>
#include <string>

using namespace std;

int main()
{
	set<string>	s, ret_set;
	string		name;
	int 		N, M;

	cin >> N >> M;
	for (int i = 0; i < N; ++i)
	{
		cin >> name;
		s.insert(name);
	}
	for (int i = 0; i < M; ++i)
	{
		cin >> name;
		if (s.count(name))
			ret_set.insert(name);
	}
	cout << ret_set.size() << '\n';
	for (set<string>::iterator iter = ret_set.begin(); iter != ret_set.end(); iter++)
		cout << *iter << "\n";
}