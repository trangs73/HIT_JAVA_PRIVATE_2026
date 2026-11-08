import model.CartItem;
import model.Customer;
import model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {
    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p01 = new Product("P01", "Áo thun", 150000, 20);
        Product p02 = new Product("P02", "Bình nước", 50000, 10);
        System.out.println("Số object Product: " + Product.getCount());

        int choice;
        do {
            System.out.println("=========HIT SHOP=========");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xoá mặt hàng");
            System.out.println("3. Xem giỏ hàng");
            System.out.println("4. Xem tổng tiền");
            System.out.println("0. Kết thúc");
            System.out.println("==========================");

            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println(p01);
                    System.out.println(p02);

                    System.out.print("Nhập mã sản phẩm: ");
                    String idProduct = sc.nextLine();
                    System.out.print("Nhập số lượng: ");
                    int quantityProduct = Integer.parseInt(sc.nextLine());

                    if (idProduct.equalsIgnoreCase("P01")) {
                        addItem(p01, quantityProduct);
                    }
                    else if (idProduct.equalsIgnoreCase("P02")) {
                        addItem(p02, quantityProduct);
                    }
                    else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                }

                case 2 -> {
                    printItems();
                    System.out.print("Nhập số thứ tự mặt hàng muốn xoá: ");
                    int displayNumber = Integer.parseInt(sc.nextLine());

                    removeItem(displayNumber - 1);
                }

                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    static void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }

        CartItem item = new CartItem(product, quantity);
        cart.add(item);
    }

    static void removeItem(int index) {
        if (index < 0 || index >= cart.size()) {
            System.out.println("Không tìm thấy mặt hàng");
            return;
        }

        cart.remove(index);
    }

    static void printItems() {
        System.out.print("Khách hàng: ");
        System.out.println(currentCustomer);

        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng đang trống");
            return;
        }

        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " +
                                cart.get(i).getProduct().getId() + " | " +
                                cart.get(i).getProduct().getName() + " | " +
                                cart.get(i).getProduct().getPrice() + " | SL: " +
                                cart.get(i).getQuantity() + " | Thành tiền: " +
                                cart.get(i).getTotal());
        }
    }

    static double calculateTotal() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }

        return total;
    }

}
