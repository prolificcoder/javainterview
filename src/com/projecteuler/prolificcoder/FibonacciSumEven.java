package com.projecteuler.prolificcoder;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSumEven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> sequence = new ArrayList<Integer>();
		int a =1;
		int b =2;
		int i=1;
		sequence.add(b);
		while(a+b<4000000)
		{
			a=a+b;		
			if(i%3==0)
				sequence.add(a);
			i++;
			b=a+b;
			if(i%3==0)
				sequence.add(b);
			i++;
		}
		long sum=0;
		for(i=0;i<sequence.size();i++)
			sum+=sequence.get(i);
		System.out.println(sum);
	}

}
