package prob1.a;

public class Prob1A {
    /*
    1. For below lambda expression, there is no parameters. s and t are free variables.

    Runnable runnable = () -> {
        int[][] products = new int[s][t];
        for (int i = 0; i < s; i++) {
            for(int j = i + 1; j < t; j++) {
                products[i][j] = i * j;
            }
        }
    };
     */

    /*
    2. For below lambda expression, there is two parameters that are s and t. And
    one free variable is ignoreCase.

    Comparator<String> comp = (s, t) -> {
        if(ignoreCase == true) {
            return s.compareToIgnoreCase(t);
        } else {
            return s.compareTo(t);
        }
    };
     */

}
