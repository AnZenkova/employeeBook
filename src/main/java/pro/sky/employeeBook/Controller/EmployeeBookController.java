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
                              @RequestParam Double salary,
                              @RequestParam Integer department) {
        firstName = employeeService.checkingTheString(firstName);
        lastName = employeeService.checkingTheString(lastName);
        String nameEmployee = firstName + " " + lastName;
        Employee employee = new Employee(firstName, lastName, salary, department);
        return "Сотрудник добавлен. " + employeeService.addNewEmployee(nameEmployee, employee);
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName) {
        employeeService.checkingTheString(firstName);
        employeeService.checkingTheString(lastName);
        String nameEmployee = firstName + " " + lastName;
        employeeService.removeEmployee(nameEmployee);
        return "Сотрудник удалён";
    }

    @RequestMapping("/find")
    public String find(@RequestParam String firstName,
                       @RequestParam String lastName) {
        employeeService.checkingTheString(firstName);
        employeeService.checkingTheString(lastName);
        String nameEmployee = firstName + " " + lastName;
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
