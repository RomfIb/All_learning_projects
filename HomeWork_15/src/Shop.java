import java.util.*;
import Exception.*;

public class Shop {
    private Map<Integer, Product> productsMap = new HashMap<>();
    private Set<String> categoriesSet = new HashSet<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot add null product");
        }
        productsMap.put(product.id(), product);
        categoriesSet.add(product.category());
    }

    public Product findProductById(Integer id) {
        Product product = productsMap.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with id " + id + "is not found in the map");
        }
        return product;
    }

    public Set<String> getCategoriesSet() {
        return categoriesSet;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product: productsMap.values()) {
            if (product.category().equalsIgnoreCase(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    public Product getMostExpensiveProduct(){
        if (productsMap.isEmpty()) {
            throw new ProductNotFoundException("Cannot find most expensive product. Mao is empty");
        }
        Product expensive = null;
        for (Product product: productsMap.values()) {
            if (expensive == null || product.price() > expensive.price()) {
                expensive = product;
            }
        }
        return expensive;
    }

    public void removeProductById(Integer id) {
        Product productToRemove = productsMap.get(id);
        if (productToRemove == null) {
            throw new ProductNotFoundException("Product with id " + id + " is not found in the map");
        }
        String category = productToRemove.category();
        productsMap.remove(id);
        System.out.println("Product " + productToRemove + " is deleted");
        boolean categoryDoesExist = false;
        for (Product product: productsMap.values()) {
            if (product.category().equalsIgnoreCase(category)) {
                categoryDoesExist = true;
                break;
            }
        }
        if(!categoryDoesExist) {
            categoriesSet.remove(category);
            System.out.println("Category " + category + " is deleted");
        }
    }
}
