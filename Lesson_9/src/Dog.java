public class Dog extends Animal {
    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public String getFoodType() {
        return "bone";
    }

    @Override
    public int getFoodAmount() {
        return 2;
    }

    @Override
    public void move() {
        System.out.println(getName() + " is running\n");
        Animal.totalMovements++;
    }

    @Override
    public void sound() {
        System.out.println(getName() + " makes bark\n");
        Animal.totalSound++;
    }

    @Override
    public void eat() {
        System.out.println(getBreed() + " " + getName() + " has eaten " + getFoodType() + " in amount of "
                + getFoodAmount() + " pieces!\n");
        Animal.totalBone += getFoodAmount();
    }
}
