import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> names = List.of("Ali","Vali","Pirvali");

        String result = names
                .stream()
                .collect(Collectors.joining(",","[","]"));
        //System.out.println(result);

        Long count = names
                .stream()
                .collect(Collectors.counting());
                //.collect(Collectors.groupingBy(User::getSalary, Collectors.counting()))
        //System.out.println(count);

//        Map<String,String> map = names
//                .stream()
//                .collect(Collectors.mapping(User::name, Collectors.toList()));

//        Boolean adult = names
//                .stream()
//                .collect(Collectors.partitioningBy(user -> user.getAge >= 18));

        Optional<String> value = Optional.of("Ali");
        Optional<String> value2 = Optional.ofNullable("Vali");
        Optional<String> value3 = Optional.empty();
        String simpleValue = value.get().toString();
        String simpleValue2 = value2.orElse("Pirvali").toString();
        System.out.println(simpleValue);
        System.out.println(simpleValue2);
        try {
            String simpleValue3 = value3.orElseThrow(() -> new RuntimeException("Wrong")).toString();
            System.out.println(simpleValue3);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
        }

        value2.ifPresent(System.out::println);

        String age = "18";
        Boolean isValid = age.matches("\\d{2}");
        System.out.println(isValid);
        String pinCode = "1234";
        Boolean isValid2 = pinCode.matches("[0-9]{4}");
        System.out.println(isValid2);

        String name = "Alex";
        Boolean isValid3 = name.matches("[a-zA-Z]{2,}");
        System.out.println(isValid3);

        String phone = "+994505050505";
        Boolean isValidPhone = phone.matches("\\+994\\d{9}");
        System.out.println(isValidPhone);

        test(5);

    }
    @Important(value = "0")
    public Integer field = 7;

    @Deprecated
    @Important(value = "5")
    public static void test(Integer integer) {
        System.out.println(integer);
    }
}