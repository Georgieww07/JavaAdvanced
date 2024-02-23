package Generics.ListUtilities_04;

import java.util.Comparator;
import java.util.List;

public class ListUtils {


    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }else {
            T min = list.stream().min((a, b) -> a.compareTo(b)).get();
            return min;
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        T max = list.stream().max((a, b) -> a.compareTo(b)).get();
        return max;

    }
}
