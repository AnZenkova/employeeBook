package pro.sky.employeeBook.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeBook.Service.EmployeeDepartmentsService;

@RestController
@RequestMapping("/employee/department")
public class EmployeeDepartmentsController {

    public EmployeeDepartmentsController(EmployeeDepartmentsService employeeDepartmentsService) {
        this.employeeDepartmentsService = employeeDepartmentsService;
    }

    public EmployeeDepartmentsService employeeDepartmentsService;

    @RequestMapping("/max-salary")
    public String maxSalary(@RequestParam Integer departmentId) {
        return String.valueOf(employeeDepartmentsService.getMaxSalaryDepartment(departmentId));
    }

    @RequestMapping("/min-salary")
    public String minSalary(@RequestParam Integer departmentId) {
        return String.valueOf(employeeDepartmentsService.getMinSalaryDepartment(departmentId));
    }

    @RequestMapping("/all")
    public String allEmployeeInDepartment(@RequestParam Integer departmentId) {
        return String.valueOf(employeeDepartmentsService.getAllEmployeeDepartment(departmentId));
    }

    @RequestMapping("/alldepartments")
    public String allEmployees() {
        return String.valueOf(employeeDepartmentsService.getAllEmployees());
    }
}
