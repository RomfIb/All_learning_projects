import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Beef", 120.0, "Meat");
        Product product2 = new Product("Motal pendiri", 70.0, "Cheese");
        Product product3 = new Product("Pepper", 30.0, "Vegetables");
        Product product4 = new Product("Parmesan", 170.0, "Cheese");
        Product product5 = new Product("Lamb", 200.0, "Meat");

        Predicate<Product> moreExpensiveThanHundred = product -> product.getPrice() >= 100.0;
        Predicate<Product> isCheese = product -> product.getCategory().equalsIgnoreCase("cheese");

        List<Product> products = List.of(product2,product1,product3,product4,product5);

//        List<Product> expensiveCheese = products
//                .stream()
//                .filter(moreExpensiveThanHundred.and(isCheese))
//                .toList();
//        System.out.println(expensiveCheese);

        Predicate<Product> cheese = product -> product.getCategory().equalsIgnoreCase("Cheese");
        List<Product> expensiveProduct = products
                .stream()
                .peek(product -> System.out.println("Product name: " + product.getName()))
                .takeWhile(product -> product.getPrice() >= 100)
                .dropWhile(cheese)
                .toList();
        System.out.println(expensiveProduct);


        Student student1 = new Student(105,"Alex", 19, 67);
        Student student2 = new Student(207,"Brian", 17, 80);
        Student student3 = new Student(303,"Jane", 18, 95);
        Student student4 = new Student(509,"Ali", 21, 56);
        Student student5 = new Student(410,"Vali", 20, 84);
        Student student6 = new Student(230,"Pirvali", 16, 71);

        List<Student> students = List.of(student1,student2,student3,student4,student5,student6);

        Predicate<Student> adult = student -> student.getAge() >= 18;
        Predicate<Student> gradeGreaterThan75 = student -> student.getGrade() >= 75;

        List<Student> smartAdultStudents = students
                .stream()
                .filter(adult.and(gradeGreaterThan75))
                .sorted(Comparator.comparingInt(Student::getGrade))
                .peek(student -> System.out.println(student.getName()))
                .toList();

        List<String> smartAdultStudentsNames = smartAdultStudents
                .stream()
                .map(Student::getName)
                .toList();
        System.out.println(smartAdultStudentsNames);

        Long notAdultStudentsCount = students
                .stream()
                .filter(adult.negate())
                .count();
        System.out.println(notAdultStudentsCount);

        Optional<Student> bestStudent = students
                .stream()
                .max(Comparator.comparingInt(Student::getGrade));
        System.out.println(bestStudent);

        String[] studentsName = students
                .stream()
                .map(Student::getName)
                .peek(studentName -> System.out.println(studentName))
                .toArray(String[]::new);

        for (String name: studentsName) {
            System.out.print(name + " ");
        }


        List<Integer> numbers = List.of(15, 27, 15, 367, 90, 75, 367, 333, -1024);

        List<Integer> streamNumbers = numbers
                .stream()
                .distinct()
                .sorted()
                .map(number -> number * 2)
                .limit(3)
                //.peek(number -> number * 2)
                .toList();
        System.out.println(streamNumbers);

        Optional<Integer> numbersSum = numbers
                .stream()
                .reduce((a, b) -> a + b);
        System.out.println(numbersSum);

        Set<Integer> numbersSet = numbers
                .stream()
                .collect(Collectors.toSet());
        System.out.println(numbersSet);
    }
}