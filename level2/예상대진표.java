package GonGmG.level2;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while((a+1)/2 == (b+1)/2)
        {
            if((a+1)/2 != (b+1)/2)
            {
                a = (a+1)/2;
                b = (b+1)/2;
                answer++;
            }
        }
        return answer;
    }
}
public class 예상대진표 {
    
}
