public class Morning {
    public static void main(String[] args) {
        System.out.println(frogJumpK(new int[] {10, 30, 40, 20, 60, 30, 20, 10, 10, 20, 30, 40, 50, 50} , 0, 3, new Integer[20]));
    }
    static int frogJumpK(int[] height, int i, int k, Integer[] dp) {
        if (i==height.length-1) return 0; 
        if (dp[i]!=null) return dp[i];
        Integer min=Integer.MAX_VALUE;
        for (int j=1; j<=k; j++) {
            if (i+j>=height.length) break;
            min=Math.min(Math.abs(height[i]-height[i+j])+frogJumpK(height,i+j, k, dp),min);
        }
        return dp[i]=min;
    }
}
