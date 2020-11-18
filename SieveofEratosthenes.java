// The Sieve of Eratosthenes is an algorithm used to generate all prime numbers smaller than N. The method is to take increasingly larger prime numbers, and mark their multiples as composite.

// For example, to find all primes less than 100, we would first mark [4, 6, 8, ...] (multiples of two), then [6, 9, 12, ...] (multiples of three), and so on. Once we have done this for all primes less than N, the unmarked numbers that remain will be prime.

// Implement this algorithm.

// Bonus: Create a generator that produces primes indefinitely (that is, without taking N as an input).

// https://leetcode.com/problems/count-primes/discuss/57638/on-solution-with-detailed-explanation-of-sieve-of-eratosthenes


// https://leetcode.com/problems/count-primes/

class Solution {
    public int countPrimes(int n) {
        if(n <=2 ){
            return 0;
        }
        int count=n-2;
        boolean divisible[]=new boolean[n];
        
        for(int i=2;i<n;i++){
            if(divisible[i]){
                continue;
            }
            for(int j=i;j<n;j=j+i){
                if(!divisible[j] && j!=i){
                    divisible[j]=true;
                    count--;
                }
            }
        }
        return count;
    }
}