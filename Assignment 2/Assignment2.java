import java.util.*;
public class Assignment2 {
        public static void main(String[] args) {
            //QUESTION 1 : BINARY STRINGS WITH NUMBER OF 1s >= NUMBER OF 0s IN ANY PREFIX  
            binaryNBit(1);
            System.out.println();
            binaryNBit(2);
            System.out.println();
            binaryNBit(3);
            System.out.println();
            binaryNBit(4);
            System.out.println();

            //QUESTION 2 : DELETE MIDDLE ELEMENT OF A STACK WITHOUT USING LOOPS OR DATA STRUCTURES 
            Stack<Integer> s1 = new Stack<>();
            s1.push(10);
            s1.push(20);
            s1.push(30);
            s1.push(40);
            s1.push(50);
            System.out.println(s1);
            deleteMid(s1);
            System.out.println(s1);
            System.out.println();

            Stack<Integer> s2 = new Stack<>();
            s2.push(10);
            s2.push(20);
            s2.push(30);
            s2.push(40);
            System.out.println(s2);
            deleteMid(s2);
            System.out.println(s2);

            //QUESTION 3 : LETTER COMBINATIONS OF A PHONE NUMBER
            List<String> ans1 = letterCombinations("247");
            List<String> ans2 = letterCombinations("39");
            System.out.println(ans1);
            System.out.println(ans2);

            System.out.println();
            //QUESTION 4 : COMBINATIONS LEETCODE 77
            List<List<Integer>>combine1 = combine(4,2);
            List<List<Integer>>combine2 = combine(4,3);
            System.out.println(combine1);
            System.out.println(combine2);

            //QUESTION 5 : NUM TILE POSSIBILITIE 
            System.out.println(numTilePossibilities("ABC"));
            System.out.println(numTilePossibilities("CDBAS"));
        }
        //SOLUTION 1 : BINARY STRINGS WITH NUMBER OF 1s >= NUMBER OF 0s IN ANY PREFIX
        static void binaryNBit(int n) {
            if (n<=0) return;
            ArrayList<String> ans = new ArrayList<>();
            binaryNBitHelper("", 0, 0, 0, n, ans);
            for (String x : ans) {
                System.out.print(x+", ");
            }
        }
        //i is length of current string, j is number of 1s, k is number of 0s, n is required length
        static void binaryNBitHelper(String num, int i, int j, int k, int n, ArrayList<String> ans) {
            if (k>j) return;
            if (i==n) {
                ans.add(num);
                return;
            }
            binaryNBitHelper(num+"1", i+1, j+1, k, n, ans);
            binaryNBitHelper(num+"0",i+1, j, k+1, n, ans);
        }
        //TIME COMPLEXITY : \O (2^n) ; SPACE COMPLEXITY: \O (2^n) 
        //SOLUTION 1 REGION ENDS
        //SOLUTION 2 REGION BEGINS
        static  void deleteMid(Stack<Integer> s) {
            //handle odd and even lengths
        if (s.size()%2==0) {
            delete(s,0,(s.size()+1)/2);
        } else delete(s,1,(s.size()+1)/2);
    }
        static void delete(Stack<Integer> s, int n, int mid) {
        if (n==mid) {
            s.pop();
            return;
        }
        int save = s.pop();
        delete(s, n+1, mid);
        s.push(save);
    }
    //SOLUTION 2 REGION ENDS

    //SOLUTION 3 REGION BEGINS
    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper(digits, 0, "", ans);
        return ans;
    }
    static void helper(String digits, int index, String ans, List<String> ANS) {
        if (index==digits.length()) {
            ANS.add(ans);
            return;
        }
        switch (digits.charAt(index)) {
            case '2':
                helper(digits, index+1, ans+"a",ANS);
                helper(digits, index+1, ans+"b",ANS);
                helper(digits, index+1, ans+"c",ANS);
                break;
            case '3':
                helper(digits, index+1, ans+"d",ANS);
                helper(digits, index+1, ans+"e",ANS);
                helper(digits, index+1, ans+"f",ANS);
                break;
            case '4':
                helper(digits, index+1, ans+"g",ANS);
                helper(digits, index+1, ans+"h",ANS);
                helper(digits, index+1, ans+"i",ANS);
                break;
            case '5':
                helper(digits, index+1, ans+"j",ANS);
                helper(digits, index+1, ans+"k",ANS);
                helper(digits, index+1, ans+"l",ANS);
                break;
            case '6':
                helper(digits, index+1, ans+"m",ANS);
                helper(digits, index+1, ans+"n",ANS);
                helper(digits, index+1, ans+"o",ANS);
                break;
            case '7':
                helper(digits, index+1, ans+"p",ANS);
                helper(digits, index+1, ans+"q",ANS);
                helper(digits, index+1, ans+"r",ANS);
                helper(digits, index+1, ans+"s",ANS);
                break;
            case '8':
                helper(digits, index+1, ans+"t",ANS);
                helper(digits, index+1, ans+"u",ANS);
                helper(digits, index+1, ans+"v",ANS);
                break;
            case '9':
                helper(digits, index+1, ans+"w",ANS);
                helper(digits, index+1, ans+"x",ANS);
                helper(digits, index+1, ans+"y",ANS);
                helper(digits, index+1, ans+"z",ANS);
                break;
        }
    }
    //QUESTION 4 REGION STARTS
    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(new ArrayList<>(), 0, 1, n, k, ans);
        return ans;
    }
    static void helper(ArrayList<Integer> ans, int i, int j, int n, int k, List<List<Integer>> ANS) {
        if (i==k) {
            ANS.add(ans);
            return;
        }
        if (j>n) return;
        ArrayList<Integer> mod = new ArrayList<>(ans);
        mod.add(j); 
        helper(ans, i, j+1, n, k, ANS);
        helper(mod, i+1, j+1, n, k, ANS);
    }

    //SOLUTION 5 : LETTER TILE POSSIBILITIES
    static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) freq[c - 'A']++;
        return dfs(freq);
    }

    
    static int dfs(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            // choose letter i
            freq[i]--;
            count += 1;          
            count += dfs(freq);  
            freq[i]++;           
        }
        return count;
    }
}
