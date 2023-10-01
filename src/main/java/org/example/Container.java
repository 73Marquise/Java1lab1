package org.example;

import java.util.Arrays;

public class Container<T> {

    /**
     * array for storing container elements
     */
    private Object[] elements;

    /**
     * current container size
     */
    private int size;

    /**
     * constant denoting the initial capacity of the container
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Default constructor
     */
    public Container() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * adds an item to the container
     * @param item element to be added to the container
     */
    public void add(T item) {
        ensureCapacity();
        elements[size] = item;
        size++;
    }

    /**
     * returns the container element at the specified index
     * @param index index of the returned container element
     * @return element at the specified index
     */
    public T get(int index) {
        validateIndex(index);

        return (T) elements[index];
    }

    /**
     * removes an item from the container at the specified index
     * @param index index of the container element to be deleted
     */
    public void remove(int index) {
        validateIndex(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
    }

    /**
     * returns the current array size
     * @return integer value
     */
    public int size() {
        return size;
    }

    /**
     * checks if the container is empty
     * @return true if container is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * checks and increases the capacity of the container if necessary
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * checks if the index is within the allowed range of values
     * @param index index to check
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы контейнера");
        }
    }
}