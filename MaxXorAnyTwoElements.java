// Given an array of integers, find the maximum XOR of any two elements.
// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap
class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask=0;
        int maxResult=0;
        /*The maxResult is a record of the largest XOR we got so far. if it's 11100 at i = 2, it means 
        before we reach the last two bits, 11100 is the biggest XOR we have, and we're going to explore
        whether we can get another two '1's and put them into maxResult
        
        This is a greedy part, since we're looking for the largest XOR, we start 
        from the very begining, aka, the 31st postition of bits. */
        for(int i=31;i>=0;i--){
               //The mask will grow like  100..000 , 110..000, 111..000,  then 1111...111
            //for each iteration, we only care about the left parts
            mask=mask | (1<<i);
            Set<Integer> set=new HashSet<>();
            for(int num: nums){
                /*                we only care about the left parts, for example, if i = 2, then we have
                {1100, 1000, 0100, 0000} from {1110, 1011, 0111, 0010}*/
                int leftPartNum=num & mask;
                set.add(leftPartNum);
            }
            // if i = 1 and before this iteration, the maxResult we have now is 1100, 
            // my wish is the maxResult will grow to 1110, so I will try to find a candidate
            // which can give me the greedyTry;
            int greedyTry=maxResult | (1<<i);
            for(int leftPartNum : set){
                 //This is the most tricky part, coming from a fact that if a ^ b = c, then a ^ c = b;
                // now we have the 'c', which is greedyTry, and we have the 'a', which is leftPartOfNum
                // If we hope the formula a ^ b = c to be valid, then we need the b, 
                // and to get b, we need a ^ c, if a ^ c exisited in our set, then we're good to go
                int anotherNum=leftPartNum^greedyTry;
                if(set.contains(anotherNum)){
                    maxResult=greedyTry;
                    break;
                }
            }
            // If unfortunately, we didn't get the greedyTry, we still have our max, 
            // So after this iteration, the max will stay at 1100.
        }
        return maxResult;
    }
}