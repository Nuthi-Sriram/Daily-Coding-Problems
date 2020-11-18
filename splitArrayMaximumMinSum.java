// Given an array of numbers N and an integer k, your task is to split N into k partitions such that the maximum sum of any partition is minimized. Return this sum.

// For example, given N = [5, 1, 2, 7, 3, 4] and k = 3, you should return 8, since the optimal partition is [5, 1, 2], [7], [3, 4].


// https://leetcode.com/problems/split-array-largest-sum/
// https://leetcode.com/problems/split-array-largest-sum/submissions/
// https://www.youtube.com/watch?v=8_FivWxrSK0


class Solution {
    public int splitArray(int[] nums, int m) {
        int n=nums.length;
        int sum=0,max=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        int lo=max;
        int hi=sum;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            int pieces=split(nums,mid);
            if(pieces > m){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    }
    
    public int split(int [] nums, int largestSum){
        int tempSum=0;
        int pieces=1;
        for(int num : nums){
            if(tempSum+num > largestSum){
                tempSum=num;
                pieces++;
            }
            else{
                tempSum+=num;
            }
        }
        return pieces;
    }
}