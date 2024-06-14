package lesson9.labs.prob10a;

import java.util.Arrays;
import java.util.List;

public class Or {

    public static void main(String[] args) {
        List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(false));
        System.out.println(someSimpleIsTrue2(list));
    }

    public boolean someSimpleIsTrue(List<Simple> list) {
        boolean accum = false;
        for (Simple s : list) {
            accum = accum || s.flag;
        }
        return accum;
    }

    // Solution using reduce operation only
    public static boolean someSimpleIsTrue1(List<Simple> list) {
        return list.stream()
                .reduce(new Simple(false), (s1, s2) -> new Simple(s1.flag || s2.flag)).flag;
    }

    // Solution using reduce and map operation
    public static boolean someSimpleIsTrue2(List<Simple> list) {
        return list.stream()
                .map(simple -> simple.flag)
                .reduce(false, (flag1, flag2) -> flag1 || flag2);
    }

}
