package customers;

public class Product {

    private String prodNum;
    private String name;
    private double price;

    private Supplier supplier;

    public Product() {
    }

    public Product(String prodNum, String name, double price) {
        this.prodNum = prodNum;
        this.name = name;
        this.price = price;
    }

    public String getProdNum() {
        return prodNum;
    }

    public void setProdNum(String prodNum) {
        this.prodNum = prodNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodNum='" + prodNum + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                '}';
    }
}
