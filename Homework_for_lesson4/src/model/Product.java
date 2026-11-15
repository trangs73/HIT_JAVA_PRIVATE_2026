package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    private static int count = 0;

    public Product(String id, String name, double price, int stock) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID không được để trống.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0.");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("Số lượng tồn kho không được âm.");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        count++;
    }

    public Product() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Tên sản phầm không được để trống.");
            return;
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0.");
        }
        this.price = price;
    }

    public void decreaseStock(int quantity) {
        if (quantity <= 0 || quantity > stock) {
            throw new IllegalArgumentException("Số lượng giảm không hợp lệ.");
        }
        stock -= quantity;
    }

    public String getDescription() {
        return name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + stock;
    }
}
