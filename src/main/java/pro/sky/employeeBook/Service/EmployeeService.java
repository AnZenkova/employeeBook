package pro.sky.employeeBook.Service;

import pro.sky.employeeBook.data.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public interface EmployeeService {
    String addNewEmployee(String nameEmployee, Employee employee);
    void removeEmployee(String nameEmployee);
    Employee findEmployees(String nameEmployee);
    List<Employee> getEmployees();
    double calculateCostOfSalary();
    public OptionalDouble findMaxSalary();
    public OptionalDouble findMinSalary();
    OptionalDouble findAverageSalary();
    DoubleStream indexationSalaryAllEmployees(Integer percent);
}
