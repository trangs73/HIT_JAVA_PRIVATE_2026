import java.util.Scanner;

public class HitShop {
    public static void main(String[] args) {
        final double VAT_RATE = 0.10;
        final int SHIPPING_FEE = 20000;
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        double price = sc.nextDouble();
        int quantity = sc.nextInt();

        double thanhTien = price * quantity;
        double tongThanhToan = price * VAT_RATE + SHIPPING_FEE;

        System.out.println("Tên mặt hàng: " + name);
        System.out.println("Đơn giá: " + price);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Thành tiền: " + thanhTien);
        System.out.println("Tổng thanh toán: " + tongThanhToan);
    }
}