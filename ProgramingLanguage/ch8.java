package GonGmG.ProgramingLanguage;
class funref{
    public int k;
    public funref(int k){
        this.k = k;
    }
}
public class ch8 {
    public static int i = 10, j = 10, sum1, sum2;
    public static int fun(int kk){
        funref K = new funref(kk);
        K.k += 4;
        return 3*K.k - 1;
    }
    public static void main(String[] args) {
            sum1 = (i / 2) + fun(i);
            sum2 = fun(j) +(j / 2);
            System.out.println("sum1 = " + sum1 + "\nsum2 = " + sum2);
    }
}