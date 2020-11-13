// Word Boggle

// Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

// https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/







import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    public static void wordsPresent(char boggle[][],HashSet<String> dictionary, int m , int n, ArrayList<String>  list){
        
        for(String word: dictionary){
            boolean flag=false;
            for(int i=0; i< m ;i ++){
                for(int j=0;j<n;j++){
                    if(boggle[i][j] == word.charAt(0) && dfs(word,boggle,m,n,i,j,0)){
                        list.add(word);
                        flag=true;
                        break;
                    }
                    
                }
                if(flag){
                   break;
                }
            }
        }
    }
    
    public static boolean dfs (String word,char boggle[][],int m, int n, int row , int col, int count){
        if(count == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= m || col >= n || word.charAt(count)!=boggle[row][col]){
            return false;
        }
        
        char temp=boggle[row][col];
	     boggle[row][col]= ' ';
	     boolean found= dfs(word,boggle,n,m,row-1,col,count+1) ||
	     dfs(word,boggle,m,n,row+1,col,count+1) ||
	     dfs(word,boggle,m,n,row,col+1,count+1) ||
	     dfs(word,boggle,m,n,row,col-1,count+1) ||
	     dfs(word,boggle,m,n,row+1,col-1,count+1) ||
	     dfs(word,boggle,m,n,row+1,col+1,count+1) ||
	     dfs(word,boggle,m,n,row-1,col-1,count+1) ||
	     dfs(word,boggle,m,n,row-1,col+1,count+1);
	     boggle[row][col]= temp;
	     return found;
                
    }
     
     
     
	public static void main (String[] args) throws IOException {
	 // Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
    		int n=Integer.parseInt(br.readLine());
    		String s=br.readLine();
    		String sa[]=s.split(" ");
    	//	String dictionary [] = new String[n];
    		HashSet <String> dictionary =new HashSet<>();
    		for(int i=0;i<n;i++){
    		    dictionary.add(sa[i]);
    		}
    		s=br.readLine().trim();
    		sa=s.split(" ");
    		int m=Integer.parseInt(sa[0]);
    		n=Integer.parseInt(sa[1]);
    		char boggle[][] = new char[m][n];
    // 		s=br.readLine().trim();
    // 		sa=s.split(" ");
    		String[] cha = new String[m*n];
            cha = br.readLine().split(" ");
            int x = 0;
            // for(int i = 0; i < m; i++){
            // for(int j = 0; j < n; j++){
            // boogle[i][j] = cha[x++].charAt(0);
            // }
            // }
    		for(int i=0;i<(m * n);i++){
    		    int k=i/n; int p=i%n;
    		    boggle[k][p]=cha[x++].charAt(0);;
    		}
    		ArrayList<String> list=new ArrayList<>();
    		wordsPresent(boggle, dictionary, m , n, list);
    		Collections.sort(list);
    		StringBuilder str=new StringBuilder();
    		if(list.size() == 0){
    		    str.append("-1");
    		}
    		else{
    		    for(String word: list){
    		        str.append(word+" ");
    		    }
    		}
    		System.out.println(str.toString().trim());
    		
    		
	    }
    }
}