// Given a positive integer K, you need to find the length of the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.

// Return the length of N. If there is no such N, return -1.

// Note: N may not fit in a 64-bit signed integer.

// https://leetcode.com/problems/smallest-integer-divisible-by-k/
// https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/260852/JavaC%2B%2BPython-O(1)-Space-with-Proves-of-Pigeon-Holes

class Solution {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 || K % 5 == 0 ){
            return -1;
        }
        int r=0;
        for(int i=1;i<=K;i++){
            r=(r*10+1)%K;
            if(r == 0 )return i;
        }
        return -1;
    }
}