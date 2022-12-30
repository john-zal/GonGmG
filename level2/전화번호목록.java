package GonGmG.level2;
import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; ++i) {
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }
        return true;
    }
}
public class 전화번호목록 {
    
}
