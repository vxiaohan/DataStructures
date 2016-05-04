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
		
	}
	private static class BinaryNode<T>{
		public BinaryNode<T> fatherBinaryNode;
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
