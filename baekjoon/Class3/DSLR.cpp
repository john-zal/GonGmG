#include <iostream>
#include <queue>
#include <vector>

void	inttoarray(int num, int *ret)
{
	ret[3] = num % 10;
	ret[2] = num / 10 % 10;
	ret[1] = num / 100 % 10;
	ret[0] = num / 1000 % 10;
}

int	arraytoint(int *num)
{
	int	ret = 0;

	for (int i = 0; i < 4; ++i)
		ret = ret * 10 + num[i];
	return (ret);
}

void	s_command(int num, int *ret)
{
	if (num == 0)
		ret[0] = 9, ret[1] = 9, ret[2] = 9, ret[3] = 9;
	else
	{
		ret[3] = (num - 1) % 10;
		ret[2] = (num - 1) / 10 % 10;
		ret[1] = (num - 1) / 100 % 10;
		ret[0] = (num - 1) / 1000 % 10;
	}
}

void	d_command(int num, int *ret)
{
	ret[3] = num * 2 % 10000 % 10;
	ret[2] = num * 2 % 10000 / 10 % 10;
	ret[1] = num * 2 % 10000 / 100 % 10;
	ret[0] = num * 2 % 10000 / 1000 % 10;
}

void l_command(int *num, int *ret)
{
	ret[0] = num[1];
	ret[1] = num[2];
	ret[2] = num[3];
	ret[3] = num[0];
}

void	r_command(int *num, int *ret)
{
	ret[0] = num[3];
	ret[1] = num[0];
	ret[2] = num[1];
	ret[3] = num[2];
}

void	bfs(int a, int b, std::string route[10000])
{
	std::queue<int> que;
	std::string	before;
	int	num[4] = {0, };
	int	q_front, d_cmd[4] = {0, }, s_cmd[4] = {0, }, l_cmd[4] = {0, }, r_cmd[4] = {0, };

	que.push(a);
	while (route[b] == "" && !que.empty())
	{
		q_front = que.front();
		inttoarray(q_front, num);
		before = route[q_front];
		d_command(q_front, d_cmd);
		s_command(q_front, s_cmd);
		l_command(num, l_cmd);
		r_command(num, r_cmd);
		if (route[arraytoint(d_cmd)] == "")
		{
			route[arraytoint(d_cmd)] = before + "D";
			que.push(arraytoint(d_cmd));
		}
		if (route[arraytoint(s_cmd)] == "")
		{
			route[arraytoint(s_cmd)] = before + "S";
			que.push(arraytoint(s_cmd));
		}
		if (route[arraytoint(l_cmd)] == "")
		{
			route[arraytoint(l_cmd)] = before + "L";
			que.push(arraytoint(l_cmd));
		}
		if (route[arraytoint(r_cmd)] == "")
		{
			route[arraytoint(r_cmd)] = before + "R";
			que.push(arraytoint(r_cmd));
		}
		que.pop();
	}
}

int main()
{
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	// D : Double, 10000 이상일 경우 그 값을 10000으로 나눈 나머지
	// S : n - 1, n이 0이면 9999
	// L : Left shift 왼쪽으로 한 칸씩 이동
	// R : Right shift 
	// 1의 경우는 0001 이런식으로 저장되어있음
	// 입력 : 테스트 케이스 개수 -> 초기값, 최종 값
	// 출력 : 최종 값을 만드는 명령어 나열 (최소 명령 횟수) -> 다 해보기 (bfs, dfs?)
	// 시간제한 : 6초 
	std::string	route[10000] = {""};
	int t, a, b;

	std::cin >> t;
	for (int i = 0; i < t; ++i)
	{
		std::cin >> a >> b;
		bfs(a, b, route);
		std::cout << route[b] << "\n";
		std::fill_n(&route[0], 10000, "");
	}
}