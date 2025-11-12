
import java.util.*;
public class Boredom {
    //Lesser memory due to no hashmap, O(n) traversal and space 
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i]=io.nextInt();
        }
        Arrays.sort(nums);       
        Long[] dp = new Long[nums.length];
        System.out.println(count(nums,0, dp)); 
    }   
    static long count(int[] nums, int i, Long[] dp) {
        if (i>=nums.length) return 0;
        if (dp[i]!=null) return dp[i];
        return dp[i]=Math.max(sum(nums,i)+count(nums,nextIndex(nums, i),dp),count(nums,PostIndex(nums, i), dp)); 
    }
    static int nextIndex(int[] nums, int idx) {
        if (idx<nums.length) {
            int val = nums[idx];
            while (idx<nums.length&&(nums[idx]==val||nums[idx]==val+1)) idx++;
            return idx;
        }
        return nums.length;
    }
    static int PostIndex(int[] nums, int idx) {
        if (idx<nums.length) {
            int val = nums[idx];
            while (idx<nums.length&&(nums[idx]==val)) idx++;
            return idx;
        }
        return nums.length;
    }
    static long sum(int[] nums, int idx) {
        int var=nums[idx];
        long sum=0;
        int i=idx;
        while (i<nums.length&&nums[i]==var) {
            sum+=nums[i++];
        }
        return sum;
    } 
}
