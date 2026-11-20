public record Product(
        Integer id,
        String name,
        String category,
        Double price
) {
    public Product(Integer id, String name, String category, Double price) {
        if (name == null || name.isEmpty()) {
            throw  new IllegalArgumentException("Name cannot be null");
        }
        if (category == null || category.isEmpty()) {
            throw  new IllegalArgumentException("Name cannot be null");
        }
        if (price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
