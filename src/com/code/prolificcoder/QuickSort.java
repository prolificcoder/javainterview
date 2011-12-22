package com.code.prolificcoder;

public class QuickSort {
//	int[] items;
//	public QuickSort(int[] items){
//		this.items=items;
//		
//	}
	public static void main(String args[]){
		System.out.print("This".length());
		int[] ar=new int[]{2,425,1,5,24,211,5,88,82,15}; 
		QuickSort qs=new QuickSort();
		qs.quickSort(ar, 0, ar.length-1);
		//for(int item : ar)
			//System.out.println(item);
	}
	void quickSort(int[] ar,int start,int end){
		int j=partition2(ar,start,end);
		if(start<j-1)
			quickSort(ar,start,j-1);
		if(j<end)
			quickSort(ar,j,end);
	}
	private int partition2(int[] ar, int start, int end) {
		int x=ar[end];
		int i=start-1;
		for(int j=start;j<end;j++){
			if(ar[j]<=x){
				i++;
				int temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			}
		}
		int temp=ar[i+1];
		ar[i+1]=ar[end];
		ar[end]=temp;
		return i+1;
	}
	private int partition(int[] items, int start, int end) {
		int i=start,j=end;
		int pivot=items[(start+end)/2];
		while(i<=j){
			while(items[i]<pivot)
				i++;
			while(items[j]>pivot)
				j--;
			if(i<=j){
				int temp=items[i];
				items[i]=items[j];
				items[j]=temp;
				i++;
				j--;
			}
		}
		return i;
	}
}
