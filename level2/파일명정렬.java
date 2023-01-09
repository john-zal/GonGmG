package GonGmG.level2;

import java.util.*;

class File {
    private String head;
    private String num;
    private String tail;
    public File(String head,String num, String tail) {
        this.head = head;
        this.num = num;
        this.tail = tail;
    }
    public String get_head() {
        return head;
    }
    public String get_num(){
        return num;
    }
    public String get_tail() {
        return tail;
    }
}
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> arr = new ArrayList<>();

        for(int i = 0; i < files.length; ++i) {
            String head = "";
            String num = "";
            String tail = "";
            int k = 0;
            for(int j = 0; j < files[i].length(); ++j) {
                if(47 < files[i].charAt(j) && files[i].charAt(j) < 58 && k == 0) {
                    k = j;
                    head = files[i].substring(0,k);
                }
                if((48 > files[i].charAt(j) || files[i].charAt(j) > 57) && k != 0) {
                    num = files[i].substring(k,j);
                    tail = files[i].substring(j);
                    break;
                }
            }
            if(num.equals(""))
                num = files[i].substring(k);

            arr.add(new File(head, num, tail));
        }

        Collections.sort(arr, new Comparator<File>() {
            public int compare(File f1,File f2) {
                return Integer.parseInt(f1.get_num()) - Integer.parseInt(f2.get_num());
            }
        });
        Collections.sort(arr, new Comparator<File>() {
            public int compare(File f1,File f2) {
                return f1.get_head().compareTo(f2.get_head());
            }
        });

        for(int i = 0; i < files.length; ++i) {
            answer[i] = arr.get(i).get_head() + arr.get(i).get_num() + arr.get(i).get_tail();
        }
        return answer;
    }
}

public class 파일명정렬 {
    
}
