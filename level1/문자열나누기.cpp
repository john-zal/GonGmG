#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int		answer = 0;
	char	x = 0;
	int		a,b;

	for (int i = 0; i < s.size(); ++i)
	{
		if (x == 0)
		{
			x = s[i];
			a = 1;
			b = 0;
            continue ;
		}
		if (x != s[i])
			b++;
		else
			a++;
		if (a == b)
		{
			x = 0;
			answer++;
		}
	}
	if (x != 0)
		answer++;
    return answer;
}
