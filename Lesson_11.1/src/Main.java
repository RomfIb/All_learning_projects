import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate date = LocalDate.of(2025,07,03);
        System.out.println(date);

        LocalDate date2 = LocalDate.of(2025, Month.JULY,03);
        System.out.println(date2);

        System.out.println(date2.getYear());
        System.out.println(date2.getMonth());
        System.out.println(date2.getDayOfMonth());
        System.out.println(date2.getMonthValue());
        System.out.println(date2.getDayOfWeek());
        date2.plusDays(5);
        System.out.println(date2);
        LocalDate date3 = date2.plusDays(5);
        System.out.println(date3);
        LocalDate date4 = date2.plusMonths(1);
        System.out.println(date4);
        System.out.println(date2.isBefore(date3));
        long differenceInDays = ChronoUnit.DAYS.between(date2,date3);
        System.out.println(differenceInDays);

        long differenceInWeeks = ChronoUnit.WEEKS.between(date2, date4);
        System.out.println(differenceInWeeks);

        LocalDate birthDate = LocalDate.of(1999, 05,06);
        Period age = Period.between(birthDate,today);
        System.out.println(age.getYears());

        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        LocalTime time2 = now.plusHours(2);
        System.out.println(time2);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        System.out.println(now2.toLocalDate());

        Duration duration = Duration.between(now, time2);
        System.out.println(duration.getSeconds());

        DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedDate = now2.format(myDateFormatter);
        System.out.println(formattedDate);

        Instant now3 = Instant.now();
        System.out.println(now3);


    }
}