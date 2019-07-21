package com.ismk.basic.examples;

public class Line {
	private class Point{
		
		int x;
		int y;
		
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	
		
	}//end class point
	
	
	public Point a;
	public Point b;
	
	public Line(Point a, Point b) {
		
		this.a=a;
		this.b=b;
		
	}
	
	public Line(int x1,int x2, int y1, int y2) {
		
		this.a = new Point(x1,x2);
		this.b = new Point(y1,y2);
		
	}
	
	public boolean isHorizontal() {
		
		if(a.y == b.y)return true;
		
		else return false;
			
	}
	
	public boolean isVertical() {
		
		if(a.x == b.x)return true;
		
		else return false;
		
	}
	
	public double slope() {
		
		if(!isVertical()) {
			return (b.y - a.y)/(b.x - a.x); 
		}
		else { return -1d;
		}
	}
	
	public boolean parallel(Line b) {
		
		if((this.slope() == b.slope()) || (isVertical()&& b.isVertical())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Line a =  new Line(3,5,3,2);
		
		System.out.println("line a: "+a.slope());
		
		
		Line b =  new Line(8,8,8,2);
		
		System.out.println("line b: "+b.slope());
		
		System.out.println("a parallel to b? " +a.parallel(b));

	}

}
