package com.code.prolificcoder;

public class Graph {
	
	int vCount,eCount;
	boolean isDirected;
	class Node{
		int v;
		Node next;
		Node(int v,Node next){
			this.v=v;
			this.next=next;
		}
	}
	Node[] adjList;
	Graph(int vCount,boolean isDirected){
		this.vCount=vCount;
		this.isDirected=isDirected;
		eCount=0;
		adjList=new Node[vCount];
	}
	
}
