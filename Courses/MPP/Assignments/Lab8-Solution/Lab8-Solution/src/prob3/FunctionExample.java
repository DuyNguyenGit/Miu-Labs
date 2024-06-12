package prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FunctionExample {
    public static void main(String[] args) {
        BiFunction<Double, Double, List<Double>> biFunction = (x, y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;
        };
        System.out.println(biFunction.apply(2.0, 3.0)); // output 1
    }

}