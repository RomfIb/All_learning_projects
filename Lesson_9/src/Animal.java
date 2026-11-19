import Exception.InvalidAgeException;
import Exception.WrongFoodException;
public abstract class Animal {
    private String name;
    private int age;
    private String breed;


    public static int totalBone = 0;
    public static int totalInsect = 0;
    public static int totalFish = 0;
    public static int totalSound = 0;
    public static int totalMovements = 0;

    public abstract void move();

    public abstract void sound();

    public abstract void eat();

    public abstract String getFoodType();

    public abstract int getFoodAmount();
    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Animal (String name, int age, String breed) {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative!");
        }
        this.name = name;
        this.age = age;
        this.breed = breed;
    }


    public void getInfo () {
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
        System.out.println("Breed is " + breed);
    }

    public void feed(String foodTypeGiven, int amount) {
        if (!foodTypeGiven.equalsIgnoreCase(getFoodType())) {
            throw new WrongFoodException(name + " do not eat " + foodTypeGiven + "\nIt eats " + getFoodType());
        }
        System.out.println(name + " is eating " + foodTypeGiven);

        if (foodTypeGiven.equalsIgnoreCase("bone"))
            totalBone++;
        if (foodTypeGiven.equalsIgnoreCase("insect"))
            totalInsect++;
        if (foodTypeGiven.equalsIgnoreCase("fish"))
            totalFish++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public static void getZooReport() {
        System.out.println("TOTAL FOOD CONSUMED:");
        System.out.println("Total bones: " + totalBone + " pieces" );
        System.out.println("Total insects: " + totalInsect + " pieces" );
        System.out.println("Total fish: " + totalFish + " pieces" );
        System.out.println("Total sounds made: " + totalSound);
        System.out.println("Total movements made: " + totalMovements);
    }
}
