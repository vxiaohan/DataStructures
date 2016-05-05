package com.structures.chapter4.tree;


public class BinarySearchTree<T extends Comparable<? super T>>  {
	private BinaryNode<T> rootNode;
	
	public BinarySearchTree(){
		this.rootNode = null;
	}
	public void clear(){
		this.rootNode = null;
	}
	public boolean isEmpty(){
		return rootNode==null;
	}
	public void insert(T content){
		if (rootNode == null) {
			rootNode = insert(content, rootNode, null);
		}
		else{
			insert(content,rootNode, null);
		}
	}
	private BinaryNode<T> insert(T content, BinaryNode<T> binaryNode, BinaryNode<T> fatherNode){
		//递归终止条件
		if (binaryNode == null) {
			binaryNode = new BinaryNode<T>(content);
			if (fatherNode != null) {
				if (content.compareTo(fatherNode.content)<0) {
					fatherNode.leftNode = binaryNode;
				}else{
					fatherNode.rightNode = binaryNode;
				}
			}
			return binaryNode;
		}
		//进行递归
		int compareResult = content.compareTo(binaryNode.content);
		
		if (compareResult < 0) {
			return insert(content, binaryNode.leftNode, binaryNode);
		} else if(compareResult > 0){
			return insert(content, binaryNode.rightNode, binaryNode);
		}else {
			//比较结果为0的话也会终止
		}
		return binaryNode;
	}
	public boolean contains(T content){
		return contains(content, rootNode);
	}
	private boolean contains(T content, BinaryNode<T> binaryNode){
		if (binaryNode == null) {
			return false;
		}
		int compareResult = content.compareTo(binaryNode.content);
		if (compareResult < 0) {
			return contains(content, binaryNode.leftNode);
		} else if (compareResult > 0) {
			return contains(content, binaryNode.rightNode);
		}else{
			return true;
		}
	}
	public T findMax(){
		return findMax(rootNode);
	}
	private T findMax(BinaryNode<T> startNode){
		BinaryNode<T> node = startNode;
		while(node!=null){
			if (node.rightNode==null) {
				return node.content;
			}else{
				node = node.rightNode;
			}
		}
		return null;
	}
	public T findMin(){
		return findMin(rootNode);
	}
	private T findMin(BinaryNode<T> startNode){
		BinaryNode<T> node = startNode;
		while(node!=null){
			if (node.leftNode==null) {
				return node.content;
			}else{
				node = node.leftNode;
			}
		}
		return null;
	}
	public void remove(T content){
		remove(content, rootNode, null);
	}
	private BinaryNode<T> remove(T content, BinaryNode<T> node, BinaryNode<T> fatherNode){
		if (node == null) {
			return node;
		}
		int compareResult = content.compareTo(node.content);
		if (compareResult < 0) {
			remove(content,node.leftNode, node);
		}else if (compareResult > 0) {
			remove(content, node.rightNode, node);
		}else {
			if (node.leftNode == null && node.rightNode == null) {
				if (node != rootNode) {
					if (fatherNode.leftNode != null && fatherNode.leftNode == node) {
						fatherNode.leftNode = null;
					}else if (fatherNode.rightNode != null && fatherNode.rightNode == node) {
						fatherNode.rightNode = null;
					}
				}else{
					rootNode = null;
				}
			}else if (node.leftNode == null) {
				if (node != rootNode) {
					if (fatherNode.leftNode != null && fatherNode.leftNode == node) {
						fatherNode.leftNode = node.rightNode;
					}else if (fatherNode.rightNode != null && fatherNode.rightNode == node) {
						fatherNode.rightNode = node.rightNode;
					}
				}else {
					rootNode = node.rightNode;
				}
			}else if(node.rightNode == null){
				if (node != rootNode) {
					if (fatherNode.leftNode != null && fatherNode.leftNode == node) {
						fatherNode.leftNode = node.leftNode;
					}else if (fatherNode.rightNode != null && fatherNode.rightNode == node) {
						fatherNode.rightNode = node.leftNode;
					}
				}else {
					rootNode = node.leftNode;
				}
			}else {
				BinaryNode<T> minNodeAtRight = node.rightNode;
				BinaryNode<T> minNodeFather = node;
				while(minNodeAtRight!=null){
					if (minNodeAtRight.leftNode==null) {
						break;
					}else{
						minNodeFather = minNodeAtRight;
						minNodeAtRight = minNodeAtRight.leftNode;
					}
				}
				if (minNodeAtRight == minNodeFather.leftNode) {
					minNodeFather.leftNode = minNodeAtRight.rightNode;
					minNodeAtRight.leftNode = node.leftNode;
					minNodeAtRight.rightNode = node.rightNode;
				}
				if (minNodeAtRight == minNodeFather.rightNode) {
					minNodeAtRight.leftNode = node.leftNode;
				}
				if (node == rootNode) {
					rootNode = minNodeAtRight;
				}else{
					if (node == fatherNode.leftNode) {
						fatherNode.leftNode = minNodeAtRight;
					}
					if (node == fatherNode.rightNode) {
						fatherNode.rightNode =minNodeAtRight;
					}
				}
				
			}
		}
		return node;
	}
	private static class BinaryNode<T>{
		//public BinaryNode<T> fatherBinaryNode;
		public BinaryNode<T> leftNode;
		public BinaryNode<T> rightNode;
		public T content;
		
		public BinaryNode(T content) {
			// TODO Auto-generated constructor stub
			this(content, null, null);
		}
		private BinaryNode(T content, BinaryNode<T> leftNode, BinaryNode<T> rightNode){
			this.content = content;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
}
