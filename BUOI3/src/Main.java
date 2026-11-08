import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final List<Student> sv = new ArrayList<>();

    public static void main(String[] args) {
        Student sv01 = new Student("SV01", "Khánh", 20, new Car("CAR01", "Lamborghini", "30A-12345"));
        Student sv02 = new Student("SV02", "An", 19, new Car("CAR02", "Toyota", "30B-67890"));
        sv.add(sv01);
        sv.add(sv02);

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        String studentId = sc.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        String name = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ma o to: ");
        String carId = sc.nextLine();
        System.out.print("Nhap hang xe: ");
        String brand = sc.nextLine();
        System.out.print("Nhap bien so: ");
        String licensePlate = sc.nextLine();

        Student sv03 = new Student(studentId, name, age, new Car(carId, brand, licensePlate));
        sv.add(sv03);

        int choice;
        do {
            System.out.println("====MENU====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. Gioi thieu sinh vien ten Khanh");
            System.out.println("5. Tim sinh vien co o to hang Lamborghini");
            System.out.println("0. Thoat");

            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ma sinh vien: ");
                    String studentId1 = sc.nextLine();
                    System.out.print("Nhap ten sinh vien: ");
                    String name1 = sc.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int age1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ma o to: ");
                    String carId1 = sc.nextLine();
                    System.out.print("Nhap hang xe: ");
                    String brand1 = sc.nextLine();
                    System.out.print("Nhap bien so: ");
                    String licensePlate1 = sc.nextLine();

                    addStudent(studentId1, name1, age1, carId1, brand1, licensePlate1);
                }
                case 2 -> {
                    System.out.print("Nhập số thứ tự sinh viên cần xoá: ");
                    int displayNumber = Integer.parseInt(sc.nextLine());
                    int index = displayNumber - 1;
                    removeStudent(index);
                }
                case 3 -> {
                    changeStudent(sc);
                }
                case 4 -> {
                    introduceKhanh();
                }
                case 5 -> {
                    findLamborghini();
                }
                case 0 -> System.out.println("Ket thuc.");
                default -> System.out.println("Lua chon khong hop le.");
            }

        } while(choice != 0);


    }

    static void addStudent(String studentId, String name, int age, String carId, String brand, String licensePlate) {
        Student extraStudent = new Student(studentId, name, age, new Car(carId, brand, licensePlate));
        sv.add(extraStudent);

        printStudents();
    }

    static void printStudents() {
        for (int i = 0; i < sv.size(); i++) {
            System.out.print((i + 1) + ".");
            System.out.println(sv.get(i).introduce());
        }
        System.out.println();
    }

    static void removeStudent(int index) {
        printStudents();

        if (index < 0 || index >= sv.size()) {
            System.out.println("Khong tim thay sinh vien");
            return;
        }

        sv.remove(index);
        printStudents();
    }

    static void changeStudent(Scanner sc) {
        printStudents();

        System.out.print("Nhap so thu tu sinh vien can sua: ");
        int displayNumber = Integer.parseInt(sc.nextLine());
        int index = displayNumber - 1;
        System.out.print("Nhap ma sinh vien: ");
        String studentId = sc.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        String name = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ma o to: ");
        String carId = sc.nextLine();
        System.out.print("Nhap hang xe: ");
        String brand = sc.nextLine();
        System.out.print("Nhap bien so: ");
        String licensePlate = sc.nextLine();

        sv.get(index).setStudentId(studentId);
        sv.get(index).setName(name);
        sv.get(index).setAge(age);
        sv.get(index).getCar().setCarId(carId);
        sv.get(index).getCar().setBrand(brand);
        sv.get(index).getCar().setLicensePlate(licensePlate);

        printStudents();
    }

    static void introduceKhanh() {
        int count = 0;
        for (int i = 0; i < sv.size(); i++) {
            if (sv.get(i).getName().equals("Khánh")) {
                System.out.println(sv.get(i).introduce());
                count++;
            }
        }
        if (count == 0) System.out.println("Anh Khánh xấu zai");
    }

    static void findLamborghini() {
        int count = 0;
        for (int i = 0; i < sv.size(); i++) {
            if (sv.get(i).getCar().getBrand().equals("Lamborghini")) {
                System.out.println(sv.get(i).introduce());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có sinh viên nào có ô tô hãng Lamborghini.");
        }
    }
}