package com.test.salesforce;

 public class Position {

	private int i;
	private int j;
	public Position(int k, int l) {
		i=k;
		j=l;
	}
	public int getI() {
		return i;
	}
	public int getJ(){
		return j;
	}
	public void setIJ(int i, int j) {
		this.i = i;
		this.j=j;
	}
	@Override
	public String toString(){
		return Integer.toString(i)+","+Integer.toString(j);
	}
	
	
}
