import java.util.*;
import java.lang.StringBuilder;
public class Morning {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        binaryStrings("", 0, 4, ans);
        System.out.println(ans);

        ans.clear();
        adjacentBinaryStrings(new StringBuilder("0000"), 0, 4, ans);
        System.out.println(ans);

        ans.clear();
        permutationsOfAString(new StringBuilder("ABCD"), 0, ans);
        System.out.println(ans);
        System.out.println(canReach(new int[][] {{0,0,1},{1,1,0},{0,0,0}},0,0));
        ArrayList<String> maze = ratInMaze(new int[][] {{0,0,1},{0,1,0},{0,0,0}});
        System.out.println(maze);
    }
    static void binaryStrings(String num, int i, int n, List<String> ans) {
        if (i==n) {
            ans.add(num);
            return;
        }
        binaryStrings(num+"0", i+1, n, ans);
        binaryStrings(num+"1", i+1, n, ans);
    } 
    static void adjacentBinaryStrings(StringBuilder num, int i, int n, List<String> ans) {
        if (i==n) {
            ans.add(num.toString());
            return;
        }
        adjacentBinaryStrings(num, i+1, n, ans);
        if (i==0||num.charAt(i-1)!='1') {
            StringBuilder mod = new StringBuilder(num);
            adjacentBinaryStrings(mod.replace(i,i+1,"1"), i+1, n, ans);
        }
    }
        static void permutationsOfAString(StringBuilder sb, int i, List<String> ans) {
            //Base Case : If the 
            if (i==sb.length()) {
                ans.add(sb.toString());
                return;
            }

            //Recursive Case
            for (int j=i; j<sb.length(); j++) {
                //Make a copy of current sb/string
                StringBuilder modsb = new StringBuilder(sb);
                //Prepare for swap
                char c1 = modsb.charAt(i);
                char c2 = modsb.charAt(j);
                //Swap ith and jth characters
                modsb.setCharAt(i, c2);
                modsb.setCharAt(j, c1);
                //Now focus on characters starting i+1
                permutationsOfAString(modsb, i+1, ans);
            }
        }

        static boolean canReach(int[][] nums, int i, int j) {
            if (i==nums.length-1&&j==nums[0].length-1) {
                return true;
            }
            if (i>=nums.length || j>= nums[0].length) return false;
            if (nums[i][j]==1) return false; 
            return canReach(nums, i+1,j) || canReach(nums, i, j+1);
        }
    static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        canReachMaze(maze, "", 0,0, ans);
        return ans; 
    }
    static void canReachMaze(int[][] maze, String path, int i, int j, ArrayList<String> ans) {
        if (i<0 || j<0 || i>=maze.length || j>=maze[0].length) return;
        if (i==maze.length-1 && j==maze[0].length-1) {
            ans.add(path);
            return;
        }
        if (maze[i][j]==0||maze[i][j]==-1) return;
        maze[i][j]=-1;
        canReachMaze(maze, path+"D",i+1, j, ans);
        canReachMaze(maze, path+"L", i, j-1, ans); 
        canReachMaze(maze, path+"R",i, j+1, ans);
        canReachMaze(maze, path+"U", i-1, j, ans);
        maze[i][j]=1;
    }

}
