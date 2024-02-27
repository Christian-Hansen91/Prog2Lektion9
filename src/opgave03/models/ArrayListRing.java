package opgave03.models;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListRing<T> implements Ring<T>{
    private final ArrayList<T> ringArrayList = new ArrayList<>();
    private int index;

    public ArrayListRing() {
        index = 0;
    }

    @Override
    public void advance() {
        if (index == ringArrayList.size() - 1) {
            index = 0;
        } else {
            this.index++;
        }
    }
    @Override
    public T getCurrentItem() {
        return ringArrayList.get(index);
    }

    @Override
    public void add(Object item) {
        ringArrayList.add((T) item);
    }

    @Override
    public boolean removeItem(Object item) {
        boolean removed = ringArrayList.remove((T) item);
        if (removed && index == ringArrayList.size()) {
            index--;
        }
        return removed;
    }

    @Override
    public T removeCurrentItem() {

        T obj = getCurrentItem();
        boolean removed = ringArrayList.remove(ringArrayList.get(index));
        if (removed && index == ringArrayList.size()) {
            index--;
        }
        return obj;
    }

    @Override
    public int size() {
        return ringArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return ringArrayList.isEmpty();
    }
}
