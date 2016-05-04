package com.structures.chapter3.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements  Iterable<AnyType>{
	public static final int DEFAULT_CAPACITY = 10;
	private int size;
	private int capacity;
	private AnyType [] items;
	
	public MyArrayList(){
		clear();
	}
	public void trimToSize(){
		ensureCapacity(size);
	}
	public int size(){
		return size;
	}
	public void ensureCapacity(int newCapacity){
		if (newCapacity < capacity) {
			return;
		}
		AnyType[] old = items;
		items = (AnyType[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			items[i] = old[i];
		}
		capacity = newCapacity;
	}
	public void clear(){
		size = 0;
		capacity = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	public boolean isEmpty(){
		return size==0;
	}
	public boolean add(AnyType x){
		return add(size(), x);
	}
	public AnyType get(int index){
		if (index<0 || index>=size()) {
			throw new IndexOutOfBoundsException();
		}
		return items[index];
	}
	public AnyType set(int index, AnyType newVal){
		if (index<0 || index>=size()) {
			throw new IndexOutOfBoundsException();
		}
		AnyType oldAnyType = items[index];
		items[index] = newVal;
		return oldAnyType;
	}
	public boolean add(int index, AnyType x){
		if (size == capacity) {
			ensureCapacity(capacity*2+1);
		}
		if (index>size()||index<0) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = size; i > index; i--) {
			items[i] = items[i-1];
		}
		items[index] = x;
		size++;
		return true;
	}
	public void remove(int index){
		if (index<0 || index>=size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = index; i < size(); i++) {
			items[i] = items[i+1];
		}
		size--;
	}
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	private class ArrayListIterator implements Iterator<AnyType>{
		private int current = 0;
		public boolean hasNext(){
			return current < size();
		}
		public AnyType next(){
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return items[current++];
		}
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
}
