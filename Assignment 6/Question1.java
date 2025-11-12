//UNIQUE PATHS 2 
public class Question1 {
    public static void main(String[] args) {
        int[][] case1 = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        int[][] case2 = new int[][] {{0,1,0,1},{0,0,0,1},{1,0,0,0}};
        System.out.println(uniquePathsWithObstacles(case1));
        System.out.println(uniquePathsWithObstacles(case2));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=0; i<obstacleGrid.length; i++) {
            for (int j=0; j<obstacleGrid[0].length; j++) dp[i][j]=-1;
        }
        return helper(obstacleGrid, 0, 0, dp);
    }
    static int helper(int[][] grid, int i, int j, int[][] dp) {
        if (i>=grid.length || j>=grid[0].length || grid[i][j]==1) return 0;
        if (i==grid.length-1&&j==grid[0].length-1) return 1;
        if (dp[i][j]!=-1) return dp[i][j]; 
        dp[i][j] = helper(grid, i+1, j, dp)+helper(grid, i, j+1, dp);
        return dp[i][j];
    }
}
