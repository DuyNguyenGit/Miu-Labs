package prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Good {

    public static final void main(String[] args) {
        int len = 5;
        char c = 'c';
        char d = 'd';
        List<String> words = Arrays.asList("abcef", "abcefggg", "abc", "abced");
        System.out.println(countWords(words, c, d, len));
    }

    public static int countWords(List<String> words, char c, char d, int len) {
        List<String> filteredWords = words.stream()
                .filter(word -> word.length() == len)
                .takeWhile(word -> word.contains(c + "") && !word.contains(d + ""))
                .toList();
        return filteredWords.size();
    }
}
