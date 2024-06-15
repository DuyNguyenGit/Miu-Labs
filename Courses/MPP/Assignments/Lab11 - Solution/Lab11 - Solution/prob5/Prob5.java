package lesson11.labs.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob5 {
    public static <T extends Comparable<? super T>> T secondSmallest(List<T> list) {
        if (list.size() < 2) return null;
        T min = list.get(0);
        T secondMin = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                secondMin = min;
                min = list.get(i);
            } else if (list.get(i).compareTo(min) > 0) {
                if(list.get(i).compareTo(secondMin) < 0) {
                    secondMin = list.get(i);
                } else if (secondMin == min) {
                    secondMin = list.get(i);
                }
            }
        }
        return secondMin;
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(secondSmallest(ints));
        List<Integer> ints2 = Arrays.asList(1,1,3,4,5,6,7,8,9);
        System.out.println(secondSmallest(ints2));
        List<Integer> ints3 = Arrays.asList(1,1,3,1,5,3,7,8,9);
        System.out.println(secondSmallest(ints3));
        List<Double> doubles = Arrays.asList(1.0,3.0,3.0,4.0,5.0,6.0,2.5,8.0);
        System.out.println(secondSmallest(doubles));
    }
}
