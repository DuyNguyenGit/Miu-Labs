package prob1.b;

import java.util.function.Supplier;

public class Prob1B {

    public static final void main(String[] args) {

        //1.
        Supplier<Double> s = () -> Math.random();
        //2.
        System.out.println(s.get());
        //3.
        class Random implements Supplier<Double> {
            @Override
            public Double get() {
                return Math.random();
            }
        }
        System.out.println(new Random().get());
    }
}
