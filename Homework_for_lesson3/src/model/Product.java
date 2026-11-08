package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    private static int count = 0;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Tên sản phầm không được để trống.");
            return;
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Giá sản phẩm phải lớn hơn 0.");
            return;
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Số lượng tồn kho không được âm.");
            return;
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + stock;
    }
}
