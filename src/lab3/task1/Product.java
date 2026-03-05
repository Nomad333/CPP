package lab3.task1;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String name;
    private ProductCategory category;
    private String description;
    private LocalDate deliveryDate;
    private Double price;
    private int amount;

    public Product(String name, Double price, ProductCategory category, int amount) {
        this(name, price, category, "", LocalDate.now(), amount);
    }

    public Product(String name, Double price, ProductCategory category, String description, LocalDate deliveryDate, int amount) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.deliveryDate = deliveryDate;
        this.amount = amount;
        this.price = price;
    }

    public boolean isAvailable() {
        return amount > 0;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount && Objects.equals(name, product.name) && category == product.category &&
                Objects.equals(description, product.description) && Objects.equals(deliveryDate, product.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, description, deliveryDate, amount);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", category=" + category.getDisplayName() +
                ", description='" + description + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", amount=" + amount +
                '}';
    }
}
