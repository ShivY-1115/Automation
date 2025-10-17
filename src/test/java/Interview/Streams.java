package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12,23,45,35,64));

        IntStream.rangeClosed(1,100).forEach(System.out::println);

        IntStream.rangeClosed(1,50).filter( item -> item%2==0).forEach(n -> System.out.print(n+" "));

        int sum = IntStream.rangeClosed(1,100).sum();

        IntStream.rangeClosed(1,100).map(item -> item*2).forEach(System.out::println);
        System.out.println(sum);

        IntStream.of(1,2,3,4,5,6).filter(x -> x%2==0).forEach(System.out::println);

        IntStream.of(11,2,22,34,55,65).boxed().
                sorted(Comparator.reverseOrder()).skip(1).limit(1)
                .forEach(System.out::println);

    }
}
