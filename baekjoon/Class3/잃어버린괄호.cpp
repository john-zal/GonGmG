#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string>	split(string str, char delimeter)
{
	vector<string>	result;
	istringstream	iss(str);
	string			buffer;

	while (getline(iss, buffer, delimeter)){
		result.push_back(buffer);
	}
	return (result);
}

int	cal_str(string str)
{
	vector<string>	v;
	int				result = 0;

	v = split(str, '+');
	for (int i = 0; i < v.size(); ++i)
		result += stoi(v[i]);
	return (result);
}
int main()
{
	vector<string>	v;
	string			s;
	int				ans = 0;

	cin >> s;
	v = split(s, '-');
	if (v[0] != "")
		ans += cal_str(v[0]);
	for (int i = 1; i < v.size(); ++i)
		ans -= cal_str(v[i]);
	cout << ans << "\n";
	return (0);
}