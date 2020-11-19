// https://leetcode.com/problems/merge-intervals/

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        
        Arrays.sort(intervals, (i0,i1)->Integer.compare(i0[0],i1[0]));
        
        List<int []>result=new ArrayList<>();
        int []newInterval=intervals[0];
        result.add(newInterval);
        for(int []interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(interval[1],newInterval[1]);
            }
            else{
                newInterval=interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}