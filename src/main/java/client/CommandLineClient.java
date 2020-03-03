package client;

import model.Employee;
import model.Gender;
import model.exception.EmployeeNotFoundException;
import service.EmployeeService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommandLineClient {

    static EmployeeService employeeService = new EmployeeService();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Select 0 to exit");
            System.out.println("Select 1 to add employee");
            System.out.println("Select 2 to modify employee");
            System.out.println("Select 3 to remove employee");
            System.out.println("Select 4 to view all employees");
            System.out.println("Select 5 to view employee by ID");
            System.out.println("Select 6 to view employees by Name");
            System.out.println("Select 7 to view employees by gender");


try {
    int selectedOption = sc.nextInt();
    switch (selectedOption) {
        case 0:
            System.out.println("Good bye!");
            return;
        case 1:
            System.out.print("Enter first name: ");
            String firstName = sc.next();
            System.out.print("Enter last name: ");
            String lastName = sc.next();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            System.out.print("Enter gender: ");
            Gender gender = Gender.valueOf(sc.next().toUpperCase());

            System.out.print("Enter department: ");
            sc.nextLine(); // Read empty line
            String department = sc.nextLine();

            System.out.print("Enter salary: ");
            BigDecimal salary = sc.nextBigDecimal();
            Employee employee = new Employee(firstName, lastName, age, gender, department, salary);
            employeeService.addEmployee(employee);
            break;
        case 2:
            System.out.print("Enter new first name: ");
            String upName = sc.next();
            System.out.print("Enter new last name: ");
            String uplastName = sc.next();
            System.out.print("Enter new age: ");
            int upAge = sc.nextInt();
            System.out.print("Enter gender: ");
            Gender  upGender = Gender.valueOf(sc.next().toUpperCase());
            System.out.print("Enter new department: ");
            sc.nextLine(); // Read empty line
            String upDepartment = sc.nextLine();
            System.out.print("Enter new salary: ");
            BigDecimal upSalary = sc.nextBigDecimal();
            Employee employeeUpdate = new Employee(upName, uplastName, upAge, upGender, upDepartment, upSalary);
            employeeService.modifyEmployee(employeeUpdate);
            break;
        case 3:
            int employeeIdForRemove = sc.nextInt();
            employeeService.removeEmployee(employeeIdForRemove);

            break;
        case 4:
           List<Employee> employees = employeeService.getEmployees();
            printEmployees(employees);
            break;
        case 5:
            System.out.print("Enter employee ID: ");
            int employeeId = sc.nextInt();
            employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                printHeader();
                printEmployee(employee);
            }
            break;
        case 6:
            System.out.print("Enter employee name: ");
            String name = sc.next();
            employees = employeeService.getEmployeesByName(name);
            printEmployees(employees);
            break;

        case 7:
            System.out.print("Enter new gender: ");
            gender = Gender.valueOf(sc.next().toUpperCase());
            employees = employeeService.getEmployeeByGender(gender);
            printEmployees(employees);
            break;

        default:
            System.out.println("Invalid option.");
    }
} catch (InputMismatchException ex  ) {
    System.out.println("you have enter invalid number");
    sc.nextLine();
} catch (IllegalArgumentException ex) {
    System.out.println("you have a enter wrong gender" + Arrays.toString(Gender.values()));

} catch (EmployeeNotFoundException ex) {
    System.out.println(ex.getMessage());
}
        } while(true);
    }

    private static void printEmployees(List<Employee> employees) {
        printHeader();
        for (Employee employee : employees) {
            if(employee != null) {
                printEmployee(employee);
            }
        }
    }


    private static void printHeader() {
        System.out.printf("%-10s | %-20s | %-20s | %-5s | %-10s | %-20s | %-20s  \n",
                "ID","First Name", "Last Name", "Age", "Gender","Department", "Salary");
    }

    private static void printEmployee(Employee employee) {

        System.out.printf("%-10s | ", employee.getId());
        System.out.printf("%-20s | ", employee.getFirstName());
        System.out.printf("%-20s | ", employee.getLastName());
        System.out.printf("%-5s | ", employee.getAge());
        System.out.printf("%-10s | ", employee.getGender());
        System.out.printf("%-20s | ", employee.getDepartment());
        System.out.printf("%-20s\n", employee.getSalary());
    }

}
