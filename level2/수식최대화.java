package GonGmG.level2;

import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> sym_h = new HashSet<>();
        StringTokenizer st = new StringTokenizer(expression, "+-*",false);
        
        while(st.hasMoreTokens()) {
            arr.add(st.nextToken());
            if(arr.get(arr.size()-1).equals("+") 
            || arr.get(arr.size()-1).equals("-") 
            || arr.get(arr.size()-1).equals("*"))
                sym_h.add(arr.get(arr.size()-1));
        }
        long max = 0;
        Stack<String> sym_com = new Stack<>();
        ArrayList<String> sym = new ArrayList<>();
        for(String i : sym_h)
            sym.add(i);

        if(sym.size() == 2){
            sym_com.add(sym.get(0));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(0));
        }
        else {
            sym_com.add(sym.get(0));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(2));
            sym_com.add(sym.get(0));
            sym_com.add(sym.get(2));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(0));
            sym_com.add(sym.get(2));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(2));
            sym_com.add(sym.get(0));
            sym_com.add(sym.get(2));
            sym_com.add(sym.get(0));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(2));
            sym_com.add(sym.get(1));
            sym_com.add(sym.get(0));
        }
        while(!sym_com.isEmpty()) {
            ArrayList<String> temp = new ArrayList<>(arr);
            while(!(temp.size()==1)) {
                String symbol = sym_com.pop();
                for(int i = 0; i < temp.size(); ++i) {
                    if(arr.get(i).equals(symbol)) {
                        arr.add(i-1,Integer.parseInt(arr.get(i-1)))
                    }
                }
            }
        }
        return answer;
    }
}

public class 수식최대화 {
    
}
