import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        stringStream.reduce((s1, s2) -> s1 + ", " + s2).ifPresent(System.out::println);
    }
}