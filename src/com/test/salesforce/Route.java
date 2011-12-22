package com.test.salesforce;

public class Route {
	char prev;
	int[][] grid;
	Route(City c)
	{
		prev='\0';
		grid=c.getGrid();
	}
	public Position moveRoute(String str, Position start) throws Exception
	{
		if(str==null||str.length()==0) 
			return start;
		else
		{
			for(char c:str.toCharArray())
			{
				if(c=='L'||c=='R'||c=='U'||c=='D')
					 start= move(c,start);
				else if(c=='M')
					 start=move(start);
				else
					throw new Exception();
			}
		}
		return start;
	}
	public Position move(char c,Position cur) throws Exception
	{
		prev=c;
		switch(c)
		{
		case 'L':
		{
			if(cur.getI()-1<0)
				throw new Exception();
			else
			{
				cur.setIJ(cur.getI()-1, cur.getJ());
				return cur;
			}				
		}
		case 'R':
		{
			if(cur.getI()+1>grid[0].length-1)
				throw new Exception();
			else
			{
				cur.setIJ(cur.getI()+1, cur.getJ());
				return cur;
			}				
		}
		case 'U':
		{
			if(cur.getJ()-1<0)
				throw new Exception();
			else
			{
				cur.setIJ(cur.getI(), cur.getJ()-1);
				return cur;
			}				
		}
		case 'D':
		{
			if(cur.getJ()+1>grid[1].length-1)
				throw new Exception();
			else
			{
				cur.setIJ(cur.getI(), cur.getJ()+1);
				return cur;
			}				
		}		
		}
		return cur;
	}
	public Position move(Position cur)throws Exception
	{
		if(prev=='\0')
			throw new Exception();
		return move(prev,cur);
	}

}
