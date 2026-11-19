import Exception.InvalidAgeException;
import Exception.WrongFoodException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Animal dog1 = new Dog("Toplan", 3, "Sheperd");
        Animal dog2 = new Dog("Tsubush", 5, "Cur");
        Animal cat1 = new Cat("Garfield", 8, "Eczot");
        Animal cat2 = new Cat("Tom", 6, "Blue shorthair");
        Animal bird1 = new Bird("Yago", 10, "parrot");
        Animal bird2 = new Bird("Woody", 4, "woodpecker");

        try {
            Animal dog3 = new Dog("Afro", -5,"Blackdog");
        }
        catch (InvalidAgeException e) {
            System.err.println(e.getMessage());
        }

        try {
            Animal bird3 = new Bird("Ali", 4, "bird");
            bird3.feed("fish", 1);
        }
        catch (WrongFoodException e) {
            System.err.println(e.getMessage());
        }

        dog1.eat();
        cat2.eat();
        bird1.eat();

        dog2.sound();
        bird2.sound();

        cat1.move();

        Animal.getZooReport();
    }
}