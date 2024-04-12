package com.aston.homework.lesson4;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        array = new Object[initialCapacity];
        size = 0;
    }

    public MyArrayList(Collection<E> collection) {
        array = collection.toArray();
        size = array.length;
        if (size == 0) {
            array = new Object[DEFAULT_CAPACITY];
        }
    }


    public void add(E element) {
        ensureCapacity(size + 1);
        array[size++] = element;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E) array[index];
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null;
        return removedElement;
    }

    public void addAll(MyArrayList<E> collection) {
        ensureCapacity(size + collection.size);
        System.arraycopy(array, 0, array, size, collection.size);
        size += collection.size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
