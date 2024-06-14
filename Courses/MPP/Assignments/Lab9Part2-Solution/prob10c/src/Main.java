import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream myIntStream = IntStream.rangeClosed(1, 100);
        IntSummaryStatistics summary = myIntStream.summaryStatistics();
        System.out.println("Max integer: " + summary.getMax());
        System.out.println("Min integer: " + summary.getMin());
    }
}