#include <iostream>
#include <memory.h>

using namespace std;

bool check_fill(int paper[128][128], int size, int i, int j, int &white, int &blue)
{
	int	n = paper[i][j];

	for (int idx = i; idx < size + i; ++idx)
		for (int jdx = j; jdx < size + j; ++jdx)
			if (paper[idx][jdx] != n)
				return (false);
	if (n == 0)
		white++;
	else
		blue++;
	return (true);	
}

void	divide_conquer(int paper[128][128], int &white, int  &blue, int size, int i, int j)
{
	if (check_fill(paper, size, i, j, white, blue))
		return ;
	divide_conquer(paper, white, blue, size / 2, i, j);
	divide_conquer(paper, white, blue, size / 2, i + size / 2, j);
	divide_conquer(paper, white, blue, size / 2, i, j + size / 2);
	divide_conquer(paper, white, blue, size / 2, i + size / 2, j + size / 2);
}

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int	paper[128][128];
	int white, blue = 0;
	int	N;

	memset(paper, -1, sizeof(paper));
	cin >> N;
	for (int i = 0; i < N; ++i)
		for (int j = 0; j < N; ++j)
			cin >> paper[i][j];
	divide_conquer(paper, white, blue, N, 0, 0);
	cout << white << "\n" << blue << "\n";
}
