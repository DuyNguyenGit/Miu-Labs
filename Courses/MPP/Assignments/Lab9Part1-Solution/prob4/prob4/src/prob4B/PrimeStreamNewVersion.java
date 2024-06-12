package prob4B;

import java.util.stream.Stream;

public class PrimeStreamNewVersion {

    private Stream<Integer> primesStream() {
        return Stream.iterate(2, this::generatePrime);
    }

    private Integer generatePrime(Integer n) {
        n += 1;
        if (isPrime(n)) {
            return n;
        } else {
            return generatePrime(n);
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void printFirstNPrimes(int i) {
        this.primesStream().limit(i)
                .toList()
                .forEach(System.out::println);

    }

    public static final void main(String[] args) {
        PrimeStreamNewVersion ps = new PrimeStreamNewVersion(); //PrimeStream is enclosing class
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}
