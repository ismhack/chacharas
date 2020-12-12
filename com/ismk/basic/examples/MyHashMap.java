package com.ismk.basic.examples;

public class MyHashMap {
	
	int size;
	int[] map;
	
	public MyHashMap(int size) {
		this.size = size;
		map = new int[size];
		
		for (int i=0; i<this.size; i++) {
			
			map[i] = -1;
		}
		
	}
	
	public int hash(int element) {
		
		return element % size;
	}
	
	public void insert (int element)
	{
		int index = hash(element);
		
		while(map[index]!= -1 && map[index] != element) {
			
			index = index+1 % size;
		}
		
		map[index] = element;
		
	}
	
	
	public void delete (int element) {
		
		int index = hash(element);
		
		while(map[index] != -1) {
			
			if(map[index] == element) {
				map[index] = -1;
				return;
			}
			index = index +1 % size;
		}
		
	}
	
	public boolean find(int element) {
		
		
		int index = hash(element);
		
		while(map[index] != -1) {
			
			if(map[index] == element)
				return true;
			index = index +1 % size;
		}
		return false;
		
	}
	
	public MyHashMap intersect(MyHashMap another) {
		
		MyHashMap result = new MyHashMap(size);
		
		for(int i=0; i<size; i++) {
			
			if(map[i] != -1 && another.find(map[i])) {
				
				result.insert(map[i]);
			}
		}
		return result;
		
	}
	
	
	public MyHashMap union(MyHashMap another) {
		
		MyHashMap result = new MyHashMap(size);
		
		for(int i=0; i< size; i++) {
			if(map[i] != -1) {
				
				result.insert(map[i]);
			}
				
			
		}
		
		
		for(int i=0; i<size; i++) {
			
			if(another.map[i] != -1 && !find(another.map[i])) {
				
				result.insert(another.map[i]);
			}
		}
		return result;
		
	}
	
	public void display() {
		
		System.out.println();
		for(int val : map) {
			
			if (val != -1) {
				System.out.print(val+ " ");
			}
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		MyHashMap map = new MyHashMap(100);
		
		map.insert(23);
		map.insert(22);
		map.insert(11);
		map.insert(43);
		map.insert(23);
		
		map.insert(29);
		
		
		map.display();
		
		map.delete(11);
		
		map.display();
		
		
		//new map
		
		MyHashMap map2 = new MyHashMap(100);
		
		map2.insert(29);
		map2.insert(10);
		map2.insert(43);
		
		MyHashMap union = map.union(map2);
		
		union.display();
		
		MyHashMap intersect = map.intersect(map2);
		
		intersect.display();

	}

}
