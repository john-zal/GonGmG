package GonGmG.level2;

import java.util.*;

class Solution {
    static Map<String,Integer> all_com = new HashMap<>();
    static boolean[] visited = new boolean[27];

    public void combination(int k , int deepth , ArrayList<Character> all , StringBuilder part, int i) {
        if(k == deepth) {
            all_com.put(String.valueOf(part),0);
            return ;
        }
        for(int a = i; a < all.size(); ++a) {
            if(!visited[i]) {
                part.append(all.get(a));
                visited[a] = true;
                combination(k,deepth+1, all, part, a+1);
                visited[a] = false;
                part.deleteCharAt(part.length()-1);
            }
        }
    }
    public String string_sort(String k) {
        char[] ch = k.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public ArrayList<String> solution(String[] orders, int[] course) {
        HashSet<Character> all_set = new HashSet<>();
        ArrayList<Character> all = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i < orders.length; ++i) {
            for(int j = 0; j < orders[i].length(); ++j) 
                all_set.add(orders[i].charAt(j));
        }

        for(Character i : all_set) 
            all.add(i);

        for(int k : course) {        
            StringBuilder part = new StringBuilder();
            combination(k, 0, all, part, 0);
        }
        
        for(int i = 0; i < orders.length; ++i)
            orders[i] = string_sort(orders[i]);
        
        for(String k : all_com.keySet()) {
            for(int i = 0; i < orders.length; ++i) {
                for(int j = 0; j < k.length(); ++j) {
                    Character a = k.charAt(j);
                    boolean check = false;
                    for(int l = 0; l < orders[i].length(); ++l) {
                        if(a == orders[i].charAt(l)) 
                            check = true;
                    }
                    if(!check)
                        break;
                    if(check && j == k.length()-1)
                        all_com.put(k,all_com.get(k)+1);
                }
            }
        }
        
        int max = 0;
        for(int k : course){
            for(String i : all_com.keySet()) {
                if(i.length() == k && all_com.get(i) > 1) {
                    if(max < all_com.get(i))
                        max = all_com.get(i);
                }
            }
            if(max > 1) {
                for(String i : all_com.keySet()) {
                    if(i.length() == k && all_com.get(i) == max)
                        ans.add(i);
                }
            }
            max = 0;
        }
        Collections.sort(ans);
        return ans;
    }
}

public class 메뉴리뉴얼 {
    
}
