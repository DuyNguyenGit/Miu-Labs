package prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon",
                "Away", "On Vacation", "Everywhere you want to be");

        //print each element of the list in upper case format

		// Method 1: Using lambda expression
        list.stream()
                .map(String::toUpperCase)
                .forEach(str -> System.out.println(str));

		// Method 2: Using method reference
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}