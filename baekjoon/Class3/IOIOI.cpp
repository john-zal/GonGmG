#include <iostream>
#include <string>
#include <cstring>

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int			N, M;
	std::string	ps, s;
	int			cnt = 0, flag = 0;

	std::cin >> N >> M >> s;
	ps = "I";
	for (int i = 0; i < N; ++i)
		ps += "OI";
	for (int i = 0; i < M; ++i)
	{
		if (s[i] == 'I')
		{
			if (flag == 1)
			{
				if (s.compare(i + ps.size() - 2, 2, "OI") == 0)
					cnt++;
				else
				{
					flag = 0;
					i += ps.size() - 3;
				}
				continue ;
			}
			if (s.compare(i, ps.size(), ps) == 0)
			{
				cnt++;
				flag = 1;
			}
		}
	}
	std::cout << cnt << "\n";
}