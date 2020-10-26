// We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup (250ml) of champagne.

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double res[]=new double[query_row+2];
        res[0]=poured;
        for(int row=1;row<=query_row;row++){
            for(int i=row;i>=0;i--){
                res[i+1]+=res[i]=Math.max(0.0,(res[i]-1)/2);
            }
        }
        return Math.min(res[query_glass],1.0);
    }
}


// https://leetcode.com/problems/champagne-tower/