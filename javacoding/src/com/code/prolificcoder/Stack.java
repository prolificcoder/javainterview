package com.code.prolificcoder;
//This stack uses an array
public class Stack {

	int ArraySIZE=100;
	Object[] array;
	int size;
	public int getSize(){
		return size;
	}
	Stack(){
		array=new Object[ArraySIZE];
		size=0;
	}
	public void push(Object item) throws Exception{
		if(size>=ArraySIZE)
			resize(ArraySIZE);
		array[size++]=item;
	}
	private void resize(int arraySIZE2) {
		ArraySIZE=arraySIZE2*2;
		Object[] newArray=new Object[ArraySIZE];
		System.arraycopy(array, 0, newArray, 0, arraySIZE2);
		array=newArray;
	}
	public Object pop() throws Exception{
		if(size<=ArraySIZE)
			return array[--size];
		else
			throw new Exception();
	}
}
