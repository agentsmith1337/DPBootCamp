import java.util.*;
public class Boredom2 {
    public static void main(String[] args) {
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
        if (idx==list.size()-1) return (long)list.get(idx)*(long)map.get(list.get(idx));
        if (dp[idx]!=null) return dp[idx];
        long score1=0, score2=0;
        int next=(list.get(idx+1)==(list.get(idx)+1))?idx+2:idx+1;
        score1+=(long)list.get(idx)*(long)map.get(list.get(idx))+count(list, next,map, dp);
        score2+=count(list, idx+1, map, dp);
        return dp[idx]=Math.max(score1,score2);
    }

}
