package test.structures.chapter3.list;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.structures.chapter3.list.MyArrayList;

public class TestMyArrayList {
	
	private MyArrayList<String> myArrayList;
	@Before
	public void setUp() throws Exception {
		myArrayList = new MyArrayList<String>();
		myArrayList.add(Integer.toString(0));
	}

	@Test
	public void testMyArrayList() {
		assertEquals(1, myArrayList.size());
	}


	@Test
	public void testSize() {
		assertEquals(1, myArrayList.size());
	}

	@Test
	public void testClear() {
		myArrayList.clear();
		assertEquals(true, myArrayList.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false, myArrayList.isEmpty());
	}

	@Test
	public void testAddAnyType() {
		for (int i = 1; i <= 100; i++) {
			myArrayList.add(Integer.toString(i));
		}
		assertEquals(101, myArrayList.size());
		assertEquals("1", myArrayList.get(1));
	}

	@Test
	public void testGet() {
		for (int i = 1; i <= 100; i++) {
			myArrayList.add(Integer.toString(i));
		}
		assertEquals(101, myArrayList.size());
		for (int i = 0; i < 101; i++) {
			assertEquals(Integer.toString(i), myArrayList.get(i));
		}
	}

	@Test
	public void testSet() {
		for (int i = 1; i <= 100; i++) {
			myArrayList.add(Integer.toString(i));
		}
		myArrayList.set(50, Integer.toString(1000));
		assertEquals(101, myArrayList.size());
		for (int i = 0; i < 101; i++) {
			if (i!=50) {
				assertEquals(Integer.toString(i), myArrayList.get(i));
			}
			else {
				assertEquals(Integer.toString(1000), myArrayList.get(i));
			}
		}
	}

	@Test
	public void testRemove() {
		for (int i = 1; i <= 100; i++) {
			myArrayList.add(Integer.toString(i));
		}
		myArrayList.remove(50);
		assertEquals(100, myArrayList.size());
		for (int i = 0; i < 100; i++) {
			if (i<50) {
				assertEquals(Integer.toString(i), myArrayList.get(i));
			}
			else {
				assertEquals(Integer.toString(i+1), myArrayList.get(i));
			}
		}
	}

	@Test
	public void testIterator() {
		for (int i = 1; i <= 100; i++) {
			myArrayList.add(Integer.toString(i));
		}
		int i = 0;
		for (Iterator iterator = myArrayList.iterator(); iterator.hasNext();) {
			assertEquals(Integer.toString(i), (String)iterator.next());
			i++;
		}
	}

}
