import java.util.*;
public class Assignment1 {
    public static void main(String[] args) {
        //QUESTION 1 : COUNT THE DIGITS OF A DECIMAL NUMBER 
        System.out.println(numberOfDigits(12345));
        System.out.println(numberOfDigits(001));
        System.out.println(numberOfDigits(1010101));
        System.out.println(numberOfDigits(-999));
        
        //Fool proof method for num that can be 0
        System.out.println(countDigits(0));
        System.out.println(countDigits(-340));
        System.out.println(countDigits(39974900));
        System.out.println();

        //QUESTION 2 : FIND THE MAXIMUM ELEMENT IN AN ARRAY USING RECURSION
        System.out.println(maxOfNums(new int[] {4,45,-34,6002}));
        System.out.println(maxOfNums(new int[] {0,-1,-44}));
        System.out.println(maxOfNums(new int[] {-4,-64,-44}));
        System.out.println(maxOfNums(new int[] {-5}));
        System.out.println(maxOfNums(new int[] {0}));
        System.out.println();

        //QUESTION 3 : CHECK IF AN ARRAY IS STRICTLY INCREASING USING RECURSION
        System.out.println(isSorted(new int[] {0,1,2,3,4,5}));
        System.out.println(isSorted(new int[] {1}));
        System.out.println(isSorted(new int[] {0,1,2,3,4,4}));
        System.out.println(isSorted(new int[] {-5,-4,2,3,4,5}));     
        System.out.println();

        //QUESTION 4 : CHECK IF A STRING CONTAINS ONLY DIGITS USING RECURSION
        System.out.println(isNumeric("3408439"));
        System.out.println(isNumeric("9843a"));
        System.out.println(isNumeric("-99")); //Hyphen or Minus is not a digit
        System.out.println(isNumeric("098903"));
        System.out.println(isNumericString("098903",0));
        System.out.println(isNumericString("11g111",0));
        System.out.println(isNumericString("283.9",0));
        System.out.println(isNumericString("a53",0));
        System.out.println();

        //QUESTION 5 : COUNT THE NUMBER OF ZEROES IN DECIMAL NUMBER
        System.out.println(countZeroes(300));
        System.out.println(countZeroes(00));
        System.out.println(countZeroes(30430540));
        System.out.println(countZeroes(90));
        System.out.println(countZeroes(-433002));
        System.out.println();

        //QUESTION 6 : CONVERT A DECIMAL NUMBER TO BINARY USING RECURSION
        System.out.println(convertToBinary(16));
        System.out.println(convertToBinary(10));
        System.out.println(convertToBinary(11));
        System.out.println(convertToBinary(31));
        System.out.println(convertToBinary(0));
        System.out.println(convertToBinary(1));
        System.out.println(convertToBinary(63));
        System.out.println(convertToBinary(112));
        System.out.println(convertToBinary(-113));
        System.out.println();

        System.out.println(convertToBinaryString(16));
        System.out.println(convertToBinaryString(10));
        System.out.println(convertToBinaryString(11));
        System.out.println(convertToBinaryString(31));
        System.out.println(convertToBinaryString(0));
        System.out.println(convertToBinaryString(1));
        System.out.println(convertToBinaryString(63));
        System.out.println(convertToBinaryString(112));
        System.out.println(convertToBinaryString(-113));
        System.out.println();

        //QUESTION 7 : REVERSE OF A NUMBER USING RECURSION
        System.out.println(reverse(33487));
        System.out.println(reverse(3));
        System.out.println(reverse(0));
        System.out.println(reverse(1000));
        System.out.println(reverse(4540033));
        System.out.println(reverse(-40502060));
        System.out.println(reverse(-34534));
        System.out.println();

        //QUESTION 8: REVERSE A LINKED LIST USING RECURSION
        ListNode A = new ListNode(0);
        A.next=new ListNode(1);
        A.next.next=new ListNode (2);
        A.next.next.next=new ListNode (3);
        ListNode B = new ListNode(5);
        ListNode reversedA = reverseList(A);
        ListNode reversedB = reverseList(B);
        ListNode curr=reversedA;
        while (curr!=null) {
            System.out.print("->"+curr.data);
            curr=curr.next;
        }
        System.out.println();
        System.out.println(reversedB.data);
        System.out.println();

        //QUESTION 9 : REVERSE AN ARRAY USING RECURSION 
        int[] arr = new int[] {1,2,3,4,5,6,7,8};
        reverseArray(arr);
        for (int x: arr) {
            System.out.print("->"+x);
        }
        System.out.println();

        //QUESTION 10 : MERGE TWO SORTED LISTS USING RECURSION
        ListNode list1 = listBuilder(new int[] {-1,1,3,5,7,9});
        ListNode list2 = listBuilder(new int[] {-2,0,2,4,6,8,10,50,70});
        ListNode list = mergeList(list1,list2);
        curr=list;
        while (curr!=null) {
            System.out.print("-> "+curr.data);
            curr=curr.next;
        }
        
        //CLASS HW QUESTION : PRINT ALL LUCKY NUMBERS N DIGITS LONG
        printLucky(1);
        System.out.println();
        printLucky(2);
        printLucky(3);
        printLucky(4);
        System.out.println();

        //CLASS HW QUESTION : STEPS TO SOLVE TOWER OF HANOI
        towerOfHanoi(1,'A','B','C');
        System.out.println();
        towerOfHanoi(2,'A','B','C');
        System.out.println();
        towerOfHanoi(3,'A','B','C'); 
        System.out.println();
        // towerOfHanoi(4,'A','B','C');
    }   
    //SOLUTION 1 REGION STARTS 
    static int countDigits(int num) {
        if (num==0) return 1;
        else if (num<0) return countDigits(-num);
        else return numberOfDigits(num);
    }
    static int numberOfDigits(int num) {
        if (num==0) return 0;
        else return 1+numberOfDigits(num/10);
    }
    //TIME COMPLEXITY : \Theta (log{10}{n}) ; SPACE COMPLEXITY : \Theta (log{10}{n})

    //SOLUTION 1 REGION ENDS
    //SOLUTION 2 REGION STARTS
    static int maxOfNums(int[] nums) {
        return maxHelper(nums, 0);
    }
    static int maxHelper(int[] nums, int i) {
        if (i==nums.length) return nums[i-1];
        return Math.max(maxHelper(nums, i+1),nums[i]); 
    }
    //TIME COMPLEXITY : \Theta {n} ; SPACE COMPLEXITY : \Theta {n} 
    //SOLUTION 2 REGION ENDS 

    //SOLUTION 3 REGION STARTS
    static boolean isSorted(int[] nums) {
        return isSortedHelper(nums, 0);
    }
    static boolean isSortedHelper(int[] nums, int i) {
        if (i==nums.length-1) return true; 
        return nums[i]<nums[i+1]&&isSortedHelper(nums, i+1);
    }
    //TIME COMPLEXITY : O(n); SPACE COMPLEXITY: O(n);
    //SOLUTION 3 REGION ENDS 

    //SOLUTION 4 REGION STARTS 
    static boolean isNumeric(String str) {
        if (str.equals("")) return true;
        else return Character.isDigit(str.charAt(0))&&isNumeric(str.substring(1));
    }
    //TIME COMPLEXITY: O(k) ; SPACE COMPLEXITY:  O(k^2) [n+n-1+n-2+...+1 due to String slicing]
    //k represents number of digits in input n
    static boolean isNumericString(String str, int i) {
        if (i==str.length()) return true;
        return Character.isDigit(str.charAt(i))&&isNumericString(str, i+1);
    }
    //TIME COMPLEXITY : O(k) ; SPACE COMPLEXITY : O(k)
    //SOLUTION 4 REGION ENDS 

    //SOLUTION 5 REGION STARTS
    static int countZeroes(int num) {
        if (num==0) return 1;
        else if (num<0) return countZeroesHelper(-num);
        else return countZeroesHelper(num);
    } 
    static int countZeroesHelper(int num) {
        if (num==0) return 0;
        else return (num%10==0)?1+countZeroesHelper(num/10):countZeroesHelper(num/10);
    }
    //TIME COMPLEXITY : \Theta (k) ; SPACE COMPLEXITY : \Theta (k)
    //SOLUTION 5 REGION ENDS 

    //SOLUTION 6 REGION STARTS
    //Converting to int representation of binary  
    static int convertToBinary(int num) {
        if (num<0) return -convertToBinary(-num);
        if (num==1) return 1;
        else if (num==0) return 0;
        return 10*convertToBinary(num>>1)+(num&1);
    }
    //TIME COMPLEXITY : \Theta (log{2}n) ; SPACE COMPLEXITY \Theta (log{2}n)
    //Converting to String representation of binary
    static String convertToBinaryString(int num) {
        if (num==0) return "0";
        else if (num<0) return "-"+convertToBinaryString(-num);
        else return convertToBinaryStringHelper(num);
    }
    static String convertToBinaryStringHelper(int num) {
        if (num==0) return "";
        return convertToBinaryStringHelper(num/2)+Integer.toString((num%2));
    }
    //Time Complexity : \Theta (log{2}n) ; Space Complexity : \Theta (log{2}n); 
    //SOLUTION 6 REGION ENDS 

    //SOLUTION 7 REGION STARTS
    static int reverse(int num) {
        if (num<0) return -reverseHelp(-num,0);
        else return reverseHelp(num,0);
    }
    static int reverseHelp(int num, int ans) {
        if (num==0) return ans;
        ans*=10;
        ans+=num%10;
        return reverseHelp(num/10, ans);
    }
    //Time Complexity : \Theta (k) ; Space Complexity : \Theta (k)
    //SOLUTION 7 REGION ENDS 

    //SOLUTION 8 REGION STARTS
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data=data;
            this.next=null;
        }
        ListNode(int data, ListNode next) {
            this.data=data;
            this.next=next;
        }
    }
    static ListNode reverseList(ListNode head) {
        return reverseListHelper(null,head);
    }
    static ListNode reverseListHelper(ListNode next, ListNode head) {
        if (head==null) return next; 
        ListNode temp = head.next;
        head.next=next;
        return reverseListHelper (head, temp);
    }
    //TIME COMPLEXITY : \Theta (n); SPACE COMPLEXITY : \Theta (n)
    //SOLUTION 9 REGION ENDS
    static void reverseArray(int[] nums) {
        if (nums!=null)
        reverseArrayHelper(nums,0, nums.length-1);
    }
    static void reverseArrayHelper(int[] nums,int i, int j) {
        if (i>=j) return;
        int copy = nums[i];
        nums[i]=nums[j];
        nums[j]=copy;
        reverseArrayHelper(nums, i+1, j-1);
    }
    //TIME COMPLEXITY : \Theta (n) ; SPACE COMPLEXITY : \Theta (n) [Without TCO]
    //QUESTION 9 REGION ENDS

    //QUESTION 10 REGION STARTS
    //List definition same as above
    static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, null);
        merge(dummy, l1, l2);
        return dummy.next;
    }
    static void merge(ListNode curr, ListNode l1, ListNode l2) {
        if (l1==null) {
            curr.next=l2;
            return;
        }
        if (l2==null) {
            curr.next=l1;
            return;
        }
        if (l1.data>l2.data) {
            curr.next=l2;
            merge(curr.next, l1, l2.next);
        } else {
            curr.next=l1;
            merge(curr.next, l1.next, l2);
        }
    }
    static ListNode listBuilder(int[] nums) {
        ListNode dummy=new ListNode(0,null);
        ListNode curr=dummy;
        for (int x: nums) {
            curr.next=new ListNode(x);
            curr=curr.next;
        }
        return dummy.next;
    }
    //QUESTION 10 REGION ENDS 

    //CLASS HW QUESTION PRINT LUCKY NUMBERS STARTS
    static void printLucky(int n) {
        List<String> set = new ArrayList<>();
        printLuckyHelper("", set, n);
        for (String x : set) {
            System.out.print(x+" ");
        }
        System.out.println();
    } 
    static void printLuckyHelper(String num, List<String> set, int n) {
        if (n==0) return;
        set.add(num+"7");
        set.add(num+"8");
        printLuckyHelper(num+"7",set,n-1);
        printLuckyHelper(num+"8",set,n-1);
    }
    //TIME COMPLEXITY: \Theta (2^{n+1}); Space Complexity: \Theta (2^{n+1});
    //LUCKY NUMBER REGION ENDS 

    //CLASS HW QUESTION : TOWER OF HANOI REGION STARTS 
    //Towers are numbered 1 to n top to bottom
    static void towerOfHanoi(int n, char source, char auxilliary, char destination) {
        if (n==1) {
            //For the smallest disk, move it directly to destination
            System.out.println("Move "+n+" from "+source+" to "+ destination);
        }
        else {
            //Move n-1 disks from Source to Auxilliary 
            towerOfHanoi(n-1, source, destination, auxilliary);
            //Move the nth disk from Source to destination
            System.out.println("Move "+n+" from "+source+" to "+ destination);
            //Now move the n-1 disks from Auxilliary to Destination using Source 
            towerOfHanoi(n-1, auxilliary, source, destination);
        }
    }
    //TOWER OF HANOI REGION ENDS 
    //TIME COMPLEXITY : \Theta (2^{n}-1) ; Space Complexity : \Theta (2^{n}-1);
}
