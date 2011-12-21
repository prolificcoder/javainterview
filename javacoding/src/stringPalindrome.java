public class stringPalindrome
{
  public static void main (String[] args) throws java.lang.Exception
  {
    // java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
 int num=999;
num++;
while(isPalindrome(num)==false)
{
num++;
}
System.out.println(num);   

  }
public static boolean isPalindrome(int num)
{
 int rev=0;
 int oringalNum=num;
 while(num>0){
 int cur= num%10;
 rev= rev*10+cur;
 num= num/10;
}
return oringalNum-rev==0;
}
}