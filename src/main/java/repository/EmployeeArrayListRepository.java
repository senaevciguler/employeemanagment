package repository;

import model.Employee;
import model.Gender;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayListRepository implements EmployeeRepository {

    List<Employee> employeeDataBase = new ArrayList<Employee>();

    @Override
    public List<Employee> addEmployee(Employee employee) {
        employeeDataBase.add(employee);
        return employeeDataBase;
    }

    @Override

    public Employee modifyEmployee(Employee employeeUp) {
        for(Employee employee : employeeDataBase) {
            if (employee.getId() != 0 && employee.getId() == employeeUp.getId())
                employeeDataBase.remove(employee);
            employeeDataBase.add(employeeUp);
        }

        return employeeUp;
    }


    @Override
    public void removeEmployee(int id) {
        if (id != 0)
            for (Employee employee : employeeDataBase) {
                if (employee.getId() == id)
                    employeeDataBase.remove(employee);
            }
    }

    @Override
    public Employee getEmployeeByID(int employeeId) {
            if(employeeId != 0)
                for(Employee employee : employeeDataBase){
                    if(employee.getId() == employeeId)
                        return employee;
                }
            return null;
        }


    @Override
    public List<Employee> getEmployeesByName(String name) {
        List<Employee> employeeName = new ArrayList<Employee>();
        if(name != null)
            for(Employee employee : employeeDataBase){
                if(employee.getFirstName() == name)
                    employeeName.add(employee);
            }
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        for(Employee employee : employeeDataBase){
            employees.add(employee);
        }
        return employees;
    }


    @Override
    public List<Employee> getEmployeeByGender(Gender gender) {

            for(Employee employee : employeeDataBase){
                if(employee.getGender() == gender) {
                   return (List<Employee>) employee;
                }
            }
        return null;

    }
}
