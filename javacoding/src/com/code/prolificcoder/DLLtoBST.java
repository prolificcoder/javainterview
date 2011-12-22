package com.code.prolificcoder;
//To covert a sorted doubly linked list to binary search tree
class DoubleLinkedListNode{
	int item;
	DoubleLinkedListNode next;
	DoubleLinkedListNode prev;
	public DoubleLinkedListNode(int item) {
		this.item=item;
		next=null;
		prev=null;
	}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if(this.prev==null)
			sb.append("X--");
		else
			sb.append(this.prev.item+"--");
		sb.append(this.item);
		if(this.next==null)
			sb.append("--X");
		else
			sb.append("--"+this.next.item);
		return sb.toString();
	}	
}
class DoubleLinkedList{
	int size;
	DoubleLinkedListNode head;
	public DoubleLinkedListNode getNode(int num){
		if(num<0)
			return null;
		DoubleLinkedListNode cur=head;
		int i=0;
		while(cur!=null){
			if(i==num)
				return cur; 
			i++;
			cur=cur.next;			
		}
		return cur;
	}
}
class BinarySearchTreeNode{
	int item;
	BinarySearchTreeNode leftChild;
	BinarySearchTreeNode rightChild;
	public BinarySearchTreeNode(int item) {
		this.item=item;
		leftChild=null;
		rightChild=null;
	}
	public BinarySearchTreeNode(){}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if(this.leftChild==null)
			sb.append("X--");
		else
			sb.append(this.leftChild.item+"--");
		sb.append(this.item);
		if(this.rightChild==null)
			sb.append("--X");
		else
			sb.append("--"+this.rightChild.item);
		return sb.toString();
	}
}

public class DLLtoBST {
	public static void main(String args[]){
		DoubleLinkedListNode d4=new DoubleLinkedListNode(13);
		DoubleLinkedListNode d3=new DoubleLinkedListNode(11);
		DoubleLinkedListNode d2=new DoubleLinkedListNode(9);
		DoubleLinkedListNode d1=new DoubleLinkedListNode(7);
		DoubleLinkedListNode d0=new DoubleLinkedListNode(3);
		d0.next=d1;d0.prev=null;
		d1.prev=d0;d1.next=d2;
		d2.prev=d1;d2.next=d3;
		d3.prev=d2;d3.next=d4;
		d4.prev=d3;d4.next=null;
		DoubleLinkedList dll=new DoubleLinkedList();
		dll.head=d0;
		
		DLLtoBST db=new DLLtoBST();
		
		BinarySearchTreeNode root =db.createBST(dll,0,4);
		System.out.println(root);
		System.out.println(root.leftChild);
		System.out.println(root.leftChild.rightChild);
		System.out.println(root.rightChild);
		System.out.println(root.rightChild.rightChild);
	}

	private BinarySearchTreeNode createBST(DoubleLinkedList dll, int start, int end) {
		BinarySearchTreeNode root=null;
		if(start<=end){
			int mid=(start+end)/2;
			DoubleLinkedListNode cur=dll.getNode(mid);			
			root=new BinarySearchTreeNode(cur.item);
			root.leftChild=createBST(dll, start, mid-1);
			root.rightChild=createBST(dll,mid+1,end);
		}
		return root;
	}
	
}
