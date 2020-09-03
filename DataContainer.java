package HW9;

import java.util.Comparator;

public class DataContainer <T> {
    private T[] container;

    public DataContainer(T[] container) {
        this.container = container;
    }

    public int add(T item) {
        int index = 0;
        for (int i = 0; i < container.length; i++) {
            if (container[i] == null) {
                container[i] = item;
                index = i;
                break;
            } else if (i == container.length - 1) {
                T[] newContainer = (T[]) new Object[container.length + 1];
                System.arraycopy(container, 0, newContainer, 0, container.length);
                container = newContainer;
                container[++i] = item;
                index = i;
                break;
            }
        }
        return index;
    }

    public T get(int index) {
        return container[index];
    }

    public T[] getItems() {
        return container;
    }

    public boolean delete(int index) {
        try {
            for (int i = 0; i < container.length; i++) {
                if (i == index) {
                    deleteItem(i);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean delete(T item) {
        try {
           for (int i = 0; i < container.length; i++) {
                if (container[i] == item) {
                    deleteItem(i);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private T [] deleteItem(int i){
        T[] newContainer1 = (T[]) new Object[container.length - 1];
        for (int k = 0; k < i; k++) {
            newContainer1[k] = container[k];
        }
        for (int j = i; j < container.length - 1; j++) {
            newContainer1[j] = container[j + 1];
        }
    container = newContainer1;
        return container;
    }

    public static <T extends Comparable<T>> void sort(DataContainer<T> data) {
        bubbleSort(data, null);
    }

    public static <T extends Comparable<T>> void sort(DataContainer<T> data, Comparator<T> comparator) {
        bubbleSort(data, comparator);
    }
    private static <T extends Comparable<T>> T [] bubbleSort(DataContainer<T> data, Comparator<T> comparator){
        for (int i = 1; i < data.container.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data.container[j + 1] == null) {
                    continue;
                }
                if (data.container[j] == null || (comparator != null ? comparator.compare(data.container[j + 1], data.container[j]) < 0 : data.container[j + 1].compareTo(data.container[j]) < 0)) {
                    T temp = data.container[j + 1];
                    data.container[j + 1] = data.container[j];
                    data.container[j] = temp;
                }
            }
        }
        return data.container;
    }
}
