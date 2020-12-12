package com.ismk.basic.examples;

class BST {
	  private class TreeNode {
	      int value;
	      TreeNode left;
	      TreeNode right;
	      
	      public TreeNode(int value) {
	    	  this.value = value;
	    	  left = null;
	    	  right =null;
	    			 
	      }
	      

	  }
	//refers to the top node
	  private TreeNode root;
	  
	  private TreeNode addRecursive(TreeNode current, int value) {
		    if (current == null) {
		        return new TreeNode(value);
		    }
		 
		    if (value < current.value) {
		        current.left = addRecursive(current.left, value);
		    } else if (value > current.value) {
		        current.right = addRecursive(current.right, value);
		    } else {
		        // value already exists
		        return current;
		    }
		 
		    return current;
		}
	  public BST() {root = null;}
	  public void add(int value) {
		    root = addRecursive(root, value);
		}
	  
	  public boolean findIter(int x){
		  
		  TreeNode top = root;
		  while(top!=null) {
			  
			  if(top.value == x)
				  return true;
			  else if(top.value > x)
				  top = top.left;
			  else
				  top = top.right;
			  
		  }
		  
		  return false;
		  
		 
	  }
	  
	  
	  public TreeNode delete(int x, TreeNode node) {
		  
		  if(node == null) {
			  return node;
		  }
		  else if(x< node.value) {
			  
			  node.left = delete(x, node.left);
			  
		  }
		  else if(x> node.value ) {
			  node.right = delete(x, node.right);
		  }else {
			  
			  // node with only one child or no child 
	            if (node.left == null) 
	                return node.right; 
	            else if (node.right == null) 
	                return node.left; 
	            
	            // node with two children: Get the inorder successor (smallest 
	            // in the right subtree) 
	            node.value = minValue(node.right); 
	  
	            // Delete the inorder successor 
	            node.right = delete(node.value, node.right); 
		  }
		  
		  return node;
	  }
	  
	  public void remove(int x) {
		  
		  root = delete(x, root);
		  
	  }
	  
	   public int minValue(TreeNode root) 
	    { 
	        int minv = root.value; 
	        while (root.left != null) 
	        { 
	            minv = root.left.value; 
	            root = root.left; 
	        } 
	        return minv; 
	    } 
	  
	  public boolean findRecursive(TreeNode root, int x){
		  
		  TreeNode top = root;
		  if(top == null) {
			  return false;
		  }
		  else if(top.value >x) {
			 return findRecursive(top.left,x);
		  }
		  else if(top.value < x) {
			  return findRecursive(top.right,x);
		  }
		  else if(top.value == x)
		  return true;
		   else return false;
		  
		 
	  }
	  
	  public boolean find(int x) {
		  
		  return findRecursive(root, x);
	  }
	  
	  public void displayOrder(TreeNode node) {
		  
		  if(node != null) {
			  
			  displayOrder(node.left);
			  System.out.println(node.value +" ");
			  displayOrder(node.right);
		  }
	  }
	  
	  public void displayDesc(TreeNode node) {
		  
		  if(node != null) {
			  displayDesc(node.right);
			  System.out.println(node.value +" "); 
			  displayDesc(node.left);
		  }
	  }
	  
	  
	  public void displayPre(TreeNode node) {
		  
		  if(node != null) {
			  
			  System.out.println(node.value +" "); 
			  displayPre(node.left);
			  displayPre(node.right);
		  }
	  }
	  
	  public void displayPost(TreeNode node) {
		  
		  if(node != null) {
			  
			  displayPost(node.left);
			  displayPost(node.right);

			  System.out.println(node.value +" "); 
		  }
	  }
	  
	  public void displayTree(TreeNode node) {
		
		  if(node != null) {
			  
			  if(node == root)
				  System.out.println("\t (" + node.value +") \t");
			  
			  
			  printNode(node.left);
			  printNode(node.right);

			  System.out.println();
				  
			  displayTree(node.left);
			  displayTree(node.right);
			 
		
		  }
		 
		 
		  
	  }
	  
	  public int findMin(TreeNode node) {
		  	
		  if(node ==null) {
			  
			  return -10000;
		  }
		  
		  if(node.left == null) {
			  
			  return node.value;
		  }
		  else {
			  
			  return findMin(node.left);
		  }
		  
		  
	  }
	  
	  public int findMin() {
		  
		  return findMin(root);
	  }
	  
	  public int findMax(TreeNode node) {
		  
		  if(node == null) {
			  
			  return -10000;
		  }
		  if(node.right == null) {
			  return node.value;
		  }
		  else {
			  
			  return findMax(node.right);
			  
		  }
		  
	  }
	  
	  
	  public int findMax() {
		  
		  return findMax(root);
	  }
	  
	  public int maxDepth(TreeNode node) {
		  
		  if(node == null)
			  return 0;
		  
		  int lDepth = maxDepth(node.left);
		  int rDepth = maxDepth(node.right);
		  
		  if(lDepth < rDepth)
			  
			  return (rDepth+1);
		  else
			  return (lDepth +1);
						
		  
	  }
	  
	  public int depth() {
		  
		  return maxDepth(root);
	  }
	  
	  public int countNodes(TreeNode node) {
		  
		  int c = 1;
		  if(node == null) {
			  
			  return 0;
		  }
		  
		  c += countNodes(node.left);
		  
		  c += countNodes(node.right);
		  
		  return c;
		  
	  }
	  
	  public int count() {
		  
		  return countNodes(root);
	  }
	  
	  public int maxWidth(TreeNode node) {
		  int maxWidth =0;
		  for(int i=1; i<= depth();  i++) {
			 int width = getWidth(node,i);
			 if(width > maxWidth)
				 maxWidth = width;
			  
		  }
		  
		  return  maxWidth;
	  }
	  

	  
	  public int getWidth(TreeNode node, int level) {
		  
		  if(node == null)
			  return 0;
		  else if(level == 1)
			  return 1;
		  if(level > 1) {
			  return getWidth(node.left, level-1) + getWidth(node.right, level-1);
		  }
		  else
			  return -1;
		  
		  
	  }
	  
	  public void printNode(TreeNode node) {
		  
		  if(node != null) {
			  
			  System.out.print("\t (" + node.value +") \t");
			  
		  }
	  }
	  
		public static void main(String[] args) {
			
			BST bst =new BST();
			bst.add(8);
			bst.add(4);
			bst.add(2);
			bst.add(5);
			bst.add(10);
			bst.add(9);
			bst.add(12);
			bst.add(7);
			bst.add(6);
			
			bst.displayOrder(bst.root);
			
			System.out.println("found: "+bst.find(3));
			
			//System.out.println("Removing 4");
			//bst.remove(4);
			
			System.out.println("Order");
			bst.displayOrder(bst.root);
			System.out.println("Desc");
			bst.displayDesc(bst.root);
			
			System.out.println("Pre");
			bst.displayPre(bst.root);
			
			System.out.println("Post");
			bst.displayPost(bst.root);
			
			System.out.println("found min: "+bst.findMin());

			System.out.println("found max: "+bst.findMax());
			
			System.out.println("depth: "+bst.depth());
			
			System.out.println("count: "+bst.count());
			
			System.out.println("width: "+bst.maxWidth(bst.root));
		}
	}