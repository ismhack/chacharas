package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class GraphShortestPath {
    static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        }
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+this.source+" "+this.destination+"]-"+this.weight;
		}
		@Override
		public boolean equals(Object obj) {
			Edge o= (Edge)obj;
			if(this.source == o.source && this.destination == o.destination)
				
				return true;
			else
				return false;
		}
		

    }
    
    static class Pair<F, S> {
    public F first;
    public S second;
    
        Pair(F first, S second){
            this.first=first;
            this.second=second;
        }
		@Override
		public boolean equals(Object obj) {
			Pair o= (Pair)obj;
			if(this.first == o.first && this.second == o.second)
				
				return true;
			else
				return false;
		}
    }
    
    static class Graph{
    private int V;   // No. of vertices 
    private int totalW= -1;
    public Map<Integer,ArrayList<Edge>> vertex; 
    public static int INF =99999999;
    Vector<Edge> edge;
    
    Graph(int v) 
    { 
        V = v; 
        vertex = new HashMap<Integer, ArrayList<Edge>>(); 
        edge = new Vector<>();
        for (int i=0; i<v; ++i){ 
            vertex.put(Integer.valueOf(i+1),new ArrayList());
        }
    } 
  
    void addEdge(int v, int d,int w) 
    { 
        vertex.get(Integer.valueOf(v)).add(new Edge(v,d,w));  // Add w to v's list. 
        vertex.get(Integer.valueOf(d)).add(new Edge(d,v,w)); 
        
        Edge e= new Edge(v, d, w ); 
        if(!edge.contains(e))
        	edge.add (  e ); 
    } 
    
    void removeEdge(int v, int d, int w)
    { 
        vertex.get(v).remove(new Edge(v,d,w));  
        vertex.get(d).remove(new Edge(d,v,w)); 
    } 
    
    
    int shortestPath(int u, int v){
        
         Set<Pair <Integer, Integer>> q = new HashSet();
         
         int[] dist = new int[V+1];
         for(int i=0; i<dist.length; i++)
        	 dist[i]=INF;
        	 
         q.add(new Pair<Integer, Integer>(Integer.valueOf(0),Integer.valueOf(u)));
         dist[u]=0;
        
        while(!q.isEmpty()){
            
            Pair<Integer, Integer> temp = q.stream().findFirst().get();
            q.remove(temp);
            Integer u2 = temp.second;
           System.out.println("u2 " +u2);
            Iterator<Edge> iter = vertex.get(u2).iterator();
            while(iter.hasNext()){
                Edge e = iter.next();
                System.out.println("edge " +e.destination);

                System.out.println("edge w " +e.weight);
                System.out.println("dist total " + dist[e.source]);
                
                System.out.println("dist total " + dist[e.destination]);
                
                if(dist[e.destination] > dist[e.source] + e.weight ){
                    
                    
                    if(dist[e.destination] != INF)
                        q.remove(new Pair<Integer, Integer>(dist[e.destination],e.destination));
                    
                    dist[e.destination] = dist[u2.intValue()] + e.weight;
                    q.add(new Pair<Integer,Integer>(dist[e.destination],e.destination));
                }
                
            }
            
            
        }
        
    return dist[v];
    }
    
}
    public int solve(int A, int[][] B) {
        
        Graph g = new Graph(A);
        for(int i=0; i<B.length; i++){
            g.addEdge(B[i][0],B[i][1],B[i][2]);
        }
        
         //System.out.println("size " +g.vertex.size());
        int min_cycle = 100000000; 
        Iterator<Edge> E = g.edge.iterator(); 
        Edge e;
        while(E.hasNext()){ 
            e= E.next();
      
            g.removeEdge( e.source, e.destination, e.weight ) ; 
      
            int distance = g.shortestPath( e.source, e.destination );
            
            System.out.println("distance "+distance);
      
            min_cycle = Math.min( min_cycle, distance + e.weight ); 

            g.addEdge( e.source, e.destination, e.weight ); 
        } 
  
        return min_cycle;
    }
    

    public static void main(String[] args) {
    	
    	int A = 5;
    	int[][] B = 
    		{
    	  {1, 2, 1},
    	  {1, 5, 2},
    	  {5, 4, 3},
    	  {4, 3, 1},
    	  {3, 2, 5},
    	  {2, 5, 8},
    	  {5, 3, 6},
    		};
    	
    	
    	System.out.println("min "+new GraphShortestPath().solve(A, B));
    }
    
}

