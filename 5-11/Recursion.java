import java.util.*;
public class Recursion {
    public static void main(String[] args) {
        int[] arr = new int[] {6,-4,1,6,3,7,3};
        sort(arr, 1, arr.length-1);
        for (int x: arr) {
            System.out.print(x+" ");
        }
        System.out.println();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(5);
        s.push(0);
        s.push(3);
        s.push(2);
        s.push(7);
        s.push(9);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
        //Sort ArrayList - save the element and call insert again
        //Sort Stack the same way 
        subsequences("abc", "", 0);
    }   
    static void sort(int[] nums, int i, int n) {
        if (i>n) return;
        insert(nums,i);
        sort(nums,i+1,nums.length-1);
    } 
    static void insert(int[] nums, int i) {
        if (i<1||nums[i]>nums[i-1]) return;
        else {
            //instead can save the top element and call with smaller index to compare - will require ArrayList
            int save=nums[i];
            nums[i]=nums[i-1];
            nums[i-1]=save;
            insert(nums, i-1);
        }
    }
    static void reverseStack(Stack<Integer> s) {
        if (s.empty()) return;
        int a = s.pop();
        reverseStack(s);
        rev(s, a);
    }
    static void rev(Stack<Integer> s, int a) {
        if (s.empty())  {
            s.push(a);
            return;
        }
        int b = s.pop();
        rev(s, a);
        s.push(b);
    }
    static void subsequences(String str, String result, int i) {
        if (i==str.length()) {
            System.out.println(result);
            return;
        }
        subsequences(str, result, i+1);
        subsequences(str, result+str.charAt(i), i+1);
        
    }
    
}
