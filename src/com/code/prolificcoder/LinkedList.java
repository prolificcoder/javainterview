	package com.code.prolificcoder;

public class LinkedList {
	public ListNode head;
	private int size;
	public LinkedList(){
		head=null;
		size=0;
	}
	public LinkedList(int[] items){
		head=null;
		size=0;
		for(int item :items){
			this.insertAtFirst(item);
		}
	}
	public boolean isEmtpy(){
		return head==null;
	}
	public int size(){
		return size;
	}
	public void insertAtFirst(Object data){
		ListNode node=new ListNode(data,null);
		if(head==null)
			head=node;
		else{
			node.next=head;
			head=node;
		}
		size++;
	}
	public void insertAtLast(Object data){
		ListNode node=new ListNode(data, null);
		if(head==null)
			head=node;
		else{
			ListNode temp=head;
			while(temp.next !=null){
				temp=temp.next;
			}
			temp.next=node;
		}
		size++;
	}
	public Object removeFirst(){
		return remove(0);
	}
	public Object removeLast(){
		return remove(size-1);
	}
	public boolean Contains(Object item){
		ListNode current=head;
		while(current!=null) {
			if(current.data.equals(item))
				return true;
			current=current.next;
		}
		return false;
	}
	public boolean removeObject(Object item){
		if(head.data.equals(item))
			{
			head=head.next;
			size--;
			return true;
			}
		else{
			ListNode current=head;
			while(current.next !=null){
				if(current.next.data.equals(item))
				{
					ListNode oneAhead=current.next.next;
					current.next=oneAhead;
					size--;
					return true;
				}
				current=current.next;
			}
		}
		return false;
	}
	public boolean removeAllObject(Object item){
		boolean val=false;
		
		ListNode current=head;
		while(current.next !=null){
			if(current.next.data.equals(item))
			{
				ListNode oneAhead=current.next.next;
				current.next=oneAhead;
				size--;
				val=true;
			}
			else
				current=current.next;
		}
		if(head.data==item){
			head=head.next;
			size--;
			val=true;
		}
		return val;
	}
	public LinkedList reverse(){
		ListNode current=head;
		head=null;
		while(current!=null)
		{
			ListNode save=current;
			current=current.next;
			save.next=head;
			head=save;
		}
		return this;
	}
	public boolean findCycle(){
		return false;
	}
	
	//Interface such that return the object at the given position
	public Object remove(int pos){
		
		Object item;
		//If list is empty
		if(head==null)
			return null;
		else if(pos==0){
			item=head.data;
			head=head.next;			
		}
		else{
			ListNode cur=head.next;
			int i=1;
			while(cur.next !=null && i<pos-1){
				cur=cur.next;
				i++;
			}
			//handling the case where pos is greater than number of elements in linkedlist
			if(cur.next==null &&i<=pos)
				return null;
			item=cur.next.data;
			ListNode oneAhead=cur.next.next;//this could be null
			cur.next=oneAhead;
		}
		size--;
		return item;

	}
	public void show()
	{
		ListNode current=head;
		while(current!=null){
			System.out.print(current.data +" -> ");
			current=current.next;
		}
	}
	public ListNode findIntersection(ListNode h1,ListNode h2){
		if(h1==h2)//this also handles both null case
			return h1;
		if(h1==null ||h2==null)
			return null;
		ListNode cur1=h1;
		ListNode cur2=h2;
		int length1=findLength(cur1);
		int length2=findLength(cur2);
		if(length1>length2)
			cur1=moveList(h1,length1-length2);
		else if(length2>length1)
			cur2=moveList(h2,length2-length1);
		while(cur1!=cur2){
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return cur1;
	}
	private ListNode moveList(ListNode h1, int times) {		
		for(int i=0;i<times;i++){
			h1=h1.next;
		}
		return h1;
	}
	private int findLength(ListNode cur1) {
		int count=0;
		while(cur1!=null){
			count++;
			cur1=cur1.next;
		}
		return count;
	}
}
