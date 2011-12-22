package com.projecteuler.prolificcoder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class SumOfPrimes {

	/**
	 *The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	  *Find the sum of all the primes below two million.
	 */
	public static void main(String[] args) {
		
		final int LIMIT=2000000;
		SumOfPrimes s = new SumOfPrimes();
		//1.Create a array from 4.. 1999999
		//2. Keep on dividing with numbers starting from 2 to 1,000,000
		// if no reminder make it a zero
		//3. Sum the array add 2+3 and return
		System.out.println(new DateTime().toString());
		s.naiveApproach(LIMIT); 
		System.out.println(new DateTime().toString());
		
	}
	private void naiveApproach(final int LIMIT){
		long sum=0;
		int i=4;
		while(i<LIMIT){
			if(isPrime(i))
				sum+=i;
			i++;
		}
		System.out.println(2+3+sum);
	}
	private boolean isPrime(int n)
	{
		for(int i=2;i<=Math.sqrt(n);i++)
		 if(n%i==0)
			 return false;
		return true;
		
	}
	// more than 5 mins sieve approach
	private  void arrayApproach(final int LIMIT) {
		
		int[] nums = new int[LIMIT-2];
		
		for(int i=0;i<LIMIT-2;i++)
			nums[i]=i+2;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==0)
				continue;
			else
				for(int j=2*i;j<nums.length;j++)
				{
					if(nums[j] !=0 && nums[j]%nums[i]==0)
						nums[j]=0;
				}
		}
		long sum=0;
		for(int i=0;i<nums.length;i++)
			sum+=nums[i];
		System.out.println(sum);//142913828922
	}
	// more than 30 mins!! sieve approach
	private  void arrayListApproach(final int LIMIT) {
		List<Integer> nums = new ArrayList<Integer>();
		
		for(int i=0;i<LIMIT-2;i++)
			nums.add(i+2);
		for(int i=0;i<nums.size();i++)
		{
			if(nums.get(i)==0)
				continue;
			else
				for(int j=2*i;j<nums.size();j++)
				{
					if(nums.get(j) !=0 && nums.get(j)%nums.get(i)==0)
						nums.remove(j);
				}
		}
		long sum=0;
		for(int i=0;i<nums.size();i++)
			sum+=nums.get(i);
		System.out.println(sum);//142913828922
	}
	

}
