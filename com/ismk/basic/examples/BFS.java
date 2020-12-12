package com.ismk.basic.examples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {
	
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[] dr2 = new int[] {-1, 0, 1, 0,-1,1,-1,1};
	static int[] dc2 = new int[] {0, 1, 0, -1,-1,1,1,-1};
	public static int orangesRotting(int[][] grid) {
		int ans = 0;
		Map<Integer, Integer> depth = new java.util.HashMap<Integer,Integer>();
		Queue<Integer> queue =  new ArrayDeque<Integer>();
		
		int R = grid.length;
		int C = grid[0].length;
		int code =0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(grid[r][c]==2) {
					code = r * C + c;
					queue.add(code);
					depth.put(code, 0);
				}
			}
		}
		
		while(!queue.isEmpty()){
			code = queue.remove();
			int r = code/C, c = code%C;
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if( nr>=0 && nr < R && nc >= 0 && nc <C && grid[nr][nc] ==1 ) {
					grid[nr][nc] = 2;
					int ncode= nr * C + nc;
					queue.add(ncode);
					depth.put(ncode, depth.get(code)+1);
					ans = depth.get(ncode);
					
				}
				
			}
			
		}
		
		for(int[] r : grid)
			for(int c: r)
				if(c == 1)
					return -1;
		
		
		
		return ans;
	}
	
	
	public static int numberOfStoresInPark(int rows, int columns, List<List<Integer>> grid) {
		
		int total=0;
		
		Map<Integer, Boolean> visited= new HashMap<Integer, Boolean>();
		
		for(int i =0; i<rows; i++) {
			
			for(int j=0; j<columns; j++) {
				
				visited.put(i*columns + j, Boolean.FALSE);
				
			}
		}
		
		
		for(int i =0; i<rows; i++) {
			
			for(int j=0; j<columns; j++) {
				int data = grid.get(i).get(j);
				int code = i * columns + j;
				
				if(data == 1 && !visited.get(code)) {
					
					bfsUtil(code,grid, visited);
					total++;
					
				}
				
			}
			
		}
		
		
		return total;
		
	}
	//checks adjacent nodes horizontally and vertically.
	static void bfsUtil(int code, List<List<Integer>> grid, Map<Integer, Boolean> visited) {
		
		visited.put(code, Boolean.TRUE);

		// Create a queue for BFS  
	    LinkedList<Integer> q=new LinkedList<>(); 
	    int C= grid.get(0).size();
	    int R = grid.size();
	    q.add(code);
		System.out.print(code+" " +"("+code/C+","+code%C+") ");
	    while(!q.isEmpty()) 
	    { 
	        // Dequeue a vertex from queue and print it  
	        int data=q.poll(); 
	        
			int r = data/C, c = data%C;

			for(int i=0; i<dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if( nr>=0 && nr < R && nc >= 0 && nc <C && grid.get(nr).get(nc) == 1 ) {
					int ncode= nr * C + nc;

					if(!visited.get(ncode) ) {
						q.add(ncode);
						visited.put(ncode, Boolean.TRUE);
					}
					
				}
				
			}//end for
	    }//end while
	    

	  
	}
	
	 static int connectedCell(int[][] matrix) {
		 
		 int max =0;
		 Map<Integer, Boolean> visited= new HashMap<Integer, Boolean>();
			int rows = matrix.length;
			int columns = matrix[0].length;
			for(int i =0; i<rows; i++) {
				
				for(int j=0; j<columns; j++) {
					
					visited.put(i*columns + j, Boolean.FALSE);
					
				}
			}
			
			
			for(int i =0; i<rows; i++) {
				
				for(int j=0; j<columns; j++) {
					int data = matrix[i][j];
					int code = i * columns + j;
					
					if(data == 1 && !visited.get(code)) {
						
						max = Math.max(max,bfsUtil2(code,matrix, visited));
						
					}
					
				}
				
			}
		return max;

	}
	
		//checks adjacent nodes horizontally and vertically and diagonally. and returns size of discovered nodes
	static int bfsUtil2(int code, int[][] matrix, Map<Integer, Boolean> visited) {
		
		visited.put(code, Boolean.TRUE);
		int nodes =1;
		// Create a queue for BFS  
	    LinkedList<Integer> q=new LinkedList<>(); 
	    int C= matrix[0].length;
	    int R = matrix.length;
	    q.add(code);
		System.out.print(code+" " +"("+code/C+","+code%C+") ");
	    while(!q.isEmpty()) 
	    { 
	        // Dequeue a vertex from queue and print it  
	        int data=q.poll(); 
	        
			int r = data/C, c = data%C;

			for(int i=0; i<dr2.length; i++) {
				int nr = r + dr2[i];
				int nc = c + dc2[i];
				if( nr>=0 && nr < R && nc >= 0 && nc <C && matrix[nr][nc] == 1 ) {
					int ncode= nr * C + nc;

					if(!visited.get(ncode) ) {
						q.add(ncode);
						visited.put(ncode, Boolean.TRUE);
						nodes++;
					}
					
				}
				
			}//end for
	    }//end while
	        
	    return nodes;
	  
	}
	

	public static void main(String[] args) {
		
		
		int[][] grid = {{0, 2}};//{{2,1,1},{0,1,1},{1,0,1}};
		System.out.println("orages rotten in secods "+BFS.orangesRotting(grid));
		
		List<List<Integer>> grid2 = new ArrayList<List<Integer>>();
		List row1 = new ArrayList<Integer>();
		row1.add(1); row1.add(1); row1.add(0); row1.add(0);
		List row2 = new ArrayList<Integer>();
		row2.add(0); row2.add(0); row2.add(1); row2.add(0);
		List row3 = new ArrayList<Integer>();
		row3.add(0); row3.add(0); row3.add(0); row3.add(0);
		List row4 = new ArrayList<Integer>();
		row4.add(1); row4.add(0); row4.add(1); row4.add(1);
		List row5 = new ArrayList<Integer>();
		row5.add(1); row5.add(1); row5.add(1); row5.add(1);
		
		grid2.add(row1);
		grid2.add(row2);
		grid2.add(row3);
		grid2.add(row4);
		grid2.add(row5);
		System.out.println("grid: "+ grid2.size() + " X " + grid2.get(0).size() );
		
		System.out.println("stores: "+numberOfStoresInPark(grid2.size(), grid2.get(0).size(), grid2));
		
		//test connected cells
		
		int[][] matrix = {{1, 1, 0, 0},
				{0, 1, 1, 0},
				{0, 0, 1, 0},
				{1, 0, 0, 0}};
		
		System.out.println("max connected cells: "+connectedCell(matrix));
		

	}

}
