package GonGmG.level2;

class Solution {
    StringBuffer tobinary ( long x ) {
        StringBuffer sb = new StringBuffer("");
        while ( x > 0 ) {
            sb.append( x % 2 );
            x /= 2;
        }
        return sb.reverse();
    }
    long todecimal (StringBuffer sb) {
        long dec = 0;
        int one = 0;
        sb.reverse();
        for ( int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '1') 
                ++one;

            else if(sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                sb.insert(i,"1");
                if(one != 0) {
                    for( int j = i-1; j >= 0; --j) {
                        if(sb.charAt(j) == '1') {
                            sb.deleteCharAt(j);
                            sb.insert(j, "0");
                            break;
                        }
                    }
                }
                break;
            }
        }
        for ( int i = 0; i < sb.length() ; ++i ){
            if(sb.charAt(i) == '1') 
                dec += Math.pow(2,i);
        }
        return dec;
    }
    long fun ( long x ) {
        StringBuffer xs = tobinary(x);
        StringBuffer fxs = tobinary(++x);
        if(xs.length() != fxs.length()) {
            for( int i = 0; i < xs.length()-1; ++i ) 
                x += Math.pow(2, i);
            return x;
        }
        else 
            return x = todecimal(xs);
    }
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for ( int i = 0; i < numbers.length; ++i ) 
            answer[i] = fun(numbers[i]);
        
        return answer;
    }
}
public class 2개이하로다른비트 {
    
}
