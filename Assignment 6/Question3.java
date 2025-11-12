
public class Question3 {
    public static void main(String[] args) {
        System.out.println(minimumDistance("HELLOWORLD"));
        System.out.println(minimumDistance("HAPPY"));
    }
    public static int minimumDistance(String word) {
    Integer[][][] dp = new Integer[word.length()][26][26]; 
    return helper(word, 0, null, null, dp);        
    }
    static int helper(String word, int idx, Character L, Character R, Integer[][][] dp) {
        if (idx==word.length()) return 0;
        if (L!=null&R!=null&&dp[idx][L-'A'][R-'A']!=null)
            return dp[idx][L-'A'][R-'A'];
        int distL=0, distR=0;
        if (L!=null) {
            distL=distance(word.charAt(idx),L);
        }
        if (R!=null) {
            distR=distance(word.charAt(idx),R);
        }
        
        int val=Math.min(distL+helper(word, idx+1, word.charAt(idx), R, dp), distR+helper(word, idx+1, L, word.charAt(idx), dp));
        if (L!=null&R!=null) dp[idx][L-'A'][R-'A']=val;
        return val;
    }
    static int distance(char A, char B) {
        int i = (int) (A-'A')%6;
        int j = (int) (A-'A')/6;    
        int a = (int) (B-'A')%6;
        int b = (int) (B-'A')/6;
        return Math.abs(i-a)+Math.abs(j-b);
    }
} 