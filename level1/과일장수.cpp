/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   과일장수.cpp                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: mkong <mkong@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/12/15 15:13:00 by mkong             #+#    #+#             */
/*   Updated: 2023/12/15 15:21:33 by mkong            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

static bool descending_sort(int i, int j)
{
	return (i > j);
}

int solution(int k, int m, vector<int> score) {
    int answer = 0;
	sort(score.begin(), score.end(), descending_sort);
	for (int i = m - 1; i < score.size(); i = i + m)
		answer += score[i] * m;
    return (answer);
}
