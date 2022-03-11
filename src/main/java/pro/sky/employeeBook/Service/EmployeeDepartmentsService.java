package pro.sky.employeeBook.Service;

import pro.sky.employeeBook.data.Employee;

import java.util.List;
import java.util.OptionalDouble;

public interface EmployeeDepartmentsService {

    OptionalDouble maxSalaryDepartment(Integer department);
    OptionalDouble minSalaryDepartment(Integer department);
    List<Employee> allEmployeeDepartment(Integer department);
    List<Employee> allEmployees();

}
