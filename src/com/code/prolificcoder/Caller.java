package com.code.prolificcoder;


public class Caller {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Caller c=new Caller();
		//System.out.print(c.convertToRoman(1));
		
		
	}
	class Romans{
		int deciValue;
		char value;
		Romans(int deciValue, char value){
			this.deciValue=deciValue;
			this.value=value;
		}
	}
	public String convertToRoman(int num)
	{
		StringBuffer sb=new StringBuffer();
		Romans[] romans = getRomans();
		for(int i=0;i<romans.length;i++)
		{
			int count=num/romans[i].deciValue;
			num=num-(romans[i].deciValue*count);
			while(count !=0){
				sb.append(romans[i].value);
				count--;
			}
		}
		return sb.toString();
	}
	private Romans[] getRomans() {
		Romans roman1=new Romans(1000,'M');
		Romans roman2=new Romans(500,'D');
		Romans roman3=new Romans(100,'C');
		Romans roman4=new Romans(50,'L');
		Romans roman5=new Romans(10,'X');
		Romans roman6=new Romans(5,'V');
		Romans roman7=new Romans(1,'I');
		Romans[] romans=new Romans[]{roman1,roman2,roman3,roman4,roman5,roman6,roman7};
		return romans;
	}

}
