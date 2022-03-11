package pro.sky.employeeBook.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeBook.Service.EmployeeDepartmentsService;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentsServiceImpl implements EmployeeDepartmentsService {

    EmployeeService employeeService;

    public EmployeeDepartmentsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public OptionalDouble maxSalaryDepartment(Integer department) {
        return employeeService.getEmployees().stream()
                .filter(s -> s.getDepartment().equals(department))
                .mapToDouble(s -> s.getEmployeeSalary())
                .max();
    }

    @Override
    public OptionalDouble minSalaryDepartment(Integer department) {
        return employeeService.getEmployees().stream()
                .filter(s -> s.getDepartment().equals(department))
                .mapToDouble(s -> s.getEmployeeSalary())
                .min();
    }

    @Override
    public List<Employee> allEmployeeDepartment(Integer department) {
        return employeeService.getEmployees().stream()
                .filter(s -> s.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> allEmployees() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
