package com.ismk.basic.examples;

import java.util.ArrayList;
import java.util.HashMap;

public class FuzzySearch {
	
	public static java.util.List<HashMap<String, Integer>> descriptionLookupArray = new ArrayList<>();
	
	static void loadDescription(String description) {
		
		HashMap<String, Integer> mapDesc =  new HashMap<>();
		
		for(String value:description.split(" ")) {
			
			mapDesc.putIfAbsent(value, 1);
			
		}
		
		descriptionLookupArray.add(mapDesc);
		
	}
	
	private static class CompareModel implements Comparable<CompareModel>{
		
		private int count;
		private int id;
		
		
		public CompareModel() {
			id=-1;
			count=0;
		}

		@Override
		public int compareTo(CompareModel o) {
			
			if(count < o.count)
				return -1;
			
			if(count > o.count )
				return 1;
			
			if(count == o.count)
				if(id < o.id)
					return 1;
				else
					return -1;
					
			
			return 0;
		}
		
		@Override
		
		public String toString() {
			
			if(count < 1)
				return "-1";
			
			return id+" " +count;
			
		}
		
		
	}
	
	static String printSearch(String query) {
		
		 CompareModel comp = null;
		 CompareModel temp = new CompareModel();
		 int idDescr=-1;
		 
		
			 for(HashMap<String, Integer> map:descriptionLookupArray) {
				 idDescr ++;
				 comp = new CompareModel();
				 for(String searchWord:query.split(" ")) {
					 
					 if(map.containsKey(searchWord)) {
						 
						 comp.count ++;
						 comp.id = idDescr;
						 
					 }
					 
				 }
				 
				 if(comp.compareTo(temp)>0)
					 temp = comp;
				
			 }
		 
		 return temp.toString();
		
	}

	public static void main(String[] args) {
		
		String[] descriptions = {"java developer experienced carrier talent", " web developer frontend react talent", 
				"human resourses rep motivate great communication solid", "javascript web developer carrier java frontend"
		};
		
		
		String[] searchQuerys = {"java developer", " frontend", "carrier", "smart"
				
		};
		
		for(String desc:descriptions) {
			loadDescription(desc);
			
		}
		
		
		for(String query:searchQuerys) {
			
			System.out.println(printSearch(query));
		}
		

	}

}
