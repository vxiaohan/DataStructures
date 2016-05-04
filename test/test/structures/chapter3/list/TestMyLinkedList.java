package test.structures.chapter3.list;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import com.structures.chapter3.list.MyLinkedList;

public class TestMyLinkedList {
	private MyLinkedList<String> myLinkedList;
	@Before
	public void setUp() throws Exception {
		myLinkedList = new MyLinkedList<String>();
		myLinkedList.addHead("0");
	}

	@Test
	public void testMyLinkedList() {
		myLinkedList.addHead("0");
	}

	@Test
	public void testRemove() {
		for (int i = 1; i <= 100; i++) {
			myLinkedList.addTail(Integer.toString(i));
		}
		myLinkedList.remove(50);
		assertEquals(100, myLinkedList.size());
		for (int i = 0; i < 100; i++) {
			if (i<50) {
				assertEquals(Integer.toString(i), myLinkedList.get(i));
			}else {
				assertEquals(Integer.toString(i+1), myLinkedList.get(i));
			}
		}
	}

	@Test
	public void testClear() {
		assertEquals(false, myLinkedList.isEmpty());
		assertEquals(1, myLinkedList.size());
		myLinkedList.clear();
		assertEquals(true, myLinkedList.isEmpty());
		assertEquals(0, myLinkedList.size());
	}

	@Test
	public void testSize() {
		assertEquals(1,myLinkedList.size());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false, myLinkedList.isEmpty());
		myLinkedList.clear();
		assertEquals(true, myLinkedList.isEmpty());
	}

	@Test
	public void testAddHead() {
		myLinkedList.clear();
		for (int i = 100; i >= 0; i--) {
			myLinkedList.addHead(Integer.toString(i));
		}
		for (int i = 0; i < 101; i++) {
			assertEquals(Integer.toString(i), myLinkedList.get(i));
		}
	}

	@Test
	public void testAddTail() {
		for (int i = 1; i <= 100; i++) {
			myLinkedList.addTail(Integer.toString(i));
		}
		for (int i = 0; i < 101; i++) {
			assertEquals(Integer.toString(i), myLinkedList.get(i));
		}
	}
	
	@Test
	public void testAddIndex(){
		for (int i = 1; i <= 100; i++) {
			myLinkedList.addTail(Integer.toString(i));
		}
		myLinkedList.addIndex(50, "1000");
		assertEquals(102, myLinkedList.size());
		for (int i = 0; i < 102; i++) {
			if (i<50) {
				assertEquals(Integer.toString(i), myLinkedList.get(i));
			} else if(i==50){
				assertEquals(Integer.toString(1000), myLinkedList.get(i));
			}else {
				assertEquals(Integer.toString(i-1), myLinkedList.get(i));
			}
		}
	}
	
	@Test
	public void testGet() {
		for (int i = 1; i <= 100; i++) {
			myLinkedList.addTail(Integer.toString(i));
		}
		for (int i = 0; i < 101; i++) {
			assertEquals(Integer.toString(i), myLinkedList.get(i));
		}	
	}
	
	@Test
	public void testIterator(){
		for (int i = 1; i <= 100; i++) {
			myLinkedList.addTail(Integer.toString(i));
		}
		int i =0;
		for (Iterator iterator = myLinkedList.iterator(); iterator.hasNext();) {
			assertEquals(Integer.toString(i), iterator.next());
			i++;
		}
	}
}
