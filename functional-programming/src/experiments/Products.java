package experiments;

class Product {
    private int productID;
    private String productName;
    private String category;
    private double price;
    private int quantitySold;

    public Product(int productID, String productName, String category, double price, int quantitySold) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantitySold = quantitySold;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantitySold=" + quantitySold +
                '}';
    }
}