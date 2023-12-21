/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   캐시.cpp                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: mkong <mkong@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/12/14 13:40:51 by mkong             #+#    #+#             */
/*   Updated: 2023/12/14 15:07:54 by mkong            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int	cache_check (vector<string> *cache, int cacheSize, string city)
{
	vector<string> :: iterator iter;
	int hit = 1;

	if (cacheSize == 0)
		return (5);
	iter = find((*cache).begin(), (*cache).end(), city);
	if (iter == (*cache).end())
	{
		if ((*cache).size() == cacheSize)
			(*cache).erase((*cache).begin());
		hit = 5;
	}
	else
		(*cache).erase(iter);
	(*cache).push_back(city);
	return (hit);
}

int solution(int cacheSize, vector<string> cities) {
	vector<string>	cache;
    int				answer = 0;
	string			city;

	for (int i = 0; i < cities.size(); ++i)
	{
		for (int j = 0; j < cities[i].size(); ++j)
			cities[i][j] = tolower(cities[i][j]);
		answer += cache_check(&cache, cacheSize, cities[i]);
	}
	return (answer);
}
