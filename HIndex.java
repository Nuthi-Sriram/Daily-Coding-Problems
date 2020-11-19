// A researcher has index h if at least h of her N papers have h citations each. If there are multiple h satisfying this formula, the maximum is chosen.

// For example, suppose N = 5, and the respective citations of each paper are [4, 3, 0, 1, 5]. Then the h-index would be 3, since the researcher has 3 papers with at least 3 citations.

// https://leetcode.com/problems/h-index/

// https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation

class Solution {
    public int hIndex(int[] citations) {
         int n=citations.length;
        int [] bucket=new int[n+1];
        for(int c:citations){
            if(c>=n){
                bucket[n]++;
            }
            else{
                bucket[c]++;
            }
        }
        int count=0;
        for(int i=n;i>=0;i--){
            count+=bucket[i];
            if(count>=i){
                return i;
            }
        }
        return 0;
    }
}