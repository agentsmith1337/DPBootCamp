
public class Question2 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] {1,1,1,1}, 3));
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
}
