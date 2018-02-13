package geometric.share;

import java.util.*;
import geometric.share.base.Shape;

public class ShapeList implements List<Shape> {

	private Shape[] elements;
	private int size;
	private int capacityIncrement;
	private static final int INVALID_INDEX=-1;
	private static final int DEFAULT_CAPACITY = 100;

	public ShapeList() {
        capacityIncrement = 0;
        elements = (Shape[]) new Object[DEFAULT_CAPACITY];
    }

	public ShapeList(int capacity) {
        capacityIncrement = 0;
        elements = (Shape[]) new Object[capacity];
    }

	public int capacity() {
		return elements.length;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return elements.length == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Shape e) {
        if (size == elements.length) {
        	int capacity = elements.length * 2;
            elements = Arrays.copyOf(elements, capacity);
        }
        elements[size++] = e;
        return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Shape> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Shape> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	//@SuppressWarnings("unchecked")
	@Override
	public Shape get(int index) {
        if (index >= this.size || index <0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        return elements[index];
	}

	@Override
	public Shape set(int index, Shape element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Shape element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Shape> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Shape> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shape> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Shape> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
