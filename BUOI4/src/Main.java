import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        Employee e = new Employee("123", "Tráng", 10000000);
        Developer d = new Developer("234", "Hưng", 7000000, 2);
        SalesEmployee s = new SalesEmployee("345", "Nam", 6000000, 12);

        list.add(e);
        list.add(d);
        list.add(s);

        for (Employee employee : list) {
            System.out.println(employee.getMonthlyIncome());
        }
    }
}