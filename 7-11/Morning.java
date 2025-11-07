import java.util.*;
import java.lang.StringBuilder;
public class Morning {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        binaryStrings("", 0, 4, ans);
        System.out.println(ans);

        ans.clear();
        adjacentBinaryStrings(new StringBuilder("0000"), 0, 4, ans);
        System.out.println(ans);

        ans.clear();
        permutationsOfAString(new StringBuilder("ABCD"), 0, 0, ans);
        System.out.println(ans);
    }
    static void binaryStrings(String num, int i, int n, List<String> ans) {
        if (i==n) {
            ans.add(num);
            return;
        }
        binaryStrings(num+"0", i+1, n, ans);
        binaryStrings(num+"1", i+1, n, ans);
    } 
    static void adjacentBinaryStrings(StringBuilder num, int i, int n, List<String> ans) {
        if (i==n) {
            ans.add(num.toString());
            return;
        }
        adjacentBinaryStrings(num, i+1, n, ans);
        if (i==0||num.charAt(i-1)!='1') {
            StringBuilder mod = new StringBuilder(num);
            adjacentBinaryStrings(mod.replace(i,i+1,"1"), i+1, n, ans);
        }
    }
    static void permutationsOfAString(StringBuilder sb, int i, int j, List<String> ans) {
        //Base Case : If the 
        if (i==sb.length()) {
            ans.add(sb.toString());
            return;
        }

        //Recursive Case
        for (j=i; j<sb.length(); j++) {
            //Make a copy of current sb/string
            StringBuilder modsb = new StringBuilder(sb);
            //Prepare for swap
            char c1 = modsb.charAt(i);
            char c2 = modsb.charAt(j);
            //Swap ith and jth characters
            modsb.setCharAt(i, c2);
            modsb.setCharAt(j, c1);
            //Now focus on characters starting i+1
            permutationsOfAString(modsb, i+1, j, ans);
        }
    }
}
