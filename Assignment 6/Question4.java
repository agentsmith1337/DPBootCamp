public class Question4 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(grid));
    }
    public static int minFallingPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length]; 
        int min=Integer.MAX_VALUE;
        for (int i=0; i<grid.length; i++) {
            min=Math.min(min,helper(0,i,grid,dp));
        }
        return min;
    }
    static int helper(int i, int j, int[][] grid, Integer[][] dp) {
        if (j<0||j>=grid[0].length) return Integer.MAX_VALUE;
        if (i==grid.length-1) return grid[i][j];
        if (dp[i][j]!=null) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for (int idx=0; idx<grid[0].length; idx++) {
            if (idx==j) continue;
            min=Math.min(min, helper(i+1,idx, grid, dp));
        }
        return dp[i][j]=grid[i][j]+min;
    }
}