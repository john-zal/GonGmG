#include <string>
#include <vector>
#include <cstring>

using namespace std;

static int check(string str)
{
	string bab = "ayayewooma";
	int check_num = 0;

	for (int i = 0; i < str.size(); ++i)
	{
		if (str[i] == 'a')
		{
			if (check_num == 1)
				return (0);
			if (!strncmp(&bab[0], &str[i],3))
			{
				check_num = 1;
				i += 2;
				continue ;
			}
			else
				return (0);
		}
		else if (str[i] == 'y')
		{
			if (check_num == 2)
				return (0);
			if (!strncmp(&bab[3], &str[i],2))
			{
				check_num = 2;
				i += 1;
				continue ;
			}
			else
				return (0);
		}
		else if (str[i] == 'w')
		{
			if (check_num == 3)
				return (0);
			if (!strncmp(&bab[5], &str[i],3))
			{
				check_num = 3;
				i += 2;
				continue ;
			}
			else
				return (0);
		}
		else if (str[i] == 'm')
		{
			if (check_num == 4)
				return (0);
			if (!strncmp(&bab[8], &str[i],2))
			{
				check_num = 4;
				i += 1;
				continue ;
			}
			else
				return (0);
		}
		else
			return (0);
	}
	return (1);
}

int solution(vector<string> babbling) {
    int answer = 0;

	for(int i = 0; i < babbling.size(); ++i)
		answer += check(babbling[i]);
    return (answer);
}
