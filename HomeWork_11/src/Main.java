import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LocalDate day = LocalDate.now();
        DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = day.format(myDateFormatter);
        System.out.println(formattedDate);

        printTextDate(formattedDate);
    }

    public static void printTextDate(String dateStr) {

        DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateStr, myDateFormatter);

        String dayText = getDayText(date.getDayOfMonth());
        String monthText = getMonthText(date.getMonthValue());
        String yearText = getYearText(date.getYear());
        System.out.println(dayText + " " + monthText + " " + yearText + " года");
    }
    public static String getMonthText(int month) {
        return switch (month) {
            case 1 -> "января";
            case 2 -> "февраля";
            case 3 -> "марта";
            case 4 -> "апреля";
            case 5 -> "мая";
            case 6 -> "июня";
            case 7 -> "июля";
            case 8 -> "августа";
            case 9 -> "сентября";
            case 10 -> "октября";
            case 11 -> "ноября";
            case 12 -> "декабря";
            default -> throw new IllegalArgumentException("Invalid month ");
        };
    }

    public static String getDayText(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day of month:");
        }

        if (day <= 20) {
            return switch (day) {
                case 1 -> "первое";
                case 2 -> "второе";
                case 3 -> "третье";
                case 4 -> "четвертое";
                case 5 -> "пятое";
                case 6 -> "шестое";
                case 7 -> "седьмое";
                case 8 -> "восьмое";
                case 9 -> "девятое";
                case 10 -> "десятое";
                case 11 -> "одиннадцатое";
                case 12 -> "двенадцатое";
                case 13 -> "тринадцатое";
                case 14 -> "четырнадцатое";
                case 15 -> "пятьнадцатое";
                case 16 -> "шестнадцатое";
                case 17 -> "семнадцатое";
                case 18 -> "восемнадцатое";
                case 19 -> "девятнадцатое";
                case 20 -> "двадцатое";
                default -> "";
            };
        }
        else if (day < 30) {
            return "двадцать" + getDayText(20 - day);
        }
        else if (day == 30) {
            return "тридцатое";
        }
        else {
            return "тридцать первое";
        }
    }

    public static String getYearText(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invlid year");
        }

        int thousands = year / 1000;
        int hundreds = (year % 1000) / 100;
        System.out.println(hundreds);
        int lastTwo = year % 100;

        if (thousands > 0 && hundreds == 0 && lastTwo == 0) {
            return getRoundThousandsText(thousands);
        }
        if (hundreds > 0 && lastTwo == 0) {
            return getThousandsPrefix(thousands) + getRoundHundredsText(hundreds);
        }
        return getThousandsPrefix(thousands) + getHundredsPrefix(hundreds) + getLastTwoDigitsText(lastTwo);
    }

    public static String getRoundThousandsText(int thousands) {
        return switch (thousands) {
            case 1 -> "тысячного";
            case 2 -> "двухтысячного";
            case 3 -> "трехтысячного";
            case 4 -> "четырехтысячного";
            case 5 -> "пятитысячного";
            case 6 -> "шеститысячного";
            case 7 -> "семитысячного";
            case 8 -> "восьмитысячного";
            case 9 -> "девятитысячного";
            default -> throw new IllegalArgumentException("Wrong thousands");
        };
    }
    public static String getRoundHundredsText(int hundreds) {
        return switch (hundreds) {
            case 1 -> "сотого";
            case 2 -> "двухсотого";
            case 3 -> "трехсотого";
            case 4 -> "четырехсотого";
            case 5 -> "пятисотого";
            case 6 -> "шестисотого";
            case 7 -> "семисотого";
            case 8 -> "восьмисотого";
            case 9 -> "девятисотого";
            default -> throw new IllegalArgumentException("Wrong hundreds");
        };
    }

    public static String getThousandsPrefix(int thousands) {
        return switch (thousands) {
            case 0 -> "";
            case 1 -> "тысяча ";
            case 2 -> "две тысячи ";
            case 3 -> "три тысячи ";
            case 4 -> "четыре тысячи ";
            case 5 -> "пять тысяч ";
            case 6 -> "шесть тысяч ";
            case 7 -> "семь тысяч ";
            case 8 -> "восемь тысяч ";
            case 9 -> "девять тысяч ";
            default -> throw new IllegalArgumentException("Wrong thousands");
        };
    }

    public static String getHundredsPrefix(int hundreds) {
        return switch (hundreds) {
            case 0 -> "";
            case 1 -> "сто ";
            case 2 -> "двести ";
            case 3 -> "триста ";
            case 4 -> "четыреста ";
            case 5 -> "пятьсот ";
            case 6 -> "шестьсот ";
            case 7 -> "семьсот ";
            case 8 -> "восемьсот ";
            case 9 -> "девятьсот ";
            default -> throw new IllegalArgumentException("Wrong hundreds");
        };
    }

    public static String getLastTwoDigitsText(int lastTwo) {
        if (lastTwo < 0 || lastTwo >99) {
            throw new IllegalArgumentException("Wrong last two digits");
        }

        if (lastTwo <= 20) {
            return switch (lastTwo) {
                case 1 -> "первого";
                case 2 -> "второго";
                case 3 -> "третьего";
                case 4 -> "четвертого";
                case 5 -> "пятого";
                case 6 -> "шестого";
                case 7 -> "седьмого";
                case 8 -> "восьмого";
                case 9 -> "девятого";
                case 10 -> "десятого";
                case 11 -> "одиннацатого";
                case 12 -> "двенадцатого";
                case 13 -> "тринадцатого";
                case 14 -> "четырнадцатого";
                case 15 -> "пятнадцатого";
                case 16 -> "шестнадцатого";
                case 17 -> "семнадцатого";
                case 18 -> "восемнадцатого";
                case 19 -> "девятнадцатого";
                case 20 -> "двацатого";
                default -> "";
            };
        }

        int tens = (lastTwo / 10) * 10;
        int units = lastTwo % 10;

        if (units == 0) {
            return switch (tens) {
                case 30 -> "тридцатого";
                case 40 -> "сорокового";
                case 50 -> "пятидесятого";
                case 60 -> "шестидесятого";
                case 70 -> "семидесятого";
                case 80 -> "восьмидесятого";
                case 90 -> "девяностого";
                default -> throw new IllegalArgumentException("Wrong tens");
            };
        }

        String tensText = switch (tens) {
            case 20 -> "двадцать ";
            case 30 -> "тридцать ";
            case 40 -> "сорок ";
            case 50 -> "пятьдесят ";
            case 60 -> "шестьдесять ";
            case 70 -> "семьдесят ";
            case 80 -> "восемьдесят ";
            case 90 -> "девяносто ";
            default -> throw new IllegalArgumentException("Wrong tens");
        };

        String unitsText = switch (units) {
            case 1 -> "первого";
            case 2 -> "второго";
            case 3 -> "третьего";
            case 4 -> "четвертого";
            case 5 -> "пятого";
            case 6 -> "шестого";
            case 7 -> "седьмого";
            case 8 -> "восьмого";
            case 9 -> "девятого";
            default -> throw new IllegalArgumentException("Wrong units");
        };
        return tensText + unitsText;
    }
}