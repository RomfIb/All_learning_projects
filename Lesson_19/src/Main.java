import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Sum_Calculator sum = new Sum_Calculator();
        //int result = sum.calculate(5,7);
        //System.out.println(result);
        Calculation sumCalculator = new Calculation() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println(sumCalculator.calculate(6,8));

        Predicate<Integer> positive = number -> number > 0;
        Boolean result = positive.test(-5);
        System.out.println(result);

        User user1 = new User("Ali", 15);
        User user2 = new User("Vali", 30);
        User user3 = new User("Pirvali", 25);
        Predicate<User> adult = user -> user.getAge() >= 18;
        System.out.println(adult.test(user2));

        Predicate<User> nameStartsWithA = user -> user.getName().startsWith("A");
        System.out.println(nameStartsWithA.test(user1));

        Predicate<User> condition = adult.and(nameStartsWithA);
        System.out.println(condition.test(user1));

        Predicate<User> noAdult = adult.negate();

        Calculation division = new Calculation() {
            @Override
            public int calculate(int a, int b) {
                if (b != 0) {
                    return a / b;
                }
                return 0;
            }
        };

        System.out.println(division.calculate(10,5));

        Calculation calculationSum = (a,b) -> a + b;
        Calculation calculationSub = (a,b) -> a - b;
        Calculation calculationMul = (a,b) -> a * b;

        Calculation calculationDivision = (a,b) -> {
            if (b == 0) throw new IllegalArgumentException("Division by zero"); return a / b;
        };
        System.out.println(calculationDivision.calculate(14,2));

        //() -> System.out.println("Hello");

        //x -> x * 2;

        //(x) -> x * 2;

        //(a, b) -> a + b;

        //(a, b) -> { if () return result;}


        List<Integer> numbers = List.of(105, -784, 24, 37, -9, 24);
        List<Integer> resultList = numbers.stream().filter(number -> number >= 100).toList();
        System.out.println(resultList);

        Predicate<Integer> greaterThanHundred = number -> number >= 100;
        List<Integer> resultList2 = numbers.stream().filter(greaterThanHundred).toList();
        System.out.println(resultList2);
        //intermediate operations (процесс):
        //фильтр - filter
        //преобразование - map
        //сортировка - sorted
        //убрать дубликаты - distinct
        //лимитировать - limit
        //пропускать - skip

        //terminal operations (концовка):
        //получить список - toList
        //количество - count

        List<Integer> multipleTwo = numbers
                .stream()
                .map(number -> number * 2)
                .toList();
        System.out.println(multipleTwo);

        List<String> names = List.of("Ali", "Vali", "Pirvali");
        List<Integer> nameLength = names.stream().map(name -> name.length()).toList();
        System.out.println(nameLength);

        List<Integer> sortedNumbers = numbers
                .stream()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .toList();
        System.out.println(sortedNumbers);

        List<String> sortedNames = names.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedNames);

        List<Integer> noDoubles = numbers
                .stream()
                .distinct()
                .limit(numbers.size() - 3)
                .toList();
        System.out.println(noDoubles);

        List<Integer> afterSecond = numbers
                .stream()
                .skip(2)
                .toList();
        System.out.println(afterSecond);

        Long count = numbers.stream().filter(greaterThanHundred).count();
        System.out.println(count);

        List<User> users = List.of(user1,user2,user3);

        Boolean hasAdult = users
                .stream()
                .anyMatch(adult);
        System.out.println(hasAdult);

        Optional<User> firstUser = users
                .stream()
                .filter(adult)
                .findFirst();
        System.out.println(firstUser);

        Optional<User> youngestUser = users
                .stream()
                .min(Comparator.comparingInt(User::getAge));
        System.out.println(youngestUser);

        Optional<User> myUser = users
                .stream()
                .distinct()
                .filter(adult)
                .filter(user -> user.getAge() < 30)
                //.sorted(Comparator.comparingInt(String:: length))
                //.skip(1)
                .findFirst();
        System.out.println(myUser);
    }
}