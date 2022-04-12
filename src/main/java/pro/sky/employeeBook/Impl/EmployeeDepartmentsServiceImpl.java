package pro.sky.employeeBook.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeBook.Service.EmployeeDepartmentsService;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentsServiceImpl implements EmployeeDepartmentsService {

    EmployeeService employeeService;

    public EmployeeDepartmentsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryDepartment(int department) {
       return employeeService.getEmployees().stream()
                .filter(s -> s.getDepartment().equals(department))
                .max(Comparator.comparingDouble(e -> e.getEmployeeSalary()))
                .get();
    }

    @Override
    public Employee getMinSalaryDepartment(int department) {
        return employeeService.getEmployees().stream()
                .filter(s -> s.getDepartment().equals(department))
                .min(Comparator.comparingDouble(e -> e.getEmployeeSalary()))
                .get();
    }

    @Override
    public List<Employee> getAllEmployeeDepartment(int department) {
        return employeeService.getEmployees().stream()
                .filter(s -> s.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Object, List<Employee>> getAllEmployees() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
