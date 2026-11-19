public class Bird extends Animal {
    public Bird(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public String getFoodType() {
        return "insect";
    }

    @Override
    public int getFoodAmount() {
        return 3;
    }
    @Override
    public void move() {
        System.out.println(getName() + " is flying\n");
        Animal.totalMovements++;
    }
    @Override
    public void sound() {
        System.out.println(getName() + " makes tweet\n");
        Animal.totalSound++;
    }

    @Override
    public void eat() {
        System.out.println(getBreed() + " " + getName() + " has eaten " + getFoodType() + " in amount of "
                + getFoodAmount() + " pieces!\n");
        Animal.totalInsect += getFoodAmount();
    }


}
