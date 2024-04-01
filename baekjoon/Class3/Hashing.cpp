#include <vector>
#include <string>
#include <iostream>
#include <cmath>

using namespace std;

int	main()
{
	const int	M = 1234567891;
	long long	L;
	long long	a, r, ret = 0;
	string		s;

	cin >> L >> s;
	for (int i = 0; i < s.size(); ++i)
	{
		a = s[i] - 'a' + 1;
		r = 1;
		for (int j = 0; j < i; ++j)
		{
			r = r * 31;
			r %= M;
		}
		a *= r % M;
		ret += a % M;
	}
	cout << ret % M << "\n";
}
