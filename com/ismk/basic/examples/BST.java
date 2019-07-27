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
	  
	  public boolean find(int x){
		  
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
	  
	  public void displayOrder(TreeNode node) {
		  
		  if(node != null) {
			  
			  displayOrder(node.left);
			  System.out.println(node.value +" ");
			  displayOrder(node.right);
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
			
			System.out.println("found: "+bst.findRecursive(bst.root,6));
			
			System.out.println("return delete "+ bst.delete(4, bst.root).value);
			
			bst.displayOrder(bst.root);
			
			
		}
	}