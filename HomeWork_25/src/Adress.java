import java.io.Serializable;

public class Adress implements Serializable {
    private String street;
    private Integer buildingNumber;

    public Adress(String street, Integer buildingNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
