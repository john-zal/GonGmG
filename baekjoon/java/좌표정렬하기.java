import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 좌표정렬하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        ArrayList<Pair_point> arr = new ArrayList<>();
        for(int i = 0; i < num; ++i) {
            String[] point = br.readLine().split(" ");
            arr.add(new Pair_point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
        }

        Collections.sort(arr,new y_sort());
        Collections.sort(arr,new x_sort());

        for(Pair_point p : arr) 
            bw.write(String.valueOf(p.getX()) +" " + String.valueOf(p.getY()) + "\n");
        bw.close();
    }
}
class Pair_point {
    private int x;
    private int y;
    
    Pair_point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
class x_sort implements Comparator<Pair_point> {
    public int compare(Pair_point p1, Pair_point p2) {
        if(p1.getX() > p2.getX())
            return 1;
        else if(p1.getX() < p2.getX())
            return -1;
        return 0;
    }
}

class y_sort implements Comparator<Pair_point> {
    public int compare(Pair_point p1, Pair_point p2) {
        if(p1.getY() > p2.getY())
            return 1;
        else if(p1.getY() < p2.getY())
            return -1;
        return 0;
    }
}