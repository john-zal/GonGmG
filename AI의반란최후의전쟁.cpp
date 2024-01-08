#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//int abc[4];
int arr[4];
int	answer;

// void	dfs(vector<vector<int>> v, int i)
// {
// 	if (i == v.size())
// 	{
// 		if (abc[0] && abc[1] && abc[2])
// 			if (abc[3] < answer || answer == 0)
// 				answer =  abc[3];
// 		return ;
// 	}
// 	for (int j = 0; j < v[i].size(); ++j)
// 	{
// 		for (int k = 0; k < v[i].size(); k++)
// 			if (k != j)
// 				abc[3] += v[i][k];
// 		abc[j] += 1;
// 		dfs(v, i + 1);
// 		abc[j] -= 1;
// 		for (int k = 0; k < v[i].size(); k++)
// 		{
// 			if (k != j)
// 				abc[3] -= v[i][k];
// 		}
// 	}
// }


void	combination(vector<vector<int>> v, int depth, int next)
{
	if (depth == 3)
	{
		for (int i = 0; i < 3; ++i)
		{
			arr[3] = 0;
			for (int j = 0; j < 3; ++j)
			{
				if (j != i)
				for (int k = 0; k < 3; ++k)
				{
					if (k != i && k != j)
					{
						arr[3] += v[arr[0]][j] + v[arr[0]][k] + v[arr[1]][i] + v[arr[1]][k] + v[arr[2]][i] + v[arr[2]][j];
						for (int x = 0; x < v.size(); ++x)
							if (x != i && x != j && x != k)
								arr[3] += v[x][0] + v[x][1] + v[x][2] - max(v[x][0], max(v[x][1], v[x][2]));
						if (answer > arr[3] || answer == 0)
							answer = arr[3];
					}
				}
			}
		}
	}
	for(int i = next; i < v.size(); ++i)
	{
		arr[depth] = i;
		combination(v, depth + 1, i + 1);
	}
}

int main()
{
	vector<vector<int>>	v;
	vector<int>			ability(3);
	int					T;
	int					a, b, c;
	int 				n;

	cin >> T;
	for (int i = 1; i <= T; ++i)
	{
		cin >> n;
		answer = 0;
		for (int j = 0; j < n; ++j)
		{
			cin >> a >> b >> c;
			ability[0] = a;
			ability[1] = b;
			ability[2] = c;
			v.push_back(ability);
		}
		if (n < 3)
			cout << "#" << i << " -1" << "\n";
		else
		{
			combination(v, 0, 0);
			cout << "#" << i << " " << answer << "\n";
		}
		v.clear();
	}
}
