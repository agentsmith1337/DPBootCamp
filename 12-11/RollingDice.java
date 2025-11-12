import java.util.Scanner;
public class RollingDice {
    public static void main(String args[]) {
        Scanner io = new Scanner(System.in);
        int n=io.nextInt();
        int[] input = new int[n];

        for (int i=0; i<n; i++) {
            input[i]=io.nextInt();
        }
        for (int x : input) {
            if (x%7==0) System.out.println(x/7);
            else System.out.println(x/7+1); 
        }
        io.close();
    }   
}
