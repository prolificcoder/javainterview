import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class pangrams {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		pangrams s = new pangrams();
		for(int i=0;i<36;i++)
			System.out.print("b");
		BufferedReader in = new BufferedReader(new FileReader(
				args[0]));
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			String result=s.pangrams(sc.nextLine().toCharArray());
			if (result.length()==0)
				System.out.println("NULL");
			else
			 System.out.println(result);
		}
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

}
