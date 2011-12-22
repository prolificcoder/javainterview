package com.code.prolificcoder;

class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode(int data,BSTNode left,BSTNode right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
}

public class BSTree {
	BSTNode root;
	public boolean find(BSTNode root,int item){
		if(root==null)
			return false;
		else if(item<root.data)
			return find(root.left,item);
		else 
			return find(root.right,item);
	}
	public boolean remove(BSTNode root, int item){
		
		return false;
	}
	public void insert(BSTNode root, int item){
		if(root==null)
			root=new BSTNode(item, null, null);
		else{
			if(item<root.data)
				insert(root.left,item);
			else
				insert(root.right,item);
		}
	}
}
