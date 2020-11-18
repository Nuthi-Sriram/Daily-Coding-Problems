// Given a sorted array of N positive integers, find the smallest positive 
// integer S such that S cannot be represented as sum of elements of any subset
//  of the given array set.
// https://practice.geeksforgeeks.org/problems/smallest-number-subset1220/1


class Solution {
    long findSmallest(long[] arr, int n) {
        // code here
        long res=1;
        for(int i=0;i<n && arr[i]<=res;i++){
            res+=arr[i];
        }
        
        return res;
    }
}
