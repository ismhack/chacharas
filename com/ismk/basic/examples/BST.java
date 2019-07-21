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
	  
		public static void main(String[] args) {
			
			BST bst =new BST();
			bst.add(8);
			bst.add(4);
			bst.add(2);
			bst.add(5);
			bst.add(10);
			bst.add(12);
			bst.add(7);
			bst.add(6);
			
			System.out.println("found: "+bst.find(8));
		}
	}