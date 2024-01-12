#include <string>
#include <vector>

using namespace std;

string solution(string s, string skip, int index) {
    string	answer = "";
	char	c;

	for (int i = 0; i < s.size(); ++i)
	{
		c = s[i];
		for(int j = 0; j < index; ++j)
		{
			c++;
			if (c == 'z' + 1)
				c = 'a';
			while ((int)skip.find(c) != -1)
			{
				c++;
				if (c == 'z' + 1)
					c = 'a';
			}
		}
		answer += c;
	}
    return answer;
}
