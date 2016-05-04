package com.structures.chapter3.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	
	private int size;
	private Node<AnyType> beginNode;
	private Node<AnyType> endNode;
	private int modCount = 0;
	
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		clear();
	}
	private void remove(Node<AnyType> node){
		node.preNode.nextNode = node.nextNode;
		node.nextNode.preNode = node.preNode;
		size--;
	}
	public void remove(int index){
		remove(getNode(index));
	}
	public void clear(){
		beginNode = new Node<AnyType>(null, null, null);
		endNode = new Node<AnyType>(null, beginNode, null);
		beginNode.nextNode = endNode;
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	private Node<AnyType> getNode(int index){
		return getNode(index, 0, size-1);
	}
	private Node<AnyType> getNode(int index, int lower, int upper){
		Node<AnyType> node;
		if (index<lower || index > upper) {
			throw new IndexOutOfBoundsException();
		}
		if (index < size/2) {
			node = beginNode.nextNode;
			for (int i = 0; i < index; i++) {
				node = node.nextNode;
			}
		}
		else {
			node = endNode.preNode;
			for (int i = size-1; i > index; i--) {
				node = node.preNode;
			}
		}
		return node;
	}
	public void addHead(AnyType x){
		addAfter(beginNode, x);
	}
	public void addTail(AnyType x){
		addBefore(endNode, x);
	}
	public void addIndex(int index, AnyType x){
		if (index == 0) {
			addHead(x);
		}else if (index == size()-1) {
			addTail(x);
		}else {
			addBefore(getNode(index), x);
		}
	}
	private void addBefore(Node<AnyType> p, AnyType x){
		Node<AnyType> node = new Node<AnyType>(x, p.preNode, p);
		node.preNode.nextNode = node;
		p.preNode = node;
		size++;
	}
	private void addAfter(Node<AnyType> p, AnyType x){
		Node<AnyType> node = new Node<AnyType>(x, p, p.nextNode);
		p.nextNode.preNode = node;
		p.nextNode = node;
		size++;
	}
	
	public AnyType get(int index){
		return getNode(index).data;
	}
	private class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> preNode;
		public Node<AnyType> nextNode;
		public Node(AnyType data, Node<AnyType> pre, Node<AnyType> next) {
			this.data = data;
			this.preNode = pre;
			this.nextNode = next;
		}
	}
	@Override
	public Iterator<AnyType> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<AnyType>{
		private Node<AnyType> current = beginNode.nextNode;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current != endNode;
		}
		public AnyType next(){
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			AnyType nextItem = current.data;
			current = current.nextNode;
			okToRemove = true;
			return nextItem;
		}
	}

}
