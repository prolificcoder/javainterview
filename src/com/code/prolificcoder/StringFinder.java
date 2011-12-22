package com.code.prolificcoder;

public class StringFinder {
	enum Direction{up,down,left,right};
	public static void main(String args[]){
		char[][] ar=new char[][]{{'m','s','s','h'},
								 {'a','t','c','i'},
								 {'p','d','a','n'},
								 {'s','a','t','h'},
								};
		String str="sath";
		StringFinder sf=new StringFinder();
		System.out.print(sf.stringFinder(ar,str));
		}

	private boolean stringFinder(char[][] ar, String str) {
		int size=ar.length;
		if(str.length()>size+1) return false;
		int k=0; 
		boolean found=false;
		char[] charArray=str.toCharArray();
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(ar[i][j]==charArray[k])
					found= isMatch(ar,charArray,i,Math.abs((j+1)%size),k+1,Direction.right)||
					isMatch(ar,charArray,Math.abs((i+1)%size),j,k+1,Direction.down)||
					isMatch(ar,charArray,Math.abs((i-1)%size),j,k+1,Direction.up)||
					isMatch(ar,charArray,i,Math.abs((j-1)%size),k+1,Direction.left)||found;
		return found;
	}

	private boolean isMatch(char[][] ar, char[] charArray, int i, int j, int k, Direction dir) {
		int size=ar.length;
		if(k==charArray.length-1)
		{
			if(ar[i][j]==charArray[k]) return true;
			else return false;
		}
		if(ar[i][j]==charArray[k]){
			if(dir==Direction.down)
				i=Math.abs((i+1)%size);	
			else if(dir==Direction.right)
				j=Math.abs((j+1)%size);	
			else if(dir==Direction.left)
				j=Math.abs((j-1)%size);
			else //dir==Direction.up
				i=Math.abs((i-1)%size);
		
			return isMatch(ar,charArray,i,j,k+1,dir);
		}
		
		
		return false;
	}

	
	
}
