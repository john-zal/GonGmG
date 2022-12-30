package GonGmG.level2;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) { 

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        for(int i = 1; i < str1.length(); ++i) {
            if(Pattern.matches("^[a-zA-Z]*$", str1.substring(i-1, i+1)))
                arr1.add(str1.substring(i-1, i+1).toLowerCase());
        }
        for(int i = 1; i < str2.length(); ++i) {
            if(Pattern.matches("^[a-zA-Z]*$", str2.substring(i-1, i+1)))
                arr2.add(str2.substring(i-1, i+1).toLowerCase());
        }

        if(arr1.size() == 0 && arr2.size() == 0) 
            return 65536;
        
        else if(arr1.size() == 0 || arr2.size() == 0)
            return 0;
        
        int intersection = 0 ;
        int union = arr1.size() + arr2.size();
        double j_similarity;
        
        if(arr1.size() < arr2.size()){
            for(int i = 0; i < arr1.size(); ++i ) {
                if(arr2.contains(arr1.get(i))) {
                    ++intersection;
                    arr2.set(arr2.indexOf(arr1.get(1)),"A");
                }
            }
        }
        else {
            for(int i = 0; i < arr2.size(); ++i ) {
                if(arr1.contains(arr2.get(i))){ 
                    ++intersection;
                    arr1.set(arr1.indexOf(arr2.get(1)),"A");
                }
            }
        }

        j_similarity = (double)intersection / (double)(union-intersection);
        
        return (int)(65536*j_similarity);
    }
}

public class 뉴스클러스터링 {
    
}
