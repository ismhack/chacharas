package com.ismk.basic.examples;

public class DecompressString {
	
	Integer count;
	String letter;
	
	public DecompressString(Integer count, String c) {
		this.count =count;
		this.letter = c;
		
	}
	public static StringBuilder decompressedString= new StringBuilder();
	
	public static void decompress(String text) {
		
		if (text == null || text.isEmpty())
			return;
		
		
		decompressRec(text,0,text.length()-1);
		
	}
	
	public static String decompressRec(String array, int start, int end) {
		
		
		boolean startSentence=false;
		String number="";
		String sequence="";
		char value;
		int j=0;
		for(int i = start; i<=end; i++) {
			value = array.charAt(i);
			if(Character.isDigit(value)) {
				
				if(startSentence) {

					j= findClosingParen(array, i+1);
					System.out.println("last index of "+j);
					sequence+=decompressRec(array,i, j);
					i=j;
				}else{
					number += value+"";
				}
				
			}
			else if(value == '[') {
				startSentence=true;
				
				
			}
			else if(Character.isLetter(value)) {
				sequence += value+"";
				if(!startSentence) {
					decompressedString.append(value);
					sequence="";
				}
				
			}
			else if(value == ']') {
				if(start==0) 
					decompressedString.append(decompressToString(sequence, Integer.valueOf(number)));
				else
					return decompressToString(sequence, Integer.valueOf(number));
				number="";
				sequence="";
				startSentence=false;
				
			}
			else {
				System.out.println("Error, expected  a-z, digit, or[]");
				break;
			}
			
		}
		return decompressedString.toString();
		
	}
	
	

	public static String decompressToString(String letter, int count) {
		String newString="";
		for(int i = 0; i<count; i++)
			newString+=letter;
		
		return newString;
	}
	
	public static int findClosingParen(String text, int openPos) {
	    int closePos = openPos;
	    int counter = 1;
	    while (counter > 0) {
	        char c = text.charAt(++closePos);
	        if (c == '[') {
	            counter++;
	        }
	        else if (c == ']') {
	            counter--;
	        }
	    }
	    return closePos;
	}


	
public static int orangesRotting(int[][] grid) {
        
        int [][] temp = gridClone(grid);
        
        int x = temp.length-1;
        int y=0;
        int seconds=0;
        
        	if(!hasOrange(grid,2))
        		return seconds;
        	
        outerloop:
        while(basketState(grid) == true){
            for(int i=0; i<grid.length; i++){
                y = grid[i].length-1;
                for(int j=0; j<grid[i].length; j++){
                    if(grid[i][j] == 2 ){
                        if(!outOfBounds(i, j-1, x, y))
                            temp[i][j-1] = 2;
                        if(!outOfBounds(i, j+1, x, y))
                            temp[i][j+1] = 2;
                        if(!outOfBounds(i-1, j, x, y))
                            temp[i-1][j] = 2;
                        if(!outOfBounds(i+1, j, x, y))
                            temp[i+1][j] = 2;
                    }

                    if(grid[i][j] ==1){
                        
                        if( !outOfBounds(i, j-1, x, y) && grid[i][j-1] != 0){
                        
                            continue;
                        }
                        
                        if( !outOfBounds(i, j+1, x, y) && grid[i][j+1] != 0 ){
                        	continue;
                        }
                            
                       if( !outOfBounds(i+1, j, x, y) && grid[i+1][j] != 0){
                    	   continue;
                       }
                           
                       if(!outOfBounds(i-1, j, x, y) && grid[i-1][j] != 0){
                    	   continue;
                       }
                       
                        seconds = -1;
                        break outerloop;
                    }

                }
            
            }
            grid = gridClone(temp);
            seconds++;
        }
        return seconds;
    }
        
    
        public static boolean basketState(int[][] grid){
            boolean flag= false;
            outerloop:
            for(int i=0; i<grid.length; i++){
              for(int j=0; j<grid[i].length; j++){
                  if(grid[i][j] == 1){
                    flag =true;
                      break outerloop;
                  }
                }
            }
        
        return flag;
    }
        
        public static boolean hasOrange(int[][] grid, int x){
            boolean flag= false;
            outerloop:
            for(int i=0; i<grid.length; i++){
              for(int j=0; j<grid[i].length; j++){
                  if(grid[i][j] == x){
                    flag =true;
                      break outerloop;
                  }
                }
            }
        
        return flag;
    }
    
    public static boolean outOfBounds(int x, int y, int i, int j){
     
        if(x > i || x < 0)
            return true;
        if (y > j || y< 0)
            return true;
        
        return false;
        
    }
    
    public static int[][] gridClone(int[][] grid ){
        int [][] temp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            System.arraycopy(grid[i], 0, temp[i], 0, grid[i].length);
        }
        
        return temp;
    }	

	public static void main(String[] args) {
		
		DecompressString.decompress("addd3[abc]4[ab]");
		//DecompressString.decompress("2[3[a]d]");
		//DecompressString.decompress("2[3[2[c]a]d]");
		
		System.out.println(decompressedString.toString());
		
		
		int[][] grid = {{0}};
		System.out.println("orages rotten in secods "+DecompressString.orangesRotting(grid));
		
		

	}

}
