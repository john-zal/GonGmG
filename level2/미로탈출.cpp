#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int vis[101][101] = {0,};

pair<int, int> find_des(vector<string> maps, char c)
{
    for (int i = 0; i < maps.size(); ++i)
    {
        for (int j = 0; j < maps[0].size(); ++j)
        {
            if (maps[i][j] == c)
                return {i, j};
        }
    }
}

void fill_distance(vector<string> maps, queue<pair<int, int>> q, pair<int, int> s)
{
    q.push(s);
    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        q.pop();
        for (int i = 0; i < 4; ++i)
        {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || ny < 0 || nx >= maps.size() || ny >= maps[0].size())
                continue;
            if (vis[nx][ny] != 0 || maps[nx][ny] == 'X' || (nx == s.first && ny == s.second))
                continue;
            vis[nx][ny] = vis[cur.first][cur.second] + 1;
            q.push({nx, ny});
        }
    }
}

int solution(vector<string> maps) {
    int answer = 0;
    queue<pair<int, int>> q;
    pair<int, int> start = find_des(maps, 'S');
    pair<int, int> lever = find_des(maps, 'L');
    pair<int, int> exit = find_des(maps, 'E');

    fill_distance(maps, q, start);
    if (vis[lever.first][lever.second] == 0 || vis[exit.first][exit.second] == 0)
        return -1;
    answer += vis[lever.first][lever.second];
    for (int i = 0; i < maps.size(); ++i)
        fill_n(vis[i], 101, 0);
    fill_distance(maps, q, lever);
    answer += vis[exit.first][exit.second];
    return answer;
}