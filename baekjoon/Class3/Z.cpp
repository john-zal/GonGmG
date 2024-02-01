#include <iostream>
#include <cmath>

using namespace std;

int	val = 0;
int	r, c;

void	fill_z(int n, int y, int x)
{
	if (y == r && x == c)
	{
		cout << val << "\n";
		return ;
	}
	if ((y <= r && r < y + n) && (x <= c && c < x + n))
	{
		fill_z(n / 2, y, x);
		fill_z(n / 2, y, x + n / 2);
		fill_z(n / 2, y + n / 2, x);
		fill_z(n / 2, y + n / 2, x + n / 2);
	}
	else
		val += n * n;
}

int main()
{
	int	N;

	cin >> N >> r >> c;
	fill_z(pow(2, N), 0, 0);
}