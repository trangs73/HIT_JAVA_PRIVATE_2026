import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    static final List<String> names = new ArrayList<>();
    static final List<Double> prices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("============MENU============");
            printMenu();
            System.out.println("============================");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> readAndAddItem(sc);
                case 2 -> readAndRemoveItem(sc);
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    static void printMenu() {
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }

    static void readAndAddItem(Scanner scanner) {
        System.out.print("Nhập tên hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá hàng: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        names.add(name);
        prices.add(price);
        quantities.add(quantity);

        printItems();
    }

    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
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

    static void readAndRemoveItem(Scanner scanner) {
        System.out.print("Nhập số thứ tự mặt hàng muốn xoá: ");
        int displayNumber = Integer.parseInt(scanner.nextLine());
        int index = displayNumber - 1;
        if (index < 0 || index >= names.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        names.remove(index);
        prices.remove(index);
        quantities.remove(index);

        printItems();
    }

    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }
}
