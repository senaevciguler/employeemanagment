package model.exception;

public class EmployeeNotFoundException extends Exception  {
    public EmployeeNotFoundException (int employeeId) {
        super("Employee with id" + employeeId + "does  not exist");
    }
    public EmployeeNotFoundException(String name ) {
        super("Employee with name " + name + "does not exist");
    }


}
