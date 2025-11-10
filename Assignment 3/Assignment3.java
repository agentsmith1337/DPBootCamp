
public class Assignment3 {
    public static void main(String[] args) {
        //QUESTION 3 
    System.out.println(totalNQueens(1));
    System.out.println(totalNQueens(2));
    System.out.println(totalNQueens(4));
    System.out.println(totalNQueens(5));
    System.out.println(totalNQueens(6));
    System.out.println(totalNQueens(10));
    }

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
}
