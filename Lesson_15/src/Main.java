import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        List<Integer> numbers = new ArrayList<>(List.of(7,125,-356,278));
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
        numbers.sort(
                Comparator.reverseOrder()
        );
        System.out.println(numbers);
        Comparator<Integer> comparator = (a, b) -> {
            return Integer.compare(b,a);
        };

        System.out.println(comparator.compare(5,7));

        List<String> stringList = new ArrayList<>(List.of("Alex", "Jane", "Brian", "Bob"));
        stringList.sort(Comparator.naturalOrder());
        System.out.println(stringList);
        stringList.sort(Comparator.reverseOrder());
        System.out.println(stringList);

        stringList.sort((a,b) -> Integer.compare(a.length(),b.length()));
        System.out.println(stringList);

        stringList.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(stringList);
        //stringList.sort(Comparator.comparingInt(String::length).thenComparing(Integer:: getAge));

        Set<Integer> integerSet = new TreeSet<>(Comparator.reverseOrder());


    }
