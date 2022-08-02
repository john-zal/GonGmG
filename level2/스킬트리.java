package GonGmG.level2;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            int prior = -1;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                String sk = String.valueOf(skill_trees[i].charAt(j));
                if(skill.contains(sk)){
                    if(prior+1 == skill.indexOf(sk))
                        prior = skill.indexOf(sk);
                    else
                        break;
                }
                if(j == skill_trees[i].length()-1)
                    answer++;
            }
        }
        return answer;
    }
}
public class 스킬트리 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tress = {"BACDE", "CBADF", "AECB", "BDA"};
        int a = s.solution("CBD", tress);
        System.out.println(a);
    }
}
