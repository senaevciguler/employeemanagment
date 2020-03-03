package service;

import model.Employee;
import model.Gender;
import model.exception.EmployeeNotFoundException;
import repository.EmployeeArrayRepository;

import java.util.List;

public class EmployeeService {

    private EmployeeArrayRepository employeeArrayRepository = new EmployeeArrayRepository();


    private final String MONDAY = "MONDAY";
    private final String TUESDAY = "TUESDAY";
    private final String WEDNESDAY = "WEDNESDAY";

    public void addEmployee(Employee employee) {

        employeeArrayRepository.addEmployee(employee);
    }

    public Employee modifyEmployee(Employee employee) {
            return employeeArrayRepository.modifyEmployee(employee);
    }

    public void removeEmployee(int id) {
        employeeArrayRepository.removeEmployee(id);

    }

    public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeArrayRepository.getEmployeeByID(employeeId);
        if(employee == null) {
            throw new EmployeeNotFoundException(employeeId);
        }
            return employee;
    }

    public List<Employee> getEmployeesByName(String name) throws EmployeeNotFoundException {

        List<Employee> employees = employeeArrayRepository.getEmployeesByName(name);
        if (employees == null) {
            throw new EmployeeNotFoundException(name);

        }
        return employees;
    }

    public List<Employee> getEmployees() {
        return employeeArrayRepository.getEmployees();
    }
    public List<Employee> getEmployeeByGender(Gender gender){
        return employeeArrayRepository.getEmployeeByGender(gender);
    }

    // runtime exception extend RunTimeException
    //compile exception extend Exception

}
