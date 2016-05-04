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
		fail("Not yet implemented");
	}

}
