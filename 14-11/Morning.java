public class Morning {
    public static void main(String[] args) {
        System.out.println(printLCS("BELIEVEE","EEVEILEB",0,0));
        System.out.println(printLCST("BELIVEE","EEVILEB"));
    }
    static String printLCS(String s1, String s2, int i, int j) {
        if (i>s1.length()-1||j>s2.length()-1) return "";
        if (s1.charAt(i)==s2.charAt(j)) return s1.charAt(i)+printLCS(s1,s2,i+1,j+1);
        else {
            String ans1=printLCS(s1, s2, i+1, j);
            String ans2=printLCS(s1, s2, i, j+1);
            if (ans1.length()>ans2.length()) return ans1;
            else return ans2;
        }
    }
    static String printLCST(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
            String ans="";
            for (int i=1; i<s1.length(); i++) {
                for (int j=1; j<s2.length(); j++) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    if (s1.charAt(i)==s2.charAt(j)) {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    if (dp[i][j-1]==dp[i][j]) ans+=s1.charAt(i);
                }

            }
            return ans;
    }

}