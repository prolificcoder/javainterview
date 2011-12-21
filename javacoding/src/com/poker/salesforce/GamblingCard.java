package com.poker.salesforce;

public class GamblingCard extends Card {

	Suite suite;
	Value value;

	GamblingCard(Suite suite,Value value){
		this.suite= suite;
		this.value= value;
	}
	@Override
	public String toString(){
		return suite.name()+" "+value.name();
	}
	@Override
	public int compareTo(Card otherCard) {
		if (!(otherCard instanceof GamblingCard))  
	      {  
	         throw new ClassCastException("A Person object expected.");  
	      }  
	       GamblingCard theOtherCard = (GamblingCard) otherCard;  
	   
		if (this.suite == ((GamblingCard) theOtherCard).suite &&
			this.value == ((GamblingCard) theOtherCard).value)
			return 0;
		else
			return -1;
	}
	
	   @Override  
	   public boolean equals(Object obj)  
	   {  
	      if (obj == null)  
	      {  
	         return false;  
	      }  
	      if (getClass() != obj.getClass())  
	      {  
	         return false;  
	      }  
	      final GamblingCard other = (GamblingCard) obj;  
	      if (this.suite == null ? other.suite != null : !this.suite.equals(other.suite))  
	      {  
	         return false;  
	      }  
	      if (this.value == null ? other.value != null : !this.value.equals(other.value))  
	      {  
	         return false;  
	      }  
	      return true;  
	   }  
	  
	   @Override  
	   public int hashCode()  
	   {  
	      int hash = 5;  
	      hash = 59 * hash + (this.suite != null ? this.suite.hashCode() : 0);  
	      hash = 59 * hash + (this.value != null ? this.value.hashCode() : 0);  
	      return hash;  
	   }

}
