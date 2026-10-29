import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ThongKeDiem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();

        System.out.println("Nhập 5 điểm!");
        for (int i = 0; i < 5; i++) {
            System.out.print("Điểm thứ " + (i + 1) + ": ");
            double score = Double.parseDouble(sc.nextLine());

            if (score < 0 || score > 10) {
                System.out.println("Điểm không hợp lệ!");
                continue;
            }

            addScore(scores, score);
        }

        System.out.println("====DANH SÁCH====");
        printScores(scores);
        System.out.printf("Điểm trung bình: %.2f%n", calculateAverage(scores));
        System.out.println("Số điểm đạt: " + countPassed(scores));
    }

    static void addScore(ArrayList<Double> scores, double score) {
        scores.add(score);
    }

    static void printScores(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Không có điểm số nào hợp lệ!");
            return;
        }

        System.out.print("Danh sách điểm hợp lệ: ");
        for (double score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    static double calculateAverage(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    static int countPassed(ArrayList<Double> scores) {
        int count = 0;
        for (double score : scores) {
            if (score >= 5) count++;
        }

        return count;
    }
}