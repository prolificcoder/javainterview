package com.projecteuler.prolificcoder;

import java.util.ArrayList;
import java.util.List;

public class Multiples {
	public static void main(String args[])
	{
		List<Integer> multiples = new ArrayList<Integer>();
		for(int i=3;i<1000;i++)
		{
			if(i%3==0)
				multiples.add(i);
			else if(i%5==0)
				multiples.add(i);
		}
		int sum=0;
		for(int i=0;i<multiples.size();i++)
			sum+=multiples.get(i);
		System.out.print(sum);
	}
}
