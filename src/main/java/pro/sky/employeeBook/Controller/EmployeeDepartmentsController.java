package pro.sky.employeeBook.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeBook.Service.EmployeeDepartmentsService;

import java.util.OptionalDouble;

@RestController
@RequestMapping("/employee/department")
public class EmployeeDepartmentsController {

    public EmployeeDepartmentsController(EmployeeDepartmentsService employeeDepartmentsService) {
        this.employeeDepartmentsService = employeeDepartmentsService;
    }

    public EmployeeDepartmentsService employeeDepartmentsService;

    @RequestMapping("/max-salary")
    public OptionalDouble maxSalary(@RequestParam Integer departmentId) {
        return employeeDepartmentsService.maxSalaryDepartment(departmentId);
    }

    @RequestMapping("/min-salary")
    public OptionalDouble minSalary(@RequestParam Integer departmentId) {
        return employeeDepartmentsService.minSalaryDepartment(departmentId);
    }

    @RequestMapping("/all")
    public String allEmployeeInDepartment(@RequestParam Integer departmentId) {
        return String.valueOf(employeeDepartmentsService.allEmployeeDepartment(departmentId));
    }

    @RequestMapping("/alldepartment")
    public String allEmployees() {
        return String.valueOf(employeeDepartmentsService.allEmployees());
    }
}
