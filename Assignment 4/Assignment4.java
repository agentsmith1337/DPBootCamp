import java.util.*;
public class Assignment4 {
    public static void main(String[] args) {
        //QUESTION 1 : WORD BREAK
        List<String> keywords = new ArrayList<>();
        keywords.add("apple");
        keywords.add("pen");
        System.out.println(wordBreak("applepenapple", keywords));

        //QUESTION 2 : WORD BREAK 2 
        keywords.clear();
        keywords.add("apple");
        keywords.add("pen");
        keywords.add("applepen");
        keywords.add("pine");
        keywords.add("pineapple");
        System.out.println(wordBreak2("pineapplepenapple", keywords));

        //QUESTION 3 : N QUEENS
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(5));
        System.out.println(totalNQueens(10));

        //QUESTION 4 : SUDOKU SOLVER
        //NOT POSSIBLE TO SIMULATE HERE, SOURCED FROM MY LEETCODE

        //QUESTION 5 : MERGE SORT
        int[] arr = sortArray(new int[] {6,4,2,-1,-1,2,4,6,3,7,9}); 
        for (int x: arr) {
            System.out.print("-> "+x);
        }

        //QUESTION 6 : QUICK SORT 
        
    }
    //SOLUTION 1 : WORD BREAK
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(s, 0, set, dp);
    }
    static boolean helper(String s, int idx, HashSet<String> set, Boolean[] dp) {
        if (idx==s.length()) return true;
        if (dp[idx]!=null) return dp[idx];
        for (int i=idx; i<s.length(); i++) {
            if (set.contains(s.substring(idx,i+1))) {
                if (helper(s, i+1, set, dp)) return true;
            }
        }
        return dp[idx]=false;
    }
    //SOLUTION 2: WORD BREAK 2 
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        helper2(s, 0, "", set, ans);
        return ans;
    }
    static void helper2(String s, int idx, String ans, HashSet<String> set, List<String> ANS) {
        if (idx>=s.length()) {
            ANS.add(ans.substring(0,ans.length()-1));
            return;
        }
        for (int i=idx; i<s.length(); i++) {
            if (set.contains(s.substring(idx,i+1))) {
                helper2(s, i+1, ans+s.substring(idx,i+1)+" ", set, ANS);
            }
        }
    }
    //SOLUTION 3: N QUEENS 2 
    public static int totalNQueens(int n) {
        int[] queens = new int[n];
        for (int i=0; i<n; i++) {
            queens[i]=-1;
        }
        return solve(0,n,queens);
    }
    static int solve(int row, int n, int[] queens) {
        if (row==n) return 1;
        int count=0;
        for (int j=0; j<n; j++) {
            if (safe(row,j,queens)) {
                queens[row]=j;
                count+=solve(row+1, n, queens);
                queens[row]=-1;
            }
        }
        return count;
    }
    static boolean safe(int i, int j, int[] queens) {
        for (int idx=0; idx<queens.length; idx++) {
            if (queens[idx]==-1) break;
            if (j==queens[idx]||Math.abs(i-idx)==Math.abs(j-queens[idx])) return false;
        }
        return true;
    }
    // SOLUTION 4 : SUDOKU SOLVER
    public static void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[board.length][10];
        boolean[][] column = new boolean[board.length][10];
        boolean[][][] grids = new boolean[3][3][10];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i][j]=='.') continue;
                int val = board[i][j]-'0';
                row[i][val]=true;
                column[j][val]=true;
                grids[i/3][j/3][val]=true;
            }
        }
        helper(0,0, board, row, column, grids);
    }
    static boolean solved=false;
    static void helper(int i, int j, char[][] board, boolean[][] row, boolean[][] column, boolean[][][] grids) {
        if (i==9) {
            solved=true;
            return;
        }
        if (j==9) {
            helper(i+1, 0, board, row, column, grids);
            return;
        }
        
        for (int val=1; val<=9; val++) {
            if (board[i][j]!='.') {
                helper(i, j+1, board, row, column, grids);
                return;
            }
            if (row[i][val]||column[j][val]||grids[i/3][j/3][val]) continue;
            board[i][j]=(char)('0'+val);
                row[i][val]=true;
                column[j][val]=true;
                grids[i/3][j/3][val]=true;
                helper(i, j+1, board, row, column, grids);
            if (!solved) {
                board[i][j]='.';
                row[i][val]=false;
                column[j][val]=false;
                grids[i/3][j/3][val]=false;
            }
        }
    }
    //QUESTION 5 : MERGE SORT 
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public static void mergeSort(int[] nums, int beg, int end) {
    if (beg<end) {
        int mid=beg+(end-beg)/2;
        mergeSort(nums, beg, mid);
        mergeSort(nums, mid+1,end);
        merge(nums, beg,mid,end);
        }
    }
    public static void merge(int[] nums, int beg, int mid, int end) {
        int[] b = new int[end-beg+1];
        int left=beg, right=mid+1, k=0;
        while (left<=mid&&right<=end) {
            if (nums[left]<=nums[right]) {
                b[k++]=nums[left++];
            } else b[k++]=nums[right++];
        }
        while (left<=mid) {
            b[k++]=nums[left++];
        }
        while(right<=end) {
            b[k++]=nums[right++];
        }
        for (int i=0; i<b.length; i++) {
            nums[beg+i]=b[i];
        }
        return;
    }
    // QUESTION 6: QUICK SORT 

}


