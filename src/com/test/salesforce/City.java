package com.test.salesforce;

public class City {
	private int[][] grid;

	City(int m,int n)
	{
		grid = new int[m][n];
	}
	public int[][] getGrid() {
		return grid;
	}
}
