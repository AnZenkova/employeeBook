package pro.sky.employeeBook.Service;

import pro.sky.employeeBook.data.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public interface EmployeeService {
    String addNewEmployee(String firstName, String lastName, Double salary, int department);
    void removeEmployee(String firstName, String lastName);
    Employee findEmployees(String firstName, String lastName);
    List<Employee> getEmployees();
    double calculateCostOfSalary();
    public OptionalDouble findMaxSalary();
    public OptionalDouble findMinSalary();
    OptionalDouble findAverageSalary();
    DoubleStream indexationSalaryAllEmployees(Integer percent);
}
