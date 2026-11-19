import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Predicate<Integer> positive = number -> number > 0;
        Predicate<Integer> greaterThanTen = number -> number > 10;
        List<Integer> numbers = List.of(5,-7,8,12,124,12,6,7,7,-7,555);
        List<Integer> streamNumbers = numbers
                .stream()
                .distinct()
                .sorted()
                .filter(positive.and(greaterThanTen.negate()))
                .toList();
        System.out.println(streamNumbers);


        List<User> users = List.of(
                new User(1, "Ali", "ali01"),
                new User(2,"Vali","vali2@mail.com"),
                new User(3,"Pirvali", "pir@mail.com")
        );

        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-z]{2,}");
        Predicate<User> isValidEmail = user -> emailPattern.matcher(user.email()).matches();
        List<User> validEmailUsers = users
                .stream()
                .filter(isValidEmail)
                .toList();
        System.out.println(validEmailUsers);

        String text = "12345";
        Pattern myPattern = Pattern.compile("\\d+");
        //Boolean myPattern = Pattern.compile("\\d+").matcher(text).matches();
        Matcher myMatcher = myPattern.matcher(text);
        Boolean result = myMatcher.matches();
        System.out.println(result);

        String myText = "English texts for beginners to practice reading and comprehension online and for free." +
                " java17@java.com Practicing your comprehension of written English will both java21@java.az improve your vocabulary and understanding of grammar and word order. The texts below are designed to help you develop while giving you an instant evaluation of your progress.";

        Pattern textPattern = Pattern.compile("[\\w.-]+@[a-zA-Z]+\\.[a-z]{2,}");
        Matcher textMatcher = textPattern.matcher(myText);
        while (textMatcher.find()) {
            System.out.println(textMatcher.start() + " " + textMatcher.group()+ " " + textMatcher.end());
        }


        Pattern patternDate = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        Pattern patternDate2 = Pattern.compile("(?<day>\\d{2})-(?<month>\\d{2})-(?<year>\\d{4})");
        String date = "07-11-2026";
        Matcher matcherDate = patternDate2.matcher(date);
        if (matcherDate.matches()) {
            System.out.println(matcherDate.group(0));
            System.out.println("day: " + matcherDate.group("day"));//group(1)
            System.out.println("month: " + matcherDate.group("month"));
            System.out.println("year: " + matcherDate.group("year"));
        }

        String txt = "My password 12345";
        Pattern numberPattern = Pattern.compile("\\d");
        Matcher numberMatcher = numberPattern.matcher(txt);
        System.out.println(numberMatcher.replaceAll("*"));

        String spaceText = "My       text     has      many      spaces";
//        Pattern spacePattern = Pattern.compile(" {2,}");
        Pattern spacePattern = Pattern.compile("\\s+");
        Matcher spaceMatcher = spacePattern.matcher(spaceText);
        System.out.println(spaceMatcher.replaceAll(" "));

        Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);


        //min 1 big letter, min 1 small letter, min 1 digit, min 1 spec symbol, min 8 symbols, latin
        String regex = "^(?=.*[A-Z])" +
                "(?=.*[a-z])" +
                "(?=.*\\d)" +
                "(?=.*[!#@$%_])" +
                "[A-Za-z\\d!#@$%_]{8,}$";
        String password = "Regex_password12@yes";
        Pattern patternPassword = Pattern.compile(regex);
        Matcher matcherPassword = patternPassword.matcher(password);
        System.out.println(matcherPassword.matches());

        String text1 = "a + b";
        Pattern pattern1 = Pattern.compile(Pattern.quote(text1));
        System.out.println(pattern1.matcher("a + b").matches());

        String pincode = "1234";
        Pattern pinPattern = Pattern.compile("\\d{4}");
        System.out.println(pinPattern.matcher(pincode).matches());

        String text2 = "Ali age 20, Vali age 25, Privali age 30";
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher2 = pattern2.matcher(text2);
        while (matcher2.find()) {
            System.out.println(matcher2.group());
        }

        List<Employee> employees = List.of(
                new Employee(1,"Alex", "HR", 1000.0),
                new Employee(2,"Jane", "IT", 2000.0),
                new Employee(3,"Jack", "IT", 2500.0),
                new Employee(4,"John", "HR", 1500.0));

        List<Employee> employeesIT = employees
                .stream()
                .filter(employee -> employee.department().equals("IT"))
                .toList();
        System.out.println(employeesIT);

        Long employeesHRCount = employees
                .stream()
                .filter(employee -> employee.department().equalsIgnoreCase("hr"))
                .count();
        System.out.println(employeesHRCount);


        Map<String, Long> employeeCount = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println(employeeCount);

        Map<String, Double> employeeSalarySum = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.summingDouble(Employee::salary)));
        System.out.println(employeeSalarySum);

        Map<Boolean, List<Employee>> salaryMap = employees
                .stream()
                .collect(Collectors.partitioningBy(employee -> employee.salary() >= 2000));
        salaryMap.get(true).forEach(System.out::println);
        salaryMap.get(false).forEach(System.out::println);

        String[] textSplitted = myText.split("\\s+");
        Map<String, Long> frequencyOfWords = Arrays.stream(textSplitted)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(frequencyOfWords);
    }
}