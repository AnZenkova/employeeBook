package pro.sky.employeeBook.Service;

import pro.sky.employeeBook.data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDepartmentsService {


    Employee getMaxSalaryDepartment(int department);

    Employee getMinSalaryDepartment(int department);

    List<Employee> getAllEmployeeDepartment(int department);

    Map<Object, List<Employee>> getAllEmployees();
}
