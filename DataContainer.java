package HW9;


import java.util.*;

public class DataContainer <T extends Comparable<T>>  {
    T [] container;

    List<T> numlist = Arrays.asList(container);

    int newIndex = 0;

    public int add (T item){
        numlist.add(item);
         int newIndex = numlist.indexOf(item);
        return newIndex;
    }

    public T get (int index){
        index = newIndex;
        return numlist.get(index);
    }

    public T[] getItems(){
        T [] arr = (T [])numlist.toArray();
        return arr;
    }

    public boolean delete(int index){
        try {
            if (numlist.remove(index) != null){
                return true;
            }
        }catch (IndexOutOfBoundsException e){
        }
        return false;
    }
    public boolean delete(T item){
        if (numlist.remove(item)){
            return true;
        }else {
            return false;
        }
    }

    public static  <T extends Comparable<T>> void sort(T [] data) {
        for (int i = 1; i < data.length; i++) {
            data[i-1].compareTo(data[i]);
        }
    }

    public static <T extends Comparable<T>> void sort (T[] data, Comparator<T> comparator) {
        for (int i = 1; i < data.length; i++) {
            comparator.compare(data[i], data[i-1]);
        }
    }
}
