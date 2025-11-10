
public class Assignment4 {
    public static void main(String[] args) {

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


