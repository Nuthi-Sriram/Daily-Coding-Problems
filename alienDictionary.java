// You come across a dictionary of sorted words in a language you've never seen before. Write a program that returns the correct order of letters in this language.

// For example, given ['xww', 'wxyz', 'wxyw', 'ywx', 'ywz'], you should return ['x', 'z', 'w', 'y'].

// https://practice.geeksforgeeks.org/problems/alien-dictionary/1#

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution T = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = T.findOrder(words,n,k);
		    
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

/*
dict : array of strings denoting the words in alien langauge
N : Size of the dictionary
K : Number of characters
*/
class Solution
{
    List<ArrayList<Integer>> adj;
    class Graph{
        int V;
        
        
        Graph(int v){
            V=v;
            adj=new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<Integer>());
            }
        }
        void addEdge(int v,int w){
            adj.get(v).add(w);
        }
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        Graph g=new Graph(K);
        
        for(int i=0;i<dict.length - 1; i++){
            String word1=dict[i];
            String word2=dict[i+1];
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                
                if(word1.charAt(j) != word2.charAt(j)){
                   g.addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a');
                   break;
                }
            }
        }
        return topoSort(adj,K);
    }
    
    String topoSort(List<ArrayList<Integer>> adj, int N) {
        Stack<Integer> st=new Stack<>();
        boolean visited[]=new boolean[N];
        
        for(int i=0;i<N;i++){
            if(!visited[i]){
                topoSortUtility(i,visited,adj,st);
            }
        }
        int arr[]=new int[N];
        int j=0;
        while(!st.isEmpty()){
            arr[j]=st.pop();
            j++;
        }
        StringBuilder br=new StringBuilder();
        for(int i : arr){
            br.append((char)(arr[i]+'a'));
        }
        return br.toString();
    }
    
    void topoSortUtility(int v,boolean []visited, List<ArrayList<Integer>> adj, Stack st){
        visited[v]=true;
        Integer i;
        Iterator<Integer> it=adj.get(v).iterator();
        while(it.hasNext()){
            i=it.next();
            if(!visited[i]){
                topoSortUtility(i,visited,adj,st);
            }
        }
        
        st.push(new Integer(v));
    }
}