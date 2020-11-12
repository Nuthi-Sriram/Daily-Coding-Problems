//909. Snakes and Ladders

//   https://leetcode.com/problems/snakes-and-ladders/




class Solution {
    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0) return 0;
        int n=board.length;
        boolean visited[]=new boolean[n*n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        
        int moves=0;
        int min=n*n;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr == n*n){
                    min=Math.min(min,moves);
                }
                for(int j=1;j<=6;j++){
                    int num=curr+j;
                    if(num>n*n) break;
                    if(!visited[num]){
                        visited[num]=true;
                    
                    int row=n-(num-1)/n-1;
                    int col=(n-row)%2==0?n-(num-1)%n-1:(num-1)%n;
                    if(board[row][col]==-1){
                        q.add(num);
                    }
                    else{
                        q.add(board[row][col]);
                    }
                  }
                }
            }
            moves++;
        }
        return min==n*n?-1:min;
        
    }
}