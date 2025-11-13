
public class Question1 {
    public static void main(String[] args) {
        System.out.println(perfectSumRecursive(new int[] {3,4,2,5,7,3,2,6,8,2}, 9));
        System.out.println(perfectSumRecursive(new int[] {5,2,3,10,6,8}, 10));

        System.out.println(perfectSumMemoisation(new int[] {3,4,2,5,7,3,2,6,8,2}, 9));
        System.out.println(perfectSumMemoisation(new int[] {5,2,3,10,6,8}, 10));

        System.out.println(perfectSumTabulation(new int[] {3,4,2,5,7,3,2,6,8,2}, 9));
        System.out.println(perfectSumTabulation(new int[] {5,2,3,10,6,8}, 10));
    }   
    //RECURSIVE SOLUTION 
    static int perfectSumRecursive(int[] nums, int target) {
        // code here
        return helperRecursive(nums, 0, target);
    }
    static int helperRecursive(int[] nums, int idx, int target) {
        if (idx==nums.length&&target==0) return 1;
        if (idx==nums.length) return 0;
        int count=0; 
        if (nums[idx]<=target)
            count+=helperRecursive(nums, idx+1, target-nums[idx]);
        count+=helperRecursive(nums, idx+1, target);
        return count;
    }
    //DYNAMIC PROGRAMMING : 2D MEMOIZATION 
    public static int perfectSumMemoisation(int[] nums, int target) {
        // code here
        Integer dp[][] = new Integer[nums.length+1][target+1];
        return helperMemoisation(nums, 0, target, dp);
    }
    static int helperMemoisation(int[] nums, int idx, int target, Integer[][] dp) {
        if (idx==nums.length&&target==0) return 1;
        if (idx==nums.length) return 0;
        if (dp[idx][target]!=null) return dp[idx][target];
        int count=0; 
        if (nums[idx]<=target)
            count+=helperMemoisation(nums, idx+1, target-nums[idx], dp);
        count+=helperMemoisation(nums, idx+1, target, dp);
        return dp[idx][target]=count;
    }
    //DYNAMIC PROGRAMMING : 2D TABULATION
    /* NOTES ON THIS CONVERSION : 
    *   The memoised version could be written as starting from index n going down to 0,
    *   As well this exact version could be tabulated as calculating from right to left instead of left to right
    *   The first base case provides us dp[0][0]=1
    *   The second base case provides us dp[0][i]=0 
    *   Recursion/Memoisation has been computing with this only along the way - with the recurrence
    *   For the case of zeroes - the recurrence simply reduces to 2*dp[i-1][j] which is appropriate.
    */  
    static int perfectSumTabulation(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length+1][target+1];

        dp[0][0]=1; 
         
         for (int i=1; i<=nums.length; i++) {
             for (int j=0; j<=target; j++) {
                 if (nums[i-1]<=j) dp[i][j]=dp[i-1][j-nums[i-1]];
                 dp[i][j]+=dp[i-1][j];
             }
         }
         
         return dp[nums.length][target];
    }
}
