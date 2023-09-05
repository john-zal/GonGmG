#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

int run_time(string mi)
{
    int start_h = stoi(mi.substr(0,2));
    int start_m = stoi(mi.substr(3,2));
    int finish_h = stoi(mi.substr(6,2));
    int finish_m = stoi(mi.substr(9,2));
    return (finish_h * 60 + finish_m) - (start_h * 60 + start_m);
}

vector<string> split(string s, char deli)
{
    vector<string> ret;
    string tmp;
    istringstream ss(s);

    while (getline(ss, tmp, deli))
        ret.push_back(tmp);
    return ret;
}

string replace_s(string s)
{
    string tmp;

    for (int i = 1; i < s.size(); ++i)
    {
        tmp = tolower(s[i - 1]);
        if (s[i] == '#')
            s.replace(i - 1, 2, tmp);
    }
    return s;
}

bool cmp(pair<string, string> a, pair<string, string> b)
{
    if (a.second.size() > b.second.size())
        return (true);
    return (false);
}

string solution(string m, vector<string> musicinfos) {
    string answer = "(None)";
    vector<pair<string, string>> title_melody;
    vector<string> mus_inf;
    string title, melody, tmp;
    int r_t;
    int j;
    
    m = replace_s(m);
    for (int i = 0; i < musicinfos.size(); ++i)
    {
        r_t = run_time(musicinfos[i]);
        mus_inf = split(musicinfos[i], ',');
        title = mus_inf[2];
        mus_inf[3] = replace_s(mus_inf[3]);
        melody = "";
        j = 0;
        while (r_t != 0)
        {
            if (mus_inf[3][j] == '#')
            {
                tmp = mus_inf[3][j];
                melody.append(tmp);
                j++;
            }
            tmp = mus_inf[3][j];
            melody.append(tmp);
            j++;
            if (j == mus_inf[3].size())
                j = 0;
            r_t--;
        }
        title_melody.push_back({title, melody});
    }
    stable_sort(title_melody.begin(), title_melody.end(), cmp);
    for (int i = 0; i < title_melody.size(); ++i)
    {
        if (title_melody[i].second.find(m) != string::npos)
            return title_melody[i].first;
    }
    return answer;
}