import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
    }

    static IntStream twinPrimes(int n) {
        return IntStream.rangeClosed(1, n).filter(x -> isPrime(x))
            .filter(x -> (isPrime(x - 2) || isPrime(x + 2)));
    }

    static boolean isPrime(int n) {
        return n > 1 && IntStream.range(2, (int) Math.sqrt(n) + 1)
            .noneMatch(x -> n % x == 0); 
    }

    static String reverse(String str) {
        return Stream.<String>of(str.split(""))
            .reduce("", (x,y) -> y + x);
    }

    static long countRepeats(List<Integer> list) {
        return IntStream.range(0, list.size() - 1)
            .filter(x -> (list.get(x).equals(list.get(x + 1))))
            .filter(x -> (x == 0 || list.get(x) != list.get(x - 1)))
            .count();
    }

    static int test(List<Integer> list, int i) {
        if (list.get(i) == 1) {
            return 0;
        } else {
            if (i == list.size() - 1 && list.get(i - 1) == 1) {
                return 1;
            }
            if (i == 0 && list.get(i + 1) == 1) {
                return 1;
            }
            if (i > 0 && i < list.size() - 1) {
                if (list.get(i) + list.get(i + 1) + list.get(i - 1) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    static UnaryOperator<List<Integer>> generateRule() {
        return list -> IntStream.range(0, list.size())
            .map(i -> test(list, i))
            .boxed().collect(Collectors.toList());
    }

    static Stream<String> gameOfLife(List<Integer> list, 
            UnaryOperator<List<Integer>> rule, int n) {

        Stream<String> temp = Stream.iterate(list, rule)
            .limit(n).map(x -> x.toString().replace(" ", ""));

        return temp.map(x -> x.toString().replace("0", " ")
                .replace("1", "*").replace(",", "")
                .replace("[", "").replace("]", ""));
    }
}
