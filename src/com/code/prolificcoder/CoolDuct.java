package com.code.prolificcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.test.salesforce.Position;

public class CoolDuct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid;
		 try {
			 Scanner scanner = new Scanner(new java.io.File(args[0]));
			 int n = scanner.nextInt();
			 int m= scanner.nextInt();
				 grid = new int[n][m];
		
				 for(int i=0;i<n;i++)
				 {
					 for(int j =0;j<m;j++)
					 {
						 int num=scanner.nextInt();
						 grid[i][j]=num;
					 }					 
				 }
				 scanner.close();
		   //Pre populate step
			Position start=null, end=null;
			int zeroCount=0;
			for(int i=0;i<n;i++)
			 {
				for(int j =0;j<m;j++)
				 {
					if(grid[i][j]==2){
						start = new Position(i, j);
					}
					else if(grid[i][j]==3)
						end = new Position(i, j);
					else if (grid[i][j]==0)
						zeroCount++;					
				 }
			 }
			int k=0;
			isRoute(grid,zeroCount,start,end,k);
				
			System.out.println(k);
		 }
	     catch (Exception e) {
	         e.printStackTrace();
	     }
	       
	}
	static boolean isRoute(int[][] grid, int zeroCount, Position current, Position end,int k)
	{
//		if(current.equals(end)){
//			if(zeroCount==0)
//				return true;
//			else 
//				return false;
//		}
		List<Position> directions = new ArrayList<Position>();
		if(isValid(grid,current.getI()+1,current.getJ()))
		  directions.add(new Position(current.getI()+1, current.getJ()));
		if(isValid(grid,current.getI(),current.getJ()+1))
			directions.add(new Position(current.getI(), current.getJ()+1));
		if(isValid(grid,current.getI()-1,current.getJ()))
			directions.add(new Position(current.getI()-1, current.getJ()));
		if(isValid(grid,current.getI(),current.getJ()-1))
			  directions.add(new Position(current.getI(), current.getJ()-1));
		
	
		Position shortest=shortest(end, directions);
		
		if(zeroCount!=0)
		{
			if(grid[shortest.getI()][shortest.getJ()]!=3)
				grid[shortest.getI()][shortest.getJ()]=5;
			isRoute(grid, zeroCount-1, new Position(shortest.getI(), shortest.getJ()),end,k);
			grid[shortest.getI()][shortest.getJ()]=0;
			zeroCount++;
		}
		
		if (shortest.getI()-end.getI()==0 && shortest.getJ()-end.getJ()==0){	
			k++;
			return true;
		}
		
		return false;
		
		//grid[shortest.getI()][shortest.getJ()+1]=0;
			
		//return false;
			
	}
	private static Position shortest(Position end, List<Position> directions) {
		double max=-1.0;
	    Position shortest = null;
		double[] distances= new double[directions.size()];
		//{distance(current, down),distance(current, right), distance(current,up),distance(current, left)};
		for(int i =0; i<directions.size(); i++)
			distances[i]=distance(end,directions.get(i));
		
		for(int i =0; i<distances.length; i++)
		{
			if (distances[i]>max){
				max=distances[i];
				shortest=directions.get(i);
			}
		}
		return shortest;
	}
	static double distance(Position start, Position end)
	{
		if(end==null)
			return 0.0;
		double x2=end.getJ()- start.getJ();
		double y2=end.getI()-start.getI() ;
		return Math.sqrt( x2*x2 + y2*y2); 
	}
	static boolean isValid(int[][] grid, int i, int j)
	{
		if(i<grid.length &&j<grid[0].length && i>=0 && j >=0)
		{
			if(grid[i][j]==0 ||grid[i][j]==3)
				return true;
		}
		return false;
		
	}
}
