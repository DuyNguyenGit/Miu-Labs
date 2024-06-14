import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        printSquares(4);
    }

    // 1, 2, 3, 4
    // 1, 4, 9, 16
    public static void printSquares(int num) {
        IntStream.iterate(1, Main::square)
                .limit(num).forEach(i -> System.out.print(i + " "));
    }

    private static int square(int n) {
        int square = (int) (Math.sqrt(n) + 1);
        return square * square;
    }
}