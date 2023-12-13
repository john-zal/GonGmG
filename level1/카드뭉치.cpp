/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   카드뭉치.cpp                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: mkong <mkong@student.42seoul.kr>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/12/13 14:57:51 by mkong             #+#    #+#             */
/*   Updated: 2023/12/13 15:15:23 by mkong            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
	string str;
	for (int i = 0; i < goal.size(); ++i)
	{
		str = goal[i];
		if (str == cards1[0])
		{
			cards1.erase(cards1.begin());
			continue;
		}
		else if (str == cards2[0])
		{
			cards2.erase(cards2.begin());
			continue;
		}
		return ("No");
	}
    return ("Yes");
}
