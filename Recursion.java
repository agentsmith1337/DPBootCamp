public class Recursion{
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println();
        print1toN(1,5);
        System.out.println();
        prints1toN(5);
        System.out.println();
        printNto1(5);
        System.out.println();
        System.out.println(sumOfDigits(12345));
        System.out.println();
        System.out.println(gcd(5,15));
        System.out.println(fib(5,0,1));
        // System.out.println(josephus(5,2));
        // System.out.println(josephus(7,3));
        // System.out.println(josephus(40,7));
    }
    public static int factorial(int n) {
        if (n==1) return 1;
        else return n*factorial(n-1);
    }
    public static void printNto1(int n) {
        if (n==1) System.out.println(1);
        else {
            System.out.println(n);
            printNto1(n-1);
        }
    }
    public static void print1toN(int i, int n) {
        if (i==n) System.out.println(i);
        else {
            System.out.println(i);
            print1toN(i+1,n);
        }
    }
    public static void prints1toN(int n) {
        if (n==1) {
            System.out.println(1);
        }
        else {
            prints1toN(n-1);
            System.out.println(n);
        }
    }
    public static int sumOfDigits(int n) {
        if (n==0) return 0;
        else return n%10 + sumOfDigits(n/10);
    }
    public static int fib(int n, int a, int b) {
        if (n==0) return 0; //or return a
        if (n==1) return b;
        else {
            return fib(n-1, b,a+b);
        }
        //O(N) TC, O(1) SC with Tail Call Optimization
    }
    public static int gcd(int a, int b) {
        if (b>a) return gcd(b,a);
        if (a%b==0) return b;
        else return gcd(b,a%b);
    }
    // public static int josephus(int n, int k) {
    //     // return k*(n-1)%n;
    //     boolean[] killed = new boolean[n];
    //     int curr=0, alive=n;
    //     for (int i=0; i<n&&alive>1; i++) {
    //         curr+=k-1;
    //         while (killed[curr]) curr++;
    //         killed[curr]=true;
    //         curr%=n;
    //         alive--;
    //     }
    //     return curr;
    // }
}
