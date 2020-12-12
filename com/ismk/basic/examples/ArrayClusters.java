package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayClusters {
	
	public static int[] dr = {-1,0,1,0};
	public static int[] dc = {0, 1, 0,-1};
	public static int calculateClusters(List<List<Integer>>  grid) {
		
		int count=0, R=0, C=0, r=0, c=0;
		R=grid.size();
		Map<Integer, Integer> mapGrid = new java.util.HashMap<Integer, Integer>();
		for(List<Integer> row: grid) {
			C = row.size();
			for(Integer value :row) {
				if(value.intValue()==1) {
					
					mapGrid.put(r*C +c, r*C +c );
				}
				c++;
			}
			c=0;
			r++;
		}
		
		Integer code=null, index=null, ncode=null;
				int nr=0, nc=0;
		boolean isCluster=true;
		while(!mapGrid.isEmpty()) {
			if(isCluster) {
				count++;
				code =mapGrid.values().iterator().next();
				code =mapGrid.remove(code);
				isCluster=false;
			}
			r = code.intValue() / C;
			c = code.intValue() % C;
			ncode=null;
			for(int i=0; i< dr.length; i++) {
				nr = dr[i] + r;
				nc = dc[i] + c;
				index = mapGrid.get(nr*C +nc);
				if( nr >=0 && nr < R && nc >=0 && nc < C && index != null) {
					ncode = mapGrid.remove(index);
					
				}
			}
			
			
			if (ncode == null) {
				mapGrid.remove(code);
				isCluster=true;
			}
			else code = ncode;
			
		}
		
		
		return count;
		 
	}

	public static void main(String[] args) {
		
		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		
		int[] arr = {1,0,0,0};
		grid.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int[] arr2 = {0,0,0,0};
		grid.add(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
		int[] arr3 = {1,1,1,0};
		grid.add(Arrays.stream(arr3).boxed().collect(Collectors.toList()));
		int[] arr4 = {1,1,0,0};
		grid.add(Arrays.stream(arr4).boxed().collect(Collectors.toList()));

		
		System.out.println("output "+ArrayClusters.calculateClusters(grid));
	}

}
