public class Cat extends Animal {
    public Cat(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public String getFoodType() {
        return "fish";
    }

    @Override
    public int getFoodAmount() {
        return 1;
    }

    @Override
    public void move() {
        System.out.println(getName() + " is jumping\n");
        Animal.totalMovements++;
    }

    @Override
    public void sound() {
        System.out.println(getName() + " makes meow\n");
        Animal.totalSound++;
    }

    @Override
    public void eat() {
        System.out.println(getBreed() + " " + getName() + " has eaten " + getFoodType() + " in amount of "
                + getFoodAmount() + " pieces!\n");
        Animal.totalFish += getFoodAmount();
    }
}
