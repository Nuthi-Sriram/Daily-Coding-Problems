//https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall/0

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
	        int V=Integer.parseInt(br.readLine());
	        int graph[][]=new int[V][V];
	        for(int i=0;i<V;i++){
	        String data[]=br.readLine().trim().split(" ");
	        
	        for(int j=0;j<V;j++)
	        {
	            graph[i][j]=Integer.parseInt(data[j]);
	        }
	        }
	        GFG obj=new GFG();
	        obj.findDist(graph,V);
	        
	    
	     }
	 }
	 
	 public void findDist(int[][] graph,int V){
	     int[][] dist=new int[V][V];
	     int INF= 10000000;
	     for(int i=0;i<V;i++)
	        for(int j=0;j<V;j++)
	            if(graph[i][j]>INF)
	                dist[i][j]=INF;
	            else
	                dist[i][j]=graph[i][j];
	    
	    for(int k=0;k<V;k++)
	        for(int i=0;i<V;i++)
	            for(int j=0;j<V;j++){
	                if(dist[i][k]==INF||dist[k][j]==INF)
	                    continue;
	                if(dist[i][j]>dist[i][k]+dist[k][j])
	                    dist[i][j]=dist[i][k]+dist[k][j];
	                
	            }
	    printDist(dist);
	 }
	 
	 public void printDist(int[][] dist){
	     int n=dist.length;
	     int INF=10000000;
	     StringBuffer br= new StringBuffer();
	     for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(dist[i][j]==INF)
	                br.append("INF ");
	           else
	            br.append(dist[i][j]+" ");
	            
	        }
	        br.append("\n");
	         
	     }
	     System.out.println(br.toString().trim());
	 }
}