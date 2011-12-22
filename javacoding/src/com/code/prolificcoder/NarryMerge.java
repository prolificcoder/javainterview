package com.code.prolificcoder;


public class NarryMerge {

	LinkedList[] sortedLinkedLists;
	public static void main(String args[]){
		int[] items1=new int[]{1,3,5,8};
		int[] items2=new int[]{2,4,6};
		LinkedList ll1=new LinkedList(items1);
		LinkedList ll2=new LinkedList(items2);
		NarryMerge nm=new NarryMerge();
		nm.sortedLinkedLists=new LinkedList[]{ll1,ll2};
		int ar[]= nm.merge(nm.sortedLinkedLists);
		for(int item : ar)
			System.out.println(item);
		
	}
	public int[] merge(LinkedList[] sortedLinkedLists){
		int count=0;
		for(int i=0;i<sortedLinkedLists.length;i++)
		{
			count+=sortedLinkedLists[i].size();
		}
		int[] finalSortedArray=new int[count];
		for(int i=0;i<count;i++)
		{
			int min=findMin();
			finalSortedArray[i]=min;
		}
		
		return finalSortedArray;
	}

	private int findMin() {
		int min=(Integer) sortedLinkedLists[0].head.data;
		int index=0;
		for(int i=1;i<sortedLinkedLists.length;i++)
		{
			if((Integer)sortedLinkedLists[i].head.data<min){
				min=(Integer)sortedLinkedLists[i].head.data;
				index=i;
			}
		}
		min=(Integer) sortedLinkedLists[index].head.data;
		sortedLinkedLists[index].head=sortedLinkedLists[index].head.next;
		return min;
	}
	
}
