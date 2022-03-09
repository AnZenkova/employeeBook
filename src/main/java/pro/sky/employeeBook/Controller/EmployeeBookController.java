package pro.sky.employeeBook.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {

    private EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName) {
        Employee employee = new Employee(firstName,lastName);
        String nameEmployee = lastName + " " + firstName;
        return "Сотрудник добавлен. " + employeeService.addNewEmployee(nameEmployee, employee);
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName) {
        String nameEmployee = lastName + " " + firstName;
        employeeService.removeEmployee(nameEmployee);
        return  "Сотрудник " + nameEmployee + " удалён";
    }

    @RequestMapping("/find")
    public String find(@RequestParam String firstName,
                       @RequestParam String lastName) {
        String nameEmployee = lastName + " " + firstName;
        return "Сотрудник найден. " + employeeService.findEmployees(nameEmployee);
    }

    @RequestMapping("/get")
    public String getEmployees() {
        return employeeService.getEmployees();
    }
}
