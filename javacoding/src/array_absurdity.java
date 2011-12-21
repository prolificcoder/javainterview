import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class array_absurdity {

	public static void main(String[] args) throws FileNotFoundException {
		array_absurdity s = new array_absurdity();		
		BufferedReader in = new BufferedReader(new FileReader(
				args[0]));
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			String str= sc.nextLine();
			if(str.length()!=0)				
			{
			long duplicate=s.findDuplicate(convertToInts(str));
			System.out.println(duplicate);
			}
		}		
	}
	
	private static int[] convertToInts(String nextLine) {		
		String[] str = nextLine.substring(nextLine.indexOf(';')+1).split(",");
		int intarray[] = new int[str.length];
		for (int i = 0; i < str.length; i++) {
		intarray[i] = Integer.parseInt(str[i]);		
		}		
		return intarray;
	}
	
	public long findDuplicate(int numbers[])
	{
		long sum=0;
		long n=numbers.length-1;
		long expectedSum= (n*(n-1))/2;
		for(int i=0;i<numbers.length;i++){
			sum +=numbers[i];
		}
		return sum-expectedSum;
	}
}
