import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 통계학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numnum = br.readLine();
        int[] arr = new int[Integer.parseInt(numnum)]; 
        for(int i = 0; i  < Integer.parseInt(numnum); ++i)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int average = 0;
        int midvalue = 0;
        int frequency = 0;
        int range = 0;
        
        midvalue = arr[arr.length/2];
        range = arr[arr.length-1] - arr[0];

        int sum = arr[arr.length-1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(arr[arr.length-1],1);

        for(int i = 0 ; i < arr.length-1; ++i) {
            sum += arr[i];
            
            if(map.get(arr[i]) == null) 
                map.put(arr[i],1);
            else 
                map.put(arr[i],map.get(arr[i])+1);
        }
        average = (int)Math.round((double)sum/(double)arr.length);

        List<HashMap.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(HashMap.Entry<Integer, Integer> o1, HashMap.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int  flag = 0;
        ArrayList<Integer> fre = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : entryList){
            if(flag == 0)
                fre.add(entry.getKey());
            else {
                if(entry.getValue() == map.get(fre.get(0)))
                    fre.add(entry.getKey());
                else
                    break;
                
            }
            ++flag;
        }
        Collections.sort(fre);
        if(fre.size() > 1)
            frequency = fre.get(1);
        else
            frequency = fre.get(0);

        bw.write(String.valueOf(average) + "\n" + String.valueOf(midvalue)
             + "\n" + String.valueOf(frequency) + "\n" + String.valueOf(range));
        
        bw.close();
    }
}