package test.structures.chapter4.tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.structures.chapter3.list.MyArrayList;
import com.structures.chapter4.tree.BinarySearchTree;

public class TestBinarySearchTree {
	private BinarySearchTree<String> binarySearchTree;
	@Before
	public void setUp() throws Exception {
		binarySearchTree = new BinarySearchTree<String>();
	}

	@Test
	public void testBinarySearchTree() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		binarySearchTree.clear();
		assertEquals(true, binarySearchTree.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, binarySearchTree.isEmpty());
	}

	@Test
	public void testInsert() {
		assertEquals(true, binarySearchTree.isEmpty());
		binarySearchTree.insert("1");
		assertEquals(false, binarySearchTree.isEmpty());
	}
	@Test
	public void testContains(){
		assertEquals(false, binarySearchTree.contains("1"));
		binarySearchTree.insert("50");
		binarySearchTree.insert("2");
		assertEquals(true, binarySearchTree.contains("50"));
		assertEquals(true, binarySearchTree.contains("2"));
		assertEquals(false, binarySearchTree.contains("3"));
		for (int i = 0; i < 100; i++) {
			binarySearchTree.insert(Integer.toString(i));
		}
		for (int i = 0; i < 100; i++) {
			assertEquals(true, binarySearchTree.contains(Integer.toString(i)));
		}
	}
	
	@Test
	public void testFindMax(){
		binarySearchTree.insert("50");
		for (int i = 0; i < 100; i++) {
			binarySearchTree.insert(Integer.toString(i));
		}
		assertEquals("99", binarySearchTree.findMax());
	}
	@Test
	public void testFindMin(){
		binarySearchTree.insert("50");
		for (int i = 0; i < 100; i++) {
			binarySearchTree.insert(Integer.toString(i));
		}
		assertEquals("0", binarySearchTree.findMin());
	}
	@Test
	public void testRemove(){
		binarySearchTree.insert("50");
		assertEquals(true, binarySearchTree.contains("50"));
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 100; i++) {
				int k = 100 - i;
				binarySearchTree.insert(Integer.toString(i));
				binarySearchTree.insert(Integer.toString(k));
			}
			for (int i = 0; i < 100; i++) {
				assertEquals(true, binarySearchTree.contains(Integer.toString(i)));
			}
			
			binarySearchTree.remove(Integer.toString(j));
			for (int i = 0; i < 100; i++) {
				if (i != j) {
					assertEquals(true, binarySearchTree.contains(Integer.toString(i)));
				} else {
					assertEquals(false, binarySearchTree.contains(Integer.toString(i)));
				}
			}
		}
	}
	@Test
	public void testPreOrderPrint(){
		binarySearchTree.insert("5");
		assertEquals(true, binarySearchTree.contains("5"));
			for (int i = 0; i < 10; i++) {
				//int k = 100 - i;
				binarySearchTree.insert(Integer.toString(i));
				//binarySearchTree.insert(Integer.toString(k));
			}
			for (int i = 0; i < 10; i++) {
				assertEquals(true, binarySearchTree.contains(Integer.toString(i)));
			}
			binarySearchTree.preOrderPrint();
	}
}
