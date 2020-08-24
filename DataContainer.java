package HW9;


import java.util.*;

public class DataContainer <T>  {
    private T [] container;

    public DataContainer(T[] container) {
        this.container = container;
    }

    public int add (T item){
        T[] newContainer = (T[]) new Object[container.length + 1];
        System.arraycopy(container, 0, newContainer, 0, container.length);
        container = newContainer;
        int index = 0;
        for (int i = 0; i < container.length; i++){
            if (container[i] == null){
                container[i] = item;
                index = i;
            }
        }
        return index;
    }

    public T get (int index){
        return container[index];
    }

    public T[] getItems(){
        return container;
    }

    public boolean delete(int index){
        try {
            T[] newContainer1 = (T[]) new Object[container.length -1];
            for (int i = 0; i < container.length; i++) {
                if (i == index) {
                    for (int k = 0; k < i; k++){
                        newContainer1[k] = container[k];
                    }
                    for (int j = i; j < container.length - 1; j++) {
                        newContainer1[j] = container[j - 1];

                    }
                    break;
                }
            }
            container = newContainer1;
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean delete(T item){
        try {
            T[] newContainer1 = (T[]) new Object[container.length -1];
            for (int i = 0; i < container.length; i++) {
                if (container[i] == item) {
                    break;
                }
                for (int k = 0; k < i; k++){
                    newContainer1[k] = container[k];
                }
                for (int j = i; j < container.length - 1; j++) {
                    newContainer1[j] = container[j - 1];

                }
            }
            container = newContainer1;
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static <T extends Comparable<T>> void sort(DataContainer<T> data)  {
        for (int i = 1; i < data.container.length; i++) {
            if(data.container[i].compareTo(data.container[i-1]) < 0){
                data.container[i] = data.container[i-1];
            }
        }
    }

    public static <T extends Comparable<T>> void sort (DataContainer<T> data, Comparator<T> comparator) {
        for (int i = 1; i < data.container.length; i++) {
            if (comparator.compare(data.container[i], data.container[i-1]) < 0){
                data.container[i] = data.container[i-1];
            }
        }
    }
}
