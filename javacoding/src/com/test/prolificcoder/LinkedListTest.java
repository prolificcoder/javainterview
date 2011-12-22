package com.test.prolificcoder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.code.prolificcoder.LinkedList;

public class LinkedListTest {

	LinkedList ll;int[] items;
	int[] items2;
	int[] items3;
	int[] items4;
	int[] items5;
	@Before
	public void setUp(){
		items=new int[]{3,5,4,9};
		items2=new int[]{3,8,5,8,13};
		items3=new int[]{8,5,8,13};
		items4=new int[]{3,8,5,8};
		items5=new int[]{8,8,8,8};
	}
	@Test
	public void testIsEmtpyOnEmptyList() {
		ll=new LinkedList();
		assertTrue(ll.isEmtpy()==true);
	}
	@Test
	public void testIsEmtpyOnNonEmptyList() {
		ll=new LinkedList(items);
		assertTrue(ll.isEmtpy()==false);
	}

	@Test
	public void testInsertAtFirstEmptyList() {
		ll=new LinkedList();
		assertTrue(ll.isEmtpy()==true);
		ll.insertAtFirst(3);
		assertTrue(ll.size()==1);
	}
	@Test
	public void testInsertAtFirstNonEmptyList() {
		ll=new LinkedList(items);
		ll.insertAtFirst(8);
		assertTrue(ll.head.data.equals(8));
	}

	@Test
	public void testInsertAtLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFirst(){
		int pos=0;
		ll=new LinkedList(items);
		ll.remove(pos);
		assertTrue(ll.head.data.equals(4));
		assertTrue(ll.size()==3);
	}
	
	@Test
	public void testRemoveLast() {
		ll=new LinkedList(items);
		ll.remove(ll.size()-1);
		assertTrue(ll.size()==3);
		assertTrue(ll.head.data.equals(9));
		assertTrue(ll.head.next.data.equals(4));
		assertTrue(ll.head.next.next.data.equals(5));
	}
	@Test
	public void testRemoveMiddle() {
		ll=new LinkedList(items);
		ll.remove(2);
		assertTrue(ll.size()==3);
		assertTrue(ll.head.data.equals(9));
		assertTrue(ll.head.next.data.equals(4));
		assertTrue(ll.head.next.next.data.equals(3));
	}
	@Test
	public void testRemoveNonExistant() {
		ll=new LinkedList(items);
		ll.remove(12);
		assertTrue(ll.size()==4);
		assertTrue(ll.head.data.equals(9));
		assertTrue(ll.head.next.data.equals(4));
		assertTrue(ll.head.next.next.data.equals(5));
		assertTrue(ll.head.next.next.next.data.equals(3));
	}

	@Test
	public void testContainsPositive() {
		ll=new LinkedList(items);
		assertTrue(ll.Contains(3));
	}
	@Test
	public void testContainsNegative() {
		ll=new LinkedList(items);
		assertFalse(ll.Contains(13));
	}

	@Test
	public void testRemoveObjectMiddle() {
		ll=new LinkedList(items);
		assertTrue(ll.removeObject(4));
		assertTrue(ll.size()==3);
		assertTrue(ll.head.data.equals(9));
		assertTrue(ll.head.next.data.equals(5));
		assertTrue(ll.head.next.next.data.equals(3));
		assertTrue(ll.head.next.next.next==null);
	}
	@Test
	public void testRemoveObjectFirst() {
		ll=new LinkedList(items);
		assertTrue(ll.removeObject(9));
		assertTrue(ll.size()==3);
		assertTrue(ll.head.data.equals(4));
		assertTrue(ll.head.next.data.equals(5));
		assertTrue(ll.head.next.next.data.equals(3));
		assertTrue(ll.head.next.next.next==null);
	}
	@Test
	public void testRemoveObjectLast() {
		ll=new LinkedList(items);
		assertTrue(ll.removeObject(3));
		assertTrue(ll.size()==3);
		assertTrue(ll.head.data.equals(9));
		assertTrue(ll.head.next.data.equals(4));
		assertTrue(ll.head.next.next.data.equals(5));
		assertTrue(ll.head.next.next.next==null);
	}
	@Test
	public void testRemoveObjectNonExistant() {
		ll=new LinkedList(items);
		assertFalse(ll.removeObject(23));
		assertTrue(ll.size()==4);
		assertTrue(ll.head.data.equals(9));
		assertTrue(ll.head.next.data.equals(4));
		assertTrue(ll.head.next.next.data.equals(5));
		assertTrue(ll.head.next.next.next!=null);
	}

	@Test
	public void testRemoveAllObjectMiddle() {
		ll=new LinkedList(items2);
		//13->8->5->8->3 
		assertTrue(ll.removeAllObject(8));
		assertTrue(ll.size()==3);
		assertTrue(ll.head.data.equals(13));
		assertTrue(ll.head.next.data.equals(5));
		assertTrue(ll.head.next.next.data.equals(3));
		assertTrue(ll.head.next.next.next==null);
	}
	@Test
	public void testRemoveAllObjectLast() {
		ll=new LinkedList(items3);
		//8->5->8->13
		assertTrue(ll.removeAllObject(8));
		assertTrue(ll.size()==2);
		assertTrue(ll.head.data.equals(13));
		assertTrue(ll.head.next.data.equals(5));
		assertTrue(ll.head.next.next==null);
	}
	@Test
	public void testRemoveAllObjectFirst() {
		ll=new LinkedList(items4);
		//3->8->5->8
		assertTrue(ll.removeAllObject(8));
		assertTrue(ll.size()==2);
		assertTrue(ll.head.data.equals(5));
		assertTrue(ll.head.next.data.equals(3));
		assertTrue(ll.head.next.next==null);
	}
	@Test
	public void testRemoveAllObjectSameValues() {
		ll=new LinkedList(items5);
		//3->8->5->8
		assertTrue(ll.removeAllObject(8));
		assertTrue(ll.size()==0);
		assertTrue(ll.head==null);
	}

	@Test
	public void testReverse() {
		ll=new LinkedList(items);
		ll=ll.reverse();
		assertTrue(ll.head.data.equals(3));
		assertTrue(ll.head.next.data.equals(5));
		assertTrue(ll.head.next.next.data.equals(4));
		assertTrue(ll.head.next.next.next.data.equals(9));
	}

}
