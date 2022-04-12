package pro.sky.employeeBook.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {

    private EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam Double employeeSalary,
                              @RequestParam Integer employeeDepartment) {
        String nameEmployee = lastName + " " + firstName;
        Employee employee = new Employee(firstName, lastName, employeeSalary, employeeDepartment);
        return "Сотрудник добавлен. " + employeeService.addNewEmployee(nameEmployee, employee);
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName) {
        String nameEmployee = lastName + " " + firstName;
        employeeService.removeEmployee(nameEmployee);
        return "Сотрудник " + nameEmployee + " удалён";
    }

    @RequestMapping("/find")
    public String find(@RequestParam String firstName,
                       @RequestParam String lastName) {
        String nameEmployee = lastName + " " + firstName;
        return "Сотрудник найден. " + employeeService.findEmployees(nameEmployee);
    }

    @RequestMapping("/get")
    public String getEmployees() {
        return String.valueOf(employeeService.getEmployees());
    }

    @RequestMapping("/salary/sum")
    public double sumSalary() {
        return employeeService.calculateCostOfSalary();
    }

    @RequestMapping("/salary/min")
    public OptionalDouble findMinSalary() {
        return employeeService.findMinSalary();
    }

    @RequestMapping("/salary/max")
    public OptionalDouble findMaxSalary() {
        return employeeService.findMaxSalary();
    }

    @RequestMapping("/salary/average")
    public OptionalDouble findAverageSalary() {
        return employeeService.findAverageSalary();
    }

    @RequestMapping("/salary/indexation")
    public DoubleStream indexationSalaryAllEmployees(@RequestParam Integer percent) {
        return employeeService.indexationSalaryAllEmployees(percent);
    }
}
