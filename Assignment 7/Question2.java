
public class Question2 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] {1,1,1,1}, 3));

        System.out.println(findTargetSumWaysMemoized(new int[] {1,1,1,1}, 3));
    }
    static int findTargetSumWays(int[] nums, int target) {
        return helperRecursive(nums, nums.length-1, target);
    }
    static int helperRecursive(int[] nums, int n, int target) {
        if (n<0&&target==0) return 1;
        if (n<0) return 0;
        int count=0;
        count+=helperRecursive(nums, n-1, target+nums[n]);
        count+=helperRecursive(nums, n-1, target-nums[n]);
        return count;
    }
    static int findTargetSumWaysMemoized(int[] nums, int target) {
        int sum=0;
        for (int x: nums) {
            sum+=x;
        }
        if (Math.abs(target)>sum) return 0;
        Integer[][] dp = new Integer[nums.length+1][sum*2+1];
        return helperMemoized(nums, nums.length-1, target, dp, sum);
    }
    static int helperMemoized(int[] nums, int n, int target, Integer[][] dp, int offset) {
        if (n<0&&target==0) return 1;
        if (n<0||Math.abs(target)>offset) return 0;
        if (dp[n][target+offset]!=null) return dp[n][target+offset];
        int count=0;
        count+=helperMemoized(nums, n-1, target+nums[n], dp, offset);
        count+=helperMemoized(nums, n-1, target-nums[n], dp, offset);
        return dp[n][target+offset]=count;
    }
}