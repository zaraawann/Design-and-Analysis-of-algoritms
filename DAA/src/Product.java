public class Product {
    private String productName;
    private double price;
    private char productInitials;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        this.productInitials = productName.charAt(0);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getProductInitials() {
        return productInitials;
    }

    public void setProductInitials(char productInitials) {
        this.productInitials = productInitials;
    }
}
