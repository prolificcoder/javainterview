import java.util.ArrayList;
import java.util.Stack;


public class methods {
	public long stringToLong(String str)
	{
		if(str==null)
			throw new IllegalArgumentException();
		int index = 0;
		int num=0;
		boolean isNeg=false;
		if(str.charAt(0)=='-')
		{
			index=1;
			isNeg= true;
		}
		while(index<str.length())
		{
			if(str.charAt(index)<'0' && str.charAt(index)>'9')
				throw new IllegalArgumentException();
			num = num * 10 + str.charAt(index)-'0';
			index++;
		}
		if(isNeg)
		{
			num=num*-1;
		}
		return num;
		
	}
	
	public String pangrams(char[] str)
	{
		if(str==null)
			throw new IllegalArgumentException();
		int[] charArray= new int[26];
		StringBuilder sb = new StringBuilder();
		ArrayList<Character> chars= new ArrayList<Character>();
		for(char ch : str)
		{
			if (Character.isUpperCase(ch))
				ch=Character.toLowerCase(ch);
			if(Character.isLowerCase(ch))
				charArray[ch-'a']=1;
		}
		for(int i=0;i<charArray.length;i++)
		{
			if(charArray[i]==0)
				sb.append((char) (i+'a'));
		}
		return sb.toString();
	}

	public float suffixEval(String str)
	{
		Stack s = new Stack();
		String[] tokens=str.split("");
		float sum=0;
		int numInt=0;
		for(String token : tokens)
		{
			
			if(token.equals("+")||token.equals("*")||token.equals("/"))
			{
				s.push(token);
			}
			//Assuming no invalid values
			else
			{
				if(numInt==2)
				{
				int num1=Integer.parseInt((String) s.pop());
				int num2= Integer.parseInt((String) s.pop());
				String operand=(String) s.pop();
				//if(operand.equals)
				}
			}
		}
		return (float) 0.0;
	}
	public static void main(String args[])
	{
		TernaryTreeNode four = new TernaryTreeNode(4);
		four = four.insert(3);
		four= four.insert(2);
		four= four.insert(5);
		four= four.insert(4);
		four= four.insert(8);
		four= four.insert(4);
		four= four.insert(2);
		//four= four.insert(4);
		four= (TernaryTreeNode) four.remove(4);
		four = (TernaryTreeNode) four.remove(8);
		four= (TernaryTreeNode) four.remove(4);
		
	}
}
