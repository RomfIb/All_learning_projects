import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1,"Ali", "ali17@mail.com", 100.0),
                new Employee(2,"Vali", "vali10@nmil.com", 200.0),
                new Employee(3,"Pirvali", "pirvali07@mail.com", 250.0),
                new Employee(4,"Aliaga", "agaga15@mail.ru", 150.0),
                new Employee(5,"Yusif", "yus1f@mail.com", 500.0));

        List<Employee> employeesSortedBySalaryFromMaxToMin = employees
                .stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
//                .filter()
                .toList();

        System.out.println(employeesSortedBySalaryFromMaxToMin);

        String hasMaxSalaryEmail = employeesSortedBySalaryFromMaxToMin.get(0).email();
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-z]{2,}");
//        Predicate<Pattern> emailPredicate = emailPattern
        Matcher emailMatcher = emailPattern.matcher(employeesSortedBySalaryFromMaxToMin.get(0).email());
        if (emailMatcher.matches())
            System.out.println("Email of employee with max salary: " + hasMaxSalaryEmail);
        else
            System.out.println("Employee with max salary has invalid email");

        List<Order> orders = List.of(
                new Order(1, "Baku", true, 80.0),
                new Order(2, "Sumqayit", true, 50.0),
                new Order(3, "Baku", false, 70.0),
                new Order(4, "Ganja", false, 90.0),
                new Order(5, "Sumqayit", false, 55.0),
                new Order(6, "Ganja", true, 60.0)
        );

        System.out.println(orders);
        List<Order> payedOrders = orders
                .stream()
                .filter(Order::payed)
                .toList();
        System.out.println(payedOrders);

        List<Order> sumGreaterThanSeventy = orders
                .stream()
                .filter(order -> order.sum() >= 70.0)
                .toList();
        System.out.println(sumGreaterThanSeventy);

        Map<String, Long> ordersMap = orders
                .stream()
                .collect(Collectors.groupingBy(Order::city, Collectors.counting()));
        System.out.println(ordersMap);

        Optional<Order> mostExpensiveOrder = orders.
                stream()
                .max(Comparator.comparingDouble(Order::sum));
        System.out.println("Most expensive order is " + mostExpensiveOrder);

        Boolean hasUnpaid = orders
                .stream()
                .anyMatch(order -> !order.payed());
        if (hasUnpaid)
            System.out.println("List has unpaid orders");
        else
            System.out.println("List doesn't have unpaid orders");



        User user1 = new User(1, "Alex", "alex1@mail.com", true);
        User user2 = new User(2, "Brian", "brian2@mail.com", false);
        User user3 = new User(3, "Jane", "jane3@mail.com", false);

        UserRepository userRepository = new UserRepository();
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        String email;
        if ((email = userRepository.findEmailIfActive(1)) != null)
            System.out.println("Active user's email: " + email);
        if ((email = userRepository.findEmailIfActive(2)) != null)
            System.out.println(email);
        if ((email = userRepository.findEmailIfActive(3)) != null)
            System.out.println(email);
        if ((email = userRepository.findEmailIfActive(4)) != null)
            System.out.println(email);
    }
}