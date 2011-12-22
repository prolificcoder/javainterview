

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runner r= new Runner();
		int[] ar = new int[] {2,3,4,5,2,3,4,5};
		//ar=r.removeDuplicates(ar);
		//for(int i:ar)
		//	System.out.println(i);
		//String str="_  this is a new string  _";
		//str=r.reverseWords(str);
		//System.out.print(str);
		String str="421";
		System.out.println(r.stringToLong("-234L"));
		
	}
	//Input         Output
	//12345         12345
	//123L          123
	//123.42L       NumberFormatExpection
	//123.L         NumberFormatExpection
	//abA-$123      NumberFormatExpection
	//-25           -25
	//-0             0
	//0              0
	//9223372036854775807    9223372036854775807
	//-9223372036854775808   -9223372036854775808
	//-9223372036854775809   9223372036854775807 (overflows)
	//9223372036854775808    -9223372036854775808 (underflows) 
	//Input can have L at the end but not l (small letter)
	private long stringToLong(String str) throws NumberFormatException{
		try{
			if(!str.matches("^-?\\d+L?$"))
				throw new NumberFormatException();
			long num = 0;
			boolean isNeg=false;
			if(str.startsWith("-")){
				isNeg=true;
				str=str.substring(1);
			}
			if(str.endsWith("L"))
				str=str.substring(0,str.length()-1);	
			char[] charArray=str.toCharArray();
			for(int i=0;i<charArray.length;i++)
			{
				num=num*10;
				num+=charArray[i]-'0';
			}
			if(isNeg)
				num=num*-1;
			return num;
		}
		catch(NumberFormatException ne){
			throw ne;
		}		
	}

	private String reverseWords(String str) {
		if(str.length()<=1)
			return str;
		int len=str.length();
		char[] charArray=str.toCharArray();
		charArray=reverse(charArray,0,len-1);
		int start=0,end=1;
		while(end<len)
		{
			while(end<len && charArray[end] !=' ')
				end++;
			reverse(charArray, start, end-1);
			start=++end;
		}
		return new String(charArray);
	}
	private char[] reverse(char[] charArray,int start,int end)
	{
		while(start<end)
		{
			char c=charArray[start];
			charArray[start]=charArray[end];
			charArray[end]=c;
			start++;end--;
		}
		return charArray;
	}

	private int[] removeDuplicates(int[] ar) {
		int arEnd=ar.length-1;
		for(int i=0;i<arEnd;i++)
			for(int j=i+1;j<=arEnd;j++)
			{
				if(ar[i]==ar[j])
				{
					swap(ar, arEnd, j);
					arEnd--;
				}
			}
 		int[] ar2=new int[arEnd+1];
		System.arraycopy(ar, 0, ar2, 0, arEnd+1);
		return ar2;
	}

	private void swap(int[] ar, int i, int j) {
		int temp=ar[j];
		ar[j]=ar[i];
		ar[i]=temp;
	}

}
