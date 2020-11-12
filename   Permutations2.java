//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

// https://leetcode.com/problems/permutations-ii/






class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();    
        if(nums.length == 0 || nums == null) return res;
        List<Integer> list=new ArrayList<>();
        boolean used[]=new boolean[nums.length];//Sort the array "int[] nums" to make sure we can skip the same value.
        Arrays.sort(nums); //Important to sort the list to make sure you don't reused the duplicate values and recreate the                                 //looking permuatation string
        dfs(nums,used,list,res);
        return res;
    }
    
    public void dfs(int [] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if(i > 0 && nums[i]==nums[i-1] && !used[i-1]) continue; //when a number has the same value with its previous, we                                                                      //can use this number only if his previous is used
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}