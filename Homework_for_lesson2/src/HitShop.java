import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {
    static final ArrayList<String> names = new ArrayList<>();
    static final ArrayList<Double> prices = new ArrayList<>();
    static final ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("=========HIT SHOP=========");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xoá mặt hàng");
            System.out.println("3. Xem giỏ hàng");
            System.out.println("4. Xem tổng tiền");
            System.out.println("5. Tìm mặt hàng theo tên");
            System.out.println("6. Chi tiết thanh toán");
            System.out.println("0. Kết thúc");
            System.out.println("==========================");

            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập tên hàng: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá hàng: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập số lượng: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    addItem(name, price, quantity);
                }

                case 2 -> {
                    System.out.print("Nhập số thứ tự mặt hàng muốn xoá: ");
                    int displayNumber = Integer.parseInt(sc.nextLine());

                    removeItem(displayNumber - 1);
                }

                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 5 -> {
                    System.out.print("Nhập tên mặt hàng cần tìm: ");
                    String name = sc.nextLine();
                    findItemsByName(name);
                }
                case 6 -> printPaymentDetails();
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    static void addItem(String name, double price, int quantity) {
        if (name.isEmpty()) {
            System.out.println("Tên mặt hàng không được rỗng");
            return;
        }

        if (price <= 0) {
            System.out.println("Giá phải lớn hơn 0");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Số lượng phải là số nguyên dương");
            return;
        }

        names.add(name);
        prices.add(price);
        quantities.add(quantity);

        printItems();
    }

    static void removeItem(int index) {
        if (index < 0 || index >= names.size()) {
            System.out.println("Không tìm thấy mặt hàng");
            return;
        }

        names.remove(index);
        prices.remove(index);
        quantities.remove(index);

        printItems();
    }

    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống");
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal);
        }
    }

    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }

        return total;
    }

    static void findItemsByName(String name) {
        boolean found = false;

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                double lineTotal = prices.get(i) * quantities.get(i);
                System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                        i + 1,
                        names.get(i),
                        prices.get(i),
                        quantities.get(i),
                        lineTotal);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy mặt hàng.");
        }
    }

    static void printPaymentDetails() {
        double total = calculateTotal();
        double vat = calculateTotal() * 0.1;
        double shipping = 20000;
        if (names.isEmpty()) shipping = 0;
        double payment = total + vat + shipping;

        System.out.printf("Tổng tiền hàng: %.1f%n", total);
        System.out.printf("VAT: %.1f%n", vat);
        System.out.printf("Phí vận chuyển: %.1f%n", shipping);
        System.out.printf("Tổng thanh toán: %.1f%n", payment);
    }
}
