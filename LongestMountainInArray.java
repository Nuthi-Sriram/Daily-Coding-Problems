// Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

// B.length >= 3
// There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
// (Note that B could be any subarray of A, including the entire array A.)

// Given an array A of integers, return the length of the longest mountain. 

// Return 0 if there is no mountain.

// https://leetcode.com/problems/longest-mountain-in-array/

class Solution {
    public int longestMountain(int[] A) {
        int res=0;
        int N=A.length;
        int []up=new int[N], down=new int[N];
        for(int i=N-2;i>=0;i--){
            if(A[i]>A[i+1]){
                down[i]=down[i+1]+1;
            }
        }
        for(int i=0;i<N;i++){
            if(i>0 && A[i]>A[i-1]){
                up[i]=up[i-1]+1;
            }
            
            if(up[i]>0 && down[i]>0){
                res=Math.max(res,up[i]+down[i]+1);
            }
        }
        return res;
    }
}