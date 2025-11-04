import java.util.*;
public class Evening {
    
    public static void main(String[] args) {
        System.out.println(reverse("Hello World"));
        System.out.println(reverseStr("reverse this string"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("rotor"));
        System.out.println(isPalindrome("abcd"));
        System.out.println(""+pow(5,4)+" "+pow(3,1)+" "+pow(3,11));
        System.out.println(lucky(2)+" Lucky numbers");
        System.out.println(expLucky(4));
        System.out.println();
        HashSet<String> set = new HashSet<>();
        printHelp("", 2, set);
        for (String x: set) {
            System.out.println(x);
        }
        towerOfHanoi(3, 'A', 'B', 'C');
    }
    // public static int josephus(int n, int k) {
    //     boolean[] killed = new boolean[n];
    //     int curr=0;
    //     int alive=n;
    //     while(alive>1) {
    //         curr+=k-1;
    //         curr%=n;
            
    //         killed[n]=true;
    //     }
    // }
    public static String reverse(String s) {
        if (s.equals("")) return "";
        return s.charAt(s.length()-1)+reverse(s.substring(0,s.length()-1));
    }
    public static String reverseStr(String s) {
        if (s.equals("")) return "";
        return reverseStr(s.substring(1))+s.charAt(0);
    }
    // public static String reverseAsCharArray(char [] s, int i) {

    // }
    public static boolean isPalindrome(String s) {
        if (s.equals("") || s.length()==1) return true;
        if (s.charAt(0)==(s.charAt(s.length()-1)))
            return isPalindrome(s.substring(1,s.length()-1));
        else return false;
    }
    public static int pow(int x, int n) {
        if (n==0) return 1;
        int y=pow(x,n/2);
        if (n%2==0) return y*y;
        else return y*y*x;
        // \log{2}{n} Time Complexity
    }
    public static int lucky(int n) {
        return 2<<n+1-2;
    }
    public static int expLucky(int n) {
        if (n==1) return 2;
        return (int)Math.pow(2,n)+expLucky(n-1);
    }
    // public static int printLucky(int l, int n) {
    //     if (l>n) return 0;
    //     return Math.pow(2,l)+printLucky(l+1, n);
    // }
    public static void printHelp(String s, int n, HashSet<String> set) {
        if (s.length()>=n) return;
        set.add(s+"7");
        set.add(s+"8");
        printHelp(s+"7", n, set);
        printHelp(s+"8", n, set);
    }
    public static void towerOfHanoi(int n, char S, char A, char D) {
        if (n==1) {
            System.out.println("Move 1 from "+S+" to "+D);
        }
        else {
            towerOfHanoi(n-1, S, D, A);
            System.out.println("Move "+n+" from "+S+" to "+D);
            towerOfHanoi(n-1, A, S, D);
        }
    }

}