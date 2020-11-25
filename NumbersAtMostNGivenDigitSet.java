// Given an array of digits, you can write numbers using each digits[i] as many times as we want.  For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.

// Return the number of positive integers that can be generated that are less than or equal to a given integer n.

 

// Example 1:

// Input: digits = ["1","3","5","7"], n = 100
// Output: 20
// Explanation: 
// The 20 numbers that can be written are:
// 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.

// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/

// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/discuss/168313/Java-Solution-with-explanation

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int result=0;
        for(int i=1;i<=Integer.toString(n).length();i++){
            result+=helper(digits,i,Integer.toString(n));
        }
        return result;
    }
    public int helper(String [] D,int k, String smax){
        if(smax.equals("0")){
            return 0;
        }
        if(smax.length() > k){
            return (int)Math.pow(D.length,k);
        }
        int count=0;
        for(int i=0;i<D.length;i++){
            //int char0=Integer.parseInt(smax.charAt(0));
            int char0=smax.charAt(0)-'0';
            if(Integer.parseInt(D[i]) < char0){
                count+=helper(D,k-1,smax);
            }
            if(Integer.parseInt(D[i]) == char0){
                if(smax.length() > 1){
                    int charRem=Integer.parseInt(smax.substring(1,2)) == 0? 0: Integer.parseInt(smax.substring(1));
                    count+=helper(D,k-1,Integer.toString(charRem));
                }
                else{
                    count++;
                }
            }            
            
        }
     return count;   
    }
}