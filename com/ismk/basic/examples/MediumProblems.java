package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MediumProblems {
	
	
	
	private List<Integer> contains(int[] array1, int[] array2) {
		List<Integer> result = new ArrayList<Integer>();
		
		int index=0;
		for( int val1 : array1) {
			
			for(int j=index; j<array2.length; j++) {
				
				if(val1 == array2[j]) {
					
					result.add(val1);
					index = j+1;
					break;
					
				}
				if(array2[j] > val1) {
					index = j;
					break;
				}
			}
			
		}
		
		
		
		return result;
	}
	
	int findClusters(int[][] grid) {
		
		int count=0;
		int[] adjR = {-1,0,1,0};
		int[] adjC = {0,1,0,-1};
		
		if( grid ==null || grid.length  <=0) {
			return 0;
		}
		
		int C = grid[0].length;
		int R = grid.length;
		int clusterSize = 0;
		HashMap<Integer, Boolean> linearValues = findElements(grid);
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(Map.Entry<Integer, Boolean> element : linearValues.entrySet() ) {
			clusterSize = 0;
			
			if(!element.getValue())
				q.add(element.getKey());
			
			while(!q.isEmpty()) {
				
				Integer code = q.poll();
				linearValues.put(code, Boolean.TRUE);
				
				int dr = code/C;
				int dc = code%C;
				clusterSize ++;
				for(int i = 0; i< adjR.length; i++) {

					int cr = (dr + adjR[i]);
					int cc = (dc + adjC[i]);
					int encodeCheck = cr * C + cc;
					Boolean checkNode = linearValues.get(encodeCheck);
					
					if(cr < R && cc < C && checkNode !=null && !checkNode) {
						q.add(encodeCheck);
					}
				}
				
			}
			
			if(clusterSize > 0)
				count ++;
			
			
		}
		
		
		
		return count;
	}
	
	HashMap<Integer, Boolean> findElements(int[][] grid){
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int r=0; r<grid.length; r ++) {
			for(int c=0; c< grid[r].length; c++) {
				
				if(grid[r][c] == 1)
					map.put(r*grid[r].length + c, Boolean.FALSE);
			}
		}
		
		return map;
	}

	public static void main(String[] args) {
		
		MediumProblems m = new MediumProblems();
		int[] arr1 = {20,22,23, 25, 41};
		int[] arr2 = {1,2,3,22,23, 25, 26,33,40,41};
		System.out.println("Invoke contains: " + m.contains(arr1, arr2));
		
		
		int[][] grid = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		
		System.out.println("invoke grid "+ m.findClusters(grid));
		
	}

}
