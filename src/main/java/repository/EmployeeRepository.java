package repository;

import model.Employee;
import model.Gender;

import java.util.List;

public interface EmployeeRepository {

   List<Employee> addEmployee(Employee employee);

   Employee modifyEmployee(Employee employee);

     void  removeEmployee(int id);

     Employee getEmployeeByID(int employeeId);

   List<Employee> getEmployeesByName(String name);

     List<Employee> getEmployees();

     List<Employee> getEmployeeByGender(Gender gender);
}
