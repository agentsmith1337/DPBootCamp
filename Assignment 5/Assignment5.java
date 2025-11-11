import java.util.*;
public class Assignment5 {
    public static void main(String[] args) {
        //Q1: nCr
        System.out.println(nCrRecursive(5, 2));
        System.out.println(nCr(5, 2));
        
        //Q2 Tribonacci
        System.out.println(tribonacci(7));
        System.out.println(tribonacciRecursive(7));

        //Q3 : MIN COST CLIMBING STAIRS
        System.out.println(minCostClimbingStairsRecursive(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        //Q4 Boredom [Both approaches - with and without hashing]
        // Scanner io = new Scanner(System.in);
        // int n = io.nextInt();
        // int[] nums = new int[n];
        // for (int i=0; i<n; i++) {
        //     nums[i]=io.nextInt();
        // }
        int[] nums = new int[] {1 ,2, 3, 2, 2, 2, 2, 1, 3};
        Arrays.sort(nums);       
        Long[] dp = new Long[nums.length];
        System.out.println(count(nums,0, dp));
        //PLEASE ENTER ANY TEST CASE for Hash based function call OR 1 2 3 2 2 2 2 3 1 ; ANS = 10
        boredom();
    }   
    //SOLUTION 1 : nCr [RECURSIVE]
    public static int nCrRecursive(int n, int r) {
        // code here
        return solve(0, 0, n, r);
    }
    static int solve(int i, int j, int n, int r) {
        if (j==r) return 1;
        if (i==n) return 0;
        int count=0;
        count+=solve(i+1, j, n, r);
        count+=solve(i+1, j+1, n, r);
        return count;
    }
    //SOLUTION 1 : nCr [DP]
    public static int nCr(int n, int r) {
        // code here
        Integer[][] dp = new Integer[n][r];
        return solver(0, 0, n, r, dp);
    }
    static int solver(int i, int j, int n, int r, Integer[][] dp) {
        if (j==r) return 1;
        if (i==n) return 0;
        if (dp[i][j]!=null) return dp[i][j];
        int count=0;
        count+=solver(i+1, j, n, r, dp);
        count+=solver(i+1, j+1, n, r, dp);
        return dp[i][j]=count;
    }
    //SOLUTION 2 : TRIBONACCI NUMBERS [RECURSIVE]
    public static int tribonacciRecursive(int n) {
        if (n<=1) return n;
        if (n==2) return 1;
        else return tribonacciRecursive(n-1)+tribonacciRecursive(n-2)+tribonacciRecursive(n-3);
    }
    //SOLUTION 2 : TRIBONACCI NUMBERS [DP]
    public static int tribonacci(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    static int helper(int n, int[] dp) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 1;
        if (dp[n]!=-1) return dp[n];
        return dp[n]=helper(n-1, dp)+helper(n-2, dp)+helper(n-3, dp);
    }
    //SOLUTION 3 : MINIMUM CLIMBING STAIRS [RECURSION]
    public static int minCostClimbingStairsRecursive(int[] cost) {
        
        int a=helperA(cost, 0);
        int b=helperA(cost, 1);
        return Math.min(a,b);
    }
    static int helperA(int[] cost, int i) {
        if (i>=cost.length) return 0;
        if (i==cost.length-1) return cost[i];
        return Math.min(cost[i]+helperA(cost, i+1), cost[i]+helperA(cost, i+2));
    }
    //SOLUTION 3 : MINIMUM CLIMBING STAIRS [MEMOISATION]
    public static int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        int a=helper(cost, 0, dp);
        int b=helper(cost, 1, dp);
        return Math.min(a,b);
    }
    static int helper(int[] cost, int i, Integer[] dp) {
        if (i>=cost.length) return 0;
        if (i==cost.length-1) return cost[i];
        if (dp[i]!=null) return dp[i];
        return dp[i]=Math.min(cost[i]+helper(cost, i+1, dp), cost[i]+helper(cost, i+2, dp));
    }

    //SOLUTION 4: Boredom [O(nlogn), No extra data structure, Hash based after this]   
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
    //QUESTION 4 : BOREDOM - Hash Based 
    static void boredom() {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i]=io.nextInt();
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();   
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (i<nums.length) {
            int count=0, key=nums[i];
            list.add(key);
            while(i<nums.length&&nums[i]==key) {
                i++;
                count++;
            }
            map.put(key, count);
        }    
        Long[] dp = new Long[list.size()];
        System.out.println(count(list, 0, map, dp));
    } 
     static long count(List<Integer> list, int idx, HashMap<Integer, Integer> map, Long[] dp) {
        if (idx>=list.size()) return 0;
        if (idx==list.size()-1) return list.get(idx)*map.get(list.get(idx));
        if (dp[idx]!=null) return dp[idx];
        long score1=0, score2=0;
        int next=(list.get(idx+1)==(list.get(idx)+1))?idx+2:idx+1;
        score1+=list.get(idx)*map.get(list.get(idx))+count(list, next,map, dp);
        score2+=count(list, idx+1, map, dp);
        return dp[idx]=Math.max(score1,score2);
    }
}
