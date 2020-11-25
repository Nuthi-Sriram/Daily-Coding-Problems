// https://www.geeksforgeeks.org/transitive-closure-of-a-graph/
// https://practice.geeksforgeeks.org/problems/transitive-closure-of-a-graph/0

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    while(t!=0)
	    {
	        t--;
	        int V=Integer.parseInt(br.readLine().trim());
	        int graph[][]=new int[V][V];
	        String data[]=br.readLine().trim().split(" ");
	        int k=0;
	        for(int i=0;i<V;i++){
	            for(int j=0;j<V;j++){
	            graph[i][j]=Integer.parseInt(data[k++]);
	          //  System.out.print(graph[i][j]+" ");
	           }
	        }
	    //    System.out.println();
	        GFG obj=new GFG();
	        obj.findDist(graph,V);
	        
	    
	     }
	 }
	 
	 public void findDist(int[][] graph,int V){
	     
	    for(int k=0;k<V;k++)
	        for(int i=0;i<V;i++)
	            for(int j=0;j<V;j++){
	                graph[i][j]=(graph[i][j]!=0) || ((graph[i][k]!=0) && (graph[k][j]!=0))?1:0;
	            }
	    printDist(graph);
	 }
	 
	 public void printDist(int[][] dist){
	     int n=dist.length;
	     StringBuffer br= new StringBuffer();
	     for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(i == j){
	                br.append("1 ");
	            }
	            else{
	                br.append(dist[i][j]+" ");    
	            }
	            
	            
	        }
	     }
	     System.out.println(br.toString().trim());
	 }
}