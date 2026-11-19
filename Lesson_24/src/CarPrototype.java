public class CarPrototype {
    private String brand;
    private String model;
    private String color;

    public CarPrototype(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public CarPrototype(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
    public CarPrototype copy() {
        return new CarPrototype(this.brand, this.model, this.color);
    }
    public void setColor(String color) {
        this.color = color;
    }
}
