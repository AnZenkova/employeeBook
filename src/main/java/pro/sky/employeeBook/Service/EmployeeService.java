package pro.sky.employeeBook.Service;

import pro.sky.employeeBook.data.Employee;

public interface EmployeeService {
    String addNewEmployee(String nameEmployee, Employee employee);
    void removeEmployee(String nameEmployee);
    String findEmployees(String nameEmployee);
    String getEmployees();
}
