// You are given an array of integers, where each element represents the maximum number of steps that can be jumped going forward from that element. Write a function to return the minimum number of jumps you must take in order to get from the start to the end of the array.

// For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], you should return 2, as the optimal solution involves jumping from 6 to 5, and then from 5 to 9.
// https://leetcode.com/problems/jump-game-ii/
// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

class Solution {
    public int jump(int[] arr) {
       int n=arr.length;
       int jumps[]=new int[n];
       
       for(int i=1;i<n;i++){
           jumps[i]=Integer.MAX_VALUE;
           for(int j=0;j<i;j++){
               
               if(i<=j+arr[j] && jumps[j] != Integer.MAX_VALUE){
                   jumps[i]=Math.min(jumps[i],jumps[j]+1);
                   break;
               }
           }
       }
       return jumps[n-1];
    }
}