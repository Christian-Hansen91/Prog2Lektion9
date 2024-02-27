package opgave02.models;

public class ArrayBag<E> implements Bag<E> {
    // the array to hold the items
    private final E[] items;
    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /**
     * Create a bag with the given capacity.
     */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /**
     * Create a bag with capacity 10.
     */
    public ArrayBag() {
        this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        boolean entryAdded = false;
        if (!isFull()) {
            items[size] = newEntry;
            size++;
            entryAdded = true;
        }
        return entryAdded;
    }

    @Override
    public E remove() {
        E o = null;
        if (size > 0) {
            o = items[size - 1];
            items[size - 1] = null;
            size--;
        }
        return o;
    }

    @Override
    public boolean remove(E anEntry) {
        boolean removed = false;
        int index = 0;
        while (!removed && index < size) {
            if (items[index].equals(anEntry)) {
                removed = true;
                for (int i = index; i < size; i++) {
                    items[i] = items[i + 1];
                }
                size--;
            } else {
                index++;
            }
        }
        return removed;
    }

    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            items[index] = null;
        }
        size = 0;
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int freq = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].equals(anEntry)) {
                freq++;
            }
        }
        return freq;
    }

    @Override
    public boolean contains(E anEntry) {
        boolean found = false;
        int index = 0;
        while (!found && index < size) {
            if (items[index].equals(anEntry)) {
                found = true;
            } else {
                index++;
            }
        }
        return found;
    }

    @Override
    public E[] toArray() {
        E[] newArray = (E[]) new Object[size + 1];
        for (int index = 0; index <= size; index++) {
            newArray[index] = items[index];
        }
        return newArray;
    }
}