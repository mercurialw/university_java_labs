package org.example;

public class MyContainer<T> {
    private T[] array;
    private int capacity;
    private int size;

    public MyContainer(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public MyContainer() {new MyContainer(10);}

    public int getSize() {return size;}

    public int getCapacity() {return capacity;}

    public void add(T obj) {
        array[size] = obj;
        size++;
        if (size > 0.75 * capacity) {
            addPlace();
        }
    }

    private void addPlace() {
        int newCapacity = capacity*2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = newCapacity;
        array = newArray;
    }

    public boolean contains(T obj) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public void remove(T obj) {
        if (contains(obj)) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(obj)) {
                    while (i < size - 1) {
                        array[i] = array[i + 1];
                        i++;
                    }
                    array[i] = null;
                    size--;
                    return;
                }
            }
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else return null;
    }
}
